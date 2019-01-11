/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Inventario;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Proveedor;

/**
 *
 * @author ASUS
 */
public class ControladorInventario {

    private List<Inventario> listaInventario;
    public String bd = "Facturacion";
    public String login = "administrador";
    public String password = "Patito.123@456";
    public String url = "jdbc:mysql://192.168.1.253:3306/" + bd;
    Connection conn = null;
    Statement st = null;
    ResultSet r = null;

    public ControladorInventario() {
        listaInventario = new ArrayList<>();
    }

    public void conexion() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = (Connection) DriverManager.getConnection(url, login, password);
            if (conn != null) {
                System.out.println("Conexión a base de datos " + url + " ... Ok");
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
            System.out.println("error " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public void desconectar() {
        try {
            if (conn != null) {
                System.out.println("Desconectado de la base de datos " + url + " ... Ok");
                conn.close();
                st.close();
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
            System.out.println("error " + ex);
        }
    }

    public void registrarInventario(Inventario p) {
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("INSERT  INTO " + "Inventario" + " VALUES" + "(" + p.getId()+ "," + p.getCantidadEntrada() + "," + p.getCantidadSalida() + ","+p.getPrecioEntrada()
                    +","+p.getPrecioSalida()+","+p.getTotalCantidad()+","+p.getTotalSaldo()+","+p.getProducto().getId()+");");
            System.out.println( "Los datos han sido guardados");
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            System.out.println("Los datos no han sido guardados");
        }

    }

    public void modificarInventario(Inventario p, int codigo) {
        int total= p.getCantidadEntrada()-p.getCantidadSalida();
        p.setTotalCantidad(total);
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("UPDATE Inventario set cantidadEntrada = " + p.getCantidadEntrada() + ",cantidadSalida = " + p.getCantidadSalida()+ ",precioEntrada = " + p.getCantidadEntrada()
                    +",precioUnitario = "+ p.getPrecioSalida()+",totalCantidad = "+p.getTotalCantidad()+",totalSaldo = "+p.getTotalSaldo()+", Producto_id = "+p.getProducto().getId()+" WHERE id = " + codigo + ";");
            System.out.println("Los datos han sido Actualizados");
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            System.out.println("Los datos no han sido Actualizados");
        }

    }

    public void eliminarInventario(Inventario p, int codigo) {
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("DELETE FROM Inventario WHERE id =" + codigo + ";");
            System.out.println("Los datos han sido Eliminados");
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
            System.out.println("Los datos no han sido Eliminados");
        }
    }

    public Inventario BuscarInventario(int codigo) {
        conexion();
        Inventario p = new Inventario();
        ControladorProducto controladorProducto = new ControladorProducto();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM Inventario WHERE id= " + codigo + ";");
            while (r.next()) {
                int cantidadEntrada = r.getInt(2);
                int cantidadSalida = r.getInt(3);
                double precioEntrada = r.getDouble(4);
                double precioUnitario = r.getDouble(5);
                int totalCantidad = r.getInt(6);
                double totalSaldo = r.getDouble(7);
                int produ = r.getInt(8);
                
                p.setId(codigo);
                p.setCantidadEntrada(cantidadEntrada);
                p.setCantidadSalida(cantidadSalida);
                p.setPrecioSalida(precioUnitario);
                p.setPrecioEntrada(precioEntrada);
                p.setTotalCantidad(totalCantidad);
                p.setTotalSaldo(totalSaldo);
                Producto producto= controladorProducto.BuscarProducto(produ);
                p.setProducto(producto);
            }
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        }
        return p;
    }
    public Inventario BuscarInventarioProducto(int codigo) {
        conexion();
        Inventario p = new Inventario();
        ControladorProducto controladorProducto = new ControladorProducto();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM Inventario WHERE Producto_id= " + codigo + ";");
            while (r.next()) {
                int id = r.getInt(1);
                int cantidadEntrada = r.getInt(2);
                int cantidadSalida = r.getInt(3);
                double precioEntrada = r.getDouble(4);
                double precioUnitario = r.getDouble(5);
                int totalCantidad = r.getInt(6);
                double totalSaldo = r.getDouble(7);
                int produ = r.getInt(8);
                
                p.setId(id);
                p.setCantidadEntrada(cantidadEntrada);
                p.setCantidadSalida(cantidadSalida);
                p.setPrecioSalida(precioUnitario);
                p.setPrecioEntrada(precioEntrada);
                p.setTotalCantidad(totalCantidad);
                p.setTotalSaldo(totalSaldo);
                Producto producto= controladorProducto.BuscarProducto(produ);
                p.setProducto(producto);
            }
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        }
        return p;
    }
    public Inventario BuscarInventarioProductoNom(String codigo) {
        conexion();
        Inventario p = new Inventario();
        ControladorProducto controladorProducto = new ControladorProducto();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM Inventario i, Producto p where i.Producto_id = p.id and p.descripcion ='"+codigo+"';");
            while (r.next()) {
                int id = r.getInt(1);
                int cantidadEntrada = r.getInt(2);
                int cantidadSalida = r.getInt(3);
                double precioEntrada = r.getDouble(4);
                double precioUnitario = r.getDouble(5);
                int totalCantidad = r.getInt(6);
                double totalSaldo = r.getDouble(7);
                int produ = r.getInt(8);
                
                p.setId(id);
                p.setCantidadEntrada(cantidadEntrada);
                p.setCantidadSalida(cantidadSalida);
                p.setPrecioSalida(precioUnitario);
                p.setPrecioEntrada(precioEntrada);
                p.setTotalCantidad(totalCantidad);
                p.setTotalSaldo(totalSaldo);
                Producto producto= controladorProducto.BuscarProducto(produ);
                p.setProducto(producto);
            }
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        }
        return p;
    }

    public List<Inventario> listar() {
        conexion();
        List<Inventario> lista = new ArrayList<>();
        Inventario p;
        ControladorProducto controladorProducto = new ControladorProducto();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM Inventario Order by id ASC;");
            while (r.next()) {
                p = new Inventario();
                int codigo = r.getInt(1);
                int cantidadEntrada = r.getInt(2);
                int cantidadSalida = r.getInt(3);
                double precioEntrada = r.getDouble(4);
                double precioUnitario = r.getDouble(5);
                int totalCantidad = r.getInt(6);
                double totalSaldo = r.getDouble(7);
                int produ = r.getInt(8);
                
                p.setId(codigo);
                p.setCantidadEntrada(cantidadEntrada);
                p.setCantidadSalida(cantidadSalida);
                p.setPrecioSalida(precioUnitario);
                p.setPrecioEntrada(precioEntrada);
                p.setTotalCantidad(totalCantidad);
                p.setTotalSaldo(totalSaldo);
                Producto producto= controladorProducto.BuscarProducto(produ);
                p.setProducto(producto);
                lista.add(p);
            }
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }
        return lista;
    }
     public int obtenerCodigo() {
        conexion();
        int codigo = 0;
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT max(id) FROM Inventario;");
            r.next();
            codigo = r.getInt(1);
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Error de SQL " + ex);
        }
        desconectar();
        return ++codigo;
    }

}
