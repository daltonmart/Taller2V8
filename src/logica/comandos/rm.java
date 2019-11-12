
package logica.comandos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Comando;
import logica.DataArchivo;
import logica.EstructuraArchivos;
import static logica.ISistemaPrincipalImpl.red;

public class rm extends Comando{
    private String url;
    private EstructuraArchivos usaEstructuraArchivos;

    public rm() {
    }

    public rm(String argumentos) {
        super(argumentos);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public EstructuraArchivos getUsaEstructuraArchivos() {
        return usaEstructuraArchivos;
    }

    public void setUsaEstructuraArchivos(EstructuraArchivos usaEstructuraArchivos) {
        this.usaEstructuraArchivos = usaEstructuraArchivos;
    }

    public String getArgumentos() {
        return argumentos;
    }

    public void setArgumentos(String argumentos) {
        this.argumentos = argumentos;
    }

    
    public Boolean verificarSintaxis(){
        return super.getArgumentos()!=null;
    }
    
    
    public boolean verificarUrl(){
        boolean res = false;
        String urlEncontro;
        System.out.println(red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado());
        DataArchivo aActual = red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos().getArchActual();
        System.out.println(aActual);
        String urlActual=aActual.getDireccion();
        String[] urlcortado = url.split("/");
        
        String nombre =urlcortado[urlcortado.length-1];
        
        
        if (red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos().existeUrl(this.getUrl())){
            
            urlEncontro = red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos().buscarUrl(this.getUrl());

            System.out.println(urlActual);
            System.out.println(urlEncontro);

            if (url.contains("/")) {//Si es absoluta
                this.setUrl(nombre);
                res = !urlEncontro.equalsIgnoreCase("");


            }
            else //si es relativa
                res =urlActual.equals(urlEncontro+nombre);
        }
        System.out.println(res);
        return res;
        
    } 

    @Override
    public String ejecutarComando() {
        String nombre;
        EstructuraArchivos eArch=red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos();
        DataArchivo a= red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos().buscarArchivo(this.getUrl());
        System.out.println(red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado());
        System.out.println(a);
        if (a.getTipo()==1){
            if (a != null){
                //System.out.println(this.extraerNombreDeUrl());
                nombre = eArch.extraerNombreDeUrl(this.getUrl());
                eArch.bajaArchivo(nombre);
                
                return "";
            }
            else
                return "No existe el archivo";
        }
        else 
            return "Error, Es un directorio";
     
    }

    @Override
    public String ejecutarYverificar() {
        String salida;
        if (this.verificarSintaxis()){
            this.setUrl(super.getArgumentos());
            if (verificarUrl())
                salida= this.ejecutarComando();
            else
                salida = " No existe el archivo en el directorio donde esta";//no desde donde estoy
        }
        else
            salida = "rm requiere un nombre de archivo";
        return salida;
    }

    
    
}
