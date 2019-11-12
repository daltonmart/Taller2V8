
package logica.interfaces;

import logica.DataUsuarioJuego;
import logica.UsuariosDelJuego;


public interface ISistemaSesion {
    public UsuariosDelJuego getUsuariosDeJuego(); 
    
    public void setUsuariosDeJuego(UsuariosDelJuego usuariosDeJuego);
    
    public DataUsuarioJuego getuEnSesion();

    public void setuEnSesion(DataUsuarioJuego uEnSesion);

    public int getNroCampania() ;

    public void setNroCampania(int nroCampania);
    
    public int getProgreso();

    public void setProgreso(int progreso);
    
    public void login(String nickname, String contrasenia);
     
    public void logout();
    
    
}
