/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa;

/**
 *
 * @author Emilsson Soler
 */
public class Cliente extends Persona{

    public Cliente() {
    }

    /**
     * 
     * @param ID
     * @param pNombre
     * @param sNombre
     * @param pApellido
     * @param sApellido
     * @param direccion
     * @param numeroTelefonico 
     */
    public Cliente(int ID, String pNombre, String sNombre, String pApellido, String sApellido, String direccion, String numeroTelefonico) {
        super(pNombre, sNombre, pApellido, sApellido, direccion, numeroTelefonico);
    }

    @Override
    String getInformacion() {
       return String.format("El nombre completo es: %s"+"\t"+
                            "su dirreccion es:%s"+"\t"+
                            "su numero de telefono es:%s"+"\n"
                            ,
                            super.getNombreCompleto(),
                            super.getDireccion(),
                            super.getNumeroTelefonico());
    }
    

    
    
    
}
