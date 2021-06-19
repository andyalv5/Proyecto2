/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

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
        monte.insertar(nodito);
        monte.insertar(nodito2);
        monte.makeAFamily();
        JOptionPane.showMessageDialog(null,monte.getpRoot().getData());
    }
    
}
