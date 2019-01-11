/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import com.mysql.jdbc.Connection;
import ec.edu.ups.modelo.OrdenCompra;
import ec.edu.ups.modelo.Proveedor;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author java
 */
public class ControladorOrdenCompra {

    private List<OrdenCompra> listaOrdenCompra;
    private String bd = "Facturacion";
    private String login = "administrador";
    private String password = "Patito.123@456";
    private String url = "jdbc:mysql://192.168.1.253:3306/" + bd;
    Connection conn = null;
    Statement st = null;
    ResultSet r = null;

    public ControladorOrdenCompra() {
        listaOrdenCompra = new ArrayList<>();
    }

    public void conexion() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = (Connection) DriverManager.getConnection(url, login, password);
            if (conn != null) {
                System.out.println("Conexion a base de datos " + url + " ... Ok");
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

    public void crearOrdenCompra(int codigo, int gerente) {
        if (conn != null) {
            try {
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
                System.out.println("Fecha: " + dateFormat.format(date));
                String sql = "INSERT INTO OrdenCompra(id,fecha,Gerente_id)" + "values(" + codigo + ",'" + dateFormat.format(date) + "'," + gerente + ");";
                st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados");
                desconectar();
            } catch (SQLException ex) {
                System.out.println("Error SQL:" + ex);
                JOptionPane.showMessageDialog(null, "Los datos no han sido guardados");
            }

        }
    }
    
    public void crearOrdenCompraDetalle(int id, String cantidad,int orden,int producto) {
        if (conn != null) {
            try {
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
                System.out.println("Fecha: " + dateFormat.format(date));
                String sql = "INSERT INTO OrdenProductoDetalle(id,cantidad,OrdenCompra_id,Producto_id)" + "values(" + id + "," + cantidad + "," + orden + "," + producto + ");";
                st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
                st.execute(sql);
                System.out.println("Los datos han sido guardados");
                desconectar();
            } catch (SQLException ex) {
                System.out.println("Error SQL:" + ex);
                JOptionPane.showMessageDialog(null, "Los datos no han sido guardados");
            }

        }
    }

    public int obtenerCodigoD() {
        conexion();
        int codigo = 0;
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT max(id) FROM OrdenProductoDetalle;");
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

    public int obtenerCodigoO() {
        conexion();
        int codigo = 0;
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT max(id) FROM OrdenCompra;");
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
