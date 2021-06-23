/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash_ulises;

/**
 *
 * @author Ulises
 */
public class Nodo_hash {
    
    private Nodo_hash siguiente;
    private Nodo_usuarios usuario;
    
    public Nodo_hash(Nodo_usuarios usuario){
        
        this.siguiente = null;
        this.usuario = usuario;
        
    }

    /**
     * @return the siguiente
     */
    public Nodo_hash getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo_hash siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the usuario
     */
    public Nodo_usuarios getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Nodo_usuarios usuario) {
        this.usuario = usuario;
    }
    
}
