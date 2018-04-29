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
public class EmpleadoPorHora extends Empleado{
    
    private float horasTrabajadas;
    private  float sueldoHora;
    

    public EmpleadoPorHora() {
    }

    /**
     * 
     * @param horasTrabajadas
     * @param sueldoHora
     * @param idEmpleado
     * @param fechaInicio
     * @param ID
     * @param pNombre
     * @param sNombre
     * @param pApellido
     * @param sApellido
     * @param direccion
     * @param numeroTelefonico 
     */
 /*   public EmpleadoPorHora(float horasTrabajadas, float sueldoHora, int idEmpleado, Date fechaInicio, int ID, String pNombre, String sNombre, String pApellido, String sApellido, String direccion, String numeroTelefonico) {
        super(idEmpleado, fechaInicio, ID, pNombre, sNombre, pApellido, sApellido, direccion, numeroTelefonico);
        this.horasTrabajadas = horasTrabajadas;
        this.sueldoHora = sueldoHora;
    }

   */ 
    
    
    /**
     * 
     * @return horasTrabajadas
     */
    public float getHorasTrabajadas() {
        return horasTrabajadas;
    }
    
    /**
     * 
     * @param horasTrabajadas 
     */
    public void setHorasTrabajadas(float horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    /**
     * 
     * @return sueldoHora
     */
    public float getSueldoHora() {
        return sueldoHora;
    }
    
    
    /**
     * 
     * @param sueldoHora 
     */
    public void setSueldoHora(float sueldoHora) {
        this.sueldoHora = sueldoHora;
    }
    
    /**
     * 
     * @return el sueldo del empleado hora
     */
    public float getSueldoTrabajadorHora(){
         
    return super.getSueldo();
    }

    @Override
    String getInformacion() {
        return String.format("El nombre completo es: %s"+"\t"+
                            "el codigo de empleado es:%d"+"\t"+
                            "su fecha de inicio es:%f "+"\t"+
                            "su dirreccion es:%s"+"\t"+
                            "su numero de telefono es:%s"+"\n"
                            ,
                            super.getNombreCompleto(),
                            super.getIdEmpleado(),
                            super.getFechaInicio(),
                            super.getDireccion(),
                            super.getNumeroTelefonico());
    }

    
    
}
