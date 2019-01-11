/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Producto;
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
import ec.edu.ups.modelo.Proveedor;

/**
 *
 * @author ASUS
 */
public class ControladorProducto {

    private List<Producto> listaProducto;
    public String bd = "Facturacion";
    public String login = "administrador";
    public String password = "Patito.123@456";
    public String url = "jdbc:mysql://192.168.1.253:3306/" + bd;
    Connection conn = null;
    Statement st = null;
    ResultSet r = null;

    public ControladorProducto() {
        listaProducto = new ArrayList<>();
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

    public void registrarProducto(Producto p) {
        conexion();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("INSERT  INTO " + "Producto" + " VALUES" + "(" + p.getId() + ",'" + p.getDescripcion() + "'," + p.getPrecio() + "," + p.getCategoria().getId() +","+ p.getProveedor().getId()
                    + ",'" + p.getCodigo() + "'," + p.getCantidad() + ");");
            JOptionPane.showMessageDialog(null, "Producto agregado: " + p.getCodigo() + " " + p.getDescripcion());
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido guardados");
        }
        desconectar();

    }

    public void modificarProducto(Producto p, String codigo) {
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("UPDATE Producto set descripcion = '" + p.getDescripcion()
                    + "',precio =" + p.getPrecio() + ",Categoria_id =" + p.getCategoria().getId() + ",Proveedor_id = " + p.getProveedor().getId() + " WHERE codigoProducto = '" + codigo + "';");
            JOptionPane.showMessageDialog(null, "Los datos han sido Actualizados");
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido Actualizados");
        }

    }

    public void modificarProductoCantidad(Producto p, String codigo) {
        conexion();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("UPDATE Producto set cantidad = " + p.getCantidad() + " WHERE codigoProducto = '" + codigo + "';");
            desconectar();
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido Actualizados");
        }

    }

    public void eliminarProducto(Producto p, int codigo) {
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            st.executeUpdate("DELETE FROM Producto WHERE id =" + codigo + ";");
            JOptionPane.showMessageDialog(null, "Los datos han sido Eliminados");
        } catch (SQLException ex) {
//            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
            System.out.println("Error " + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido Eliminados");
        }
    }

    public Producto BuscarProducto(int codigo) {
        conexion();
        Producto p = new Producto();
        ControladorCategoria cc = new ControladorCategoria();
        ControladorProveedor controladorProveedor = new ControladorProveedor();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM Producto WHERE id= " + codigo + ";");
            while (r.next()) {
                String descripcion = r.getString(2);
                double precio = r.getDouble(3);
                int cat = r.getInt(4);
                int prov = r.getInt(5);
                String codProducto = r.getString(6);
                int cant = r.getInt(7);
                p.setId(codigo);
                p.setDescripcion(descripcion);
                p.setPrecio(precio);
                p.setCodigo(codProducto);
                p.setCantidad(cant);
                Categoria categoria = cc.BuscarCategoria(cat);
                Proveedor proveedor = controladorProveedor.buscarPCodigo(prov);
                p.setCategoria(categoria);
                p.setProveedor(proveedor);
            }
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        }
        return p;
    }

    public Producto BuscarProducto(String descripcion) {
        Producto p = new Producto();
        ControladorCategoria cc = new ControladorCategoria();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM Producto WHERE descripcion= '" + descripcion + "';");
            while (r.next()) {
                int c = r.getInt(1);
                String nombre = r.getString(2);
                double precio = r.getDouble(3);
                int cat = r.getInt(4);
                String codProducto = r.getString(6);
                int cant = r.getInt(7);
                p.setId(c);
                p.setDescripcion(nombre);
                p.setPrecio(precio);
                p.setCantidad(cant);
                p.setCodigo(codProducto);
                Categoria categoria = cc.BuscarCategoria(cat);
                p.setCategoria(categoria);
            }
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        }
        return p;
    }

    public List<Producto> listar() {
        conexion();
        List<Producto> lista = new ArrayList<>();
        Producto p;
        ControladorCategoria cc = new ControladorCategoria();
        ControladorProveedor controladorProveedor = new ControladorProveedor();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM Producto p, Inventario i where p.id=i.Producto_id Order by p.id ASC;");
            while (r.next()) {
                p = new Producto();
                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                double precio = r.getDouble(3);
                int cat = r.getInt(4);
                int prov = r.getInt(5);
                String codigoPro = r.getString(6);
                int cantidad = r.getInt(7);

                p.setDescripcion(nombre);
                p.setPrecio(precio);
                Categoria categoria = cc.BuscarCategoria(cat);
                Proveedor proveedor = controladorProveedor.buscarPCodigo(prov);
                p.setCategoria(categoria);
                p.setProveedor(proveedor);
                p.setId(codigo);
                p.setDescripcion(nombre);
                p.setCodigo(codigoPro);
                p.setCantidad(cantidad);
                lista.add(p);
            }
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }
        return lista;
    }

    public List<Producto> listarxP(int idProveedor) {
        List<Producto> lista = new ArrayList<>();
        Producto p;
        ControladorCategoria cc = new ControladorCategoria();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM Producto where Proveedor_id=" + idProveedor + ";");
            while (r.next()) {
                p = new Producto();
                int codigo = r.getInt(1);
                String nombre = r.getString(2);
                double precio = r.getDouble(3);
                int cat = r.getInt(4);
                int cant = r.getInt(7);
                String cod=r.getString(6);
                p.setDescripcion(nombre);
                p.setPrecio(precio);
                p.setCantidad(cant);
                Categoria categoria = cc.BuscarCategoria(cat);
                p.setCategoria(categoria);
                p.setId(codigo);
                p.setCodigo(cod);
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
            r = st.executeQuery("SELECT max(id) FROM Producto;");
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

    public String Codigo(String nombre, String categoria) {
        String codigo = "";
        String cadena = nombre;
        String cadena2 = categoria;
        String sCadena = cadena.substring(0, 4).toUpperCase();
        String sCadenaD = cadena2.substring(0, 3).toUpperCase();
        conexion();
        int num = 0;
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT count(c.id) FROM Facturacion.Producto p, Facturacion.Categoria c where p.Categoria_id=c.id and c.descripcion='" + categoria + "';");
            r.next();
            num = r.getInt(1);
        } catch (SQLException ex) {
            System.out.println("error " + ex);
            JOptionPane.showMessageDialog(null, "Los datos no han sido guardados");
        }
        if (num < 10) {
            codigo = sCadenaD + "-" + sCadena + "-000" + (num + 1);
        }
        if (num < 100 && num >= 10) {
            codigo = sCadenaD + "-" + sCadena + "-00" + (num + 1);
        }
        if (num < 1000 && num >= 100) {
            codigo = sCadenaD + "-" + sCadena + "-0" + (num + 1);
        }
        if (num >= 1000) {
            codigo = sCadenaD + "-" + sCadena + "-" + (num + 1);
        }

        return codigo;
    }

    public List<Producto> BuscarProductoLik(String producto) {
        List<Producto> lista = new ArrayList<>();
        conexion();
        ControladorCategoria cc = new ControladorCategoria();
        try {
            String sql = "SELECT * FROM Producto p, Inventario i WHERE i.Producto_id=p.id and ((p.descripcion like '" + producto + "_%' or p.descripcion ='" + producto + "')OR(p.codigoProducto like '" + producto + "_%' or p.codigoProducto ='" + producto + "'));";
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery(sql);
            while (r.next()) {
                Producto p = new Producto();
                String descripcion = r.getString(2);
                double precio = r.getDouble(3);
                int cat = r.getInt(4);
                String codigo = r.getString(6);
                int cantidad = r.getInt(7);

                p.setCodigo(codigo);
                p.setDescripcion(descripcion);
                p.setPrecio(precio);
                Categoria categoria = cc.BuscarCategoria(cat);
                p.setCategoria(categoria);
                p.setCantidad(cantidad);

                lista.add(p);
            }
            st.close();
            r.close();
        } catch (Exception ex) {
            System.out.println("Error " + ex);

        }
        return lista;
    }

    public Producto BuscarProductoCod(String codigo) {
        conexion();
        Producto p = new Producto();
        ControladorCategoria cc = new ControladorCategoria();
        ControladorProveedor controladorProveedor = new ControladorProveedor();
        try {
            st = conn.createStatement(r.TYPE_SCROLL_SENSITIVE, r.CONCUR_UPDATABLE);
            r = st.executeQuery("SELECT * FROM Producto WHERE codigoProducto = '" + codigo + "';");
            while (r.next()) {
                int id = r.getInt(1);
                String nombre = r.getString(2);
                double precio = r.getDouble(3);
                int cat = r.getInt(4);
                int prov = r.getInt(5);
                int cant = r.getInt(7);
                p.setId(id);
                p.setDescripcion(nombre);
                p.setPrecio(precio);
                p.setCodigo(codigo);
                p.setCantidad(cant);
                Categoria categoria = cc.BuscarCategoria(cat);
                Proveedor proveedor = controladorProveedor.buscarPCodigo(prov);
                p.setCategoria(categoria);
                p.setProveedor(proveedor);
            }
            r.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Hubo un problema al realizar la busqueda " + url);
        }
        return p;
    }

}
