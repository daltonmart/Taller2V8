
package logica.comandos;

import logica.*;
import static logica.ISistemaPrincipalImpl.red;

public class insertbomb extends Comando{
    
    public insertbomb(){
        
    }
    
    public insertbomb(String argumentos){
        super(argumentos);
    }

    @Override
    public String ejecutarComando() {
        String salida = "";
        
        if(red.getEquipoActual().getdEquipo().getIp().equals(red.getEquipoDelUsuario().getdEquipo().getIp())){
            
            salida += "ATENCIÓN. No se puede insertar una Bomba Lógica en tu propio equipo ;-)\n";
        
        } else {
        
            red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos().setBombaLogica(true);
            
            salida += "Intentando implantar la bomba lógica...\n";
            salida += "¡Bomba lógica implantada con éxito!\n";
            
        }
        
        return salida;
    }

    @Override
    public String ejecutarYverificar() {
        String salida;
        
        String args = super.getArgumentos();
        
        if(args.length() == 0){
            
            salida = ejecutarComando();
            
        } else {
            salida = "ERROR. El comando insertbomb no necesita de ningún parámetro.";
        }
 
        return salida;
    }

}
