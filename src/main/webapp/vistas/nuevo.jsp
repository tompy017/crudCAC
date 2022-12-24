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
    <title>Nuevo Socio</title>
</head>
<body>
    <div class="container-fluid p-5 text-center">
        <h1 >Registro de nuevo socio</h1>
        <h6 class="p-5"> Complete todos los datos del formulario para continuar</h6>

        <div class="container text-bg-light p-5">
            <form action="SociosController?accion=insert" method="post">
                <div class="row mb-3">
                    <div class="col">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" name="nombre" id="nombre" class="form-control" required>
                    </div>
                    <div class="col">
                        <label for="apellido" class="form-label">Apellido</label>
                        <input type="text" name="apellido" id="apellido" class="form-control" required>
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col">
                        <label for="direccion" class="form-label">Direccion</label>
                        <input type="text" name="direccion" id="direccion" class="form-control" required>
                    </div>
                    <div class="col">
                        <label for="localidad" class="form-label">Localidad</label>
                        <input type="text" name="localidad" id="localidad" class="form-control" required>
                    </div>
                    
                </div>
                <div class="row mb-3">
                        <div class="col">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" name="email" id="email" class="form-control" required>
                        </div>
                        <div class="col">
                            <label for="telefono" class="form-label">Telefono</label>
                            <input type="text" name="telefono" id="telefono" class="form-control" required>
                        </div>
                    </div>
                <div class="row mb-3 align-content-center">
                    <div class="col-4 mx-auto" >
                        <label for="fnac" class="form-label">Fecha de nacimiento</label>
                        <input type="date" name="fnac" id="fnac"  min="1900-01-01" class="form-control text-center" >
                    </div>
                </div>


                <button type="submit" class="btn btn-primary"><i class="fa fa-floppy-o pe-2" aria-hidden="true"></i>Guardar</button>
            </form>

        </div>



    </div>

</body>
</html>