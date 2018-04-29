/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa;

import java.util.Date;

/**
 *
 * @author Emilsson Soler
 */
public class Descuento {
    private Producto producto;
    private Date fechaInicio;
    private Date fechaFinal;
    private float precioDescuento;

    /**
     * constructor por defecto
     */
    public Descuento() {
    }

    
    
    /**
     * 
     * @param producto
     * @param fechaFinal
     * @param precioDescuento 
     */
    public Descuento(Producto producto, Date fechaFinal, float precioDescuento) {
        this.producto = producto;
        this.fechaFinal = fechaFinal;
        this.fechaInicio=AdminFechas.getFechaActual();
        this.precioDescuento = precioDescuento;
    }

    /**
     * 
     * @param producto
     * @param fechaInicio
     * @param fechaFinal
     * @param precioDescuento 
     */
    public Descuento(Producto producto, Date fechaInicio, Date fechaFinal, float precioDescuento) {
        this.producto = producto;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.precioDescuento = precioDescuento;
    }

    /**
     * 
     * @return precioDescuento 
     */
    public float getPrecioDescuento() {
        return precioDescuento;
    }

    /**
     * 
     * @param precioDescuento 
     */
    public void setPrecioDescuento(float precioDescuento) {
        this.precioDescuento = precioDescuento;
    }

    /**
     * 
     * @return producto 
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * 
     * @param producto 
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * 
     * @return fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * 
     * @param fechaInicio 
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * 
     * @return fechaFinal
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * 
     * @param fechaFinal 
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
    
    
    
}
