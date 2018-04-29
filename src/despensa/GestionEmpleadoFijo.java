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
public class GestionEmpleadoFijo {
     private LinkedList<EmpleadoFijo> listaEmleado = new LinkedList<>();

    /**
     * Metodo para agregar empleado
     * @param empleado
     * @return booleano que es el exito del proceso
     */
    public boolean agregarEmpleado(EmpleadoFijo empleado) {
       
        int codigoEmpleado=empleado.getID();
        
        int indice=this.buscarEmpleado(codigoEmpleado);
        
        if(indice==-1){
             empleado.setID(this.obtenerUltimoCodigo()+1);
             this.listaEmleado.add(empleado); 
             return true;
        }else{
            return false;
        }
        
       
    }

    /**metodo para elimiar empleado
     * @param codigoEmpleado
     * @return 
     */
    public boolean eliminarEmpleado(int codigoEmpleado) {
        int indice = this.buscarEmpleado(codigoEmpleado);
        if (indice != -1) {
            this.listaEmleado.remove(indice);
            return true;
        }
        return false;
    }

    /**x
     * Método para eliminar empleado
     * @param empleado objeto empleado
     * @return
     */
    public boolean eliminarEmpleado(EmpleadoFijo empleado) {
        this.listaEmleado.remove(empleado);
        return true;
    }

    /**
     * Método para eliminar empleado
     * @param indiceEmpleado indice
     * @return
     */
    public boolean eliminarEmpleadoByIndice(int indiceEmpleado) {
        
        if (buscarExistenciaDelEmpleadoPorIndice(indiceEmpleado)==true) {
            this.listaEmleado.remove(indiceEmpleado);
        return true;
        }else{
        return false;
        }
        
    }

    /**
     * 
     * @param codigoEmpleado
     * @return booleano que es el exito del proceso
     */
    public boolean eliminarEmpleadoByCodigo(int codigoEmpleado) {

        Empleado empleado = this.buscarEmpleadoObjeto(codigoEmpleado);
        if (empleado != null) {
            this.listaEmleado.remove(empleado);
            return true;
        }
        return false;

    }

    /**
     * Método para modificar empleado por indice del empleado y el empleado modificado
     * @param indiceEmpleado: indice del objeto a modificar
     * @param EmpleadoModificado: Objeto con los nuevos parámetros
     * @return
     */
    public boolean modificarEmpleadoByIndice(int indiceEmpleado, EmpleadoFijo EmpleadoModificado) {
        
        if (buscarExistenciaDelEmpleadoPorIndice(indiceEmpleado)==true) {
            this.listaEmleado.set(indiceEmpleado, EmpleadoModificado);
            return true;
        }else{
            return false;
        }
        
    }

    /**
     * Método para buscar empleado solo  con el codigo del empleado a modificar y el empleado modificado
     * @param codigoEpleadoAmodificar
     * @param empleadoModificado
     * @return 
     */
    public boolean modificarEmpleado(int codigoEpleadoAmodificar, EmpleadoFijo empleadoModificado) {
        int indice = this.buscarEmpleado(codigoEpleadoAmodificar);
        if (indice != -1) {
            this.listaEmleado.set(indice, empleadoModificado);
            return true;
        }
        return false;

    }

    /**
     * metodo para modificar empleado
     * @param nombreEmpleadoAmodificar
     * @param empleadoModificado
     * @return booleano que es el exito de la funcion 
     */
    public boolean modificarEmpleado(String nombreEmpleadoAmodificar, EmpleadoFijo empleadoModificado) {
        int indice = this.buscarEmpleado(nombreEmpleadoAmodificar);
        if (indice != -1) {
            this.listaEmleado.set(indice, empleadoModificado);
            return true;
        }else{
        return false;
        }
        

    }

    /**
     * Método para buscar empleado
     * @param codigoEpleado codigo de empleado a buscar
     * @return el indice donde se encuentra el empleado, si no lo encuentra
     * retorna -1
     */
    public int buscarEmpleado(int codigoEpleado) {
        int i, indiceEncontrado = -1;
        for (i = 0; i < this.listaEmleado.size(); i++) {
            if (this.listaEmleado.get(i).getIdEmpleado() == codigoEpleado) {
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
    public boolean buscarExistenciaDelEmpleadoPorIndice(int indice){
        
        if (indice<=this.listaEmleado.size()) {
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
        for (i = 0; i < this.listaEmleado.size(); i++) {
            if (this.listaEmleado.get(i).getID()>mayor) {
                mayor=this.listaEmleado.get(i).getID();
            }
        }
        return mayor;
    }

    /**
     * Método para buscar empleado
     *
     * @param nombreEmpleado nombre de empleado a buscar
     * @return el indice donde se encuentra el empleado, si no lo encuentra
     * retorna -1
     */
    public int buscarEmpleado(String nombreEmpleado) {
        int i, indiceEncontrado = -1;
        for (i = 0; i < this.listaEmleado.size(); i++) {
            if (this.listaEmleado.get(i).getpNombre().equals(nombreEmpleado)) {
                indiceEncontrado = i;
                break;
            }
        }
        return indiceEncontrado;
    }

    /**
     * Método para buscar empleado
     *
     * @param codigoEmpleado codigo de empleado a buscar
     * @return el objeto del empleado encontrado, si no lo encuentra retorna null
     */
    public Empleado buscarEmpleadoObjeto(int codigoEmpleado) {
        int i;
        Empleado empleadoEcontrado = null;
        for (i = 0; i < this.listaEmleado.size(); i++) {
            if (this.listaEmleado.get(i).getID() == codigoEmpleado) {
                empleadoEcontrado = listaEmleado.get(i);
                break;
            }
        }
        return empleadoEcontrado;
    }
    /**
     * 
     * @return info que es una recopilacion de informacion enscencial de los empleados
     */
    public String getInfoEmpleado(){
        String info="";
        int i;
        for (i = 0; i < this.listaEmleado.size(); i++) {
            info+=this.listaEmleado.get(i).getID()+" \t "+
                    this.listaEmleado.get(i).getIdEmpleado()+"\t"+
                    this.listaEmleado.get(i).getNombreCompleto()+ "\t "+
                    this.listaEmleado.get(i).getNumeroTelefonico()+"\n";
        }
        return info;
    }
    
}
