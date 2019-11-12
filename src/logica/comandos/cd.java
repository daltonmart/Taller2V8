package logica.comandos;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import logica.Comando;
import logica.DataArchivo;
import logica.EstructuraArchivos;
import static logica.ISistemaPrincipalImpl.red;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class cd extends Comando {

    private String[] args;

    public cd() {
    }

    public cd(String argumentos) {
        args = argumentos.split(" ");
    }

    public String ejecutarComando() {
        StringWriter salida = new StringWriter();
        PrintWriter pw = new PrintWriter(salida);

        EstructuraArchivos estructArchivos = red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos();

        String urlEntrada = extraerUrlDeArgs(args);
        if( urlEntrada.equals("") ) {  
                // aca debo ir al home del ususario
        }
        String url = estructArchivos.getUrlAbsoluta(urlEntrada);

        DataArchivo directorio = estructArchivos.getArchivoDeUrl(url);
        if (directorio != null) {
            if (directorio.getTipo() == 0) {
                estructArchivos.setDirectorioDeTrabajo(directorio);
            } else {
                pw.println("No es un Archivo o Directorio");
            }
        } else {
            pw.println("No es un Archivo o Directorio");
        }
        pw.flush();
        return salida.toString();
    }

    private String extraerUrlDeArgs(String[] args) {
        String url = "";
        for (String arg : args) {
            if (!arg.startsWith("-")) {
                url = arg;
                break;
            }
        }
        return url;
    }

    @Override
    public String ejecutarYverificar() {
        return ejecutarComando();
    }

    private String convertirOctalATexto(int permisos) {
        StringBuilder resultado = new StringBuilder(9);
        String nroOctal = String.valueOf(permisos);
        permisos = Integer.parseInt(nroOctal, 8);
        resultado.append((permisos & 256) == 0 ? '-' : 'r');
        resultado.append((permisos & 128) == 0 ? '-' : 'w');
        resultado.append((permisos & 64) == 0 ? '-' : 'x');
        resultado.append((permisos & 32) == 0 ? '-' : 'r');
        resultado.append((permisos & 16) == 0 ? '-' : 'w');
        resultado.append((permisos & 8) == 0 ? '-' : 'x');
        resultado.append((permisos & 4) == 0 ? '-' : 'r');
        resultado.append((permisos & 2) == 0 ? '-' : 'w');
        resultado.append((permisos & 1) == 0 ? '-' : 'x');
        return resultado.toString();
    }

}
