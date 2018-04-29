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
public class FacturaDetalleDB {
     private Producto producto;
      private int cantidad;
      private float total ;

    public FacturaDetalleDB(Producto producto, int cantidad, float total) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
      

      
    
}
