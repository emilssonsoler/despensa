/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa;

import java.util.LinkedList;

/**
 *
 * @author Emilsson Soler
 */
public class GestionDescuento {
     private LinkedList<Descuento> listaDescuento = new LinkedList<>();

    /**
     * Metodo para agregar descuento
     * @param descuento
     * @return booleano que es el exito del proceso
     */
    public boolean agregarDescuento(Descuento descuento) {
       
        int codigoDescuentos=descuento.getProducto().getCodigo();
        
        int indice=this.buscarDescuento(codigoDescuentos);
        
        if(indice==-1){
             descuento.getProducto().setCodigo(this.obtenerUltimoCodigo()+1);
             this.listaDescuento.add(descuento); 
             return true;
        }else{
            return false;
        }
        
       
    }

    /**metodo para elimiar descuento
     * @param codigoDescuentp
     * @return 
     */
    public boolean eliminarDescuento(int codigoDescuentp) {
        int indice = this.buscarDescuento(codigoDescuentp);
        if (indice != -1) {
            this.listaDescuento.remove(indice);
            return true;
        }
        return false;
    }

    /**
     * Método para eliminar descuento
     * @param descuento objeto descuento
     * @return
     */
    public boolean eliminarDescuento(Descuento descuento) {
        this.listaDescuento.remove(descuento);
        return true;
    }

    /**
     * Método para eliminar descuento
     * @param indiceDescuento indice
     * @return
     */
    public boolean eliminarDescuentoByIndice(int indiceDescuento) {
        
        if (buscarExistenciaDelDescuentoPorIndice(indiceDescuento)==true) {
            this.listaDescuento.remove(indiceDescuento);
        return true;
        }else{
        return false;
        }
        
    }

    /**
     * 
     * @param codigoDescuento
     * @return booleano que es el exito del proceso
     */
    public boolean eliminarDescuentoByCodigo(int codigoDescuento) {

        Descuento descuento = this.buscarDescuentoObjeto(codigoDescuento);
        if (descuento != null) {
            this.listaDescuento.remove(descuento);
            return true;
        }
        return false;

    }

    /**
     * Método para modificar descuento por indice del descuento y el descuento modificado
     * @param indiceDescuento: indice del objeto a modificar
     * @param descuentoModificado: Objeto con los nuevos parámetros
     * @return
     */
    public boolean modificarDescuentoByIndice(int indiceDescuento, Descuento descuentoModificado) {
        
        if (buscarExistenciaDelDescuentoPorIndice(indiceDescuento)==true) {
            this.listaDescuento.set(indiceDescuento, descuentoModificado);
            return true;
        }else{
            return false;
        }
        
    }

    /**
     * Método para buscar descuento solo  con el codigo del descuento a modificar y el descuento modificado
     * @param codigoDescuentoAModificar
     * @param descuentoModificado
     * @return 
     */
    public boolean modificarDescuento(int codigoDescuentoAModificar, Descuento descuentoModificado) {
        int indice = this.buscarDescuento(codigoDescuentoAModificar);
        if (indice != -1) {
            this.listaDescuento.set(indice, descuentoModificado);
            return true;
        }
        return false;

    }

    /**
     * metodo para modificar descuento
     * @param nombreDescuentoAmodificar
     * @param descuentoModificado
     * @return booleano que es el exito de la funcion 
     */
    public boolean modificarDescuento(String nombreDescuentoAmodificar, Descuento descuentoModificado) {
        int indice = this.buscarDescuento(nombreDescuentoAmodificar);
        if (indice != -1) {
            this.listaDescuento.set(indice, descuentoModificado);
            return true;
        }else{
        return false;
        }
        

    }

    /**
     * Método para buscar descuento
     * @param codigoDescuento codigo de descuento a buscar
     * @return el indice donde se encuentra el descuento, si no lo encuentra
     * retorna -1
     */
    public int buscarDescuento(int codigoDescuento) {
        int i, indiceEncontrado = -1;
        for (i = 0; i < this.listaDescuento.size(); i++) {
            if (this.listaDescuento.get(i).getProducto().getCodigo()== codigoDescuento) {
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
    public boolean buscarExistenciaDelDescuentoPorIndice(int indice){
        
        if (indice<=this.listaDescuento.size()) {
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
        for (i = 0; i < this.listaDescuento.size(); i++) {
            if (this.listaDescuento.get(i).getProducto().getCodigo()>mayor) {
                mayor=this.listaDescuento.get(i).getProducto().getCodigo();
            }
        }
        return mayor;
    }

    /**
     * Método para buscar descuento
     *
     * @param nombreDescuento nombre de descuento a buscar
     * @return el indice donde se encuentra el descuento, si no lo encuentra
     * retorna -1
     */
    public int buscarDescuento(String nombreDescuento) {
        int i, indiceEncontrado = -1;
        for (i = 0; i < this.listaDescuento.size(); i++) {
            if (this.listaDescuento.get(i).getProducto().getNombre().equals(nombreDescuento)) {
                indiceEncontrado = i;
                break;
            }
        }
        return indiceEncontrado;
    }

    /**
     * Método para buscar descuento
     *
     * @param codigoDescuento codigo de descuento a buscar
     * @return el objeto del descuento encontrado, si no lo encuentra retorna null
     */
    public Descuento buscarDescuentoObjeto(int codigoDescuento) {
        int i;
        Descuento descuentoEncontrado = null;
        for (i = 0; i < this.listaDescuento.size(); i++) {
            if (this.listaDescuento.get(i).getProducto().getCodigo()== codigoDescuento) {
                descuentoEncontrado = listaDescuento.get(i);
                break;
            }
        }
        return descuentoEncontrado;
    }
    /**
     * 
     * @return info que es una recopilacion de informacion enscencial de los descuentos
     */
    public String getInfoDescuentos(){
        String info="";
        int i;
        for (i = 0; i < this.listaDescuento.size(); i++) {
            info+=this.listaDescuento.get(i).getProducto().getCodigo()+" \t "+
                    this.listaDescuento.get(i).getProducto().getNombre()+ "\t ";
        }
        return info;
    }
    
}
