package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import logica.DataArchivo;

public class EditorTexto {

    private final JTextArea areaEdicion;

    public EditorTexto(DataArchivo archivo) {
        String contenidoAEditar = archivo.getContenido();

        JFrame ventana = new JFrame("Hack");
        // Inicializa todos los elementos del menu
        JMenuBar menu = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuAyuda = new JMenu("Ayuda");

       // JMenuItem nuevo = new JMenuItem("Nuevo");
       // JMenuItem abrir = new JMenuItem("Abrir...");
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem salir = new JMenuItem("Salir");
        JMenuItem acercaDe = new JMenuItem("Acerca de...");

        // Añade los elementos al menu
        //menuArchivo.add(nuevo);
        //menuArchivo.add(abrir);
        menuArchivo.add(guardar);
        menuArchivo.add(salir);
        menuAyuda.add(acercaDe);

        menu.add(menuArchivo);
        menu.add(menuAyuda);

        // Añade la barra de menu a la ventana
        ventana.setJMenuBar(menu);

        // Cra un area de texto con scroll y lo añade a la ventana 
        areaEdicion = new JTextArea(contenidoAEditar);
        JScrollPane scrollNotas = new JScrollPane(areaEdicion);
        ventana.add(scrollNotas);

        // Asigna a cada menuItem su listener
//        nuevo.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                areaEdicion.setText("");
//            }
//        });
//        abrir.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                abrirArchivo();
//            }
//
//            private void abrirArchivo() {
//                areaEdicion.setText(contenidoAEditar);
//            }
//        });
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarArchivo();
            }

            private void guardarArchivo() {
                String contenidoEditado = areaEdicion.getText();
                archivo.setContenido(contenidoEditado);

            }
        });
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
            }
        });
        // Hace visible la ventana
        ventana.setSize(500, 320);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setResizable(true);
        ventana.setLocationRelativeTo(null);        
    }
}
