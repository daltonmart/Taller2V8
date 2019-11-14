package logica.comandos;

import java.io.PrintWriter;
import java.io.StringWriter;
import logica.Comando;
import logica.DataArchivo;
import logica.EstructuraArchivos;
import static logica.ISistemaPrincipalImpl.red;
import presentacion.EditorTexto;

public class hack extends Comando {
    private String[] args;

    public hack() {
    }

    public hack(String argumentos) {
        this.args = argumentos.split(" ");
    }

    @Override
    public String ejecutarComando() {
        StringWriter salida = new StringWriter();
        PrintWriter pw = new PrintWriter(salida);
        EstructuraArchivos estructArchivos = red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos();

        String urlEntrada = extraerUrlDeArgs(args);
        if (urlEntrada.equals("")) {
            pw.println("Forma de uso: edit nombreArchivo");
        } else {
            String url = estructArchivos.getUrlAbsoluta(urlEntrada);
            DataArchivo archivo = estructArchivos.getArchivoDeUrl(url);
            if (archivo != null) {
                if (archivo.getTipo() == 1) {
                    EditorTexto editor = new EditorTexto(archivo);                   
                } else {
                    pw.println("No es un archivo");
                }
            } else {
                pw.println("No existe el archivo");
            }
        }
        pw.flush();
        return salida.toString();
    }

    @Override
    public String ejecutarYverificar() {
        return ejecutarComando();
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


}
