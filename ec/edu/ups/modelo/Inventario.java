/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author ASUS
 */
public class Inventario {
    private int id;
    private int cantidadEntrada;
    private int cantidadSalida;
    private double precioEntrada;
    private double precioSalida;
    private int totalCantidad;
    private double totalSaldo;
    private Producto producto;
    
    public Inventario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadEntrada() {
        return cantidadEntrada;
    }

    public void setCantidadEntrada(int cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }

    public int getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(int cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public double getPrecioSalida() {
        return precioSalida;
    }

    public void setPrecioSalida(double precioSalida) {
        this.precioSalida = precioSalida;
    }

    public int getTotalCantidad() {
        return totalCantidad;
    }

    public void setTotalCantidad(int totalCantidad) {
        this.totalCantidad = totalCantidad;
    }

    public double getTotalSaldo() {
        return totalSaldo;
    }

    public void setTotalSaldo(double totalSaldo) {
        this.totalSaldo = totalSaldo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Inventario " + "id =" + id + ", cantidadEntrada =" + cantidadEntrada + ", cantidadSalida =" + cantidadSalida + ", precioEntrada =" + precioEntrada + ", precioSalida =" + precioSalida + ", totalCantidad =" + totalCantidad + ", totalSaldo =" + totalSaldo + ", producto =" + producto ;
    }
    
}
