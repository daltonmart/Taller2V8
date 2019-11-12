
package logica;

public class DataUsuarioSesion {
    private String nombre;
    private String contrasenia;
    private boolean conectado;
    private int tiempoConectado;
    private boolean admin;

    public DataUsuarioSesion(){
        
    }
    
    public DataUsuarioSesion(String nombre, String contrasenia, boolean conectado, int tiempoConectado, boolean admin) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.conectado = conectado;
        this.tiempoConectado = tiempoConectado;
        this.admin = admin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean getConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public int getTiempoConectado() {
        return tiempoConectado;
    }

    public void setTiempoConectado(int tiempoConectado) {
        this.tiempoConectado = tiempoConectado;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "DataUsuarioSesion{" + "nombre=" + nombre + ", contrasenia=" + contrasenia + ", conectado=" + conectado + ", tiempoConectado=" + tiempoConectado + ", admin=" + admin + '}';
    }
    
    
    
}
