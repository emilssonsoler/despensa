/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa;

import java.io.Serializable;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emilsson Soler
 */
public class GestionProducto implements Serializable{
    private LinkedList<Producto> listaProducto = new LinkedList<>();

    /**
     * Metodo para agregar producto
     * @param producto
     * @return booleano que es el exito del proceso
     */
    public boolean agregarProducto(Producto producto) {
       
        int codigoProducto=producto.getCodigo();
        
        int indice=this.buscarProducto(codigoProducto);
        
        if(indice==-1){
             producto.setCodigo(this.obtenerUltimoCodigo()+1);
             this.listaProducto.add(producto); 
             return true;
        }else{
            return false;
        }
        
       
    }

    /**metodo para elimiar producto
     * @param codigoProducto
     * @return 
     */
    public boolean eliminarProducto(int codigoProducto) {
        int indice = this.buscarProducto(codigoProducto);
        if (indice != -1) {
            this.listaProducto.remove(indice);
            return true;
        }
        return false;
    }

    /**
     * Método para eliminar producto
     * @param producto objeto producto
     * @return
     */
    public boolean eliminarProducto(Producto producto) {
        this.listaProducto.remove(producto);
        return true;
    }

    /**
     * Método para eliminar producto
     * @param indiceProducto indice
     * @return
     */
    public boolean eliminarProductoByIndice(int indiceProducto) {
        
        if (buscarExistenciaDelProductoPorIndice(indiceProducto)==true) {
            this.listaProducto.remove(indiceProducto);
        return true;
        }else{
        return false;
        }
        
    }

    /**
     * 
     * @param codigoProducto
     * @return booleano que es el exito del proceso
     */
    public boolean eliminarProductoByCodigo(int codigoProducto) {

        Producto producto = this.buscarProductoObjeto(codigoProducto);
        if (producto != null) {
            this.listaProducto.remove(producto);
            return true;
        }
        return false;

    }

    /**
     * Método para modificar producto por indice del producto y el producto modificado
     * @param indiceProducto: indice del objeto a modificar
     * @param ProductoModificado: Objeto con los nuevos parámetros
     * @return
     */
    public boolean modificarProductoByIndice(int indiceProducto, Producto ProductoModificado) {
        
        if (buscarExistenciaDelProductoPorIndice(indiceProducto)==true) {
            this.listaProducto.set(indiceProducto, ProductoModificado);
            return true;
        }else{
            return false;
        }
        
    }

    /**
     * Método para buscar producto solo  con el codigo del producto a modificar y el producto modificado
     * @param codigoProductoAModificar
     * @param productoModificado
     * @return 
     */
    public boolean modificarProducto(int codigoProductoAModificar, Producto productoModificado) {
        int indice = this.buscarProducto(codigoProductoAModificar);
        if (indice != -1) {
            this.listaProducto.set(indice, productoModificado);
            return true;
        }
        return false;

    }

    /**
     * metodo para modificar producto
     * @param nombreProductoAmodificar
     * @param productoModificado
     * @return booleano que es el exito de la funcion 
     */
    public boolean modificarProducto(String nombreProductoAmodificar, Producto productoModificado) {
        int indice = this.buscarProducto(nombreProductoAmodificar);
        if (indice != -1) {
            this.listaProducto.set(indice, productoModificado);
            return true;
        }else{
        return false;
        }
        

    }

    /**
     * Método para buscar producto
     * @param codigoProducto codigo de producto a buscar
     * @return el indice donde se encuentra el producto, si no lo encuentra
     * retorna -1
     */
    public int buscarProducto(int codigoProducto) {
        int i, indiceEncontrado = -1;
        for (i = 0; i < this.listaProducto.size(); i++) {
            if (this.listaProducto.get(i).getCodigo()== codigoProducto) {
                indiceEncontrado = i;
                break;
            }
        }
        return indiceEncontrado;
    }
    /**
     * metodo para ver si el indice existe en la lista
     * @param indice
     * @return booelano que es el exito de la fucion
     */
    public boolean buscarExistenciaDelProductoPorIndice(int indice){
        
        if (indice<=this.listaProducto.size()) {
            return true;
        }else{
        return false;
        }
        
        
    }
    
    /**
     * 
     * @return mayor el mayor id generado en la lista
     */
    public int obtenerUltimoCodigo() {
        int i, indiceEncontrado = -1;
        int mayor=0;
        for (i = 0; i < this.listaProducto.size(); i++) {
            if (this.listaProducto.get(i).getCodigo()>mayor) {
                mayor=this.listaProducto.get(i).getCodigo();
            }
        }
        return mayor;
    }

    /**
     * Método para buscar producto
     *
     * @param nombreProducto nombre de producto a buscar
     * @return el indice donde se encuentra el producto, si no lo encuentra
     * retorna -1
     */
    public int buscarProducto(String nombreProducto) {
        int i, indiceEncontrado = -1;
        for (i = 0; i < this.listaProducto.size(); i++) {
            if (this.listaProducto.get(i).getNombre().equals(nombreProducto)) {
                indiceEncontrado = i;
                break;
            }
        }
        return indiceEncontrado;
    }

    /**
     * Método para buscar producto
     *
     * @param codigoProducto codigo de producto a buscar
     * @return el objeto del producto encontrado, si no lo encuentra retorna null
     */
    public Producto buscarProductoObjeto(int codigoProducto) {
        int i;
        Producto productoEncontrado = null;
        for (i = 0; i < this.listaProducto.size(); i++) {
            if (this.listaProducto.get(i).getCodigo()== codigoProducto) {
                productoEncontrado = listaProducto.get(i);
                break;
            }
        }
        return productoEncontrado;
    }
    /**
     * 
     * @return info que es una recopilacion de informacion enscencial de los productos
     */
    public String getInfoProductos(){
        String info="";
        int i;
        for (i = 0; i < this.listaProducto.size(); i++) {
            info+=this.listaProducto.get(i).getCodigo()+" \t ";
        }
        return info;
    }
    public Object[][] getArrayHabitacion() {
         Object[][] data = new Object[this.listaProducto.size()][4];
           for(int i=0;i<listaProducto.size();i++){
            data[i][0]=this.listaProducto.get(i).getNombre();
            data[i][1]=this.listaProducto.get(i).getCodigo();
            data[i][2]=this.listaProducto.get(i).getPrecioVenta();
            data[i][3]=this.listaProducto.get(i).getProveedor().getNombre();
        }
       
        return data;
    
}
}
