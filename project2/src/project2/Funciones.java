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
 * Clase Funciones
 * Esta es la clase que se utiliza para cargar y escribir los datos de un archivo txt 
 * @author Andy,Maria,Jose,Ulises
 * @version 2/7/21
 */
public class Funciones {
    
    /**
     * Método que busca en una ruta el archivo de los usuarios para cargar en el Sistema operativo
     * @param file el parametro para buscar el csv a cargar
     * @return El número de ítems (números aleatorios) de que consta la serie
     */
    
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
    
     /**
     * Método que graba la lista dentro del sistema operativo de los usuarios almacenados en el Txt
     * @param lista la lista de usuarios que se graban en el csv, dicha lista es
     * modificada por el usuario dentro del sistema operativo en tiempo de ejecución
     */
    
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
            PrintWriter pw = new PrintWriter("test//new.csv");
            pw.print("usuario,tipo"+"\n");
            pw.append(txt);
            pw.close();
            JOptionPane.showMessageDialog(null, "Guardado Exitoso.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Fallo En Cargar Datos.");
        }

    }  
    
    /**
     * Función que carga en el txt una lista de usuarios con uno de ellos eliminado
     * @param toDel parámetro que busca al usuario a eliminar y lo excluye al momento
     * de cargar los datos dentro del txt, aprovecha el recorrido para devolver los nombres
     * para luego imprimirlos en pantalla
     * @return String llamado users 
     */
    
    public String writeTxt(String toDel){
        Funciones fun = new Funciones();
        File f=new File("test//new.csv");
        Users listaUser=fun.Leer_csv(f);
        String users= "";
        NodoUsers firstUser = listaUser.getFirst();
        Users newUserList = new Users();
        while(firstUser!=null){
            if(!firstUser.getUser().equals(toDel)){
                newUserList.addAtEnd(firstUser);
                users+=firstUser.getUser()+",";
            }
            firstUser = firstUser.getNext();
        }
        writeTxt(newUserList);
        return users;
    }
    
    /**
     * Método que carga en el csv una lista de usuarios con uno extra
     * @param nodo el nodo a insertar en la lista para cargar
     * al txt 
     */
    
    public void writeTxt(NodoUsers nodo){
        Funciones fun = new Funciones();
        File f=new File("test//new.csv");
        Users listaUser=fun.Leer_csv(f);
        listaUser.addAtEnd(nodo);
        writeTxt(listaUser);
    }
    
    
}
