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
abstract class Persona {
  
   private int ID;
   private String pNombre;
   private String sNombre;
   private String pApellido;
   private String sApellido;
   private String direccion;
   private String numeroTelefonico;

    public Persona() {
    }

    /**
     * 
     * @param pNombre
     * @param sNombre
     * @param pApellido
     * @param sApellido
     * @param direccion
     * @param numeroTelefonico 
     */
    public Persona( String pNombre, String sNombre, String pApellido, String sApellido, String direccion, String numeroTelefonico) {
        
        this.pNombre = pNombre;
        this.sNombre = sNombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.direccion = direccion;
        this.numeroTelefonico = numeroTelefonico;
    }
    

    /**
     * 
     * @return ID 
     */
    public int getID() {
        return ID;
    }

    /**
     * 
     * @param ID 
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * 
     * @return pNombre
     */
    public String getpNombre() {
        return pNombre;
    }

    /**
     * 
     * @param pNombre 
     */
    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    /**
     * 
     * @return sNombre 
     */
    public String getsNombre() {
        return sNombre;
    }

    /**
     * 
     * @param sNombre 
     */
    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    /**
     * 
     * @return pApellido 
     */
    public String getpApellido() {
        return pApellido;
    }

    /**
     * 
     * @param pApellido 
     */
    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    /**
     * 
     * @return sApellido 
     */
    public String getsApellido() {
        return sApellido;
    }

    /**
     * 
     * @param sApellido 
     */
    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    /**
     * 
     * @return direccion 
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * 
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * 
     * @return numeroTelefonico
     */
    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    /**
     * 
     * @param numeroTelefonico 
     */
    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
    /**
     * 
     * @return String que es el nombre completo de la persona
     */
     public String getNombreCompleto(){
    return String.format("%s  "+"%s "+"%s "+"%s", this.pNombre,this.sNombre,this.pApellido,this.sApellido);
    
    }
     
     /**
      * 
      * @return String que es la toda la informacion 
      */
     abstract String getInformacion();
    
   
    
}
