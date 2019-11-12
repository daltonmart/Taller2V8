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


public class ls extends Comando {
    private String[] args;

    public ls() {
    }

    public ls(String argumentos) {
        args = argumentos.split(" ");
    }

    public String ejecutarComando() {
        CommandLineParser parser = null;
        CommandLine cmdLine = null;
        HelpFormatter formatter = new HelpFormatter();
        StringWriter salida = new StringWriter();
        PrintWriter pw = new PrintWriter(salida);
 
        Options options = new Options();
        options.addOption("l", false, "lista en formato largo");
        options.addOption("h", "help", false, "Imprime el mensaje de ayuda");

        try {
            parser = new BasicParser();

            cmdLine = parser.parse(options, args);

            if (cmdLine.hasOption("h")) {    // No hace falta preguntar por el parámetro "help". Ambos son sinónimos                  
                formatter.printHelp(pw, 80, this.getClass().getSimpleName(), "Parametros", options, 4, 3, "", true);
            }
            
            EstructuraArchivos estructArchivos =  red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos();

                    
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
                        String perm = convertirOctalATexto(arch.getPermiso());
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


