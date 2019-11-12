
package logica;

import java.util.ArrayList;

public class Equipo {
    
    private DataEquipo dEquipo;
    private ArrayList<Proceso> compuestoPorProcesos;
    private UsuariosSesion compuestoPorUsuarios;
    
    //private ArrayList<BaseDeDatos> compuestoPorBDD;

    public Equipo() {
        this.dEquipo = new DataEquipo();
        
        this.compuestoPorProcesos = new ArrayList<> ();
        this.compuestoPorUsuarios = new UsuariosSesion();
        //this.compuestoPorBDD = new ArrayList<> ();
    }
    
    public Equipo(String nombre, String ip, Boolean servidor, String informacion) {
        this.dEquipo= new DataEquipo(nombre, ip, servidor, informacion);
        
        this.compuestoPorProcesos = new ArrayList<> ();
        this.compuestoPorUsuarios = new UsuariosSesion();
        //this.compuestoPorBDD = new ArrayList<> ();
    }

    public DataEquipo getdEquipo() {
        return dEquipo;
    }

    public void setdEquipo(DataEquipo dEquipo) {
        this.dEquipo = dEquipo;
    }

    public ArrayList<Proceso> getCompuestoPorProcesos() {
        return compuestoPorProcesos;
    }

    public void setCompuestoPorProcesos(ArrayList<Proceso> compuestoPorProcesos) {
        this.compuestoPorProcesos = compuestoPorProcesos;
    }

    public UsuariosSesion getCompuestoPorUsuarios() {
        return compuestoPorUsuarios;
    }

    public void setCompuestoPorUsuarios(UsuariosSesion compuestoPorUsuarios) {
        this.compuestoPorUsuarios = compuestoPorUsuarios;
    }

    @Override
    public String toString() {
        return "Equipo{" + "dEquipo=" + dEquipo + ", compuestoPorProcesos=" + compuestoPorProcesos + ", compuestoPorUsuarios=" + compuestoPorUsuarios + '}';
    }

    
    
}
