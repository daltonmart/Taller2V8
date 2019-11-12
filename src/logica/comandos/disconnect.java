
package logica.comandos;

import logica.*;
import static logica.ISistemaPrincipalImpl.red;

public class disconnect extends Comando {
    
    public disconnect(){

    }
    
    public disconnect(String argumentos){
        super(argumentos);
    }

    @Override
    public String ejecutarComando() {
        
        String salida = "";
        
        if(red.getEquipoActual().getdEquipo().getIp().equals(red.getEquipoDelUsuario().getdEquipo().getIp())){
            
            salida += "ATENCIÓN. No te puedes desconectar de tu propio equipo.\n";
            
        } else {
            String ipAnterior = red.getEquipoActual().getdEquipo().getIp();
        
            Equipo equipoDelUsuario = red.getEquipoDelUsuario();
        
            red.setEquipoActual(equipoDelUsuario);
            
            red.setTiempoFinConexion(System.currentTimeMillis());
        
            salida += "Te has desconectado del equipo con IP: " + ipAnterior + ".\n";
            salida += "Tiempo conectado: " + (red.tiempoDeConexion()/1000) + " segundos.\n";
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
            salida = "ERROR. El comando disconnect no necesita de ningún parámetro.";
        }
 
        return salida;
    }
    
}
