/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Emilsson Soler
 */
public class Producto  implements Serializable{
    private int codigo;
    private int codigoDB;
    private String nombre;
    private float precioCompra;
    private float precioVenta;
    private Proveedor proveedor;
    private Refrigeracion refrigeracion;

    public Producto() {
    }

    /**
     * 
     * @param codigo
     * @param codigoDB
     * @param nombre
     * @param precioCompra
     * @param precioVenta
     * @param proveedor
     * 
     */
    public Producto(int codigo, int codigoDB, String nombre, float precioCompra, float precioVenta, Proveedor proveedor,boolean refri) {    
        this.codigo = codigo;
        this.codigoDB = codigoDB;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.proveedor = proveedor;
        this.refrigeracion = new Refrigeracion(refri);
       
    }
    
    /**
     * 
     * @param codigo
     * @param codigoDB
     * @param nombre
     * @param precioCompra
     * @param precioVenta
     * @param proveedor
     * @param fechaDeVencimiento
     * @param refrigeracion 
     */
    public Producto(int codigo, int codigoDB, String nombre, float precioCompra, float precioVenta, Proveedor proveedor, Date fechaDeVencimiento, Refrigeracion refrigeracion) {
        this.codigo = codigo;
        this.codigoDB = codigoDB;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.proveedor = proveedor;
        this.refrigeracion = refrigeracion;
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
     * @return precioCompra
     */
    public float getPrecioCompra() {
        return precioCompra;
    }

    /**
     * 
     * @param precioCompra 
     */
    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    /**
     * 
     * @return precioVenta
     */
    public float getPrecioVenta() {
        return precioVenta;
    }

    /**
     * 
     * @param precioVenta 
     */
    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * 
     * @return proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * 
     * @param proveedor 
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getCodigoDB() {
        return codigoDB;
    }

   

    public Refrigeracion getRefrigeracion() {
        return refrigeracion;
    }

    public void setRefrigeracion(Refrigeracion refrigeracion) {
        this.refrigeracion = refrigeracion;
    }
    

    @Override
   public String toString(){
   return this.nombre;
   }
    
    
    
    
    
}
