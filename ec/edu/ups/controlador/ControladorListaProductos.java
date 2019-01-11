/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

/**
 *
 * @author ASUS
 */
public class ControladorListaProductos {
    
    private String cantidad;
    private String descripcion;
    private String unidad;
    private String totalvalor;

    public ControladorListaProductos(String cantidad, String descripcion, String unidad, String totalvalor) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.totalvalor=totalvalor;
      
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getTotalvalor() {
        return totalvalor;
    }

    public void setTotalvalor(String totalvalor) {
        this.totalvalor = totalvalor;
    }

    @Override
    public String toString() {
        return "ControladorListaProductos{" + "cantidad=" + cantidad + ", descripcion=" + descripcion + ", unidad=" + unidad + ", totalvalor=" + totalvalor + '}';
    }

    
    
    
}
