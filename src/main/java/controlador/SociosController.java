package controlador;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import jakarta.servlet.annotation.WebServlet;

//import javax.servlet.annotation.WebServlet;

import javax.servlet.RequestDispatcher;

import modelo.Socios;
import modelo.SociosDAO;


//@WebServlet("/SociosController")
public class SociosController extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
            // Constructor
    public SociosController() {
        super();
    }
    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
         SociosDAO sociosDAO;//=null; 
         sociosDAO = new SociosDAO();
         
        String accion;
        RequestDispatcher dispatcher = null;


        accion = request.getParameter("accion");

        // Vista por primera vez ya que la accion viene como null y sin id
        if (accion==null||accion.isEmpty()) {
            dispatcher=request.getRequestDispatcher("../../webapp/vistas/socios.jsp");
        }
        
        // vista para modificar 
        else if (accion.equals("modificar")) {
            dispatcher=request.getRequestDispatcher("vistas/modificar.jsp");  
        }
        
        // vistas para actualizar la info de un socio
        else if (accion.equals("actualizar")) {
            int id_socio=Integer.parseInt(request.getParameter("id_socio"));
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String direccion=request.getParameter("direccion");
            String localidad=request.getParameter("localidad");
            LocalDate fnac=LocalDate.parse(request.getParameter("fnac"));
            String email=request.getParameter("email");
            String telefono=request.getParameter("telefono");
            boolean active=Boolean.parseBoolean(request.getParameter("active"));
            //instancio un nuevo socio
            Socios socio=new Socios(id_socio,nombre,apellido,direccion,localidad,fnac,email,telefono,active);
            sociosDAO.updateSocio(socio);                                 // actualizo la bd con los datos del socio
            
            dispatcher=request.getRequestDispatcher("vistas/socios.jsp");  // Vuelve al listado general de socios           
        }
        // eliminar socio
        else if (accion.equals("eliminar")) {
            int id_socio=Integer.parseInt(request.getParameter("id_socio"));
            sociosDAO.EliminarSocio(id_socio);          
        }
        // formulario para nuevo socio
        else if (accion.equals("nuevo")){
            dispatcher=request.getRequestDispatcher("vistas/nuevo.jsp");
        }
        
        // Graba, registra el socio en la bd
        else if (accion.equals("insert")) {
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String direccion=request.getParameter("direccion");
            String localidad=request.getParameter("localidad");
            LocalDate fnac=LocalDate.parse(request.getParameter("fnac"));
            String email=request.getParameter("email");
            String telefono=request.getParameter("telefono");
            //instancio un nuevo socio
            Socios socio=new Socios(0,nombre,apellido,direccion,localidad,fnac,email,telefono,true);
            sociosDAO.registrarSocio(socio);    // inserto socio en bd
                
            dispatcher=request.getRequestDispatcher("vistas/socios.jsp");  // Vuelve al listado general de socios;
        }
        
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
