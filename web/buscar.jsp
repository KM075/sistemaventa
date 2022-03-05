<%-- 
    Document   : index
    Created on : 24/11/2021, 06:41:32 PM
    Author     : Aprendiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">



        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <div class="container">
            <div class="table-responsive">

                <table  id="tablaValores" class="table table-bordered table-striped table-hover" paging="false">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Direccion</th>
                            <th>editar</th>
                            <th>eliminar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Pepito</td>
                            <td>Perez</td>
                            <td>Sur</td>
                            <td> <a class="btn btn-warning" >Edit</a></td>
                            <td> <a class="btn btn-danger" >Eliminar</a></td>
                        </tr>
                        <tr>
                            <td>Juanito</td>
                            <td>Perez</td>
                            <td>Norte</td>
                            <td> <a class="btn btn-warning" href="" >Edit</a></td>
                            <td> <a class="btn btn-danger" href="" >Eliminar</a></td>
                        </tr>
                        <tr>
                            <td>Maria</td>
                            <td>SOcorro</td>
                            <td>Centreo</td>
                            <td> <a class="btn btn-warning" >Edit</a></td>
                            <td> <a class="btn btn-danger" >Eliminar</a></td>
                        </tr>
                    </tbody>
                </table>

            </div>
        </div>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>      
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <script>
            $(document).ready(function () {
                $('#tablaValores').DataTable({
                    "language": {
                        "decimal": ",",
                        "thousands": "."
                    }
                });
            });


        </script>


    </body>
</html>

