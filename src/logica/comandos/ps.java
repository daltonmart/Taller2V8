
package logica.comandos;

import logica.*;
import static logica.ISistemaPrincipalImpl.red;

public class ps extends Comando{
    
    public ps(){
        
    }
    
    private String DatosProcesosToString(Equipo equipo){
        
        String aux = "";
        
        aux += "\nUSER\tPID\tPPID\tSTATUS\tNOMBRE\n";
        
        UsuarioSesion usuario = equipo.getCompuestoPorUsuarios().buscarUsuarioConectado();
        
        aux += usuario.getdUsrSesion().getNombre() + "\t";
        
        for(int i = 0; i < equipo.getCompuestoPorProcesos().size(); i++){
        
            aux += equipo.getCompuestoPorProcesos().get(i).getPID() + "\t";
            aux += equipo.getCompuestoPorProcesos().get(i).getPPID() + "\t";
            
            if(equipo.getCompuestoPorProcesos().get(i).getActivo()){
                aux += "active\t";
            } else {
                aux += "inactive\t";
            }
            
            aux += equipo.getCompuestoPorProcesos().get(i).getNombre() + "\n";
            
        }
        
        return aux;
    }

    @Override
    public String ejecutarComando() {
        return DatosProcesosToString(red.getEquipoActual());
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
