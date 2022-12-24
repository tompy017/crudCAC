package config;

import java.sql.*;

public class Conexion {
    
    public String driver="com.mysql.cj.jdbc.Driver"; // Driver para conectar con la bbdd
    //com.mysql.jdbc.Driver DEPRECATED 
    
    public Connection getConnection() {
        
        Connection conexion=null;
        
        // Para conectar con bbdd hay que hacer un try catch SIEMPRE
        try {
            Class.forName(driver);
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/crudCACWeb","root","");
            
        }
        catch (Exception e){ 
            System.out.println("e");
        }
        
        
        return conexion;
    }
    
    public static void main(String[] args) throws SQLException {
        Connection conex;
        Conexion con = new Conexion();
        conex = con.getConnection();
        
        PreparedStatement ps;
        ResultSet rs;
        
        ps = conex.prepareStatement("select * from socios");
        rs = ps.executeQuery();
        
        while (rs.next()) {
            int id = rs.getInt("id_socio");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            
            System.out.println("ID: "+id+"\nNombre: "+nombre+"\nApellido: "+apellido+"\n-------------------------\n\n");
         
        }
    }
}
