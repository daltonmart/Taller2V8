package logica.comandos;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Comparator;
import logica.Comando;
import logica.DataArchivo;
import logica.EstructuraArchivos;
import static logica.ISistemaPrincipalImpl.red;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class echo extends Comando {

    private String[] args;

    public echo() {
    }

    public echo(String argumentos) {
        args = argumentos.split(" ");
    }

    public String ejecutarComando() {
        StringWriter salida = new StringWriter();
        PrintWriter pw = new PrintWriter(salida);

        EstructuraArchivos estructArchivos = red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos();

        String lineaCLI = String.join(" ", args);
        String[] textoEntreComillas = lineaCLI.split("\"");
        String texto = textoEntreComillas[1];
        if (texto.length() > 0) {
            String archivoDestino = args[args.length - 1];
            String url = estructArchivos.getUrlAbsoluta(archivoDestino);
            DataArchivo arch1 = estructArchivos.getArchivoDeUrl(url);
            if (arch1 != null) {
                if (arch1.getTipo() == 1) {
                    arch1.setContenido(arch1.getContenido() + texto);
                } else {
                    pw.println("Si indico directorio y se necesita un archivo");
                }
            } else {
                pw.println("No se encontro el archivo");
            }

        } else {
            pw.println("Forma de uso:  echo \"texto buscado\" > archivo");
        }
        pw.flush();
        return salida.toString();
    }

    @Override
    public String ejecutarYverificar() {
        return ejecutarComando();
    }
}
