
package logica.comandos;

import logica.*;
import static logica.ISistemaPrincipalImpl.red;

public class bruteforce extends Comando {
    
    private String ip;
    
    public bruteforce(){
        
        
        
    }
 
    public bruteforce(String argumentos){
        super(argumentos);
        ip = "";
    }
    
    public bruteforce(String argumentos, String ip, Red red){
        super(argumentos);
        this.ip = ip;
    }
    
    
    private String DatosDeLosUsuarios(Equipo equipoAConectar){
        
        String aux = "";
 
        UsuariosSesion usuarios = equipoAConectar.getCompuestoPorUsuarios();
        
        aux += "\nEquipo: " + equipoAConectar.getdEquipo().getNombre() + "(" + this.ip + ").\n";
        aux += "USUARIO\t\tCONTRASEÑA\n";
        
        for(int i = 0; i< usuarios.getListaUsuarios().size(); i++){
            
            aux += usuarios.getListaUsuarios().get(i).getdUsrSesion().getNombre() + "\t\t" + usuarios.getListaUsuarios().get(i).getdUsrSesion().getContrasenia() + "\n";
        }
        
        return aux;
    }

    @Override
    public String ejecutarComando() {
        String salida = "";
        
            salida += "Intentando conectarse al equipo (" + this.ip + ").\n";

        
        if(this.ip.equals(red.getEquipoDelUsuario().getdEquipo().getIp())){
            
            salida += "Crackeando seguridad, sobornando guardias y resolviendo patrones.\n";
            salida += "\nConexión exitosa.\n";
            salida += "\nATENCIÓN. Estos datos pertenecen a TU equipo.\n";
            salida += DatosDeLosUsuarios(red.getEquipoDelUsuario());
            
        } else if(red.existeEquipo(this.ip)){
            
            salida += "Crackeando seguridad, sobornando guardias y resolviendo patrones.\n";
            salida += "\nConexión exitosa.\n\nPlantando keylogger y accediendo a contraseñas.\n";
            salida += DatosDeLosUsuarios(red.buscarEquipo(this.ip));

        } else {
            
            return "\nIP mal escrita o no existe el equipo con esa IP.\n";
                       
        }
        return salida;
    }

    @Override
    public String ejecutarYverificar() {
        String salida;
        
        String args = super.getArgumentos();
        
        if(args.length() != 0){
            
            String[] argumentosSeparados = super.getArgumentos().split(" ");
            
            if(argumentosSeparados.length == 1){
            
                this.ip = argumentosSeparados[0];
                salida = ejecutarComando();
            
            } else {
                salida = "ERROR. El comando ping necesita solamente la IP como parámetro.";
            }
            
        } else {
            salida = "ERROR. El comando bruteforce necesita una IP como parámetro.\n";
            salida += "Ej.: bruteforce 192.168.0.1\n";
        }
        
        return salida;
    }
    
}
