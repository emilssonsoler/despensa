/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despensa;

import java.io.Serializable;

/**
 * 
 * @author Emilsson Soler
 */
public class Refrigeracion implements Serializable{
    
    private boolean refrigeracion;

    /**
     * constructor por defecto
     */
    public Refrigeracion() {
    }

    /**
     * 
     * @param refrigeracion  booleano para saber si o no necesita refrigeracion
     */
    public Refrigeracion(boolean refrigeracion) {
        this.refrigeracion = refrigeracion;
    }

    /**
     * 
     * @return refrigeracion  
     */
    public boolean isRefrigeracion() {
        return refrigeracion;
    }

    /**
     * 
     * @param refrigeracion 
     */
    public void setRefrigeracion(boolean refrigeracion) {
        this.refrigeracion = refrigeracion;
    }
    
    
    
}
