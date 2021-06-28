/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

/**
 *
 * @author mkferrerteran
 */
public class NodoH {
    private String user;
    private String prioridad;
    private String domcumento;

    public NodoH(String user, String prioridad, String domcumento) {
        this.user = user;
        this.prioridad = prioridad;
        this.domcumento = domcumento;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDomcumento() {
        return domcumento;
    }

    public void setDomcumento(String domcumento) {
        this.domcumento = domcumento;
    }
    
}
