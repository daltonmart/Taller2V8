
package logica.comandos;

import java.util.Random;
import logica.*;
import static logica.ISistemaPrincipalImpl.red;

public class ping extends Comando{

    private String ip;
    
    public ping(){
        
    }
 
    public ping(String argumentos){
        super(argumentos);
    }
    
    public Boolean verificarSintaxisIP(String ip){
        
        int contadorDePuntos = 0;
        
        for(int i = 0; i < ip.length(); i++){
            
            if(!Character.isDigit(ip.charAt(i))){
                if(ip.charAt(i) == '.' && contadorDePuntos !=3){
                    contadorDePuntos++;
                } else{
                    return false;
                }
            }
        }
        
        if(contadorDePuntos < 3 || ip.length() > 15){
            return false;
        } else {
            return true;
        }
        
        /*
        int contadorDePuntos = 0;
        char caracter;
        
        for(int i = 0; i < ip.length(); i++){
            
            caracter = ip.charAt(i);
            if(caracter == '.'){
                contadorDePuntos++;
            }
            
        }
        */
    }
    
    
    @Override
    public String ejecutarComando() {
        
        String salida = "";
        
        if(this.ip.equals(red.getEquipoDelUsuario().getdEquipo().getIp())){
            
            salida += "ATENCIÓN. Estás intentando hacer ping al equipo que estás usando.\n";
            
        } else if(red.existeEquipo(this.ip)){
            
            Equipo equipoApinguear = red.buscarEquipo(this.ip);
            
            Random rnd = new Random();
            
            long tiempoping;
            long tiempoTotal = 0;

            salida += "PING " + equipoApinguear.getdEquipo().getNombre() + "(" + this.ip + ") " + 56 + "(" + 84 + ") " + "bytes of data.\n";
            
            for(int i = 1; i <= 19; i++){
                salida += "64 bytes from " + equipoApinguear.getdEquipo().getNombre() + "(" + this.ip + ") " + " icmp_seq=" + i + " ttl=63 time=";
                tiempoping = rnd.nextInt(501);
                tiempoTotal += tiempoping;
                salida += tiempoping + "ms\n";
            }
            
            salida += "--- " + equipoApinguear.getdEquipo().getNombre() + "(" + this.ip + ") " + " ping statistics ---\n";
            
            
            salida += "19 packets transmitted, 19 received, 0% packet loss, time " + tiempoTotal + "ms\n";
           
        } else {
            
            if(verificarSintaxisIP(this.ip)){
                Random rnd = new Random();
          
                salida += "PING " + this.ip + " " + 56 + "(" + 84 + ") " + "bytes of data.\n";
            
                salida += "--- " + "(" + this.ip + ") " + " ping statistics ---\n";
            
                salida += "19 packets transmitted, 0 received, 100% packet loss, time " + rnd.nextInt(2001) + "ms\n";
            
            } else {
                
                salida = "ERROR. El comando ping necesita una IP a la que deseas hacer ping.\n";
                salida += "Ej.: ping 192.168.0.1\n";
            
            }
            

           
            
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
                salida = "ERROR. El comando ping necesita solamente la IP a la que deseas hacer ping.";
            }
            
        } else {
            salida = "ERROR. El comando ping necesita una IP a la que deseas hacer ping.\n";
            salida += "Ej.: ping 192.168.0.1\n";
        }
        
        return salida;
    }
    
}
