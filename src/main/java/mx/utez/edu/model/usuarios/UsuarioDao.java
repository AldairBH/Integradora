package mx.utez.edu.model.usuarios;

import mx.utez.edu.connection.MySQLConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;
    Logger logger = LoggerFactory.getLogger(UsuarioDao.class);
    int r;

    public int Validar(){
        UsuarioBean user = null;
        r=0;
        try{
            con = MySQLConnection.getConnection();
            cstm = con.prepareCall("select * from usuario WHERE usuario='administrador' AND contraseña='admin12345'");
            rs = cstm.executeQuery();

            while(rs.next()){
                user = new UsuarioBean();
                r=1;
                user.setUsuario(rs.getString("usuario"));
                user.setContraseña(rs.getString("contrasena"));
            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());

        }finally {
            MySQLConnection.closeConnections(con,cstm,rs);
        }
        return r;

    }

    public UsuarioBean Validar2(String usuario, String contraseña){
        UsuarioBean user = null;
        r=0;
        try{
            con = MySQLConnection.getConnection();
            cstm = con.prepareCall("select * from usuario WHERE usuario=? AND contraseña=?");
            cstm.setString(1,usuario);
            cstm.setString(2,contraseña);
            rs = cstm.executeQuery();

            while(rs.next()){
                user = new UsuarioBean();
                r=1;
                user.setUsuario(rs.getString("usuario"));
                user.setContraseña(rs.getString("contrasena"));
            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());

        }finally {
            MySQLConnection.closeConnections(con,cstm,rs);
        }
        return user;

    }
}
