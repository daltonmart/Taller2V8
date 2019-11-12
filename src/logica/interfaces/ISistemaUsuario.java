
package logica.interfaces;

import logica.UsuariosDelJuego;


public interface ISistemaUsuario {
    public void setUsaUsuariosDelJuego(UsuariosDelJuego usaUsuariosDelJuego);
    public void altaUsuario(String nickname, String email, String contrasenia);
    public void bajaUsuario(String nickname);
}
