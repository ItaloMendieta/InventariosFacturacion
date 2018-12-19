/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import ec.edu.ups.modelo.Persona;

/**
 *
 * @author Jonathan
 */
public class Gerente extends Persona{
    private int id;
    private String usuario;
    private String contraseña;

    public Gerente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Gerente{" + "id=" + id + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }
    


   

    

   

    
}
