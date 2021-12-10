package mx.utez.edu.model.productos;

import mx.utez.edu.model.productos.ProductosBean;
import mx.utez.edu.connection.MySQLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductosDao {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;
    Logger logger = LoggerFactory.getLogger(ProductosDao.class);
    int r;

    public List<ProductosBean> findAll() {
        List<ProductosBean> ProductosList = new ArrayList<>();
        try {
            con = MySQLConnection.getConnection();
            cstm = con.prepareCall("{SELECT *FROM productos}");
            rs = cstm.executeQuery();
            while (rs.next()) {

                ProductosBean productos = new ProductosBean();

                productos.setCodigo(rs.getInt("codigo"));
                productos.setNombre(rs.getString("nombre"));
                productos.setCategoria(rs.getString("categoria"));
                productos.setMarca(rs.getString("marca"));
                productos.setExistencias(rs.getInt("existencias"));
                productos.setPrecio_unitario(rs.getInt("precio_unitario"));
                productos.setDescripcion(rs.getString("descripcion"));
                ProductosList.add(productos);
            }
        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            MySQLConnection.closeConnections(con, cstm, rs);
        }
        return ProductosList;
    }

    public int agregar(ProductosBean producto) {
        try {
            con = MySQLConnection.getConnection();
            cstm = con.prepareCall("{INSERT INTO productos (codigo,nombre,categoria,marca,existencias,precio_unitario,descripcion) VALUES(?,?,?,?,?,?,?)}");

            cstm.setInt(1, producto.getCodigo());
            cstm.setString(2, producto.getNombre());
            cstm.setString(3, producto.getCategoria());
            cstm.setString(4, producto.getMarca());
            cstm.setInt(5, producto.getExistencias());
            cstm.setInt(6, producto.getPrecio_unitario());
            cstm.setString(7, producto.getDescripcion());
            cstm.executeUpdate();
        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            MySQLConnection.closeConnections(con, cstm);
        }
        return r;
    }

    public int actualizar(ProductosBean producto) {
        try {
            con = MySQLConnection.getConnection();
            cstm = con.prepareCall("{UPDATE productos SET codigo=?,nombre=?,categoria=?,marca=?,existencias=?,precio_unitario=?,descripcion=? WHERE codigo=?}");

            cstm.setString(1, producto.getNombre());
            cstm.setString(2, producto.getCategoria());
            cstm.setString(3, producto.getMarca());
            cstm.setInt(4, producto.getExistencias());
            cstm.setInt(5, producto.getPrecio_unitario());
            cstm.setString(6, producto.getDescripcion());
            cstm.executeUpdate();
        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            MySQLConnection.closeConnections(con, cstm);
        }
        return r;

    }

    public void eliminar(int codigo) {
        try {
            con = MySQLConnection.getConnection();
            cstm = con.prepareCall("{DELETE FROM productos WHERE codigo=?}");
            cstm.setInt(1, codigo);
            cstm.executeUpdate();
        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            MySQLConnection.closeConnections(con, cstm);
        }
    }
}
