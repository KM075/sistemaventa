/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Aprendiz
 */
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    Cliente cl = new Cliente();
    Producto pr = new Producto();

    EmpleadoDAO edao = new EmpleadoDAO();
    ClienteDAO dao = new ClienteDAO();
    ProductoDAO daoProducto = new ProductoDAO();
    int ide;

    Venta venta = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    String fecha;
    String numeroserie;
    VentaDAO ventadao = new VentaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List listae = edao.listar();
                    request.setAttribute("empleados", listae);
                    break;

                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }

        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List listac = dao.listar();
                    request.setAttribute("clientes", listac);
                    break;

                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String dir = request.getParameter("txtDir");
                    String est = request.getParameter("txtEstado");

                    cl.setDni(dni);
                    cl.setNom(nom);
                    cl.setDir(dir);
                    cl.setEs(est);
                    dao.agregar(cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Cliente e = dao.listarId(ide);
                    request.setAttribute("cliente", e);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String dir1 = request.getParameter("txtDir");
                    String est1 = request.getParameter("txtEstado");
                    cl.setDni(dni1);
                    cl.setNom(nom1);
                    cl.setDir(dir1);
                    cl.setEs(est1);
                    cl.setId(ide);
                    dao.actualizar(cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    dao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List listap = daoProducto.listar();
                    request.setAttribute("productos", listap);
                    break;

                case "Agregar":
                    String nom = request.getParameter("txtNombre");
                    Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    String es = request.getParameter("txtEstado");

                    pr.setNom(nom);
                    pr.setPrecio(precio);
                    pr.setStock(stock);
                    pr.setEs(es);
                    daoProducto.agregar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Producto e = daoProducto.listarId(ide);
                    request.setAttribute("producto", e);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String nom1 = request.getParameter("txtNombre");
                    Double precio1 = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock1 = Integer.parseInt(request.getParameter("txtStock"));
                    String est1 = request.getParameter("txtEstado");
                    pr.setNom(nom1);
                    pr.setPrecio(precio1);
                    pr.setStock(stock1);
                    pr.setEs(est1);
                    pr.setId(ide);
                    daoProducto.actualizar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    daoProducto.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);

        }
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    cl.setDni(dni);
                    cl = dao.buscar(dni);
                    request.setAttribute("cl", cl);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("fechahoy", fecha);
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    pr = daoProducto.listarId(id);
                    request.setAttribute("cl", cl);
                    request.setAttribute("producto", pr);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("listarventa", lista);
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("fechahoy", fecha);
                    break;
                case "Agregar":
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("cl", cl);
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = pr.getId();
                    descripcion = request.getParameter("nombresproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    
                    subtotal = precio * cant;
                    venta = new Venta();
                    venta.setItem(item);
                    venta.setIdproducto(cod);
                    venta.setDescripcionP(descripcion);
                    venta.setPrecio(precio);
                    venta.setCantidad(cant);
                    venta.setSubtotal(subtotal);
                    lista.add(venta);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("fechahoy", fecha);
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("listarventa", lista);
                    break;

                case "GenerarVenta":
                    //Actualizacion del Stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cantidad = lista.get(i).getCantidad();
                        int idproducto = lista.get(i).getIdproducto();
                        ProductoDAO ao = new ProductoDAO();
                        pr = ao.buscar(idproducto);
                        int sac = pr.getStock() - cantidad;
                        ao.actualizarstock(idproducto, sac);
                    }
                    //Guardar Venta

                    venta.setIdcliente(cl.getId());
                    venta.setIdempleado(2);
                    venta.setNumserie(numeroserie);                  
                    venta.setFecha(fecha);
                    venta.setMonto(totalPagar);
                    venta.setEstado("1");
                    ventadao.guardarVenta(venta);
                    //Guardar Detalle ventas
                    int idventa = Integer.parseInt(ventadao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        venta = new Venta();
                        venta.setId(idventa);
                        venta.setIdproducto(lista.get(i).getIdproducto());
                        venta.setCantidad(lista.get(i).getCantidad());
                        venta.setPrecio(lista.get(i).getPrecio());
                        ventadao.guardarDetalleventas(venta);
                    }
                    break;
                default:
                    venta = new Venta();
                    lista = new ArrayList<>();
                    item = 0;
                    totalPagar = 0.0;

                    numeroserie = ventadao.GenerarSerie();

                    if (numeroserie == null) {
                        numeroserie = "000000001";

                    }

                    if (numeroserie != null) {
                        int incrementar = (Integer.parseInt(numeroserie));
                        GenerarSerie gs = new GenerarSerie();

                        numeroserie = gs.NumeroSerie((incrementar));

                    }
                    Calendar c = Calendar.getInstance();
                    String dia = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
                    String mes = String.valueOf(c.get(Calendar.MONTH));
                    String annio = String.valueOf(c.get(Calendar.YEAR));
                    fecha = annio + "/" + mes + "/" + dia;
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("fechahoy", fecha);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
