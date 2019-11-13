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

public class echo extends Comando {

    private String[] args;

    public echo() {
    }

    public echo(String argumentos) {
        this.args = argumentos.split(" ");
    }

    @Override
    public String ejecutarComando() {
        StringWriter salida = new StringWriter();
        PrintWriter pw = new PrintWriter(salida);
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                pw.print(args[i] + " ");
            }
            pw.println("");
        } else {
            pw.println("");
        }
        pw.flush();
        return salida.toString();
    }

    @Override
    public String ejecutarYverificar() {
        return ejecutarComando();
    }
}
