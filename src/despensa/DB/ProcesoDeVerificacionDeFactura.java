/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa.DB;

import despensa.FacturaDetalleDB;
import despensa.Paquete;
import despensa.Producto;
import java.util.LinkedList;

/**
 *
 * @author Emilsson Soler
 */
public class ProcesoDeVerificacionDeFactura {

    public static boolean verificarSiHayPaqueteDelProdutoOexiste(int codigo, LinkedList<despensa.Paquete> paquete) {
        boolean encontrado = false;
        for (Paquete paquete1 : paquete) {
            if (paquete1.getPrd().getCodigo() == codigo) {
                encontrado = true;
                break;
            }

        }
        return encontrado;
    }

    //metodo para verificar la cantidad total de todos los productos
    public static int verificarCuantoProductoHayEnLosPaquetes(int codigo, LinkedList<despensa.Paquete> paquete2) {
        int cantidad = 0;

        for (Paquete paquete : paquete2) {
            if (paquete.getPrd().getCodigo() == codigo) {
                cantidad += paquete.getCantidad();
            }
        }
        return cantidad;
    }

    //restar la cantidad en paquete
    public static LinkedList<despensa.Paquete> restarLaCantidadNecesaria(LinkedList<despensa.Paquete> paquete, int cantidad, int codigo) {
        int contandor = 1;
        int cantidadInPrograma = cantidad;
        for (Paquete paquete1 : paquete) {
            if (paquete1.getPrd().getCodigo() == codigo) {
                while (paquete1.getCantidad() != 0 && cantidadInPrograma != 0) {
                    paquete1.setCantidad(paquete1.getCantidad() - contandor);
                    cantidadInPrograma--;
                }
            }
            if (cantidadInPrograma == 0) {
                
                break;
            }
        }

        LinkedList<despensa.Paquete> elNuenvoPaqueteDeReferencia = paquete;
        return elNuenvoPaqueteDeReferencia;
    }
    
    public static despensa.Producto obtenerProducto(LinkedList<despensa.Producto> lstProducto,int codigo){
        despensa.Producto pro = new  Producto();
        for (Producto producto : lstProducto) {
            if (producto.getCodigo()==codigo) {
                pro = producto;
                break;
            }
            
        }
         
    return pro;
    }
    
    public static Object[][] obtenerArregloDeLstCompra(LinkedList<despensa.FacturaDetalleDB> lista){
        Object[][] data = new Object[lista.size()][4];
    for (int i = 0; i < lista.size(); i++) {
             data[i][0] = lista.get(i).getProducto().getNombre();
            data[i][1] = lista.get(i).getProducto().getPrecioVenta();
            data[i][2] = lista.get(i).getCantidad();
            data[i][3] = lista.get(i).getTotal();
           
        }
    return data;
    }
    
    
    public static boolean verificarSiYaHabiaUnProductoIgual( LinkedList<despensa.FacturaDetalleDB> lstCompra,int codigo,int cantidad){
        boolean rst = false;
        for (FacturaDetalleDB facturaDetalleDB : lstCompra){
            if (facturaDetalleDB.getProducto().getCodigo()==codigo){
                rst = true;   
            }
        }
        
 return rst;
    }
    
     public static LinkedList<despensa.FacturaDetalleDB> setCantidadNueva( LinkedList<despensa.FacturaDetalleDB> lstCompra,int codigo,int cantidad){
      
         for (int i = 0; i < lstCompra.size(); i++) {
             if (lstCompra.get(i).getProducto().getCodigo()==codigo){
                lstCompra.get(i).setCantidad(lstCompra.get(i).getCantidad()+cantidad);
                lstCompra.get(i).setTotal(lstCompra.get(i).getCantidad()*lstCompra.get(i).getProducto().getPrecioVenta());
            }
         }
 return lstCompra;
    }
     
     public static float obtenerTotalFinal(LinkedList<despensa.FacturaDetalleDB> lstCompra){
         float totalFinal =0;
         for (FacturaDetalleDB facturaDetalleDB : lstCompra) {
              totalFinal+= facturaDetalleDB.getTotal();
             
         }
     return totalFinal;
     
     }
     

}
