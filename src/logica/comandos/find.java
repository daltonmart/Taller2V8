package logica.comandos;

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Comando;
import logica.DataArchivo;
import logica.EstructuraArchivos;
import static logica.ISistemaPrincipalImpl.red;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class find extends Comando {

    private String[] args;

    public find() {
    }

    public find(String argumentos) {
        args = argumentos.split(" ");
    }

    @Override
    public String ejecutarYverificar() {
        return ejecutarComando();
    }

    public String ejecutarComando() {
        CommandLineParser parser = null;
        CommandLine cmdLine = null;
        HelpFormatter formatter = new HelpFormatter();
        StringWriter salida = new StringWriter();
        PrintWriter pw = new PrintWriter(salida);

        // find <startingdirectory> <options> <search term>
        Options options = new Options();
        options.addOption("-name", false, "buscar archivos con el nombre indicado");
        options.addOption("-iname", false, "buscar por archivos ignorando mayuscula/minuscula en el nombre");
        options.addOption("-type", false, "buscar tipo de archivo");
        options.addOption("h", "help", false, "Imprime el mensaje de ayuda");

        try {
            parser = new BasicParser();
            cmdLine = parser.parse(options, args);

            if (cmdLine.hasOption("h")) {    // No hace falta preguntar por el parámetro "help". Ambos son sinónimos                  
                formatter.printHelp(pw, 80, this.getClass().getSimpleName(), "Parametros", options, 4, 3, "", true);
            }

            if (cmdLine.hasOption("-name")) {    // No hace falta preguntar por el parámetro "help". Ambos son sinónimos                  
                formatter.printHelp(pw, 80, this.getClass().getSimpleName(), "Parametros", options, 4, 3, "", true);
            }
            EstructuraArchivos estructArchivos = red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos();

            String urlEntrada = extraerUrlDeArgs(args);
            String url = estructArchivos.getUrlAbsoluta(urlEntrada);

            DataArchivo arch1 = estructArchivos.getArchivoDeUrl(url);
            if (arch1 != null) {

                ArrayList<DataArchivo> archivos = new ArrayList<>();
                if (arch1.getTipo() == 1) {
                    archivos.add(arch1);
                } else {
                    archivos = estructArchivos.getArchivos(url);
                }

                if (!cmdLine.hasOption("l")) {
                    for (DataArchivo arch : archivos) {
                        pw.println(arch.getNombre());
                    }
                } else {
                    for (DataArchivo arch : archivos) {
                        String perm = ""; // convertirOctalATexto(arch.getPermiso());
                        //  pw.printf("%1i %9d %10s %10s %8i %14s %20s", arch.getTipo(),arch.getPermiso(),arch.getDuenio(),arch.getGrupo(),arch.getTamanio(),arch.getFechayhora(),arch.getNombre());
                        pw.printf("%1s%-9s %-6s %-8s %5d %-14s %-20s \n", arch.getTipo() == 0 ? 'd' : '-', perm, arch.getDuenio(), arch.getGrupo(), arch.getTamanio(), arch.getFechayhora(), arch.getNombre());
                    }
                }
            } else {
                pw.println("No es un Archivo o Directorio");
            }
        } catch (org.apache.commons.cli.ParseException | java.lang.NumberFormatException ex) {
            formatter.printHelp(pw, 80, this.getClass().getCanonicalName(), "Parametros", options, 4, 3, "", true);
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

    public static void main(String[] args) {
        try {
            String CLI = "find /home -type a -iname *.txt";
            args = CLI.split(" ");
            CommandLineParser parser = new BasicParser();
            Options options = new Options();
            options.addOption("name", false, "buscar archivos con el nombre indicado");
            options.addOption("iname", false, "buscar por archivos ignorando mayuscula/minuscula en el nombre");
            options.addOption("type", false, "buscar tipo de archivo");
            options.addOption("h", "help", false, "Imprime el mensaje de ayuda");

            CommandLine commandLine = parser.parse(options, args);

            String optionA = getOpcion("type", commandLine);
            String optionB = getOpcion("b", commandLine);

            String[] remainingArguments = commandLine.getArgs();

            System.out.println(String.format("OptionA: %s, OptionB: %s", optionA, optionB));
            System.out.println("Remaining arguments: " + Arrays.toString(remainingArguments));
        } catch (ParseException ex) {
            Logger.getLogger(find.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getOpcion(String option, CommandLine commandLine) {

        if (commandLine.hasOption(option)) {
            return commandLine.getOptionValue(option);
        }
        return "";
    }
}
