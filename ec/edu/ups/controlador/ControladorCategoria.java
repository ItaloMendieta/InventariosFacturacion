/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Categoria;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;

/**
 *
 * @author ASUS
 */
public class ControladorCategoria {

    private List<Categoria> listaCategoria;
    public String bd = "Facturacion";
    public String login = "administrador";
    public String password = "Patito.123@456";
    public String url = "jdbc:mysql://192.168.1.253:3306/" + bd;
    Connection conn = null;
    Statement st = null;
    ResultSet r = null;

    public ControladorCategoria() {
        listaCategoria = new ArrayList<>();
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

    public void registrarCategoria(Categoria p) {
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("INSERT  INTO " + "Categoria" + " VALUES" + "(" + p.getId()+",'"+p.getDescripcion()+"');");
            JOptionPane.showMessageDialog(null, "Los datos han sido guardados");
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido guardados");
        }

    }

    public void modificarCategoria(Categoria p, int codigo) {
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("UPDATE Categoria set descripcion = '" + p.getDescripcion()
                    + "' WHERE id = " + codigo + ";");
            JOptionPane.showMessageDialog(null, "Los datos han sido Actualizados");
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido Actualizados");
        }

    }

    public void eliminarCategoria(Categoria p, int codigo) {
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("DELETE FROM Categoria WHERE id =" + codigo + ";");
            JOptionPane.showMessageDialog(null, "Los datos han sido Eliminados");
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
            JOptionPane.showMessageDialog(null, "Los datos no han sido Eliminados");
        }
    }

    public Categoria BuscarCategoria(int codigo) {
        conexion();
        Categoria p = new Categoria();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM Categoria WHERE id= " + codigo + ";");
            while (r.next()) {
                String nombre = r.getString(2);
                p.setDescripcion(nombre);
                p.setId(codigo);
            }
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        }
        return p;
    }
      public Categoria BuscarCategoriaNombre(String nombre) {
        conexion();
        Categoria p = new Categoria();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM Categoria WHERE descripcion= '" + nombre + "';");
            while (r.next()) {
                int codigo = r.getInt(1);
                p.setDescripcion(nombre);
                p.setId(codigo);
            }
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        }
        return p;
    }
    

    public List<Categoria> listar() {
        conexion();
        List<Categoria> lista = new ArrayList<>();
         Categoria p;
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM Categoria Order by id ASC;");
            while (r.next()) {
                p = new Categoria();
                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                p.setId(codigo);
                p.setDescripcion(nombre);
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
            r = st.executeQuery("SELECT max(id) FROM Categoria;");
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
