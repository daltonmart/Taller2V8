
package persistencia;

import persistencia.interfaces.IPUsuariosDelJuego;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.DataUsuarioJuego;
import logica.UsuariosDelJuego;


public class PUsuariosDelJuego implements IPUsuariosDelJuego{


    
    public void escribirPersistenciaUsuarioJuego(String nickname, String email, String contrasenia, int nroCampania, int progreso){
        String cadenaDatos= " ";
        cadenaDatos=nickname+" ; "+email+" ; "+contrasenia+" ; "+String.valueOf(nroCampania)+" ; "+String.valueOf(progreso);
        
        //guardamos datos en el archivo
        FileWriter fichero;
        PrintWriter pw;
        try{
            fichero = new FileWriter ("UsuariosDelJuego.txt",true);
            pw = new PrintWriter(fichero);
            pw.println(cadenaDatos);
            pw.close();
            fichero.close();
            //mensaje de exito
            JOptionPane.showConfirmDialog(null,"Datos ingresados al archivo correspondiente",
                    "Información",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null,"No se pudo guardar",
                    "Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    public void verPersistenciaUsuarioJuego(UsuariosDelJuego listaUsuarios){
        
        //Lectura de los datos del archivo
        File archivo=null;
        FileReader fr=null;
        BufferedReader br=null;
        
        try{
            //apertura del archivo
            archivo = new File ("UsuariosDelJuego.txt");
            fr = new FileReader(archivo);
            br= new BufferedReader(fr);
            String filaLeidaArchivo;
            String [] cadenaSeparada;
            
            while ((filaLeidaArchivo = br.readLine())!= null){
                cadenaSeparada = filaLeidaArchivo.split(" ; ");
                DataUsuarioJuego u=new DataUsuarioJuego(cadenaSeparada[0],cadenaSeparada[1],cadenaSeparada[2],Integer.valueOf(cadenaSeparada[3]),Integer.valueOf(cadenaSeparada[4]));
                listaUsuarios.insertarUsuario(u);
                //System.out.println(u);
            }
            
            br.close();
            fr.close();
            
        }
        catch (Exception e){
            JOptionPane.showConfirmDialog(null,"El Archivo no existe", "Información",
                    JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void borrarUsuarioDePersistenciaUsuarioJuego(String nickname)  {
        try {
            File inputFile = new File("UsuariosDelJuego.txt");
            File tempFile = new File("myTempFile.txt");
            
            boolean successful = inputFile.renameTo(tempFile);
            
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(tempFile));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PUsuariosDelJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(inputFile));
            } catch (IOException ex) {
                Logger.getLogger(PUsuariosDelJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String lineToRemove = nickname;
            String currentLine;
            
            while((currentLine = reader.readLine()) != null) {
                String [] trimmedLine = currentLine.trim().split(" ; ");;
                if(trimmedLine[0].equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            tempFile.delete();
            
        } catch (IOException ex) {
            Logger.getLogger(PUsuariosDelJuego.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {
        return "PUsuariosDelJuego{" + super.toString()+'}';
    }
    
    
}
