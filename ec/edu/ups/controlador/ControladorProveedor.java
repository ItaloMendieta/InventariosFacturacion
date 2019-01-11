/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

//import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import ec.edu.ups.modelo.Proveedor;

/**
 *
 * @author java
 */
public class ControladorProveedor {
    private List<Proveedor> listaProveedor;
    private String bd = "Facturacion";
    private String login = "administrador";
    private String password = "Patito.123@456";
    private String url = "jdbc:mysql://192.168.1.253:3306/" + bd;
    Connection conn = null;
    Statement st = null;
    ResultSet r = null;

    public ControladorProveedor() {
        listaProveedor = new ArrayList<>();
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
    
    public Proveedor buscarP(String nom) {
        conexion();
        Proveedor p = new Proveedor();
        String sql = "SELECT * FROM Proveedor WHERE nombre =  '" + nom + "'; ";
        try {
            st = conn.createStatement();
            r = st.executeQuery(sql);
            while (r.next()) {
                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                p.setId(codigo);
                p.setNombre(nombre);
            }
        } catch (SQLException ex) {
            System.out.println("Error del SQL" + ex);
        }
        desconectar();
        return p;
    }
    public Proveedor buscarPCodigo(int nom) {
        conexion();
        Proveedor p = new Proveedor();
        String sql = "SELECT * FROM Proveedor WHERE id =  '" + nom + "'; ";
        try {
            st = conn.createStatement();
            r = st.executeQuery(sql);
            while (r.next()) {
                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                p.setId(codigo);
                p.setNombre(nombre);
            }
        } catch (SQLException ex) {
            System.out.println("Error del SQL" + ex);
        }
        desconectar();
        return p;
    }

    public void crearProveedor(Proveedor p) {
        if (conn != null) {
            try {
                String sql = "INSERT INTO Proveedor(nombre,ruc,direccion)" + "values('" + p.getNombre() + "','"+p.getRuc()+"','"+p.getDireccion()+"');";
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
    
    public void eliminar(String nombre) {
        conexion();

        String sql = "DELETE FROM Proveedor WHERE nombre= '" + nombre + "';";
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "El proveedor se ha eliminado");
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error del SQL" + ex);
            JOptionPane.showMessageDialog(null, "El proveedor no ha sido eliminado");
        }
        desconectar();
    }
    
    public void modificar(String nombre, String cedula, String direccion) {
        conexion();
        String sql = "UPDATE Proveedor SET nombre='" + nombre + "';";
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "El proveedor se ha modificado");
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Error de SQL");
            JOptionPane.showMessageDialog(null, "El proveedor no ha sido modificado");
        }
        desconectar();
    }

    public List<Proveedor> listar() {
        conexion();
        List<Proveedor> lista = null;
        String sql = "SELECT * FROM Proveedor Order by id ASC;";
        try {
            lista = new ArrayList<>();

            st = conn.createStatement();
            r = st.executeQuery(sql);
            while (r.next()) {
                Proveedor p = new Proveedor();

                p.setId(r.getInt("id"));
                p.setNombre(r.getString("nombre").trim());
                
                lista.add(p);
//                resultado.close();
            }

        } catch (Exception ex) {
        }
        desconectar();
        System.out.println(lista);
        return lista;
    }
    
    public List<Proveedor> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }
    
}
