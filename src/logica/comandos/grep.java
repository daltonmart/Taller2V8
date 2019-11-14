/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.comandos;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import logica.Comando;
import logica.DataArchivo;
import logica.EstructuraArchivos;
import static logica.ISistemaPrincipalImpl.red;
import presentacion.EditorTexto;

public class grep extends Comando {

    private String[] args;

    public grep() {
    }

    public grep(String argumentos) {
        this.args = argumentos.split(" ");
    }

    @Override
    public String ejecutarComando() {
        StringWriter salida = new StringWriter();
        PrintWriter pw = new PrintWriter(salida);
        EstructuraArchivos estructArchivos = red.getEquipoActual().getCompuestoPorUsuarios().buscarUsuarioConectado().getCompuestoPorArchivos();

        Integer permisos = 0;
        String urlEntrada = "";

        String lineaCLI = String.join(" ", args);
        String[] textoEntreComillas = lineaCLI.split("\"");
        String textoBuscado = textoEntreComillas[1];
        if (textoBuscado.length() > 0) {
            urlEntrada = args[args.length - 1];
            String url = estructArchivos.getUrlAbsoluta(urlEntrada);
            DataArchivo archivo = estructArchivos.getArchivoDeUrl(url);
            if (archivo != null) {
                String contenido = archivo.getContenido();
                if (contenido.contains(textoBuscado)) {
                    pw.println(contenido);
                }
            }
        } else {
            pw.println("No se encontro :" + urlEntrada);
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
