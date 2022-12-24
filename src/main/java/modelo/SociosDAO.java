// Clase con metodos para interactuar con la bd y realizar el crud

package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;


//Data Access Object
public class SociosDAO {

		Connection conexion;

		//Constructor
		public SociosDAO() {
			Conexion con = new Conexion();
			conexion = con.getConnection();
			
		}
		
		// Metodo para listar todos los socios de la base de datos.
		public List<Socios> listarSocios() {
		    
		    PreparedStatement ps;
		    ResultSet rs;
		    List<Socios> listaSocios = new ArrayList<Socios>();
		    
		    try {
		        ps = conexion.prepareStatement("select * from socios");
		        rs = ps.executeQuery();
		        
		        while (rs.next()) {
		            int id = rs.getInt("id_socio");
		            String nombre = rs.getString("nombre");
		            String apellido = rs.getString("apellido");
		            String direccion = rs.getString("direccion");
		            String localidad = rs.getString("localidad");
		            LocalDate fnac = rs.getDate("fnac").toLocalDate();
		            String email = rs.getString("email");
		            String telefono = rs.getString("telefono");
		            boolean active = rs.getBoolean("active"); 
		            
		            Socios nuevoSocio = new Socios(id, nombre,apellido,direccion,localidad,fnac,email,telefono,active);
		            listaSocios.add(nuevoSocio);
		        }
		    }
		    
		    catch(SQLException e ) {
		        
		        System.out.println(e);
		        return null;	        
		    }

		    return listaSocios;   
		}
		
		// Metodo para buscar socio por id
		public Socios mostrarSocio(int id_socio) {
		    PreparedStatement ps;
            ResultSet rs;
            Socios nuevoSocio = null;
            
            try {
                ps = conexion.prepareStatement("select * from socios where id=?");
                ps.setInt(1, id_socio);
                rs = ps.executeQuery();
            
                while (rs.next()) {
                    int id = rs.getInt("id_socio");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String direccion = rs.getString("direccion");
                    String localidad = rs.getString("localidad");
                    LocalDate fnac = rs.getDate("fnac").toLocalDate();
                    String email = rs.getString("email");
                    String telefono = rs.getString("telefono");
                    boolean active = rs.getBoolean("active"); 
                    
                    nuevoSocio = new Socios(id, nombre,apellido,direccion,localidad,fnac,email,telefono,active);
                }
            }
            
            catch(SQLException e) {
                System.out.println(e);
                //return null;
            }
       
            return nuevoSocio;
		}
		
		// Metodo para registrar nuevos socios.
		public boolean registrarSocio(Socios nuevoSocio) {
		    PreparedStatement ps;
		    try {
		        ps=conexion.prepareStatement("INSERT INTO socios(nombre,apellido,direccion,localidad,fnac,email,telefono,active) values(?,?,?,?,?,?,?,DEFAULT)");
		        
		        ps.setString(1, nuevoSocio.getNombre());
		        ps.setString(2, nuevoSocio.getApellido());
		        ps.setString(3, nuevoSocio.getDireccion());
		        ps.setString(4, nuevoSocio.getLocalidad());
		        ps.setObject(5, nuevoSocio.getFnac());    // estoy probando lo del localdate
		        ps.setString(6, nuevoSocio.getEmail());
		        ps.setString(7, nuevoSocio.getTelefono());
		        
		        ps.execute();
	            return true;
		    }
		    catch(SQLException e) {
		        System.out.println(e);
		        return false;
		    }
		}
		
		//Eliminar completamente el registro de la bd
	    public boolean EliminarSocio(int id_socio) {
	        PreparedStatement ps;
	        
	        try
	        {
	            ps=conexion.prepareStatement("delete from socios where id_socio=?");
	            ps.setInt(1,id_socio);            
	            ps.execute();
	            return true;          
	            
	        }
	        catch(SQLException e) {
	            System.out.println(e);
	            return false;
	        }
	    }
	    
	    // Metodo para modificar los datos de un socio
	    public boolean updateSocio(Socios socio) {
	        
	        PreparedStatement ps;
	        
	        try {
	            ps=conexion.prepareStatement("UPDATE socios SET nombre=?,apellido=?,direccion=?,localidad=?,fnac=?,email=?,telefono=?,active=?");
                
                ps.setString(1, socio.getNombre());
                ps.setString(2, socio.getApellido());
                ps.setString(3, socio.getDireccion());
                ps.setString(4, socio.getLocalidad());
                ps.setObject(5, socio.getFnac());    // estoy probando lo del localdate
                ps.setString(6, socio.getEmail());
                ps.setString(7, socio.getTelefono());
                ps.setBoolean(8, socio.isActive());

                return true;
	        }
	        catch(SQLException e){
	            System.out.println(e);
	            return false;
	        }
	        
	        
	        
	    }
}
