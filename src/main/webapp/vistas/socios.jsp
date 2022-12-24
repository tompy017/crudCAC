<%@page import="modelo.SociosDAO"%>
<%@page import="modelo.Socios"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <!-- icons fontawesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Socios</title>
</head>
<body>
    <div class="container-fluid pt-5 text-center">
    <h1>Listado de Socios</h1>
    </div>
    
    <div class="d-grid gap-2 p-5 mt-0">
        <a href="SociosController?accion=insert" class="btn btn-outline-dark rounded-4" type="button">Agregar Nuevo Socio</a>

    </div>


    <div class="table-responsive mt-2">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Direccion</th>
                    <th>Localidad</th>
                    <th>F. Nac.</th>
                    <th>email</th>
                    <th>Tel</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            
            
            
            
            <%
            List<Socios> socios=null; // genero lista
            SociosDAO dao=new SociosDAO();   // instancio el data access object
            socios=dao.listarSocios();  // metodo listarSocios() devuelve lista de todos los socios
            
            
            for (int i=0;i<socios.size();i++) {
                String modificarPATH="SociosController?accion=modificar&id_socio="+socios.get(i).getId_socio();       
                String eliminarPATH="SociosController?accion=eliminar&id_socio="+socios.get(i).getId_socio();
            %>
            
            <tbody class="table-group-divider">
                <tr>
                    <td><%=socios.get(i).getId_socio() %></td>
                    <td><%=socios.get(i).getNombre() %></td>
                    <td><%=socios.get(i).getApellido() %></td>
                    <td><%=socios.get(i).getDireccion() %></td>
                    <td><%=socios.get(i).getLocalidad() %></td>
                    <td><%=socios.get(i).getFnac() %></td>
                    <td><%=socios.get(i).getEmail() %></td>
                    <td><%=socios.get(i).getTelefono() %></td>
                   
                    <!-- Boton Borrar -->
                    <td class="text-center">
                        <a href=<%=eliminarPATH %>>
                            <button class="btn btn-light btn-sm border border-dark">
                                <i class="fa fa-trash-o" aria-hidden="true"></i> 
                            </button>
                        </a>
                    </td>
                    <!-- Boton Modificar -->
                    <td class="text-center">
	                    <a href=<%=modificarPATH %>>
	                        <button class="btn btn-light btn-sm border border-dark">
	                            <i class="fa fa-pencil-square-o fa-align-center" aria-hidden="true"></i>
	                        </button>
	                    </a>
                    </td>
                </tr>
            </tbody>
           
            <%
            }       // fin del for para cada fila
            %>
        </table>
    </div>

</body>
</html>