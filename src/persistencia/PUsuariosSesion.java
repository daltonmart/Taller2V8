
package persistencia;

import persistencia.interfaces.IPUsuariosSesion;
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
import logica.EstructuraArchivos;
import logica.UsuarioSesion;
import logica.UsuariosSesion;


public class PUsuariosSesion implements IPUsuariosSesion{

    public PUsuariosSesion() {
    }
    
    
    @Override
    public void escribirPersistenciaUsuarioSesion(String nombreUsuarios, String nombre, String contrasenia, Boolean conectado, int tiempoConectado, Boolean admin){
        String cadenaDatos= " ";
        cadenaDatos=nombre+" ; "+contrasenia+" ; "+String.valueOf(conectado)+" ; "+String.valueOf(tiempoConectado)+" ; "+String.valueOf(admin);
        
        //guardamos datos en el archivo
        FileWriter fichero;
        PrintWriter pw;
        try{
            fichero = new FileWriter (nombreUsuarios,true);
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
    
    
    @Override
    public void verPersistenciaUsuarioSesion(UsuariosSesion us, String nombreUsuarios){
        
        //Lectura de los datos del archivo
        File archivo=null;
        FileReader fr=null;
        BufferedReader br=null;
        
        try{
            //apertura del archivo
            archivo = new File (nombreUsuarios);
            fr = new FileReader(archivo);
            br= new BufferedReader(fr);
            String filaLeidaArchivo;
            String [] cadenaSeparada;
            
            while ((filaLeidaArchivo = br.readLine())!= null){
                cadenaSeparada = filaLeidaArchivo.split(" ; ");
                UsuarioSesion u=new UsuarioSesion(cadenaSeparada[0],cadenaSeparada[1],Boolean.valueOf(cadenaSeparada[2]),Integer.valueOf(cadenaSeparada[3]),Boolean.valueOf(cadenaSeparada[4]));
                
                //Cada usuario levanta sus archivos
                String nombreArchivo=u.getdUsrSesion().getNombre();
                EstructuraArchivos eArch = new EstructuraArchivos();
                eArch.cargarPersistenciaEstructuraArchivos(nombreArchivo+"EArchivos.txt");
                u.setCompuestoPorArchivos(eArch);
                
                us.insertarUsuario(u);
                
                //System.out.println(u);
            }
            
            br.close();
            fr.close();
            
        }
        catch (Exception e){
            JOptionPane.showConfirmDialog(null,"El Archivo Usuarios no existe", "Información",
                    JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    @Override
    public void borrarUsuarioDePersistenciaUsuarioSesion(String nombreUsuarios,String nickname){
        try {
            File inputFile = new File(nombreUsuarios);
            File tempFile = new File("myTempFile.txt");
            
            boolean successful = inputFile.renameTo(tempFile);
            
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(tempFile));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PUsuariosSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
            
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
            Logger.getLogger(PUsuariosSesion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {
        return "PUsuariosSesion{ "+super.toString() +" }";
    }
    
    
    
}
