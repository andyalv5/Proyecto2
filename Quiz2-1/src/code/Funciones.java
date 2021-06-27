/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author andy
 */
public class Funciones {
     public ArbolBinario Leer_txt(File file){
        ArbolBinario lista = new ArbolBinario();
        String line;
        String infotd = "";
        
        try{
            if (!file.exists()) {
                file.createNewFile();
                JOptionPane.showMessageDialog(null,"Fatal ERROR","No existe archivo",JOptionPane.WARNING_MESSAGE);
            }   
            else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine())!=null){
                    
                    infotd += line +"\n";       
                }
                
                if(!"".equals(infotd)){
                    String[] newString = infotd.split("\n");
                    for(int i =0;i<newString.length; i++){
                        String[] user=newString[i].split(",");
                        lista.insertar(user[0],Integer.parseInt(user[1]));
                    }
                }
                br.close();
            } 
        }
                
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL LEER! ");
        }
        return lista; 
    }
    
    public int[] LeerTxtArray(File file){
        int[]lista=new int[0];
        String line;
        String infotd = "";
        
        try{
            if (!file.exists()) {
                file.createNewFile();
                JOptionPane.showMessageDialog(null,"Fatal ERROR","No existe archivo",JOptionPane.WARNING_MESSAGE);
            }   
            else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine())!=null){
                    
                    infotd += line +"\n";       
                }
                
                if(!"".equals(infotd)){
                    String[] newString = infotd.split("\n");
                    lista= new int[newString.length];
                    for(int i =0;i<newString.length; i++){
                        String[] user=newString[i].split(",");
                        lista[i]=Integer.parseInt(user[0]);
                    }
                }
                br.close();
            } 
        }
                
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR AL LEER! ");
        }
        return lista; 
    }
}
