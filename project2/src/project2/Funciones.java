/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

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
     public Users Leer_csv(File file){
        Users lista = new Users();
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
                br.readLine();
                while((line = br.readLine())!=null){
                    
                    infotd += line +"\n";       
                }
                
                if(!"".equals(infotd)){
                    String[] newString = infotd.split("\n");
                    for(int i =0;i<newString.length; i++){
                        String[] user=newString[i].split(",");
                        NodoUsers usuario = new NodoUsers(user[0],user[1]);
                        lista.addAtEnd(usuario);
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
    
    
    public void writeTxt(Users lista){
        String txt ="";
        
        
        if(!lista.isEmpty()){
            NodoUsers temp1= lista.getFirst();
            for(int z =0;z< lista.getSize();z++){
                txt +=temp1.getUser()+","+temp1.getPriority()+"\n";
                temp1 =temp1.getNext();
            }  
        }
        
        try{
            PrintWriter pw = new PrintWriter("test//lista.csv");
            pw.print("usuario,tipo"+"\n");
            pw.append(txt);
            pw.close();
            JOptionPane.showMessageDialog(null, "Guardado Exitoso.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Fallo En Cargar Datos.");
        }

    }  
     
}
