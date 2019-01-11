/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import com.mysql.jdbc.Connection;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.FacturaCabecera;
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
 * @author ASUS
 */
public class ControladorFacturaCabecera {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    /**
     *
     * @author ASUS
     */
    private List<FacturaCabecera> listaFacturaCabecera;
    public String bd = "Facturacion";
    public String login = "administrador";
    public String password = "Patito.123@456";
    public String url = "jdbc:mysql://192.168.1.253:3306/" + bd;
    Connection conn = null;
    Statement st = null;
    ResultSet r = null;

    public ControladorFacturaCabecera() {
        listaFacturaCabecera = new ArrayList<>();
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

    public void registrarFacturaCabecera(FacturaCabecera p) {
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(p.getFecha());

        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("INSERT  INTO " + "FacturaCabecera" + " VALUES" + "(" + p.getId() + "," + p.getSubtotal() + "," + p.getTotal() + "," + p.getIva()
                    + ",'" + fecha + "'," + null + "," + p.getCliente().getId() + "," + p.getCodigo() + ");");
            JOptionPane.showMessageDialog(null, "Los datos han sido guardados");
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido guardados");
        }

    }

    public void modificarFacturaCabecera(FacturaCabecera p, int codigo) {
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("UPDATE FacturaCabecera set `subtotal` = " + p.getSubtotal() + ",`total` = " + p.getTotal() + ",`iva` =" + p.getIva() + ",`fecha` = " + p.getFecha() + ",`descuento` = " + null
                    + ",`Cliente_id` = " + p.getCliente().getId() + " WHERE id = " + codigo + ";");
            JOptionPane.showMessageDialog(null, "Los datos han sido Actualizados");
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido Actualizados");
        }

    }

    public void eliminarFacturaCabecera(FacturaCabecera p, int codigo) {
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("DELETE FROM FacturaCabecera WHERE id =" + codigo + ";");
            JOptionPane.showMessageDialog(null, "Los datos han sido Eliminados");
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
            JOptionPane.showMessageDialog(null, "Los datos no han sido Eliminados");
        }
    }

    public FacturaCabecera BuscarFacturaCabecera(int codigo) {
        conexion();
        ControladorCliente controladorCliente = new ControladorCliente();
        FacturaCabecera p = new FacturaCabecera();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM FacturaCabecera WHERE id= " + codigo + ";");
            while (r.next()) {
                double subTotal = r.getDouble(2);
                double total = r.getInt(3);
                double iva = r.getDouble(4);
                Date fecha = r.getDate(5);
                double descuento = r.getDouble(6);
                int codCliente = r.getInt(7);
                int cajacaj = r.getInt(9);
                Cliente cliente = controladorCliente.buscarPersonaxId(codCliente);
                p.setId(codigo);
                p.setSubtotal(subTotal);
                p.setTotal(total);
                p.setIva(iva);
                p.setFecha(fecha);
                p.setDescuento(descuento);
                p.setCliente(cliente);
            }
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        }
        return p;
    }

    public FacturaCabecera BuscarFacturaCabeceraFecha(String nombre) {
        conexion();
        FacturaCabecera p = new FacturaCabecera();
        ControladorCliente controladorCliente = new ControladorCliente();
 
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM FacturaCabecera WHERE descripcion= '" + nombre + "';");
            while (r.next()) {
                int codigo = r.getInt(1);
                double subTotal = r.getDouble(2);
                double total = r.getInt(3);
                double iva = r.getDouble(4);
                Date fecha = r.getDate(5);
                double descuento = r.getDouble(6);
                int codCliente = r.getInt(7);
                Cliente cliente = controladorCliente.buscarPersonaxId(codCliente);
                int cajacaj = r.getInt(9);
                p.setId(codigo);
                p.setSubtotal(subTotal);
                p.setTotal(total);
                p.setIva(iva);
                p.setFecha(fecha);
                p.setDescuento(descuento);
                p.setCliente(cliente);

            }
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        }
        return p;
    }

    public List<FacturaCabecera> listar() {
        conexion();
        ControladorCliente controladorCliente = new ControladorCliente();
        List<FacturaCabecera> lista = new ArrayList<>();
        FacturaCabecera p;
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM FacturaCabecera Order by id ASC;");
            while (r.next()) {
                p = new FacturaCabecera();
                int codigo = r.getInt(1);
                double subTotal = r.getDouble(2);
                double total = r.getInt(3);
                double iva = r.getDouble(4);
                Date fecha = r.getDate(5);
                double descuento = r.getDouble(6);
                int codCliente = r.getInt(7);
                Cliente cliente = controladorCliente.buscarPersonaxId(codCliente);
                int cajacaj = r.getInt(9);
                
                p.setId(codigo);
                p.setSubtotal(subTotal);
                p.setTotal(total);
                p.setIva(iva);
                p.setFecha(fecha);
                p.setDescuento(descuento);
                p.setCliente(cliente);
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
            r = st.executeQuery("SELECT max(id) FROM FacturaCabecera;");
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

    public String codigoFactura() {
        conexion();
        String codigo = "";
        int num = 0;
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT max(id) FROM FacturaCabecera;");
            r.next();
            num = r.getInt(1);
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido guardados");
        }
        if (num < 10) {
            codigo = "000000" + (num + 1);
        }
        if (num < 100 && num >= 10) {
            codigo = "00000" + (num + 1);
        }
        if (num < 1000 && num >= 100) {
            codigo = "0000" + (num + 1);
        }
        if (num < 10000 && num >= 1000) {
            codigo = "000" + (num + 1);
        }
        if (num < 100000 && num >= 10000) {
            codigo = "00" + (num + 1);
        }
        if (num >= 10000) {
            codigo = "0" + (num + 1);
        }
        desconectar();
        return codigo;
    }

}
