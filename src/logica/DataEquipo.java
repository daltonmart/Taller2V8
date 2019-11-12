
package logica;

public class DataEquipo {
    private String nombre;
    private String ip;
    private Boolean servidor;
    private String informacion;
    
    public DataEquipo() {
        
    }
    
    public DataEquipo(String nombre, String ip, Boolean servidor, String informacion) {
        this.nombre = nombre;
        this.ip = ip;
        this.servidor = servidor;
        this.informacion = informacion;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Boolean getServidor() {
        return servidor;
    }

    public void setServidor(Boolean servidor) {
        this.servidor = servidor;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
    
    public Boolean esServidor(){
        return this.getServidor();
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", ip=" + ip + ", servidor=" + servidor + ", informacion=" + informacion + '}';
    }
    
    
}
