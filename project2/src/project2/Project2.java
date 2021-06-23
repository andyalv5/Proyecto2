/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import Interfaces.VentanaImprimirDocumento;
import Interfaces.VentanaPrincipal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
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
//        Scanner entrada = null;
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.showOpenDialog(fileChooser);
//        try{
//            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
//            File f = new File(ruta);
//            entrada = new Scanner(f);
//            while (entrada.hasNext()){
//                System.out.println(entrada.nextLine());    
//            }    
//        }catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());    
//        }catch (NullPointerException e){
//            System.out.println("NO SE HA SELECCIONADO NINGUN FICHERO");    
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }finally{
//            if (entrada != null){
//                entrada.close();
//            }
//        }    

        
        VentanaPrincipal inicial =new VentanaPrincipal();
        inicial.setVisible(true);
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
        monte.eliminarMinimo();
        
        monte.makeAFamily();
        monte.pntAllelmnt();
        monte.ShowHeap();
        
    }
    
}
