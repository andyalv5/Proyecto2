/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author andynet
 */
public class NodoArbol {
    private Object tInfo;
    private int clave;
    private NodoArbol NodIzquierdo;
    private NodoArbol NodDerecho;

    /**
     * @return the tInfo
     */
    public Object gettInfo() {
        return tInfo;
    }

    public NodoArbol(Object tInfo,int clave){
        this.NodDerecho = null;
        this.NodIzquierdo=null;
        this.tInfo = tInfo;
        this.clave=clave;
    }
    
    public void destructor(){
        this.tInfo =null;
    }
    
    /**
     * @param tInfo the tInfo to set
     */
    public void settInfo(Object tInfo) {
        this.tInfo = tInfo;
    }

    /**
     * @return the NodIzquierdo
     */
    public NodoArbol getNodIzquierdo() {
        return NodIzquierdo;
    }

    /**
     * @param NodIzquierdo the NodIzquierdo to set
     */
    public void setNodIzquierdo(NodoArbol NodIzquierdo) {
        this.NodIzquierdo = NodIzquierdo;
    }

    /**
     * @return the NodDerecho
     */
    public NodoArbol getNodDerecho() {
        return NodDerecho;
    }

    /**
     * @param NodDerecho the NodDerecho to set
     */
    public void setNodDerecho(NodoArbol NodDerecho) {
        this.NodDerecho = NodDerecho;
    }

    /**
     * @return the clave
     */
    public int getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(int clave) {
        this.clave = clave;
    }

    
}
