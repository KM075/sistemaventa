<%-- 
    Document   : Producto
    Created on : 23/11/2021, 02:01:44 PM
    Author     : diana
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="POST">
                        <div class="form-group"> 
                            <label>Nombres</label>
                            <input type="text" value="${producto.getNom()}" name="txtNombre" class="form-control" required="">
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" value="${producto.getPrecio()}" name="txtPrecio" class="form-control" required="">
                        </div>
                        <div class="form-group">
                            <label>Stock</label>
                            <input type="text" value="${producto.getStock()}" name="txtStock" class="form-control" required="">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${producto.getEs()}" name="txtEstado" class="form-control" required="">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>

            <div class="container-fluid">
                <div class="table-responsive">

                    <table id="tablaproducto"  class="table table-bordered table-striped table-hover" paging="false">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>NOMBRES</th>
                                <th>PRECIO</th>
                                <th>STOCK</th>
                                <th>ESTADO</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="pr" items="${productos}">
                                <tr>
                                    <td>${pr.getId()}</td>
                                    <td>${pr.getNom()}</td>
                                    <td>${pr.getPrecio()}</td>
                                    <td>${pr.getStock()}</td>
                                    <td>${pr.getEs()}</td>

                                    <td>
                                        <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=${pr.getId()}">Editar</a>
                                        <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Delete&id=${pr.getId()}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>



                        </tbody>
                    </table>
                </div> 
            </div>

        </div>

     
          <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>      
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <script>
            $(document).ready(function () {
                $('#tablaproducto').DataTable({
                    "language": {
                        "decimal": ",",
                        "thousands": "."
                    }
                });
            });


        </script>

    </body>
</html>

