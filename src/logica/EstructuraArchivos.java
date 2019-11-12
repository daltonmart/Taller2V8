package logica;

import java.util.ArrayList;
import java.util.Arrays;
import static logica.ISistemaPrincipalImpl.red;
import persistencia.PEstructuraArchivo;
import persistencia.interfaces.IPEstructuraArchivo;

public class EstructuraArchivos {

    private ArrayList<DataArchivo> listaArchivos;
    private DataArchivo archActual;//siempre tiene que ser tipo 1
    Boolean bombaLogica;

    public EstructuraArchivos() {

        this.listaArchivos = new ArrayList<>();

        this.archActual = new DataArchivo();
    }

    public ArrayList<DataArchivo> getListaArchivos() {
        return listaArchivos;
    }

    public void setListaArchivos(ArrayList<DataArchivo> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }

    public DataArchivo getArchActual() {
        return archActual;
    }

    public void setArchActual(DataArchivo archActual) {
        this.archActual = archActual;
    }

    public Boolean getBombaLogica() {
        return bombaLogica;
    }

    public void setBombaLogica(Boolean bombaLogica) {
        this.bombaLogica = bombaLogica;
    }

    //Precondicion: existeArchivoConnombre
    public DataArchivo buscarArchivo(String nombre) {

        boolean encontro = false;
        int i = 0;
        while ((i < listaArchivos.size()) && (!encontro)) {
            encontro = nombre.equals(listaArchivos.get(i).getNombre());
            i++;
        }
        if (encontro) {
            return listaArchivos.get(i - 1);
        } else {
            return null;
        }
    }

    //Precondicion: existeArchivoConnombre
    public DataArchivo buscarPorDireccionArchivo(String direccion) {

        boolean encontro = false;
        int i = 0;
        while ((i < listaArchivos.size()) && (!encontro)) {
            encontro = direccion.equals(listaArchivos.get(i).getDireccion());
            i++;
        }
        if (encontro) {
            return listaArchivos.get(i - 1);
        } else {
            return null;
        }
    }

    public String extraerNombreDeUrl(String urlComando) {
        String[] url = urlComando.split("/");

        String nombre = url[url.length - 1];
        return nombre;
    }

    public String buscarUrl(String urlComando) {

        String nombre = this.extraerNombreDeUrl(urlComando);
        return this.buscarArchivo(nombre).getDireccion();
    }

    public boolean existeUrl(String urlComando) {
        String nombre = this.extraerNombreDeUrl(urlComando);
        return existeArchivoConNombre(nombre);
    }

    public boolean existeArchivoConNombre(String nombre) {
        boolean encontro = false;
        int i = 0;
        while ((i < listaArchivos.size()) && (!encontro)) {
            encontro = nombre.equals(listaArchivos.get(i).getNombre());
            i++;
        }
        return encontro;
    }

    public boolean existeDireccion(String dir) {
        boolean encontro = false;
        int i = 0;
        while ((i < listaArchivos.size()) && (!encontro)) {
            encontro = dir.equals(listaArchivos.get(i).getDireccion());
            i++;
        }
        return encontro;
    }

    public boolean existeNombreDireccion(String nom, String dir) {
        boolean encontro = false;
        int i = 0;
        while ((i < listaArchivos.size()) && (!encontro)) {
            encontro = (dir.equals(listaArchivos.get(i).getDireccion()) && nom.equals(listaArchivos.get(i).getNombre()));
            i++;
        }
        return encontro;
    }

    public boolean existeArchivo(DataArchivo arch) {
        return listaArchivos.contains(arch);
    }

    public void insertarArchivo(DataArchivo arch) {
        listaArchivos.add(arch);
    }

    public void borrarArchivo(DataArchivo arch) {
        listaArchivos.remove(arch);
    }

    public void altaArchivo(String nombre, int tipo, String direccion, int permisos, String duenio, String grupo, String contenido, int tamanio, String fechayhora) {
        //if ( existeArchivoConNombre(nombre)==false ){
        //si no existe lo agrega a usuarios del juego
        DataArchivo a = new DataArchivo(nombre, tipo, direccion, permisos, duenio, grupo, contenido, tamanio, fechayhora);
        insertarArchivo(a);
        IPEstructuraArchivo pEstructuraArchivos = new PEstructuraArchivo();
        UsuarioSesion userSesion = red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado();
        String nombreArchivoTxt = userSesion.getdUsrSesion().getNombre();
        pEstructuraArchivos.escribirPersistenciaEstructuraArchivos(nombreArchivoTxt + "EArchivos.txt", nombre, tipo, direccion, permisos, duenio, grupo, contenido, tamanio, fechayhora);

        //}
        //else
        //   System.out.println("Ya existe ese archivo con ese nombre");
    }

    public void bajaArchivo(String nombre) {
        if (!existeArchivoConNombre(nombre)) {
            System.out.println("Ese Archivo no existe");
        } else {
            borrarArchivo(buscarArchivo(nombre));
            IPEstructuraArchivo pEstructuraArchivos = new PEstructuraArchivo();
            UsuarioSesion userSesion = red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado();
            String nombreArchivoTxt = userSesion.getdUsrSesion().getNombre();
            pEstructuraArchivos.borrarArchivoDePersistenciaEstructuraArchivos(nombre, nombreArchivoTxt + "EArchivos.txt");
        }
    }

    public void cargarPersistenciaEstructuraArchivos(String nombreArchivo) {
        IPEstructuraArchivo pEstructuraArchivos = new PEstructuraArchivo();
        pEstructuraArchivos.verPersistenciaEstructuraArchivos(this, nombreArchivo);
    }

    @Override
    public String toString() {
        return "EstructuraArchivos{" + "listaArchivos=" + listaArchivos + ", archActual=" + archActual + '}';
    }

    
    
    
    public ArrayList<DataArchivo> getArchivos(String url) {
        ArrayList<DataArchivo> ArchivosUrl = new ArrayList<DataArchivo>();

        if (url.lastIndexOf("/") != url.length() - 1) {
            url = url + "/";
        }
        for (DataArchivo arch : listaArchivos) {
            if (url.equals(arch.getDireccion())) {
                ArchivosUrl.add(arch);
            }
        }
        return ArchivosUrl;
    }

    public ArrayList<DataArchivo> getArchivos() {
        return listaArchivos;
    }

    public DataArchivo getArchivoDeUrl(String posibleUrl) {
        for (DataArchivo arch : listaArchivos) {
            if (posibleUrl.equals(arch.getDireccion() + arch.getNombre())) {
                return arch;
            }
        }
        return null;
    }

    public String getUrlAbsoluta(String urlEntrada) {
        String url = urlEntrada;
        if (url.length() == 0) {
            url = this.getDirectorioActual();
        }
        if (url.equals("..")) {
            String[] dirAnterior = this.getDirectorioActual().split("/");
            String directorioAnterior = "";
            if (dirAnterior.length > 0) {
                dirAnterior = Arrays.copyOf(dirAnterior, dirAnterior.length - 1);
                directorioAnterior = String.join("/", dirAnterior);
            }
            if (directorioAnterior.equals("")) {
                directorioAnterior = "/";
            }
            url = directorioAnterior;
        }
        if (!url.startsWith("/")) {
            if (this.getDirectorioActual().equals("/")) {
                url = "/" + urlEntrada;
            } else {
                url = this.getDirectorioActual() + "/" + urlEntrada;
            }
        }
        return url;
    }
    
    public void setDirectorioDeTrabajo(DataArchivo directorio) {
       this.archActual = directorio;
    }
   
    public String getDirectorioActual() {
        return archActual.getDireccion() + archActual.getNombre();
    }

}
