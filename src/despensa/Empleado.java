/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa;

import java.util.Date;

/**
 *
 * @author Emilsson Soler
 */
public  class Empleado extends Persona {
    private int idEmpleado;
    private int idEmpleadoDB;
    private float sueldo;
    private java.sql.Date fechaInicio;
    

    public Empleado() {
        
    }

    /**
     * 
     * @param idEmpleado
     * @param idEmpleadoDB
     * @param sueldo
     * @param fechaInicio
     * @param pNombre
     * @param sNombre
     * @param pApellido
     * @param sApellido
     * @param direccion
     * @param numeroTelefonico 
     */
    public Empleado(int idEmpleado, int idEmpleadoDB, float sueldo, java.sql.Date fechaInicio, String pNombre, String sNombre, String pApellido, String sApellido, String direccion, String numeroTelefonico) {       
        super(pNombre, sNombre, pApellido, sApellido, direccion, numeroTelefonico);
        this.idEmpleado = idEmpleado;
        this.idEmpleadoDB = idEmpleadoDB;
        this.sueldo = sueldo;
        this.fechaInicio = fechaInicio;
    }

    /**
     * 
     * @return idEmpleado
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * 
     * @param idEmpleado 
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * 
     * @return sueldo
     */
    public float getSueldo() {
        return sueldo;
    }

    /**
     * 
     * @param sueldo 
     */
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

   

    public int getIdEmpleadoDB() {
        return idEmpleadoDB;
    }

    public java.sql.Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     *
     * @return fechaInicio 
     */
    public void setFechaInicio(java.sql.Date fechaInicio) {   
        this.fechaInicio = fechaInicio;
    }

    @Override
            String getInformacion() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
