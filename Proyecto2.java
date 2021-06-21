/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author mkferrerteran
 */
public class Proyecto2 {
    public static void main(String[] args) {
        
        Scanner entrada = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        try{
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            File f = new File(ruta);
            entrada = new Scanner(f);
            while (entrada.hasNext()){
                System.out.println(entrada.nextLine());    
            }    
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());    
        }catch (NullPointerException e){
            System.out.println("NO SE HA SELECCIONADO NINGUN FICHERO");    
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            if (entrada != null){
                entrada.close();
            }
        }    
    }  
    
    /*
    public static void crearCSV(){
        String salidaArchivo = "ArchivoUsers.csv"; //Nombre del archivo
        boolean exist = new File(salidaArchivo).exists(); //verificar si existe el archivo
        if(exist){
            System.out.println("ya existe el archivo");
        }
        try { 
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            // datos para indentificar las columnas
            salidaCSV.write("Usuario");
            salidaCSV.write("Prioridad");
            salidaCSV.endRecord(); //Deja de escribir en el archivo
            //Recorremos la lista y lo insertamos en el archivo
            for (Users usuario : user) {
                salidaCSV.write(usuario.getUser());
                salidaCSV.write(usuario.getPriority());
                
                salidaCSV.endRecord(); //deja de escribir en el archivo
            }
            salidaCSV.close(); //cierra el archivo
        }catch(IOException e){
            e.printStackTrace();
        }    
    }
*/

}
