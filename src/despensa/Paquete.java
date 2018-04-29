/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa;

import java.sql.Date;

/**
 *
 * @author Emilsson Soler
 */
public class Paquete {
     
    private int idPaqueteDB;
    private java.sql.Date fechaVencimiento;
    private int cantidad;
    private Producto prd;

    public Paquete(int idPaqueteDB, Date fechaVencimiento, int cantidad, Producto prd) {
        this.idPaqueteDB = idPaqueteDB;
      
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
        this.prd = prd;
    }

    public int getIdPaqueteDB() {
        return idPaqueteDB;
    }

    public void setIdPaqueteDB(int idPaqueteDB) {
        this.idPaqueteDB = idPaqueteDB;
    }


    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getPrd() {
        return prd;
    }

    public void setPrd(Producto prd) {
        this.prd = prd;
    }
    
    
    
    @Override
    public String toString(){
       String datos = this.prd.getNombre()+" "+this.cantidad+"   "+this.fechaVencimiento;
        return datos; 
    }
    
    
    
    
    
    
}
