package mx.utez.edu.model.marcas;
import mx.utez.edu.model.marcas.MarcasBean;
import mx.utez.edu.connection.MySQLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarcasDao {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;
    Logger logger = LoggerFactory.getLogger(MarcasDao.class);
    int r;

    public List<MarcasBean> findAll() {
        List<MarcasBean> MarcasList = new ArrayList<>();
        try {
            con = MySQLConnection.getConnection();
            cstm = con.prepareCall("{SELECT *FROM marcas}");
            rs = cstm.executeQuery();
            while (rs.next()) {

                MarcasBean marcas = new MarcasBean();

                marcas.setNombre(rs.getString("nombre"));
                marcas.setDescripcion(rs.getString("descripcion"));
                MarcasList.add(marcas);
            }
        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            MySQLConnection.closeConnections(con, cstm, rs);
        }
        return MarcasList;
    }

    public int agregar(MarcasBean marca) {
        try {
            con = MySQLConnection.getConnection();
            cstm = con.prepareCall("{INSERT INTO marcas (nombre,descripcion) VALUES(?,?)}");

            cstm.setString(1, marca.getNombre());
            cstm.setString(2, marca.getDescripcion());
            cstm.executeUpdate();
        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            MySQLConnection.closeConnections(con, cstm);
        }
        return r;
    }

    public int actualizar(MarcasBean marca) {
        try {
            con = MySQLConnection.getConnection();
            cstm = con.prepareCall("{UPDATE marcas SET nombre=?,descripcion=? WHERE nombre=?}");

            cstm.setString(1, marca.getNombre());
            cstm.setString(2, marca.getDescripcion());
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
            cstm = con.prepareCall("{DELETE FROM marcas WHERE nombre=?}");
            cstm.setInt(1, nombre);
            cstm.executeUpdate();
        } catch (SQLException e) {
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            MySQLConnection.closeConnections(con, cstm);
        }
    }
}
