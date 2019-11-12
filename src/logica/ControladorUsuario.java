
package logica;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static logica.ISistemaPrincipalImpl.red;
import logica.interfaces.ISistemaUsuario;
import persistencia.PUsuariosDelJuego;


public class ControladorUsuario implements ISistemaUsuario {
    
    private UsuariosDelJuego usuariosDelJuego;
    private Campania usaCapania;
    
    public ControladorUsuario(){
        if (usuariosDelJuego == null)
            this.usuariosDelJuego = new UsuariosDelJuego();
        if (usaCapania == null)
            this.usaCapania= new Campania();
    }

    
    public ControladorUsuario(UsuariosDelJuego usuariosDelJuego, Campania usaCapania) {
        this.usuariosDelJuego = usuariosDelJuego;
        this.usaCapania = usaCapania;
    }
    
    

    public UsuariosDelJuego getUsaUsuariosDelJuego() {
        return usuariosDelJuego;
    }

    public void setUsaUsuariosDelJuego(UsuariosDelJuego usaUsuariosDelJuego) {
        this.usuariosDelJuego = usaUsuariosDelJuego;
    }

    public Campania getUsaCapania() {
        return usaCapania;
    }

    public void setUsaCapania(Campania usaCapania) {
        this.usaCapania = usaCapania;
    }

    public void altaUsuario(String nickname, String email, String contrasenia){
        if ( usuariosDelJuego.existeNickname(nickname)==false ){
            //si no existe lo agrega a usuarios del juego
            DataUsuarioJuego u= new DataUsuarioJuego(nickname, email, contrasenia,1,0);
            usuariosDelJuego.insertarUsuario(u);
            PUsuariosDelJuego pusuariosDelJuego = new PUsuariosDelJuego();
            pusuariosDelJuego.escribirPersistenciaUsuarioJuego(nickname, email, contrasenia,u.getNroCampania(),u.getProgreso());
            JOptionPane.showConfirmDialog(null,"Usuario creado",
                    "Crear Usuario",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showConfirmDialog(null,"Ya existe un usuario con ese nickname",
                    "Crear Usuario",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void bajaUsuario(String nickname){
        if (! usuariosDelJuego.existeNickname(nickname) )
            JOptionPane.showConfirmDialog(null,"NO existe un usuario con ese nickname",
                    "Borrar Usuario",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        else{
            usuariosDelJuego.borrarUsuario(usuariosDelJuego.buscarUsuario(nickname));
            PUsuariosDelJuego pusuariosDelJuego = new PUsuariosDelJuego();
            pusuariosDelJuego.borrarUsuarioDePersistenciaUsuarioJuego(nickname);
            JOptionPane.showConfirmDialog(null,"Usuario Borrado",
                    "Borrar Usuario",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
    
    
}
