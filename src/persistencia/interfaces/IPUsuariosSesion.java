
package persistencia.interfaces;

import logica.UsuariosSesion;

public interface IPUsuariosSesion {
    public void escribirPersistenciaUsuarioSesion(String nombreUsuarios, String nombre, String contrasenia, Boolean conectado, int tiempoConectado, Boolean admin);
    public void verPersistenciaUsuarioSesion(UsuariosSesion us,String nombreUsuarios);
    public void borrarUsuarioDePersistenciaUsuarioSesion(String nombreUsuarios, String nickname);
}
