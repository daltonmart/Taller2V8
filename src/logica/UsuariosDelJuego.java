

package logica;


import java.util.ArrayList;

import persistencia.PUsuariosDelJuego;
import persistencia.interfaces.IPUsuariosDelJuego;

public class UsuariosDelJuego {
    
    private ArrayList<DataUsuarioJuego> listaUsuarios;

   
    public UsuariosDelJuego( ) {
        //if (listaUsuarios==null)
            this.listaUsuarios = new ArrayList<>();
    
    }
    
    
    public DataUsuarioJuego buscarUsuario(String nickname){
       
        Boolean encontro = false;
        int i=0;
        while ( (i<listaUsuarios.size()) && (!encontro)){
            encontro = nickname.equals(listaUsuarios.get(i).getNickname());
            i++;
        }
        if (encontro)
            return listaUsuarios.get(i-1);
        else
            return null;
    }
    
    public Boolean existeNickname(String nickname){
        Boolean encontro = false;
        int i=0;
        while ( (i<listaUsuarios.size()) && (!encontro) ){
            encontro = nickname.equals(listaUsuarios.get(i).getNickname());
            i++;
        }
        return encontro;
    }
    
    public Boolean existeUsuario(DataUsuarioJuego u){
        return listaUsuarios.contains(u);
    }
    
    public void insertarUsuario(DataUsuarioJuego u){
        listaUsuarios.add(u);
    }
    
    public void borrarUsuario(DataUsuarioJuego u){
        listaUsuarios.remove(u);
    }

    public void cargarPersistenciaUsuariosDelJuego(){
        IPUsuariosDelJuego pUsuariosDelJuego = new PUsuariosDelJuego();
        pUsuariosDelJuego.verPersistenciaUsuarioJuego(this);
    }
    
    @Override
    public String toString() {
        return "UsuariosDelJuego{" + "listaUsuarios=" + listaUsuarios + '}';
    }
    
    
}
