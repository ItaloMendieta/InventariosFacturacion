/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import com.mysql.jdbc.Connection;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Producto;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ControladorFacturaDetalle {

    private String bd = "Facturacion";
    private String login = "administrador";
    private String password = "Patito.123@456";
    private String url = "jdbc:mysql://192.168.1.253:3306/" + bd;
    Connection conn = null;
    Statement st = null;
    ResultSet r = null;

    public ControladorFacturaDetalle() {
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

    public void registrarFacturaDetalle(FacturaDetalle f) {
        conexion();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("INSERT  INTO " + "FacturaDetalle" + " VALUES" + "(" + f.getId() + "," + f.getCantidad() + "," + f.getSubTotal() + "," + f.getFacturaCabecera().getId()
                    + "," + f.getProducto().getId() + ");");
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido guardados");
        }
        desconectar();

    }

    public void modificarFacturaDetalle(FacturaDetalle f, int codigo) {
        conexion();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("UPDATE FacturaDetalle set `subtotal` = " + f.getSubTotal() + ",cantidad = " + f.getCantidad() + ", FacturaCabecera_id = " + f.getFacturaCabecera().getId() + ", Producto_id = " + f.getProducto().getId() + " WHERE id = " + codigo + ";");
            JOptionPane.showMessageDialog(null, "Los datos han sido Actualizados");
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido Actualizados");
        }
        desconectar();

    }

    public void eliminarFacturaDetalle(FacturaDetalle f, int codigo) {
        conexion();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("DELETE FROM FacturaDetalle WHERE id =" + codigo + ";");
            JOptionPane.showMessageDialog(null, "Los datos han sido Eliminados");
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
            JOptionPane.showMessageDialog(null, "Los datos no han sido Eliminados");
        }
        desconectar();
    }

    public FacturaDetalle BuscarFacturaDetalle(int codigo) {
        conexion();
        ControladorProducto controladorProducto = new ControladorProducto();
        ControladorFacturaCabecera controladorFacturaCabecera = new ControladorFacturaCabecera();
        FacturaDetalle f = new FacturaDetalle();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM FacturaDetalle WHERE id= " + codigo + ";");
            while (r.next()) {
                double cantidad = r.getDouble(2);
                double subTotal = r.getInt(3);
                int codFacturaCabecera = r.getInt(4);
                int codProducto = r.getInt(5);
                FacturaCabecera facturaCabecera = controladorFacturaCabecera.BuscarFacturaCabecera(codFacturaCabecera);
                Producto producto = controladorProducto.BuscarProducto(codProducto);
                f.setId(codigo);
                f.setSubTotal(subTotal);
                f.setFacturaCabecera(facturaCabecera);
                f.setProducto(producto);

            }
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        }
        return f;
    }

    public List<FacturaDetalle> listar() {
        conexion();
        ControladorProducto controladorProducto = new ControladorProducto();
        ControladorFacturaCabecera controladorFacturaCabecera = new ControladorFacturaCabecera();
        List<FacturaDetalle> lista = new ArrayList<>();
        FacturaDetalle f;
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM FacturaDetalle Order by id ASC;");
            while (r.next()) {
                f = new FacturaDetalle();
                int codigo = r.getInt(1);
                double cantidad = r.getDouble(2);
                double subTotal = r.getInt(3);
                int codFacturaCabecera = r.getInt(4);
                int codProducto = r.getInt(5);
                FacturaCabecera facturaCabecera = controladorFacturaCabecera.BuscarFacturaCabecera(codFacturaCabecera);
                Producto producto = controladorProducto.BuscarProducto(codProducto);
                f.setId(codigo);
                f.setSubTotal(subTotal);
                f.setFacturaCabecera(facturaCabecera);
                f.setProducto(producto);

                lista.add(f);
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
            r = st.executeQuery("SELECT max(id) FROM FacturaDetalle;");
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
