
package logica;

public class UsuarioSesion {
    private DataUsuarioSesion dUsrSesion;
    private EstructuraArchivos compuestoPorArchivos;

    public UsuarioSesion() {
        dUsrSesion = new DataUsuarioSesion();
        this.compuestoPorArchivos = new EstructuraArchivos();
    }
    
    public UsuarioSesion (String nombre, String contrasenia, Boolean conectado, int tiempoConectado, Boolean admin){
        dUsrSesion = new DataUsuarioSesion( nombre, contrasenia, conectado, tiempoConectado, admin);
        this.compuestoPorArchivos = new EstructuraArchivos();
    }
    
    public UsuarioSesion(DataUsuarioSesion dUsrSesion) {
        this.dUsrSesion = dUsrSesion;
    }

    
    public EstructuraArchivos getCompuestoPorArchivos() {
        return compuestoPorArchivos;
    }

    public void setCompuestoPorArchivos(EstructuraArchivos compuestoPorArchivos) {
        this.compuestoPorArchivos = compuestoPorArchivos;
    }
    
    public DataUsuarioSesion getdUsrSesion() {
        return dUsrSesion;
    }

    public void setdUsrSesion(DataUsuarioSesion dUsrSesion) {
        this.dUsrSesion = dUsrSesion;
    }
    
    public Boolean estaConectado(){
        return this.getdUsrSesion().getConectado()==true;
    }
    
    public void desconectar(){
        this.dUsrSesion.setConectado(false);
    }
    
    public void conectar(){
        this.dUsrSesion.setConectado(true);
    }
    
    public Boolean esAdministrador(){
        
       return this.getdUsrSesion().getAdmin()==true;
    }

    @Override
    public String toString() {
        return "UsuarioSesion{" + "dUsrSesion=" + dUsrSesion + ", compuestoPorArchivos=" + compuestoPorArchivos + '}';
    }
    
    
}
