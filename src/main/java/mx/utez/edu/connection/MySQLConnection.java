package mx.utez.edu.connection;
import java.sql.*;

public class MySQLConnection {
    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://"+"localhost"+":"+3306+"/"+"tiendita?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root","");
    }

    public static void main(String[] args) {
        try{
            Connection con = getConnection();
            System.out.println("¡Conexion exitosa :D!");
            con.close();
        }catch (SQLException e){
            System.out.println("¡Conexion fallida!: ( "+e);
        }
    }


    public static void closeConnections(Connection con, CallableStatement cstm, ResultSet rs){
        try{
            if(rs != null){ rs.close(); }

            if(cstm != null){ cstm.close(); }

            if(con != null){ con.close(); }

        }catch(SQLException e){ }
    }

    public static void closeConnections(Connection con, CallableStatement cstm){
        try{
            if(cstm != null){ cstm.close(); }

            if(con != null){ con.close(); }

        }catch(SQLException e){ }
    }

}
