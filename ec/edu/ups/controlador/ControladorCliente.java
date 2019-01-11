
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import com.mysql.jdbc.Connection;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;
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

/**
 *
 * @author ASUS
 */
public class ControladorCliente {

    private String bd = "Facturacion";
    private String login = "administrador";
    private String password = "Patito.123@456";
    private String url = "jdbc:mysql://192.168.1.253:3306/" + bd;
    Connection conn = null;
    Statement st = null;
    ResultSet r = null;

    public ControladorCliente() {
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
            System.out.println("Hubo un problema al intentar desconectarse con la base de datos " + url);
            System.out.println("error " + ex);
        }
    }

    public void crearPersona(Persona p) {
        conexion();
//        try {
//            String sql = "INSERT INTO Persona (id, nombre, apellido, genero, fechanacimiento, correo, cedula, telefono, direccion ) VALUES (" + p.getIdPer() + ",'" + p.getNombre() + "','" + p.getApellido()
//                    + "','" + p.getGenero() + "','" + p.getFecha_Naciemineto() + "','" + p.getCorreo() + "','" + p.getCedula() + "','" + p.getTelefono() + "','" + p.getDireccion() + "');";
//            System.out.println(sql);
//            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
//            st.execute(sql);
//            //JOptionPane.showMessageDialog(null, "Los datos han sido guardados");
//        } catch (SQLException ex) {
//            System.out.println("error " + ex);
//            //JOptionPane.showMessageDialog(null, "Los datos no han sido guardados");
//        }
    }

    public void crearCliente(Cliente g) {
        conexion();
        try {
            String sql = "INSERT INTO Cliente (id, Persona_id ) VALUES (" + g.getId() + "," + g.getIdPer() + ");";
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Los datos han sido guardados");
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido guardados");
        }
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
        return ++codigo;
    }

    public int obtenerCodigo() {
        conexion();
        int codigo = 0;
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT max(id) FROM Cliente;");
            r.next();
            codigo = r.getInt(1);
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Error de SQL " + ex);
        }
        return ++codigo;
    }

    public void modificarPersona(Persona nueva, String cedula) {
        conexion();
//        try {
//            String sql = "UPDATE Persona SET nombre = '" + nueva.getNombre() + "', apellido = '" + nueva.getApellido()
//                    + "',correo = '" + nueva.getCorreo()
//                    + "',cedula = '" + nueva.getCedula()
//                    + "',telefono ='" + nueva.getTelefono()
//                    + "',direccion ='" + nueva.getDireccion() + "' WHERE cedula= " + cedula + ";";
//
//            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
//            st.execute(sql);
//
//           // JOptionPane.showMessageDialog(null, "Los datos han sido Actualizados");
//            desconectar();
//
//        } catch (SQLException ex) {
//            //System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
//            System.out.println("error" + ex);
//            JOptionPane.showMessageDialog(null, "Los datos no han sido Actualizados");
//        }
        desconectar();
    }

    public void modificarCliente(Cliente nueva, int id) {
        try {
            String sql = "UPDATE Cliente SET id = " + nueva.getId() + " WHERE id = " + id + ";";

            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            System.out.println("perderrrrrrrrrrrrr111");
            st.execute(sql);

            JOptionPane.showMessageDialog(null, "Los datos han sido Actualizados");

        } catch (SQLException ex) {
            System.out.println("error" + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido Actualizados");
        }
    }

    public void eliminarCliente(String codigo) {
        conexion();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            String sql = "DELETE FROM Cliente WHERE id = " + codigo + ";";
            st.execute(sql);
            conn.close();
            st.close();
         //   JOptionPane.showMessageDialog(null, "Los datos han sido Eliminados");
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
           // JOptionPane.showMessageDialog(null, "Los datos no han sido Eliminados");
        }
    }

    public void eliminarPersonaCedula(String cedula) {
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
    }

    public void eliminarPersonaCodigo(int codigo) {
        conexion();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            String sql = "DELETE FROM Persona WHERE id = " + codigo + ";";
            st.execute(sql);
            conn.close();
            st.close();
           // JOptionPane.showMessageDialog(null, "Los datos han sido Eliminados");

        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
            //JOptionPane.showMessageDialog(null, "Los datos no han sido Eliminados");

        }
    }

    public Cliente buscarPersona(String cedula) {
        conexion();
        Cliente p = new Cliente();
        String sql = "SELECT * FROM Persona p, Cliente c WHERE p.id=c.Persona_id and p.cedula=  '" + cedula + "'; ";

        try {
            st = conn.createStatement();
            r = st.executeQuery(sql);

            while (r.next()) {

                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                String apellido = r.getString(3);
                String genero = r.getString(4);
                String fecha = r.getString(5);
                String correo = r.getString(6);
                String cedul = r.getString(7);
                String telefono = r.getString(8);
                String direccion = r.getString(9);
                int idC = r.getInt(10);

                p.setIdPer(codigo);
                p.setNombre(nombre);
                p.setApellido(apellido);
//                p.setGenero(genero);
//                p.setFecha_Naciemineto(fecha);
                p.setCorreo(correo);
                p.setCedula(cedul);
                p.setTelefono(telefono);
                p.setDireccion(direccion);
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

    public Cliente buscarClienteNombre(String nombr, String apellid) {
        conexion();
        Cliente p = new Cliente();
        String sql = "SELECT * FROM Persona WHERE nombre=  '" + nombr + "'and apellido= '" + apellid + "'; ";

        try {
            st = conn.createStatement();
            r = st.executeQuery(sql);

            while (r.next()) {

                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                String apellido = r.getString(3);
                String genero = r.getString(4);
                String fecha = r.getString(5);
                String correo = r.getString(6);
                String cedul = r.getString(7);
                String telefono = r.getString(8);
                String direccion = r.getString(9);
                p.setIdPer(codigo);
                p.setNombre(nombre);
                p.setApellido(apellido);
//                p.setGenero(genero);
//                p.setFecha_Naciemineto(fecha);
                p.setCorreo(correo);
                p.setCedula(cedul);
                p.setTelefono(telefono);
                p.setDireccion(direccion);

            }
            st.close();
            r.close();
        } catch (SQLException ex) {
            System.out.println("Error del SQL" + ex);
        }
        desconectar();
        return p;

    }

    public Cliente buscarPersonaxId(int cod) {
        conexion();
        Cliente p = new Cliente();
        String sql = "SELECT * FROM Persona p, Cliente c WHERE p.id=c.Persona_id and c.id=  " + cod + "; ";
        try {
            st = conn.createStatement();
            r = st.executeQuery(sql);
            while (r.next()) {
                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                String apellido = r.getString(3);
                String genero = r.getString(4);
                String fecha = r.getString(5);
                String correo = r.getString(6);
                String cedul = r.getString(7);
                String telefono = r.getString(8);
                String direccion = r.getString(9);
                int idC = r.getInt(10);
                p.setIdPer(codigo);
                p.setNombre(nombre);
                p.setApellido(apellido);
//                p.setGenero(genero);
//                p.setFecha_Naciemineto(fecha);
                p.setCorreo(correo);
                p.setCedula(cedul);
                p.setTelefono(telefono);
                p.setDireccion(direccion);
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

    public Cliente buscarPersonaxIdS(String cod) {
        conexion();
        Cliente p = new Cliente();
        String sql = "SELECT * FROM Persona p, Cliente c WHERE p.id=c.Persona_id and c.id=  " + cod + "; ";
        try {
            st = conn.createStatement();
            r = st.executeQuery(sql);
            while (r.next()) {
                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                String apellido = r.getString(3);
                String genero = r.getString(4);
                String fecha = r.getString(5);
                String correo = r.getString(6);
                String cedul = r.getString(7);
                String telefono = r.getString(8);
                String direccion = r.getString(9);
                int idC = r.getInt(10);
                p.setIdPer(codigo);
                p.setNombre(nombre);
                p.setApellido(apellido);
//                p.setGenero(genero);
//                p.setFecha_Naciemineto(fecha);
                p.setCorreo(correo);
                p.setCedula(cedul);
                p.setTelefono(telefono);
                p.setDireccion(direccion);
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

    public List<Cliente> listar() {
        conexion();
        List<Cliente> lista = null;
        String sql = "SELECT * FROM Persona p, Cliente c where p.id=c.Persona_id Order by c.id ASC;";

        try {
            lista = new ArrayList<>();
            st = conn.createStatement();
            r = st.executeQuery(sql);
            while (r.next()) {
                Cliente p = new Cliente();
                p.setIdPer(r.getInt("id"));
                p.setNombre(r.getString("nombre").trim());
                p.setApellido(r.getString("apellido").trim());
  //              p.setGenero(r.getString("genero").trim());
//                p.setFecha_Naciemineto(r.getString("fechaNacimiento"));
                p.setCorreo(r.getString("correo").trim());
                p.setCedula(r.getString("cedula").trim());
                p.setTelefono(r.getString("telefono").trim());
                p.setDireccion(r.getString("direccion").trim());
                int idC = r.getInt(10);
                p.setId(idC);
                lista.add(p);
            }
            st.close();
            r.close();

        } catch (Exception ex) {
        }
        desconectar();
        System.out.println(lista);
        return lista;
    }

    public List<Cliente> BuscarClienteLik(String cliente) {
        List<Cliente> lista = new ArrayList<>();
        conexion();
        try {
            String sql = "SELECT * FROM Persona p, Cliente c WHERE c.Persona_id=p.id and (p.apellido like '" + cliente + "_%' or p.apellido ='" + cliente + "');";
            // String sql = "SELECT distinct * FROM Facturacion.Producto p, Facturacion.Categoria c WHERE  p.Categoria_id=c.id and p.descripcion like '"+producto+"_%' or p.codigoProducto like '"+producto+"_%' or c.descripcion like '"+producto+"_%' ;";
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery(sql);
            while (r.next()) {
                Cliente p = new Cliente();
                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                String apellido = r.getString(3);
                String genero = r.getString(4);
                String fecha = r.getString(5);
                String correo = r.getString(6);
                String cedul = r.getString(7);
                String telefono = r.getString(8);
                String direccion = r.getString(9);
                int idC = r.getInt(10);
                p.setIdPer(codigo);
                p.setNombre(nombre);
                p.setApellido(apellido);
//                p.setGenero(genero);
//                p.setFecha_Naciemineto(fecha);
                p.setCorreo(correo);
                p.setCedula(cedul);
                p.setTelefono(telefono);
                p.setDireccion(direccion);
                p.setId(idC);
                lista.add(p);
            }
            st.close();
            r.close();
        } catch (Exception ex) {
            System.out.println("Error " + ex);

        }
        return lista;
    }

    public List<Cliente> BuscarClienteLikCedula(String cliente) {
        List<Cliente> lista = new ArrayList<>();
        conexion();
        try {
            String sql = "SELECT * FROM Persona p, Cliente c WHERE c.Persona_id=p.id and (p.cedula like '" + cliente + "_%' or p.cedula ='" + cliente + "');";
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery(sql);
            while (r.next()) {
                Cliente p = new Cliente();
                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                String apellido = r.getString(3);
                String genero = r.getString(4);
                String fecha = r.getString(5);
                String correo = r.getString(6);
                String cedul = r.getString(7);
                String telefono = r.getString(8);
                String direccion = r.getString(9);
                int idC = r.getInt(10);
                p.setIdPer(codigo);
                p.setNombre(nombre);
                p.setApellido(apellido);
//                p.setGenero(genero);
//                p.setFecha_Naciemineto(fecha);
                p.setCorreo(correo);
                p.setCedula(cedul);
                p.setTelefono(telefono);
                p.setDireccion(direccion);
                p.setId(idC);
                lista.add(p);
            }
            st.close();
            r.close();
        } catch (Exception ex) {
            System.out.println("Error " + ex);

        }
        return lista;
    }

    public List<Cliente> BuscarClienteCedula(String cliente) {
        List<Cliente> lista = new ArrayList<>();
        conexion();
        try {
            String sql = "SELECT * FROM Persona p, Cliente c WHERE c.Persona_id=p.id and p.cedula ='" + cliente + "';";
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery(sql);
            while (r.next()) {
                Cliente p = new Cliente();
                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                String apellido = r.getString(3);
                String genero = r.getString(4);
                String fecha = r.getString(5);
                String correo = r.getString(6);
                String cedul = r.getString(7);
                String telefono = r.getString(8);
                String direccion = r.getString(9);
                int idC = r.getInt(10);
                p.setIdPer(codigo);
                p.setNombre(nombre);
                p.setApellido(apellido);
//                p.setGenero(genero);
//                p.setFecha_Naciemineto(fecha);
                p.setCorreo(correo);
                p.setCedula(cedul);
                p.setTelefono(telefono);
                p.setDireccion(direccion);
                p.setId(idC);
                lista.add(p);
            }
            st.close();
            r.close();
        } catch (Exception ex) {
            System.out.println("Error " + ex);

        }
        return lista;
    }

    public Cliente BuscarClienteCedulaText(String cliente) {
        Cliente p = new Cliente();
        conexion();

        String sql = "SELECT * FROM Persona p, Cliente c WHERE c.Persona_id=p.id and p.cedula ='" + cliente + "';";
        try {
            st = conn.createStatement();
            r = st.executeQuery(sql);
           if (r.next()) {
                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                String apellido = r.getString(3);
                String genero = r.getString(4);
                String fecha = r.getString(5);
                String correo = r.getString(6);
                String cedul = r.getString(7);
                String telefono = r.getString(8);
                String direccion = r.getString(9);
                int idC = r.getInt(10);
                p.setIdPer(codigo);
                p.setNombre(nombre);
                p.setApellido(apellido);
//                p.setGenero(genero);
//                p.setFecha_Naciemineto(fecha);
                p.setCorreo(correo);
                p.setCedula(cedul);
                p.setTelefono(telefono);
                p.setDireccion(direccion);
                p.setId(idC);

            }
            st.close();
            r.close();
        } catch (Exception ex) {
            System.out.println("Error " + ex);

        }
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
