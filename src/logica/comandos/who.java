
package logica.comandos;

import logica.*;
import java.util.Random;
import static logica.ISistemaPrincipalImpl.red;

public class who extends Comando{
    
    
    public who(){
        
    }
    
    public who(String argumentos){
        
        super(argumentos);
        
    }
    
    private String DatosUsuariosToString(Equipo equipo){
        
        String aux = "";
        
        Random rnd = new Random();
        
        UsuariosSesion usuarios = equipo.getCompuestoPorUsuarios();
        
        aux += "\nID\tUSUARIO\tTIPO\tESTADO\tTIEMPO\n";
        
        for(int i = 0; i< usuarios.getListaUsuarios().size(); i++){
            
            aux += (i+1) + "\t";
            
            aux += usuarios.getListaUsuarios().get(i).getdUsrSesion().getNombre();
            aux += "\t";
            
            if(usuarios.getListaUsuarios().get(i).getdUsrSesion().getAdmin()){
                aux += "Admin.\t";
            } else {
                aux += "User.\t";
            }
            
            if(usuarios.getListaUsuarios().get(i).getdUsrSesion().getConectado()){
                
                aux += "Online\t" + rnd.nextInt(100001) + "seg.";
            } else {
                aux += "Ofline\t0 seg.";
            }
            
            aux += "\n";
        }
        
        return aux;
    }

    @Override
    public String ejecutarComando() {
         
        return DatosUsuariosToString(red.getEquipoActual());
    }

    @Override
    public String ejecutarYverificar() {
        String salida;
        
        String args = super.getArgumentos();
        
        if(args.length() == 0){
            
            salida = ejecutarComando();
            
        } else {
            salida = "ERROR. El comando who no necesita de ningún parámetro.";
        }
 
        return salida;
    }
    
}
