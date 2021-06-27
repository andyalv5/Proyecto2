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
    
    public void writeTxt(NodoUsers nodo){
        Funciones fun = new Funciones();
        File f=new File("test//new.csv");
        Users listaUser=fun.Leer_csv(f);
        listaUser.addAtEnd(nodo);
        writeTxt(listaUser);
    }
    
    public void writeProductTxt(Users lista){
        String txt ="";
        
        if(!lista.isEmpty()){
            NodoUsers temp1= lista.getFirst();
            for(int z =0;z< lista.getSize();z++){
                txt +=temp1.getUser()+","+temp1.getPriority()+"-"+"\n";
                if(temp1.getDocuments()!=null){
                NodoDoc temp2= temp1.getDocuments().getpFirst();
                    while(temp2!=null){
                        txt+=temp2.getNombre()+","+temp2.getTipo()+","+temp2.getSize()+"@"+"\n";
                        temp2=temp2.getpNext();
                    }
                }
                temp1 =temp1.getNext();
            }  
        }
        
        try{
            PrintWriter pw = new PrintWriter("test//productos.csv");
            pw.print("usuario,tipo"+"\n");
            pw.append(txt);
            pw.close();
            JOptionPane.showMessageDialog(null, "Guardado Exitoso.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Fallo En Cargar Datos.");
        }

    }  
    
    public Users LeerProductosCsv(File file){
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
                    if(line.endsWith("-")){
                        infotd +="@%"+ line;
                    }
                    if(line.endsWith("@")){
                        infotd += line+"%";
                    }
                }
                
                
                if(!"".equals(infotd)){
                    String[] newString = infotd.split("@%");
                    for(int i =0;i<newString.length; i++){
                        if(!newString[i].equals("") ){
                            String[] product= newString[i].split("-");
                            String[] productos = product[0].split(",");
                            JOptionPane.showMessageDialog(null, productos[0]);
                            NodoUsers nodo= new NodoUsers(productos[0],productos[1]);
                            
                            ListaDoc lis=new ListaDoc();
                            for(int j=1;j<product.length;j++){
                                if(product[j]!=null){
                                    String[] productw = product[j].split(",");
                                    lis.addDoc(productw[0],Integer.parseInt(productw[2]),productw[1]);
                                }
                            nodo.setDocuments(lis);
                            lista.addAtEnd(nodo);
                            }
                        }
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
