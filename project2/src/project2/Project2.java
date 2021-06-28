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
        
        Funciones fun =new Funciones();
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
        
    }
    
}
