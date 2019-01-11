/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author java
 */
public class Proveedor {
    private int id;
    private String nombre;
    private String ruc;
    private String direccion;

    public Proveedor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", nombre=" + nombre + ", ruc=" + ruc + ", direccion=" + direccion + '}';
    }
    

    
}
