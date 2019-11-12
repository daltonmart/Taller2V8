

package logica;

import java.util.ArrayList;
import persistencia.PUsuariosSesion;
import persistencia.interfaces.IPUsuariosSesion;



public class UsuariosSesion {
    
    private ArrayList<UsuarioSesion> listaUsuarios;
    
   
    public UsuariosSesion( ) {
        
        this.listaUsuarios = new ArrayList<>();
        
    
    }

    public ArrayList<UsuarioSesion> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<UsuarioSesion> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    
    public UsuarioSesion buscarUsuario(String nombre){
       
        boolean encontro = false;
        int i=0;
        while ( (i<listaUsuarios.size()) && (!encontro)){
            encontro = nombre.equals(listaUsuarios.get(i).getdUsrSesion().getNombre());
            i++;
        }
        return listaUsuarios.get(i-1);
    }
    
    public void desconectarUsuarios(){
        for(int i = 0; i < listaUsuarios.size(); i++){
            listaUsuarios.get(i).desconectar();
        }
    }
    
    public void conectarUsuario(String nombre){
        
        for(int i = 0; i < listaUsuarios.size(); i++){
            
            if(nombre.equals(listaUsuarios.get(i).getdUsrSesion().getNombre())){
                listaUsuarios.get(i).conectar();
            }
            
        }
        
    }
    
    public boolean existeNickname(String nickname){
        boolean encontro = false;
        int i=0;
        while ( (i<listaUsuarios.size()) && (!encontro) ){
            encontro = nickname.equals(listaUsuarios.get(i).getdUsrSesion().getNombre());
            i++;
        }
        return encontro;
    }
    
    public boolean existeUsuario(UsuarioSesion u){
        return listaUsuarios.contains(u);
    }
    
    
    public boolean loginCorrecto(String usuario, String contrasenia){
        
        for(int i = 0; i < listaUsuarios.size(); i++){
            
            if(usuario.equals(listaUsuarios.get(i).getdUsrSesion().getNombre()) && contrasenia.equals(listaUsuarios.get(i).getdUsrSesion().getContrasenia())){
                
                return true;
                
            }
        }
        
        return false;
    }
    
    public void insertarUsuario(UsuarioSesion u){
        listaUsuarios.add(u);
    }
    
    public void borrarUsuario(UsuarioSesion u){
        listaUsuarios.remove(u);
    }
    
    public UsuarioSesion buscarUsuarioConectado(){
           
        boolean encontro = false;
        int i=0;
        while ( (i<listaUsuarios.size()) && (!encontro) ){
            encontro = listaUsuarios.get(i).estaConectado();
            i++;
        }
        if (encontro)
            return listaUsuarios.get(i-1);
        else
            return null;
    }

    public void cargarPersistenciaUsuariosSesion(String nombreUsuarios){
        IPUsuariosSesion pUsuariosSesion = new PUsuariosSesion();
        pUsuariosSesion.verPersistenciaUsuarioSesion(this, nombreUsuarios);
    }
    
    @Override
    public String toString() {
        return "UsuariosSesion{" + "listaUsuarios=" + listaUsuarios + '}';
    }
    
    
}
