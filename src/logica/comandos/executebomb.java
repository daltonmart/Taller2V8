package logica.comandos;

import logica.*;
import static logica.ISistemaPrincipalImpl.red;


public class executebomb extends Comando{
    
    private String ip;
    private String usuario;
    private String contrasenia;
    
    public executebomb(){
        this.ip = "";
        this.usuario = "";
        this.contrasenia = "";
    }
    
    public executebomb(String argumentos){
        
        super(argumentos);
        
        this.ip = "";
        this.usuario = "";
        this.contrasenia = "";
    }
    
    public executebomb(String ip, String usuario, String contrasenia) {
        
        this.ip = ip;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public executebomb(String ip, String usuario, String contrasenia, String argumentos) {
        
        super(argumentos);
        this.ip = ip;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    @Override
    public String ejecutarComando() {
        
        String salida = "";
        Equipo equipoAConectar;
        
        if(this.ip.equals(red.getEquipoDelUsuario().getdEquipo().getIp())){

            salida += "ATENCIÓN. No se puede ejecutar una Bomba Lógica en tu propio equipo ;-)\n";
        
        } else if(red.existeEquipo(this.ip)){
            
            equipoAConectar = red.buscarEquipo(this.ip);
            
            salida += "Intentando conectar a " + equipoAConectar.getdEquipo().getNombre() + "(" + this.ip + ")...\n";
            salida += "Conectando a "+ this.ip + " con el usuario " + this.usuario + "...\n";
            
            if(equipoAConectar.getCompuestoPorUsuarios().loginCorrecto(this.usuario, this.contrasenia)){
                
                UsuarioSesion usr = equipoAConectar.getCompuestoPorUsuarios().buscarUsuario(this.usuario);
                
                salida += "Conectado a "+ this.ip + " con el usuario " + this.usuario + "...\n";
                
                //Si ya se había implantado una bomba lógica
                if(usr.getCompuestoPorArchivos().getBombaLogica()){
                    
                    //recupero datos del equipo
                    
                    salida+= "Recuperando datos del equipo...\n";
                    salida+= "Nombre del equipo: " + equipoAConectar.getdEquipo().getNombre();
                    salida+= "\nIP: " + equipoAConectar.getdEquipo().getIp();
                    salida+= "\nTipo: ";
                    if(equipoAConectar.getdEquipo().getServidor()){
                        salida+= "Servidor";
                    } else{
                        salida+= "PC";
                    }
                    salida+= "\nInformación del equipo: " + equipoAConectar.getdEquipo().getInformacion() + "\n";
                    
                    
                } else{

                    salida+= "ERROR. No se ha implantado una bomba lógica en este equipo.\n";
                    
                }
                
            } else {
                
                salida+= "ERROR. Usuario y/o contraseña incorrectos.\n";
            }
            
        } else {
            
            salida += "ERROR. IP mal escrita o no existe el equipo con esa IP.\n";
        }
        
        return salida;
        
    }

    @Override
    public String ejecutarYverificar() {
        
        String salida;
        
        String [] argumentosSeparados = super.getArgumentos().split(" ");
        
        if(argumentosSeparados.length == 3){
            
            this.ip = argumentosSeparados[0];
            this.usuario = argumentosSeparados[1];
            this.contrasenia = argumentosSeparados[2];
            
            
            salida = ejecutarComando();
            
            
        } else {
            salida = "ERROR. El comando executebomb necesita una IP, un usuario y una contraseña válidas.\n";
            salida += "Ej.: executebomb 192.168.0.1 usuario contraseña\n";
        }
        
        return salida;
    }
    
    
    
}
