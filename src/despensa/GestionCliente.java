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
public class GestionCliente {
    private LinkedList<Cliente> listaClientes = new LinkedList<>();

    /**
     * Metodo para agregar cliente
     * @param cli
     * @return booleano que es el exito del proceso
     */
    public boolean agregarCliente(Cliente cli) {
       
        int codigoCliente=cli.getID();
        
        int indice=this.buscarCliente(codigoCliente);
        
        if(indice==-1){
             cli.setID(this.obtenerUltimoCodigo()+1);
             this.listaClientes.add(cli); 
             return true;
        }else{
            return false;
        }
        
       
    }

    /**
     * @param codigoCliente
     * @return 
     */
    public boolean eliminarCliente(int codigoCliente) {
        int indice = this.buscarCliente(codigoCliente);
        if (indice != -1) {
            this.listaClientes.remove(indice);
            return true;
        }
        return false;
    }

    /**
     * Método para eliminar cliente
     * @param cli objeto cliente
     * @return
     */
    public boolean eliminarCliente(Cliente cli) {
        this.listaClientes.remove(cli);
        return true;
    }

    /**
     * Método para eliminar cliente
     * @param indiceCliente indice
     * @return
     */
    public boolean eliminarClienteByIndice(int indiceCliente) {
        
        if (buscarExistenciaDelClientePorIndice(indiceCliente)==true) {
            this.listaClientes.remove(indiceCliente);
        return true;
        }else{
        return false;
        }
        
    }

    /**
     * 
     * @param codigoCliente
     * @return booleano que es el exito del proceso
     */
    public boolean eliminarClienteByCodigo(int codigoCliente) {

        Cliente cliente = this.buscarClienteObjeto(codigoCliente);
        if (cliente != null) {
            this.listaClientes.remove(cliente);
            return true;
        }
        return false;

    }

    /**
     * Método para modificar cliente por indice del cliente y el cliente modificado
     * @param indiceCliente: indice del objeto a modificar
     * @param clienteModificado: Objeto con los nuevos parámetros
     * @return
     */
    public boolean modificarClienteByIndice(int indiceCliente, Cliente clienteModificado) {
        
        if (buscarExistenciaDelClientePorIndice(indiceCliente)==true) {
            this.listaClientes.set(indiceCliente, clienteModificado);
            return true;
        }else{
            return false;
        }
        
    }

    /**
     * Método para buscar cliente solo  con el codigo del cliente a modificar y el cliente modificado
     * @param codigoClienteAmodificar
     * @param clienteModificado
     * @return 
     */
    public boolean modificarCliente(int codigoClienteAmodificar, Cliente clienteModificado) {
        int indice = this.buscarCliente(codigoClienteAmodificar);
        if (indice != -1) {
            this.listaClientes.set(indice, clienteModificado);
            return true;
        }
        return false;

    }

    /**
     * metodo para modificar cliente
     * @param nombreClienteAmodificar
     * @param clienteModificado
     * @return booleano que es el exito de la funcion 
     */
    public boolean modificarCliente(String nombreClienteAmodificar, Cliente clienteModificado) {
        int indice = this.buscarCliente(nombreClienteAmodificar);
        if (indice != -1) {
            this.listaClientes.set(indice, clienteModificado);
            return true;
        }else{
        return false;
        }
        

    }

    /**
     * Método para buscar cliente
     * @param codigoCliente codigo de cliente a buscar
     * @return el indice donde se encuentra el cliente, si no lo encuentra
     * retorna -1
     */
    public int buscarCliente(int codigoCliente) {
        int i, indiceEncontrado = -1;
        for (i = 0; i < this.listaClientes.size(); i++) {
            if (this.listaClientes.get(i).getID() == codigoCliente) {
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
    public boolean buscarExistenciaDelClientePorIndice(int indice){
        
        if (indice<=this.listaClientes.size()) {
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
        for (i = 0; i < this.listaClientes.size(); i++) {
            if (this.listaClientes.get(i).getID()>mayor) {
                mayor=this.listaClientes.get(i).getID();
            }
        }
        return mayor;
    }

    /**
     * Método para buscar cliente
     *
     * @param nombreCliente nombre de cliente a buscar
     * @return el indice donde se encuentra el cliente, si no lo encuentra
     * retorna -1
     */
    public int buscarCliente(String nombreCliente) {
        int i, indiceEncontrado = -1;
        for (i = 0; i < this.listaClientes.size(); i++) {
            if (this.listaClientes.get(i).getpNombre().equals(nombreCliente)) {
                indiceEncontrado = i;
                break;
            }
        }
        return indiceEncontrado;
    }

    /**
     * Método para buscar cliente
     *
     * @param codigoCliente codigo de cliente a buscar
     * @return el objeto del cliente encontrado, si no lo encuentra retorna null
     */
    public Cliente buscarClienteObjeto(int codigoCliente) {
        int i;
        Cliente clienteEcontrado = null;
        for (i = 0; i < this.listaClientes.size(); i++) {
            if (this.listaClientes.get(i).getID() == codigoCliente) {
                clienteEcontrado = listaClientes.get(i);
                break;
            }
        }
        return clienteEcontrado;
    }
    
    public String getInfoClientes(){
        String info="";
        int i;
        for (i = 0; i < this.listaClientes.size(); i++) {
            info+=this.listaClientes.get(i).getID()+" \t "+
                    this.listaClientes.get(i).getNombreCompleto()+ "\t "+
                    this.listaClientes.get(i).getNumeroTelefonico()+"\n";
        }
        return info;
    }
    
}
