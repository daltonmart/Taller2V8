package persistencia;

import persistencia.interfaces.IPEstructuraArchivo;
import logica.DataArchivo;
import logica.EstructuraArchivos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PEstructuraArchivo implements IPEstructuraArchivo {

    public PEstructuraArchivo() {
    }

    @Override
    public void escribirPersistenciaEstructuraArchivos(String nombreArchivo, String nombre, int tipo, String direccion, int permiso, String duenio, String grupo, String contenido, int tamanio, String fechayhora) {

        String cadenaDatos = " ";
        String stipo = String.valueOf(tipo);
        String spermiso = String.valueOf(permiso);
        String stamanio = String.valueOf(tamanio);
        cadenaDatos = nombre + " ; " + stipo + " ; " + direccion + " ; " + spermiso + " ; " + duenio + " ; " + grupo + " ; " + contenido + " ; " + stamanio + " ; " + fechayhora;

        //guardamos datos en el archivo
        FileWriter fichero;
        PrintWriter pw;
        try {
            fichero = new FileWriter(nombreArchivo, true);
            pw = new PrintWriter(fichero);
            pw.println(cadenaDatos);
            pw.close();
            fichero.close();
            //mensaje de exito
            JOptionPane.showConfirmDialog(null, "Datos ingresados al archivo EstructuraArchivos",
                    "Información", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "No se pudo guardar",
                    "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }

    }

    @Override
    public void verPersistenciaEstructuraArchivos(EstructuraArchivos listaArchivos, String nombreArchivo) {
        int tipo, permiso, tamanio;
        File archivo = null;
        FileReader frEA = null;
        BufferedReader brEA = null;

        try {
            //apertura del archivo
            archivo = new File(nombreArchivo);
            frEA = new FileReader(archivo);
            brEA = new BufferedReader(frEA);
            String filaLeidaArchivo;
            String[] cadenaSeparada;
            int i = 1;
            while ((filaLeidaArchivo = brEA.readLine()) != null) {
                cadenaSeparada = filaLeidaArchivo.split(" ; ");
                tipo = Integer.valueOf(cadenaSeparada[1]);
                permiso = Integer.valueOf(cadenaSeparada[3]);
                tamanio = Integer.valueOf(cadenaSeparada[7]);
                DataArchivo a = new DataArchivo(cadenaSeparada[0], tipo, cadenaSeparada[2], permiso, cadenaSeparada[4], cadenaSeparada[5], cadenaSeparada[6], tamanio, cadenaSeparada[8]);

                if (i == 1) {
                    listaArchivos.setArchActual(a);
                    listaArchivos.insertarArchivo(a);
                } else {
                    listaArchivos.insertarArchivo(a);
                }

                System.out.println(a);
                i++;
            }

            brEA.close();
            frEA.close();

        } catch (Exception ee) {
            JOptionPane.showConfirmDialog(null, "El Archivo " + nombreArchivo + " no existe", "Información",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void borrarArchivoDePersistenciaEstructuraArchivos(String nombre, String nombreArch) {

        File inputFile = new File(nombreArch);
        File tempFile = new File("myTempFileEA.txt");

        boolean successful = inputFile.renameTo(tempFile);
        System.out.println(successful);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(tempFile));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PEstructuraArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(inputFile));
        } catch (IOException ex) {
            Logger.getLogger(PEstructuraArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        String lineToRemove = nombre;
        String currentLine;

        try {
            while ((currentLine = reader.readLine()) != null) {
                String[] trimmedLine = currentLine.trim().split(" ; ");;
                if (trimmedLine[0].equals(lineToRemove)) {
                    continue;
                }
                try {
                    writer.write(currentLine + System.getProperty("line.separator"));
                } catch (IOException ex) {
                    Logger.getLogger(PEstructuraArchivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(PEstructuraArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(PEstructuraArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(PEstructuraArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        tempFile.delete();

    }

    @Override
    public String toString() {
        return "PEstructuraArchivo{" + super.toString() + '}';
    }

}
