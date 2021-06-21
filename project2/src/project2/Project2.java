/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import Interfaces.VentanaImprimirDocumento;
import javax.swing.JOptionPane;

/**
 *
 * @author andy
 */
public class Project2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MonticuloMin monte =new MonticuloMin();
        NodoArbol nodito = new NodoArbol("hola",5);
        NodoArbol nodito2 = new NodoArbol("lol",3);
        NodoArbol nodito3 = new NodoArbol("coca",7);
        NodoArbol nodito4 = new NodoArbol("cola",9);
        NodoArbol nodito5 = new NodoArbol("colas",10);
        NodoArbol nodito6 = new NodoArbol("tecno",80);
        NodoArbol nodito7 = new NodoArbol("r",65);
        NodoArbol nodito8 = new NodoArbol("toto",15);
        
        monte.insertar(nodito);
        monte.insertar(nodito2);
        monte.insertar(nodito3);
        monte.insertar(nodito4);
        monte.insertar(nodito5);
        monte.insertar(nodito6);
        monte.insertar(nodito7);
        monte.insertar(nodito8);
        monte.eliminarMinimo();
        
        monte.makeAFamily();
        monte.pntAllelmnt();
        monte.ShowHeap();
        
    }
    
}
