package persistencia;

import persistencia.interfaces.IPRed;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import logica.Equipo;
import logica.Red;
import logica.UsuariosSesion;

public class PRed implements IPRed{

    public PRed() {
    }

    
     
    @Override
    public void verPersistenciaRed(Red r){
        
        //Lectura de los datos del archivo
        File archivo;
        FileReader fr;
        BufferedReader br;
        
        
        try{
            //apertura del archivo
            archivo = new File ("Red.txt");
            fr = new FileReader(archivo);
            br= new BufferedReader(fr);
            String filaLeidaArchivo;
            String [] cadenaSeparada;
            int i=1;
            while  ((filaLeidaArchivo = br.readLine())!= null){
                cadenaSeparada = filaLeidaArchivo.split(" ; ");
                Equipo e= new Equipo(cadenaSeparada[0], cadenaSeparada[1] , Boolean.valueOf(cadenaSeparada[2]), cadenaSeparada[3]);
                
                //Cada equipo levanta sus usuarios en sesion
                String nombreUsuarios=String.valueOf(e.getdEquipo().getIp());
                UsuariosSesion  userSesion= new UsuariosSesion();
                userSesion.cargarPersistenciaUsuariosSesion(nombreUsuarios+"UsuariosSesion.txt");
                e.setCompuestoPorUsuarios( userSesion);
                
                if (i==1){
                    r.setEquipoActual(e);
                    r.setEquipoDelUsuario(e);
                }else{
                    r.insertarEquipo(e);
                }
                //System.out.println(e);
                
                i++;
            }
            
            br.close();
            fr.close();
            
        }
        catch (Exception eR){
            JOptionPane.showConfirmDialog(null,"El Archico Red no existe", "Información",
                    JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "PRed{" + super.toString()+'}';
    }

    
}
