/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash_ulises;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
/**
 *
 * @author Ulises
 */
public class Archivo_cvs {
    
    public void Lerr_txt(Hash_table tabla){
        
        String line;
        String Datos_cvs = "";
        String path = "test//datos.cvs";
        File file = new File(path);
        
        try{
            
            if (!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine()) != null){
                    
                    if(!line.isEmpty()){
                        Datos_cvs += line + "\n";
                    }
                    
                }
                if(!"".equals(Datos_cvs)){
                    
                    String[] datos_split = Datos_cvs.split("\n");
                    for (int i = 0; i < datos_split.length; i++) {
                        
                        String[] dato = datos_split[i].split(",");
                        Nodo_usuarios usuario = new Nodo_usuarios(dato[0], dato[1], null);
                        tabla.Insertar(usuario);
                        
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa");
            }
            
        }catch (Exception err){
            JOptionPane.showMessageDialog(null, "Error al leer los datos");
        }

    }
    
}
