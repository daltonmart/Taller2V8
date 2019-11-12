
package persistencia.interfaces;

import logica.EstructuraArchivos;

public interface IPEstructuraArchivo {
    public void escribirPersistenciaEstructuraArchivos( String nombreArchivo,String nombre, int tipo, String direccion, int permiso, String duenio, String grupo, String contenido, int tamanio, String fechayhora);
    public void verPersistenciaEstructuraArchivos(EstructuraArchivos listaArchivos, String nombreArchivo);
    public void borrarArchivoDePersistenciaEstructuraArchivos( String nombre, String nombreArch);
}
