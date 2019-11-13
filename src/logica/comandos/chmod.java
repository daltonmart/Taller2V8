package logica.comandos;

import java.io.PrintWriter;
import java.io.StringWriter;
import logica.Comando;
import logica.EstructuraArchivos;
import static logica.ISistemaPrincipalImpl.red;

public class chmod extends Comando {

    private String[] args;

    public chmod() {
    }

    public chmod(String argumentos) {
        args = argumentos.split(" ");
    }

    public String ejecutarComando() {
        StringWriter salida = new StringWriter();
        PrintWriter pw = new PrintWriter(salida);
        Integer permisos = 0;

        EstructuraArchivos estructArchivos = red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos();
        String urlEntrada = "";
        if (args.length > 2) {
            pw.println("Se requiere ingresar Permisos y Nombre de Archivo o Directorio");
        } else {
            if (args.length == 2) {
                permisos = Integer.valueOf(args[0]);
                if (permisos >= 0 && permisos <= 777) {
                    urlEntrada = args[1];
                } else {
                    pw.println("Sintaxis chmod [permisos] [nombre de Archivo o Directorio]");
                }
            }
        }
        String url = estructArchivos.getUrlAbsoluta(urlEntrada);
        estructArchivos.getArchivoDeUrl(url).setPermiso(permisos);
        pw.flush();
        return salida.toString();
    }

    @Override
    public String ejecutarYverificar() {
        return ejecutarComando();
    }

}
