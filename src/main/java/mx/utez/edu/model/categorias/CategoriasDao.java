package mx.utez.edu.model.categorias;

import mx.utez.edu.model.categorias.CategoriasBean;
import mx.utez.edu.connection.MySQLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriasDao {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;
    Logger logger = LoggerFactory.getLogger(CategoriasDao.class);
    int r;

    public List<CategoriasBean> findAll() {
        List<CategoriasBean> CategoriasList = new ArrayList<>();
        try {
            con = MySQLConnection.getConnection();
            cstm = con.prepareCall("{SELECT *FROM categorias}");
            rs = cstm.executeQuery();
            while (rs.next()) {

                CategoriasBean categorias = new CategoriasBean();

                categorias.setNombre(rs.getString("nombre"));
                categorias.setCategorias(rs.getString("categorias"));
                CategoriasList.add(categorias);
            }
        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            MySQLConnection.closeConnections(con, cstm, rs);
        }
        return CategoriasList;
    }

    public int agregar(CategoriasBean categorias) {
        try {
            con = MySQLConnection.getConnection();
            cstm = con.prepareCall("{INSERT INTO categorias (nombre,categorias) VALUES(?,?)}");

            cstm.setString(1, categorias.getNombre());
            cstm.setString(2, categorias.getCategorias());
            cstm.executeUpdate();
        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            MySQLConnection.closeConnections(con, cstm);
        }
        return r;
    }

    public int actualizar(CategoriasBean categorias) {
        try {
            con = MySQLConnection.getConnection();
            cstm = con.prepareCall("{UPDATE categorias SET nombre=?,categorias=? WHERE nombre=?}");

            cstm.setString(1, categorias.getNombre());
            cstm.setString(2, categorias.getCategorias());
            cstm.executeUpdate();
        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            MySQLConnection.closeConnections(con, cstm);
        }
        return r;

    }

    public void eliminar(int nombre) {
        try {
            con = MySQLConnection.getConnection();
            cstm = con.prepareCall("{DELETE FROM categorias WHERE nombre=?}");
            cstm.setInt(1, nombre);
            cstm.executeUpdate();
        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            MySQLConnection.closeConnections(con, cstm);
        }
    }
}