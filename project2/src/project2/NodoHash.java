/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 * Clase NodoHash
 * Esta es la clase que crea el Nodo del Hash
 * @author Andy,Maria,Jose,Ulises
 * @version 2/7/21
 */
public class NodoHash {

    private NodoHash siguiente;
    private String usuario;
    private int timeTag;
    private NodoDoc document;

    /**
     * Constructor del NodoHash
     * @param usuario nombre del usuario
     * @param timeTag etiqueta de tiemp
     * @param document nodo del documento
     */
    
    public NodoHash(String usuario, int timeTag, NodoDoc document){

        this.siguiente = null;
        this.usuario = usuario;
        this.document= document;
        this.timeTag= timeTag;

    }

    /**
     * Función que retorna el siguiente Nodo Hash
     * @return the siguiente
     */
    public NodoHash getSiguiente() {
        return siguiente;
    }

    /**
     * Método que configura el siguiente Nodo Hash
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoHash siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Función que retorna el nombre del usuario
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método que define el nombre del usuario
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Función que retorna el número de la etiqueta de tiempo
     * @return the timeTag
     */
    public int getTimeTag() {
        return timeTag;
    }

    /**
     * Método que define el número de la etiqueta de tiempo
     * @param timeTag the timeTag to set
     */
    public void setTimeTag(int timeTag) {
        this.timeTag = timeTag;
    }

    /**
     * Función que retorna el Nodo documento
     * @return the document
     */
    public NodoDoc getDocument() {
        return document;
    }

    /**
     * Método que define el Nodo documento
     * @param document the document to set
     */
    public void setDocument(NodoDoc document) {
        this.document = document;
    }

    
    
}
