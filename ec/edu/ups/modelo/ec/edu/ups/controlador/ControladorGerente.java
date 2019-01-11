/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import com.mysql.jdbc.Connection;
import ec.edu.ups.modelo.Gerente;
import ec.edu.ups.modelo.Persona;
import java.sql.Date;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorGerente {

    private String bd = "Facturacion";
    private String login = "administrador";
    private String password = "Patito.123@456";
    private String url = "jdbc:mysql://192.168.1.253:3306/" + bd;
    Connection conn = null;
    Statement st = null;
    ResultSet r = null;

    public ControladorGerente() {
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

    public void crearPersona(Persona p) {
        conexion();
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//        String fecha = formato.format(p.getFecha_Naciemineto());
//        try {
//            String sql = "INSERT INTO Persona (id, nombre, apellido, genero, fechaNacimiento, correo, cedula, telefono, direccion ) VALUES (" + p.getIdPer() + ",'" + p.getNombre() + "','" + p.getApellido() + "','" + p.getGenero() + "','" + fecha
//                    + "','" + p.getCorreo() + "','" + p.getCedula() + "','" + p.getTelefono() + "','" + p.getDireccion() + "');";
//            System.out.println(sql);
//            // Statement sentencia = conexion.createStatement();      
//            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
//            st.execute(sql);
//            JOptionPane.showMessageDialog(null, "Los datos han sido guardados");
//        } catch (SQLException ex) {
//            System.out.println("error " + ex);
//            JOptionPane.showMessageDialog(null, "Los datos no han sido guardados");
//        }
        desconectar();
    }

    public void crearGerente(Gerente g) {
        conexion();
        try {
            String sql = "INSERT INTO Gerente (id, ususario, contrasenia , Persona_id ) VALUES (" + g.getId() + ",'" + g.getUsuario() + "','" + g.getContraseña() + "'," + g.getIdPer() + ");";

            System.out.println(g.getIdPer());
            // Statement sentencia = conexion.createStatement();      
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Los datos han sido guardados");
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido guardados");
        }
        desconectar();
    }

    public int obtenerCodigoPersona() {
        conexion();
        int codigo = 0;
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT max(id) FROM Persona;");
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

    public int obtenerCodigo() {
        conexion();
        int codigo = 0;
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT max(id) FROM Gerente;");
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

    public void modificarPersona(Persona nueva, String cedula) {

        conexion();
        try {
            System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//            String sql = "UPDATE Persona SET nombre = '" + nueva.getNombre() + "', apellido = '" + nueva.getApellido() + "', genero = '" + nueva.getGenero()
//                    + "',fechaNacimiento = '" + nueva.getFecha_Naciemineto()
//                    + "',correo ='" + nueva.getCorreo()
//                    + "',cedula = '" + nueva.getCedula()
//                    + "',telefono ='" + nueva.getTelefono()
//                    + "',direccion ='" + nueva.getDireccion() + "' WHERE cedula= " + cedula + ";";

            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            System.out.println("perderrrrrrrrrrrrr");
//            st.execute(sql);

            JOptionPane.showMessageDialog(null, "Los datos han sido Actualizados");

        } catch (SQLException ex) {
            //System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
            System.out.println("error" + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido Actualizados");
        }
        desconectar();
    }

    public void modificarGerente(Gerente nueva, int id) {

        conexion();
        try {
            System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa111111");
            String sql = "UPDATE Gerente SET id = " + nueva.getId() + ", ususario = '" + nueva.getUsuario() + "', contrasenia = '" + nueva.getContraseña() + "' WHERE id = " + id + ";";

            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            System.out.println("perderrrrrrrrrrrrr111");
            st.execute(sql);

            JOptionPane.showMessageDialog(null, "Los datos han sido Actualizados");

        } catch (SQLException ex) {
            //System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
            System.out.println("error" + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido Actualizados");
        }
        desconectar();
    }

    public void eliminarGerente(int codigo) {
        conexion();
        try {

            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            String sql = "DELETE FROM Gerente WHERE `id` = " + codigo + ";";
            st.execute(sql);
            conn.close();
            st.close();
            JOptionPane.showMessageDialog(null, "Los datos han sido Eliminados");

        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
            JOptionPane.showMessageDialog(null, "Los datos no han sido Eliminados");

        }
        desconectar();
    }

    public void eliminarPersona(String cedula) {
        conexion();
        try {

            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            String sql = "DELETE FROM Persona WHERE cedula = " + cedula + ";";
            st.execute(sql);
            conn.close();
            st.close();
            JOptionPane.showMessageDialog(null, "Los datos han sido Eliminados");

        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
            JOptionPane.showMessageDialog(null, "Los datos no han sido Eliminados");

        }
        desconectar();
    }

    public Persona buscarPersona(String cedula) {
        conexion();
        Persona p = new Persona();
        String sql = "SELECT * FROM Persona WHERE cedula=  '" + cedula + "'; ";

        try {
            st = conn.createStatement();
            r = st.executeQuery(sql);

            while (r.next()) {

                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                String apellido = r.getString(3);
                String genero = r.getString(4);
                Date fecha = r.getDate(5);
                String correo = r.getString(6);
                String cedul = r.getString(7);
                String telefono = r.getString(8);
                String direccion = r.getString(9);
                p.setIdPer(codigo);
                p.setNombre(nombre);
                p.setApellido(apellido);
                p.setCedula(cedul);
                p.setTelefono(telefono);

            }
        } catch (SQLException ex) {
            System.out.println("Error del SQL" + ex);
        }
        desconectar();
        return p;

    }

    public Persona buscarPersonaxNombre(String nombr, String apellid) {
        conexion();
        Persona p = new Persona();
        String sql = "SELECT * FROM Persona WHERE nombre=  '" + nombr + "'and apellido= '" + apellid + "'; ";

        try {
            st = conn.createStatement();
            r = st.executeQuery(sql);

            while (r.next()) {

                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                String apellido = r.getString(3);
                String cedul = r.getString(7);
                String telefono = r.getString(8);
                p.setIdPer(codigo);
                p.setNombre(nombre);
                p.setApellido(apellido);
                p.setCedula(cedul);
                p.setTelefono(telefono);
            }
        } catch (SQLException ex) {
            System.out.println("Error del SQL" + ex);
        }
        desconectar();
        return p;

    }

    public Persona buscarPersonaxId(int cod) {
        conexion();
        Persona p = new Persona();
        String sql = "SELECT * FROM Persona WHERE id=  " + cod + "; ";

        try {
            st = conn.createStatement();
            r = st.executeQuery(sql);

            while (r.next()) {

                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                String apellido = r.getString(3);
                String genero = r.getString(4);
                Date fecha = r.getDate(5);
                String correo = r.getString(6);
                String cedul = r.getString(7);
                String telefono = r.getString(8);
                String direccion = r.getString(9);
                p.setIdPer(codigo);
                p.setNombre(nombre);
                p.setApellido(apellido);
                p.setCedula(cedul);
                p.setTelefono(telefono);

            }
        } catch (SQLException ex) {
            System.out.println("Error del SQL" + ex);
        }
        desconectar();
        return p;

    }

    public Gerente buscarGerente(int Persona_id) {
        conexion();
        Gerente g = new Gerente();
        ControladorGerente cg = new ControladorGerente();
        String sql = "SELECT * FROM Gerente WHERE Persona_id= " + Persona_id + "; ";

        try {
            st = conn.createStatement();
            r = st.executeQuery(sql);

            while (r.next()) {
                int codigo = r.getInt(1);
                String usuario = r.getString(2);
                String contrasenia = r.getString(3);
                int idPer = r.getInt(4);
                g.setId(codigo);
                g.setUsuario(usuario);
                g.setContraseña(contrasenia);
                g.setIdPer(idPer);

            }
        } catch (SQLException ex) {
            System.out.println("Error del SQL" + ex);
        }
        desconectar();
        return g;

    }

    public List<Gerente> listarGerente() {
        conexion();
        List<Gerente> lista1 = new ArrayList<>();
        String sql = "SELECT * FROM Gerente Order by id ASC;";
        try {
            st = conn.createStatement();
            r = st.executeQuery(sql);
            while (r.next()) {
                Gerente p = new Gerente();
                int idg = r.getInt(1);
                int id = r.getInt(4);
                //p.setPerId(id);
                p.setId(id);
                p.setUsuario(r.getString("ususario").trim());
                p.setContraseña(r.getString("contrasenia").trim());
                System.out.println("" + p.getUsuario());
                lista1.add(p);
//     resultado.close();
            }
            desconectar();

        } catch (Exception ex) {
        }
        System.out.println(lista1);
        return lista1;
    }

    public List<Persona> listar() {
        conexion();
        List<Persona> lista = null;
        String sql = "SELECT * FROM Persona Order by id ASC;";
        try {
            lista = new ArrayList<>();
            st = conn.createStatement();
            r = st.executeQuery(sql);
            while (r.next()) {
                Persona p = new Persona();
                p.setIdPer(r.getInt("id"));
                p.setNombre(r.getString("nombre").trim());
                p.setApellido(r.getString("apellido").trim());
                p.setCedula(r.getString("cedula").trim());
                p.setTelefono(r.getString("telefono").trim());
                lista.add(p);
//                resultado.close();
            }

        } catch (Exception ex) {
        }
        desconectar();
        System.out.println(lista);
        return lista;
    }

    public Gerente buscarGerenteLog(String us, String pas) {
        conexion();
        Gerente p = new Gerente();
        String sql = "SELECT * FROM Facturacion.Persona p, Facturacion.Gerente c where p.id=c.Persona_id and c.ususario= '" + us + "' and c.contrasenia='" + pas + "'; ";
        try {
            st = conn.createStatement();
            r = st.executeQuery(sql);
            while (r.next()) {
                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                String apellido = r.getString(3);
                String cedul = r.getString(7);
                String telefono = r.getString(8);
                int idC = r.getInt(10);
                String usuario = r.getString(11);
                String pass = r.getString(12);
                p.setIdPer(codigo);
                p.setNombre(nombre);
                p.setApellido(apellido);
                p.setCedula(cedul);
                p.setTelefono(telefono);
                p.setUsuario(usuario);
                p.setContraseña(pass);
                p.setId(idC);

            }
            st.close();
            r.close();
        } catch (SQLException ex) {
            System.out.println("Error del SQL" + ex);
        }
        desconectar();
        return p;

    }

    public boolean validarCedula(String Cedula) {
        if (Cedula.length() == 10) {
            int digito = Integer.parseInt(Cedula.substring(2, 3));
            if (digito < 6) {
                int[] MCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                int verificador = Integer.parseInt(Cedula.substring(9, 10));
                int suma = 0;
                for (int i = 0; i < (Cedula.length() - 1); i++) {
                    digito = Integer.parseInt(Cedula.substring(i, i + 1)) * MCedula[i];
                    suma += ((digito % 10) + (digito / 10));
                }
                if (suma % 10 == 0 && suma % 10 == verificador) {
                    return true;
                }
                if ((10 - (suma % 10)) == verificador) {
                    return true;
                } else {
                    return false;
                }

            }
        }
        return false;
    }

}
