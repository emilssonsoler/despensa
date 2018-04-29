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
public class GestionProveedores {
     private LinkedList<Proveedor> listaProveedores = new LinkedList<>();

    /**
     * Metodo para agregar proveedor
     * @param proveedor
     * @return booleano que es el exito del proceso
     */
    public boolean agregarProveedor(Proveedor proveedor) {
       
        int codigoProveedor=proveedor.getCodigo();
        
        int indice=this.buscarProveedor(codigoProveedor);
        
        if(indice==-1){
             proveedor.setCodigo(this.obtenerUltimoCodigo()+1);
             this.listaProveedores.add(proveedor); 
             return true;
        }else{
            return false;
        }
        
       
    }

    /**metodo para elimiar proveedor
     * @param codigoProveedor
     * @return 
     */
    public boolean eliminarProveedor(int codigoProveedor) {
        int indice = this.buscarProveedor(codigoProveedor);
        if (indice != -1) {
            this.listaProveedores.remove(indice);
            return true;
        }
        return false;
    }

    /**
     * Método para eliminar proveedor
     * @param proveedor objeto proveedor
     * @return
     */
    public boolean eliminarProveedor(Proveedor proveedor) {
        this.listaProveedores.remove(proveedor);
        return true;
    }

    /**
     * Método para eliminar proveedor
     * @param indiceProveedor indice
     * @return
     */
    public boolean eliminarProveedorByIndice(int indiceProveedor) {
        
        if (buscarExistenciaDelProveedorPorIndice(indiceProveedor)==true) {
            this.listaProveedores.remove(indiceProveedor);
        return true;
        }else{
        return false;
        }
        
    }

    /**
     * 
     * @param codigoProveedor
     * @return booleano que es el exito del proceso
     */
    public boolean eliminarProveedorByCodigo(int codigoProveedor) {

        Proveedor proveedor = this.buscarProveedorObjeto(codigoProveedor);
        if (proveedor != null) {
            this.listaProveedores.remove(proveedor);
            return true;
        }
        return false;

    }

    /**
     * Método para modificar proveedor por indice del proveedor y el proveedor modificado
     * @param indiceProveedor: indice del objeto a modificar
     * @param ProveedorModificado: Objeto con los nuevos parámetros
     * @return
     */
    public boolean modificarProveedorByIndice(int indiceProveedor, Proveedor ProveedorModificado) {
        
        if (buscarExistenciaDelProveedorPorIndice(indiceProveedor)==true) {
            this.listaProveedores.set(indiceProveedor, ProveedorModificado);
            return true;
        }else{
            return false;
        }
        
    }

    /**
     * Método para buscar proveedor solo  con el codigo del proveedor a modificar y el proveedor modificado
     * @param codigoProveedorAModificar
     * @param proveedorModificado
     * @return 
     */
    public boolean modificarProveedor(int codigoProveedorAModificar, Proveedor proveedorModificado) {
        int indice = this.buscarProveedor(codigoProveedorAModificar);
        if (indice != -1) {
            this.listaProveedores.set(indice, proveedorModificado);
            return true;
        }
        return false;

    }

    /**
     * metodo para modificar proveedor
     * @param nombreProveedorAmodificar
     * @param proveedorModificado
     * @return booleano que es el exito de la funcion 
     */
    public boolean modificarProveedor(String nombreProveedorAmodificar, Proveedor proveedorModificado) {
        int indice = this.buscarProveedor(nombreProveedorAmodificar);
        if (indice != -1) {
            this.listaProveedores.set(indice, proveedorModificado);
            return true;
        }else{
        return false;
        }
        

    }

    /**
     * Método para buscar proveedor
     * @param codigoProveedor codigo de proveedor a buscar
     * @return el indice donde se encuentra el proveedor, si no lo encuentra
     * retorna -1
     */
    public int buscarProveedor(int codigoProveedor) {
        int i, indiceEncontrado = -1;
        for (i = 0; i < this.listaProveedores.size(); i++) {
            if (this.listaProveedores.get(i).getCodigo()== codigoProveedor) {
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
    public boolean buscarExistenciaDelProveedorPorIndice(int indice){
        
        if (indice<=this.listaProveedores.size()) {
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
        for (i = 0; i < this.listaProveedores.size(); i++) {
            if (this.listaProveedores.get(i).getCodigo()>mayor) {
                mayor=this.listaProveedores.get(i).getCodigo();
            }
        }
        return mayor;
    }

    /**
     * Método para buscar proveedor
     *
     * @param nombreProveedor nombre de proveedor a buscar
     * @return el indice donde se encuentra el proveedor, si no lo encuentra
     * retorna -1
     */
    public int buscarProveedor(String nombreProveedor) {
        int i, indiceEncontrado = -1;
        for (i = 0; i < this.listaProveedores.size(); i++) {
            if (this.listaProveedores.get(i).getNombre().equals(nombreProveedor)) {
                indiceEncontrado = i;
                break;
            }
        }
        return indiceEncontrado;
    }

    /**
     * Método para buscar proveedor
     *
     * @param codigoProveedor codigo de proveedor a buscar
     * @return el objeto del proveedor encontrado, si no lo encuentra retorna null
     */
    public Proveedor buscarProveedorObjeto(int codigoProveedor) {
        int i;
        Proveedor proveedorEncontrado = null;
        for (i = 0; i < this.listaProveedores.size(); i++) {
            if (this.listaProveedores.get(i).getCodigo()== codigoProveedor) {
                proveedorEncontrado = listaProveedores.get(i);
                break;
            }
        }
        return proveedorEncontrado;
    }
    /**
     * 
     * @return info que es una recopilacion de informacion enscencial de los proveedores
     */
    public String getInfoProveedores(){
        String info="";
        int i;
        for (i = 0; i < this.listaProveedores.size(); i++) {
            info+=this.listaProveedores.get(i).getCodigo()+" \t "+
                    this.listaProveedores.get(i).getNombre()+ "\t "+"\n";
        }
        return info;
    }
}
