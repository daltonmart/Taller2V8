
package logica.comandos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import logica.Comando;
import logica.DataArchivo;
import logica.EstructuraArchivos;
import static logica.ISistemaPrincipalImpl.red;
import logica.UsuarioSesion;

public class mkdir extends Comando {
    private String url;
    private EstructuraArchivos usaEstructuraArchivos;

    public mkdir() {
    }

    public mkdir(String argumentos) {
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
        
        UsuarioSesion userConect =red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado();
        EstructuraArchivos eArch = userConect.getCompuestoPorArchivos();
        DataArchivo aActual = eArch.getArchActual();
        System.out.println(aActual);
        String urlActual=aActual.getDireccion();
        
        
        String nombre = eArch.extraerNombreDeUrl(this.url);

        String urlSinNombre = this.getUrl().replaceAll(nombre, "") ;
        System.out.println(urlSinNombre);
        
        
        if (url.contains("/")) {//Si es absoluta
            res =( (!eArch.existeNombreDireccion(nombre, urlSinNombre)) && ((urlActual.equals(urlSinNombre)) || (eArch.existeDireccion(urlSinNombre)))  );

        }
        else //si es relativa
            res = !eArch.existeNombreDireccion(nombre, urlActual);

        System.out.println(res);
        return res;
        
    } 
    

    @Override
    public String ejecutarComando() {
        String nombre;
        DataArchivo a;
        UsuarioSesion ua = red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado();
        EstructuraArchivos eArch=ua.getCompuestoPorArchivos();
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("MMM dd, yy HH:mm");
        String fechayhora= (String) hourdateFormat.format(date);        
        nombre = eArch.extraerNombreDeUrl(this.getUrl());
        
        System.out.println(nombre);
        if (url.contains("/")) {//Si es absoluta
            String urlSinNombre = this.getUrl().replaceAll(nombre, "") ;
            a = eArch.buscarPorDireccionArchivo(urlSinNombre);
            
            eArch.altaArchivo(nombre,0, a.getDireccion() , a.getPermiso() , ua.getdUsrSesion().getNombre() , "G"+ua.getdUsrSesion().getNombre(), "null", 0, fechayhora);
        }
        else
        {
            a = eArch.getArchActual();//para cuando es relativa
            eArch.altaArchivo(nombre,0,a.getDireccion() , a.getPermiso() , ua.getdUsrSesion().getNombre() , "G"+ua.getdUsrSesion().getNombre(), "null", 0, fechayhora);
        }
        return "";
        
    }

    @Override
    public String ejecutarYverificar() {
        String salida;
        if (this.verificarSintaxis()){
            this.setUrl(super.getArgumentos());
            if (verificarUrl())
                salida= this.ejecutarComando();
            else
                salida = " ya existe el directorio que quiere crear";//no desde donde estoy
        }
        else
            salida = "mkdir requiere un nombre de archivo";
        return salida;
    }
}
