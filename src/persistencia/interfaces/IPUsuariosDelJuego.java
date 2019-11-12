
package persistencia.interfaces;

import logica.UsuariosDelJuego;

public interface IPUsuariosDelJuego {
    public void escribirPersistenciaUsuarioJuego(String nickname, String email, String contrasenia, int nroCampania, int progreso);
    public void verPersistenciaUsuarioJuego(UsuariosDelJuego listaUsuarios);
    public void borrarUsuarioDePersistenciaUsuarioJuego(String nickname);
}
