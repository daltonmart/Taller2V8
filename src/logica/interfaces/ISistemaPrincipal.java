
package logica.interfaces;

import logica.DataUsuarioJuego;
import logica.UsuariosDelJuego;

public interface ISistemaPrincipal {
    public void cargarRedInicial();
    public void cargarHistoria();
    public void cargarUsuariosDelJuego();
    
    //ControladorSesion
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
    
    //ControladorUsuario
    public void setUsaUsuariosDelJuego(UsuariosDelJuego usaUsuariosDelJuego);
    public void altaUsuario(String nickname, String email, String contrasenia);
    public void bajaUsuario(String nickname);
    
    //ControladorJuegoHistoria
    
    public String obtenerHistoriaUsuarioSesion();

    public String manejoComandoDeITerminal(String lineaTextoIngresada);
    
    public void avanceMision();
    
    public String getPrompt();
    
    public boolean jugadorGano();
    
    public boolean jugadorAlFinalDeCampania(int nroCampaniasDeHistoria);
}
