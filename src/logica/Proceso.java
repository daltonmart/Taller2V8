
package logica;


public class Proceso {
    private int pid;
    private int ppid;
    private String nombre;
    private Boolean activo;

    public Proceso() {
        
    }
    
    public Proceso(int pid, int ppid, String nombre, Boolean activo) {
        this.pid = pid;
        this.ppid = ppid;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getPID() {
        return this.pid;
    }

    public void setPID(int pid) {
        this.pid = pid;
    }
    
    public int getPPID() {
        return this.ppid;
    }

    public void setPPID(int ppid) {
        this.ppid = ppid;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    public Boolean estaActivo(){
        return this.getActivo();
    }
    
}
