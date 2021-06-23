/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class hashTable {
    String [] arreglo;
    String nombre;
    int size;
    int contador;
    
    public hashTable(int tam){
        size = tam;
        arreglo = new String[tam];
    }
    
    
    
    public void funcionHash2(int id, String nombre, Object [] arreglo){
        int indice = id % (size - 1);
        JOptionPane.showMessageDialog(null, "El índice es " + indice + " para el usuario " + nombre);
        
        while (arreglo[indice] != null){
            indice++;
            JOptionPane.showMessageDialog(null, "Ocurrió una colisión en el índice " + (indice - 1) + " el usuario será almacenado en el índice " + indice);
            indice %= size;
        }
        arreglo[indice] =  id + "," + nombre;
        
    }

    public void mostrar(){
        int incremento = 0;
        for (int i = 0; i < 1; i++){
            incremento += size;
            
            for (int j = 0; j < 71; j++){
                System.out.print("-");;
            }
            for (int j = incremento - size; j < incremento; j++){
                System.out.format("| %3s " + " ", j);
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++){
                System.out.print("-");
            }
            System.out.println();
            for (int j = incremento - size; j < incremento; j++){
                if (arreglo[j].equals(null)){
                    System.out.println("|          ");
                }else{
                    System.out.print(String.format("| %3s " + " ", arreglo[j]));
                }
            }
            System.out.println("|");
            for (int j = 0; j < 71; j++){
                System.out.print("-");
            }
            System.out.println();
        }
    }
    
    public String buscar(int id){
            int indice = id % (size - 1);
            contador = 0;
            while (arreglo[indice] != null){
                JOptionPane.showMessageDialog(null, arreglo[indice]);
                if (arreglo[indice] == Integer.toString(id)){
                    JOptionPane.showMessageDialog(null, "El elemento fue encontrado en el índice " + indice);
                    return arreglo[indice];
                }
                indice++;
                indice %= size;
                contador++;
                if (contador > size){
                    break;
                }
            }
            return null;
    }
    
    
    //Main
    /*
    hashTable3.hashTable hash = new hashTable3.hashTable(67);
        
        int id = 2150;
        String nombre = "Hola";
        hash.funcionHash2(id, nombre, hash.arreglo);
        //hash.mostrar();

        
        String buscado = hash.buscar(id);
        if (buscado == null){
            JOptionPane.showMessageDialog(null, "El elemento que desea buscar no a sido encontrado");
        }
    */ 
}
