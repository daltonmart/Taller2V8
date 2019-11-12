
package logica;

import logica.interfaces.ISistemaJuegoHistoria;
import logica.interfaces.ISistemaPrincipal;
import logica.interfaces.ISistemaSesion;
import logica.interfaces.ISistemaUsuario;

public class ISistemaPrincipalImpl implements ISistemaPrincipal {
    public static UsuariosDelJuego usuariosDelJuego=new UsuariosDelJuego();
    public static Historia historia = new Historia();
    public static Red red= new Red();
    public static ISistemaSesion iSesion= new ControladorSesion();
    public static ISistemaUsuario iUsuario = new ControladorUsuario();
    public static ISistemaJuegoHistoria iJuego = new ControladorJuegoHistoria();
    
    @Override
    public void cargarRedInicial(){
        System.out.println("Cargando Su equipo...");
        red.cargarPersistenciaRed();
        System.out.println("Cargando Red...");
        System.out.println(red);
    }
    
    @Override
    public void cargarHistoria(){
        historia.generarCampanias(4);
        historia.insertarMisionACampania(1,"Debes ingresar cat nombre archivo","Ver contenido del archivo llamdo peligro ", "cat peligro");
        
        System.out.println("Cargando Historia...");
        System.out.println(historia);
    }
    
    @Override
    public void cargarUsuariosDelJuego(){
        usuariosDelJuego.cargarPersistenciaUsuariosDelJuego();
        System.out.println(usuariosDelJuego);
    }
    
    //ControladorSesion
    @Override
    public UsuariosDelJuego getUsuariosDeJuego(){
        return iSesion.getUsuariosDeJuego();
    }
    
    @Override
    public void setUsuariosDeJuego(UsuariosDelJuego usuariosDeJuego){
        iSesion.setUsuariosDeJuego(usuariosDeJuego);
    }
    
    @Override
    public DataUsuarioJuego getuEnSesion(){
        return iSesion.getuEnSesion();
    }

    @Override
    public void setuEnSesion(DataUsuarioJuego uEnSesion){
        iSesion.setuEnSesion(uEnSesion);
    }

    @Override
    public int getNroCampania(){
        return iSesion.getNroCampania();
    }

    @Override
    public void setNroCampania(int nroCampania){
        iSesion.setNroCampania(nroCampania);
    }
    
    @Override
    public int getProgreso(){
        return iSesion.getProgreso();
    }

    @Override
    public void setProgreso(int progreso){
        iSesion.setProgreso(progreso);
    }
    
    @Override
    public void login(String nickname, String contrasenia){
        iSesion.setUsuariosDeJuego(usuariosDelJuego);
        iSesion.login(nickname, contrasenia);
    }
     
    @Override
    public void logout(){
        iSesion.logout();
    }
    
    
    
    //ControladorUsuario
    @Override
    public void setUsaUsuariosDelJuego(UsuariosDelJuego usaUsuariosDelJuego){
        iUsuario.setUsaUsuariosDelJuego(usaUsuariosDelJuego);
    }
    @Override
    public void altaUsuario(String nickname, String email, String contrasenia){
        iUsuario.altaUsuario(nickname, email, contrasenia);
    }
    
    @Override
    public void bajaUsuario(String nickname){
        iUsuario.bajaUsuario(nickname);
    }
    
    //ControladorJuegoHistoria
    @Override
    public String obtenerHistoriaUsuarioSesion(){
        return iJuego.obtenerHistoriaUsuarioSesion();
    }
    
    @Override
    public String manejoComandoDeITerminal(String lineaTextoIngresada){
        return iJuego.manejoComandoDeITerminal(lineaTextoIngresada);
    }
    
    @Override
    public void avanceMision(){
        iJuego.avanceMision();
    }
    
    @Override
    public String getPrompt(){
        return iJuego.getPrompt();
    }
    
    @Override
    public boolean jugadorGano(){
        return iJuego.jugadorGano();
    }
    
    @Override
    public boolean jugadorAlFinalDeCampania(int nroCampaniasDeHistoria){
        return iJuego.jugadorAlFinalDeCampania(nroCampaniasDeHistoria);
    }
    
}
