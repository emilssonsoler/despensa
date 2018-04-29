/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa;

import java.io.Serializable;

/**
 *
 * @author Emilsson Soler
 */
public class Proveedor implements  Serializable{
    private String nombre;
    private String descripcion;
    private int codigo;

    public Proveedor(String nombre, String descripcion, int codigo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    
    public Proveedor() {
    }
    /**
     * 
     * @param nombre
     * @param telefono 
     */
    public Proveedor(String nombre, String telefono) {
        this.nombre = nombre;
        this.descripcion = telefono;
    }

    public Proveedor(String nombre) {
        this.nombre = nombre;
    }
    

    /**
     * 
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * 
     * @param codigo 
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    @Override
    public String toString(){
    return this.nombre;
    }
    
}
