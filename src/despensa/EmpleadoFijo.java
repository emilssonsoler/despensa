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
public class EmpleadoFijo extends Empleado  {
    private float sueldoinicial;
    private float bono;

    public EmpleadoFijo() {
    }

    /**
     * 
     * @param sueldoinicial
     * @param bono
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
  /*  public EmpleadoFijo(float sueldoinicial, float bono, int idEmpleado, Date fechaInicio, int ID, String pNombre, String sNombre, String pApellido, String sApellido, String direccion, String numeroTelefonico) {
        super(idEmpleado, fechaInicio, ID, pNombre, sNombre, pApellido, sApellido, direccion, numeroTelefonico);
        this.sueldoinicial = sueldoinicial;
        this.bono = bono;
    }
*/
    /**
     * 
     * @return sueldoinicial
     */
    public float getSueldoinicial() {
        return sueldoinicial;
    }

    /**
     * 
     * @param sueldoinicial 
     */
    public void setSueldoinicial(float sueldoinicial) {
        this.sueldoinicial = sueldoinicial;
    }

    /**
     * 
     * @return bono
     */
    public float getBono() {
        return bono;
    }

    /**
     * 
     * @param bono 
     */
    public void setBono(float bono) {
        this.bono = bono;
    }
    
    /**
     *
     * @param fechaInicio
     * @return bono 
     */
    public float obtenerBono(Date fechaInicio){
    int añosTrabajados= AdminFechas.restarFechasAnios(fechaInicio,AdminFechas.getFechaActual());
    bono = (float) (this.sueldoinicial*(0.5*añosTrabajados));
   return bono;
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
