/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.comandos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JFrame;
import logica.Comando;
import logica.DataArchivo;
import logica.EstructuraArchivos;
import static logica.ISistemaPrincipalImpl.red;
import presentacion.EditorTexto;

public class edit extends Comando {

    private String[] args;

    public edit() {
    }

    public edit(String argumentos) {
        this.args = argumentos.split(" ");
    }

    @Override
    public String ejecutarComando() {
       /* JFrame frame = new EditorTexto_viejo();
        
        frame.setTitle("Editor");
        frame.setVisible(true);
        frame.setSize(500, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
*/
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
                    //EditorTexto editor = new EditorTexto_viejo(archivo);
                    EditorTexto editor = new EditorTexto(archivo);
                 //   estructArchivos.setDirectorioDeTrabajo(directorio);
                    
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
