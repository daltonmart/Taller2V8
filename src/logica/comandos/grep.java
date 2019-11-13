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

        if (args.length != 2) {
            pw.println("Sintaxis grep <texto buscado> <nombre de Archivo o Directorio>");
        } else {
//            Pattern patron = null;        // Compiled RE
//            try { 
            //patron = Pattern.compile(args[0]);
            String textoBuscado = args[0];
            urlEntrada = args[1];
            String url = estructArchivos.getUrlAbsoluta(urlEntrada);
            DataArchivo archivo = estructArchivos.getArchivoDeUrl(url);
            if (archivo != null) {
                String contenido = archivo.getContenido();
                if (contenido.contains(textoBuscado)) {
                    pw.println(contenido);
                }
                //int pos = contenido.indexOf(textoBuscado);
                //contenido = contenido.substring(pos + textoBuscado.length(), contenido.length());
//                        Matcher m = patron.matcher(contenido);
//                        if (m.find()) {
//                            System.out.println(s);
//                        }
            } else {
                pw.println("No se encontro :" + urlEntrada);
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
