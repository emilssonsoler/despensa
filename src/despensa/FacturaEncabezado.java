/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa;

import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Emilsson Soler
 */
public class FacturaEncabezado {
    private int codigo;
    private Date fecha;
    private Cliente cliente;
    private Empleado empleado;
    LinkedList<FacturaDetalle>listaCompra=new LinkedList<>();
    
    /**
     * metodo para agregar un detalle(producto,cantidad)
     * @param fact factura detalle
     * @return un booleano 
     */
    public boolean agregarDetalle(FacturaDetalle fact){
        this.listaCompra.add(fact);
        return true;
    }
    
   /**
     * Método para buscar producto
     *
     * @param codigoProducto codigo de producto a buscar
     * @return el indice donde se encuentra el producto, si no lo encuentra
     * retorna -1
     */
    public int buscarProductoByCodigoProducto(int codigoProducto) {
        int i, indiceEncontrado = -1;
        for (i = 0; i < this.listaCompra.size(); i++) {
            if (this.listaCompra.get(i).getProducto().getCodigo() == codigoProducto) {
                indiceEncontrado = i;
                break;
            }
        }
        return indiceEncontrado;
    }
   
    /**
     * Método para eliminar todo el detalle(producto,cantidad)
     *
     * @param codigoProducto  
     * @return booleano que representa el exito de la accion
     */
    public boolean EliminarProducto(int codigoProducto) {
        int eliminarproducto=this.buscarProductoByCodigoProducto(codigoProducto);
        boolean respuesta = false;
        if (eliminarproducto!=-1) {
            this.listaCompra.remove(eliminarproducto);
            respuesta = true;
        }
        return respuesta;
    }
  
    
    
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the total
     */
    

    /**
     * @param total the total to set
     */
    

    /**
     * @return the empleado
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
    /**
     * 
     * @return String que es la ingformacion estatica de la factura 
     */
    public String getInformacion(){
        return String.format("No. Fact: %d \n "
                            + "Fecha: %s \n "
                            + "Cliente %s \n "
                            + "Empleado: %s", this.codigo, this.fecha, 
                            this.cliente.getpNombre(),
                            this.empleado.getNombreCompleto());
    }
    
}
