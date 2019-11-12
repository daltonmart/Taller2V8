
package logica.comandos;

import logica.*;
import static logica.ISistemaPrincipalImpl.red;

public class connect extends Comando{
    
    private String ip;
    private String usuario;
    private String contrasenia;
    private long tiempoInicioConexion;
    
    
    public connect(){
        this.ip = "";
        this.usuario = "";
        this.contrasenia = "";
    }
    
    public connect(String argumentos){
        
        super(argumentos);
        
        this.ip = "";
        this.usuario = "";
        this.contrasenia = "";
    }
    
    public connect(String ip, String usuario, String contrasenia) {
        
        this.ip = ip;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public connect(String ip, String usuario, String contrasenia, String argumentos) {
        
        super(argumentos);
        this.ip = ip;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    @Override
    public String ejecutarComando() {
        
        Equipo equipoAConectar;
        String salida = "";
        
        
        if(this.ip.equals(red.getEquipoDelUsuario().getdEquipo().getIp())){
            
            return "ATENCIÓN. Estás intentando conectarte a tu propio equipo.\n";
            
        } else if(red.existeEquipo(this.ip)){
            
            equipoAConectar = red.buscarEquipo(this.ip);
            
            if(equipoAConectar.getCompuestoPorUsuarios().loginCorrecto(this.usuario, this.contrasenia)){

                //recupero los usuarios
                UsuariosSesion usuarios = equipoAConectar.getCompuestoPorUsuarios();
                
                //los desconecto a todos
                usuarios.desconectarUsuarios();
                
                //el usuario al que me voy a conectar pasa a ser el usuario conectado
                usuarios.conectarUsuario(this.usuario);
                
                //guardo los cambios en la lista de usuarios
                equipoAConectar.setCompuestoPorUsuarios(usuarios);
                
                //seteo el equipo actual como el equipo a conectar
                red.setEquipoActual(equipoAConectar);
                
                //ingreso el tiempo de inicio de conexión
                this.tiempoInicioConexion = System.currentTimeMillis();
                red.setTiempoInicioConexion(this.tiempoInicioConexion);
                
                
                salida += "Intentando conectar a " + equipoAConectar.getdEquipo().getNombre() + "(" + this.ip + ")...\n";
                salida += "Cerrando la sesión de los otros usuarios...\n";
                salida += "Conectado a "+ this.ip + " con el usuario " + this.usuario + "...\n";
                
                return salida;
                
            } else {
               
               return "Usuario o contraseña inválidos...";
           }
            
        } else {
            
            return "ERROR. IP mal escrita o no existe el equipo con esa IP.\n";
        }
        
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
            salida = "ERROR. El comando connect necesita una IP, un usuario y una contraseña válidas.\n";
            salida += "Ej.: connect 192.168.0.1 usuario contraseña\n";
        }
        
        return salida;
    }
    
}
