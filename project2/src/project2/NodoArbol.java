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
public class NodoArbol {
    private Object data;
    private NodoArbol parent;
    private NodoArbol nodoIzq;
    private NodoArbol nodoDer;
    private int priority;

    public NodoArbol(Object data, int priority){
        this.data=data;
        this.priority=priority;
        this.parent=null;
        this.nodoDer=null;
        this.nodoIzq=null;
    }
    
    
    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @return the parent
     */
    public NodoArbol getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(NodoArbol parent) {
        this.parent = parent;
    }

    /**
     * @return the nodoIzq
     */
    public NodoArbol getNodoIzq() {
        return nodoIzq;
    }

    /**
     * @param nodoIzq the nodoIzq to set
     */
    public void setNodoIzq(NodoArbol nodoIzq) {
        this.nodoIzq = nodoIzq;
    }

    /**
     * @return the nodoDer
     */
    public NodoArbol getNodoDer() {
        return nodoDer;
    }

    /**
     * @param nodoDer the nodoDer to set
     */
    public void setNodoDer(NodoArbol nodoDer) {
        this.nodoDer = nodoDer;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
}
