/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author andy
 */
public class NodoHash {

    private NodoHash siguiente;
    private String usuario;
    private int timeTag;
    private NodoDoc document;

    public NodoHash(String usuario, int timeTag, NodoDoc document){

        this.siguiente = null;
        this.usuario = usuario;
        this.document= document;
        this.timeTag= timeTag;

    }

    /**
     * @return the siguiente
     */
    public NodoHash getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoHash siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the timeTag
     */
    public int getTimeTag() {
        return timeTag;
    }

    /**
     * @param timeTag the timeTag to set
     */
    public void setTimeTag(int timeTag) {
        this.timeTag = timeTag;
    }

    /**
     * @return the document
     */
    public NodoDoc getDocument() {
        return document;
    }

    /**
     * @param document the document to set
     */
    public void setDocument(NodoDoc document) {
        this.document = document;
    }

    
    
}
