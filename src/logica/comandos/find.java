package logica.comandos;

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

        options.addOption("name", true, "buscar archivos con el nombre indicado");
        options.addOption("iname", true, "buscar por archivos ignorando mayuscula/minuscula en el nombre");
        options.addOption("type", true, "buscar tipo de archivo");
        options.addOption("h", "help", false, "Imprime el mensaje de ayuda");

        try {
            parser = new BasicParser();
            cmdLine = parser.parse(options, args);

            String[] argsRemanentes = cmdLine.getArgs();

            if (cmdLine.hasOption("h")) {    // No hace falta preguntar por el parámetro "help". Ambos son sinónimos                  
                formatter.printHelp(pw, 80, this.getClass().getSimpleName(), "Parametros: find <startingdirectory> <options> <search term>", options, 4, 3, "", true);
            }

            String paramType = getOpcion("type", cmdLine);
            String paramName = getOpcion("name", cmdLine);
            String paramIName = getOpcion("iname", cmdLine);
            String nombreBuscado = "*";

            if (paramName.length() > 0) {
                nombreBuscado = paramName;
            }
            if (paramIName.length() > 0) {
                nombreBuscado = paramIName;
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
                } else {  // aca va la opcion de recursivo en los directorios
                    archivos = estructArchivos.getArchivos(url);
                }
                for (DataArchivo arch : archivos) {
                    Pattern pat = Pattern.compile(nombreBuscado);
                    Matcher mat = pat.matcher(arch.getNombre());
                    if (mat.matches()) {
                        pw.println(arch.getNombre());
                    }
                }
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
            find find = new find();
            String CLI = "/home -type d -iname *.txt -h";
            args = CLI.split(" ");
            String camino = find.extraerUrlDeArgs(args);
            System.out.println("Camino:" + camino);

            CommandLineParser parser = new BasicParser();
            Options options = new Options();
            options.addOption("name", true, "buscar archivos con el nombre indicado");
            options.addOption("iname", true, "buscar por archivos ignorando mayuscula/minuscula en el nombre");
            options.addOption("type", true, "buscar tipo de archivo");
            options.addOption("h", "help", false, "Imprime el mensaje de ayuda");

            CommandLine commandLine = parser.parse(options, args);

            String[] argsRemanentes = commandLine.getArgs();

            String paramType = getOpcion("type", commandLine);
            String paramName = getOpcion("name", commandLine);
            String paramIName = getOpcion("iname", commandLine);

            //   String[] remainingArguments = commandLine.getArgs();
            System.out.println(String.format("type: %s, name: %s, iname: %s", paramType, paramName, paramIName));
            System.out.println("Remaining arguments: " + Arrays.toString(argsRemanentes));

        } catch (ParseException ex) {
            Logger.getLogger(find.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getOpcion(String option, CommandLine commandLine) {
        if (commandLine.hasOption(option)) {
            String pp = commandLine.getOptionValue(option);
            return pp;
        }
        return "";
    }
}
