/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa;

/**
 *
 * @author Emilsson Soler
 */
public class FacturaDetalle {
      private Producto producto;
      private float cantidad;

    public FacturaDetalle() {
    }

    /**
     * 
     * @param producto 
     */
    public FacturaDetalle(Producto producto) {
        this.producto = producto;
        this.cantidad=1;
    }

    /**
     * 
     * @param producto
     * @param cantidad 
     */
    public FacturaDetalle(Producto producto, float cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
      
      

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    

    /**
     * @return the cantidad
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    
}
