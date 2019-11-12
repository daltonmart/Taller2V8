
package logica;

import java.util.ArrayList;
import persistencia.PRed;
import persistencia.interfaces.IPRed;

public class Red {
    private ArrayList<Equipo> listaEquipos;
    private Equipo equipoActual;
    private Equipo equipoDelUsuario;
    private long tiempoInicioConexion;
    private long tiempoFinConexion;

    public Red(){
        this.listaEquipos= new ArrayList<>();
        this.equipoActual = new Equipo();
        this.equipoDelUsuario = new Equipo();
        this.tiempoInicioConexion = 0;
        this.tiempoFinConexion = 0;
    }
    
    public Red(Equipo equipoActual) {
        this.equipoActual = equipoActual;
        this.equipoDelUsuario = equipoActual;
        this.listaEquipos= new ArrayList<>();
        this.tiempoInicioConexion = 0;
        this.tiempoFinConexion = 0;
    }

    //GETTERS
    
    public Equipo getEquipoActual() {
        return this.equipoActual;
    }
    
    public Equipo getEquipoDelUsuario(){
        return this.equipoDelUsuario;
    }
    
    public ArrayList<Equipo> getListaEquipos(){
        return listaEquipos;
    }
    
    public long getTiempoInicioConexion(){
        return this.tiempoInicioConexion;
    }

    public long getTiempoFinConexion(){
        return this.tiempoFinConexion;
    }
    
    //SETTERS
    
    public void setEquipoActual(Equipo equipoActual){
        this.equipoActual = equipoActual;
    }
    
    public void setEquipoDelUsuario(Equipo equipoDelUsuario){
        this.equipoDelUsuario = equipoDelUsuario;
    }
    
    public void setListaEquipos(ArrayList<Equipo> listaEquipos){
        this.listaEquipos = listaEquipos;
    }
    
    public void setTiempoInicioConexion(long tiempo){
        this.tiempoInicioConexion = tiempo;
    }
    
    public void setTiempoFinConexion(long tiempo){
        this.tiempoFinConexion = tiempo;
    }
    
    //MÉTODOS

    public void insertarEquipo(Equipo e){
        listaEquipos.add(e);
    }
     
    public Equipo buscarEquipo(String ip){
       
        Boolean encontro = false;
        int i=0;
        while ( (i<listaEquipos.size()) && (!encontro)){
            encontro = (ip.equals(listaEquipos.get(i).getdEquipo().getIp()));
            i++;
        }
        return listaEquipos.get(i-1);
    }
    
    public Boolean existeEquipo(String ip){
        
        for(int i = 0; i<listaEquipos.size(); i++){
            if(ip.equals(listaEquipos.get(i).getdEquipo().getIp())){
                return true;
            }
        }
        
        return false;
    }
    
    public long tiempoDeConexion(){
        return this.tiempoFinConexion - this.tiempoInicioConexion;
    }
    
    public void cargarPersistenciaRed(){
        IPRed r = new PRed();
        r.verPersistenciaRed(this);
    }

    @Override
    public String toString(){
        return "Red{" + "listaEquipos=" + listaEquipos + ", equipoActual=" + equipoActual + '}';
    }
    
    
}
