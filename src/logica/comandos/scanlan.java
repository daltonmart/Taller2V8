
package logica.comandos;

import logica.*;
import static logica.ISistemaPrincipalImpl.red;

public class scanlan extends Comando{
    
    public scanlan(){
        
    }
    
    public scanlan(String argumentos){
        
        super(argumentos);
    }
    
    private String DatosEquipoToString(Equipo equipo){
        
        String aux = "";
        
        aux += equipo.getdEquipo().getIp() + "\t";
        
        if(equipo.getdEquipo().esServidor()){
            aux += "SERVIDOR\t";
        } else {
            aux += "PC\t\t";
        }
        
        aux += equipo.getdEquipo().getNombre() + "\n\n";
        
        return aux;
    }
    
    
    

    @Override
    public String ejecutarComando() {
        String salida = "";
        
        salida += "\nEquipo actual:\n";
        
        salida += "IP\t\tTIPO\t\tNOMBRE\n";
        
        salida += DatosEquipoToString(red.getEquipoActual());
        
        salida += "Equipos en la red:\n";
        
        salida += "IP\t\tTIPO\t\tNOMBRE\n";
        
        for(int i = 0; i< red.getListaEquipos().size(); i++){
            
            salida += DatosEquipoToString(red.getListaEquipos().get(i));
        
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
            salida = "ERROR. El comando scanlan no necesita de ningún parámetro.";
        }
 
        return salida;

    }
    
    
}
