/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 * Clase NodoArbol
 * Esta es la clase que crea el Nodo del Arbol
 * @author Andy,Maria,Jose,Ulises
 * @version 2/7/21
 */
public class NodoArbol {
    private NodoDoc data;
    private NodoArbol parent;
    private NodoArbol nodoIzq;
    private NodoArbol nodoDer;
    private int priority;

    /**
     * Constructor del NodoArbol
     * @param data nodo del documento
     * @param priority número entero que indica la posición del arbol
     */
    
    public NodoArbol(NodoDoc data, int priority){
        this.data=data;
        this.priority=priority;
        this.parent=null;
        this.nodoDer=null;
        this.nodoIzq=null;
    }
    
    
    /**
     * Función que retorna el NodoDoc
     * @return the data
     */
    public NodoDoc getData() {
        return data;
    }

    /**
     * Método que define el NodoDoc
     * @param data the data to set
     */
    public void setData(NodoDoc data) {
        this.data = data;
    }

    /**
     * Función que retorna al padre 
     * @return the parent
     */
    public NodoArbol getParent() {
        return parent;
    }

    /**
     * Método que define al padre
     * @param parent the parent to set
     */
    public void setParent(NodoArbol parent) {
        this.parent = parent;
    }

    /**
     * Función que retorna al hijo izquierdo
     * @return the nodoIzq
     */
    public NodoArbol getNodoIzq() {
        return nodoIzq;
    }

    /**
     * Método que define al hijo izquierdo
     * @param nodoIzq the nodoIzq to set
     */
    public void setNodoIzq(NodoArbol nodoIzq) {
        this.nodoIzq = nodoIzq;
    }

    /**
     * Función que retorna al hijo derecho
     * @return the nodoDer
     */
    public NodoArbol getNodoDer() {
        return nodoDer;
    }

    /**
     * Método que define al hijo derecho
     * @param nodoDer the nodoDer to set
     */
    public void setNodoDer(NodoArbol nodoDer) {
        this.nodoDer = nodoDer;
    }

    /**
     * Función que retorna el entero de prioridad
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Método que define el entero de prioridad
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
}
