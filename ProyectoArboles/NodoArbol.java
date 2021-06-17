/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoArboles;
    
    
/**
 *
 * @author andynet
 */
public class NodoArbol {
    private Object Data;
    private NodoArbol right;
    private NodoArbol Left;
    
    NodoArbol(Object Data){
        this.Data = Data;
        this.Left =null;
        this.right=null;
    }

    /**
     * @return the Data
     */
    public Object getData() {
        return Data;
    }

    /**
     * @param Data the Data to set
     */
    public void setData(Object Data) {
        this.Data = Data;
    }

    /**
     * @return the right
     */
    public NodoArbol getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(NodoArbol right) {
        this.right = right;
    }

    /**
     * @return the Left
     */
    public NodoArbol getLeft() {
        return Left;
    }

    /**
     * @param Left the Left to set
     */
    public void setLeft(NodoArbol Left) {
        this.Left = Left;
    }
    
    
}
