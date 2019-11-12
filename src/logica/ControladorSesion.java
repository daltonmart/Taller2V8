
package logica;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static logica.ISistemaPrincipalImpl.historia;
import logica.interfaces.ISistemaSesion;

public class ControladorSesion implements ISistemaSesion{
    private UsuariosDelJuego usuariosDeJuego;
    private DataUsuarioJuego uEnSesion;
    


    public ControladorSesion() {
        if (usuariosDeJuego == null)
            this.usuariosDeJuego = new UsuariosDelJuego();
        
    }
    
    
    public UsuariosDelJuego getUsuariosDeJuego() {
        return usuariosDeJuego;
    }

    public void setUsuariosDeJuego(UsuariosDelJuego usuariosDeJuego) {
        this.usuariosDeJuego = usuariosDeJuego;
    }

    public DataUsuarioJuego getuEnSesion() {
        return uEnSesion;
    }

    public void setuEnSesion(DataUsuarioJuego uEnSesion) {
        this.uEnSesion = uEnSesion;
    }

    public int getNroCampania(){
        return this.getuEnSesion().getNroCampania();
    }

    public void setNroCampania(int nroCampania){
        this.getuEnSesion().setNroCampania(nroCampania);
    }
    
    public int getProgreso(){
        return this.getuEnSesion().getProgreso();
    }

    public void setProgreso(int progreso){
        this.getuEnSesion().setProgreso(progreso);
    }
    
    
    
    public void login(String nickname, String contrasenia){
        DataUsuarioJuego u;
        if (!usuariosDeJuego.existeNickname(nickname))
            JOptionPane.showConfirmDialog(null,"NO existe un usuario con ese nickname, vuelva a ingresar",
                    "Login",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        else{
                u=usuariosDeJuego.buscarUsuario(nickname);
                if (contrasenia.equals(u.getContrasenia())){
                    //coloca Usuario en uEnSesion
                    uEnSesion=u;
                    
                }
                else
                    JOptionPane.showConfirmDialog(null,"Contrasenia incorrecta",
                    "Login",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void logout(){
        uEnSesion=null;
    }
    
    
}
