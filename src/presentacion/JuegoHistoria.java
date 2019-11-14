package presentacion;

import AppPackage.AnimationClass;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import static logica.ISistemaPrincipalImpl.iSesion;
import static logica.ISistemaPrincipalImpl.historia;
import static logica.ISistemaPrincipalImpl.iJuego;
import static presentacion.Principal.iPrincipal;

public class JuegoHistoria extends javax.swing.JFrame {

    public JuegoHistoria() {

        inicializar();
        iniciarCampania();
    }

    private void iniciarCampania() {
        jlContenidoHistoria.setText(iPrincipal.obtenerHistoriaUsuarioSesion());
        jlContenidoPista.setText(historia.obtenerPistaDeCampania(iSesion.getNroCampania(), iSesion.getProgreso()));

    }

    private void inicializar() {
        initComponents();
        this.setLocationRelativeTo(null);
        jtxtTerminal.setText(iPrincipal.getPrompt());
        jtxtTerminal.setCaretPosition(iPrincipal.getPrompt().length());
        System.out.println("** Iniciando Terminal **");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelEncabezado = new javax.swing.JPanel();
        jlCerrar = new javax.swing.JLabel();
        jlMinimizar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPaneArbol = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jSiguienteMision = new javax.swing.JButton();
        jlOcultarPista = new javax.swing.JLabel();
        jlbtranpOcultarPista = new javax.swing.JLabel();
        jlMostrarPista = new javax.swing.JLabel();
        jlbtranpMostrarPista = new javax.swing.JLabel();
        jlTituloPista = new javax.swing.JLabel();
        jlContenidoPista = new javax.swing.JLabel();
        jlContenidoHistoria = new javax.swing.JLabel();
        jlTituloHistoria = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPaneTerminal = new javax.swing.JScrollPane();
        jtxtTerminal = new javax.swing.JTextArea();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanelEncabezado.setBackground(new java.awt.Color(0, 0, 0));

        jlCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/icons8_Multiply_32px_1.png"))); // NOI18N
        jlCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCerrarMouseClicked(evt);
            }
        });

        jlMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/icons8_Expand_Arrow_32px_1.png"))); // NOI18N
        jlMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlMinimizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpanelEncabezadoLayout = new javax.swing.GroupLayout(jpanelEncabezado);
        jpanelEncabezado.setLayout(jpanelEncabezadoLayout);
        jpanelEncabezadoLayout.setHorizontalGroup(
            jpanelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelEncabezadoLayout.createSequentialGroup()
                .addContainerGap(790, Short.MAX_VALUE)
                .addComponent(jlMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlCerrar))
        );
        jpanelEncabezadoLayout.setVerticalGroup(
            jpanelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelEncabezadoLayout.createSequentialGroup()
                .addGroup(jpanelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCerrar)
                    .addComponent(jlMinimizar))
                .addGap(0, 28, Short.MAX_VALUE))
        );

        getContentPane().add(jpanelEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 60));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTree1.setBackground(new java.awt.Color(0, 153, 102));
        jTree1.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        jTree1.setFont(new java.awt.Font("OCR A Extended", 0, 11)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("/");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("bin");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("bash");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("boot");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("grub");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("dev");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("input");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("etc");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("apt");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("home");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("melisa");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("monica");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("sandra");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("santiago");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("scarlett");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("media");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("melisa");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("monica");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("sandra");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("santiago");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("scarlett");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("lib");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("init");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("oculto");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("run");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("network");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("sys");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("firmware");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("tmp");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("actualizacion");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("usr");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("bin");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("src");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("var");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("log");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPaneArbol.setViewportView(jTree1);

        jPanel2.add(jScrollPaneArbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 140, 150));

        jSiguienteMision.setBackground(new java.awt.Color(0, 153, 102));
        jSiguienteMision.setText("Siguiente Mision");
        jSiguienteMision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSiguienteMisionActionPerformed(evt);
            }
        });
        jPanel2.add(jSiguienteMision, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, -1));

        jlOcultarPista.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jlOcultarPista.setForeground(new java.awt.Color(255, 255, 255));
        jlOcultarPista.setText("      Ocultar Pista");
        jlOcultarPista.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlOcultarPista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlOcultarPistaMouseClicked(evt);
            }
        });
        jPanel2.add(jlOcultarPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 450, 290, 40));

        jlbtranpOcultarPista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/b2.png"))); // NOI18N
        jlbtranpOcultarPista.setText("transp");
        jPanel2.add(jlbtranpOcultarPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 450, 290, 40));

        jlMostrarPista.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jlMostrarPista.setForeground(new java.awt.Color(255, 255, 255));
        jlMostrarPista.setText("         Mostrar Pista");
        jlMostrarPista.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlMostrarPista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlMostrarPistaMouseClicked(evt);
            }
        });
        jPanel2.add(jlMostrarPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 290, 40));

        jlbtranpMostrarPista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/b2.png"))); // NOI18N
        jlbtranpMostrarPista.setText("transp");
        jPanel2.add(jlbtranpMostrarPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 290, 40));

        jlTituloPista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/TituloPista.gif"))); // NOI18N
        jPanel2.add(jlTituloPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 250, 100, 50));

        jlContenidoPista.setBackground(new java.awt.Color(0, 0, 0));
        jlContenidoPista.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        jlContenidoPista.setForeground(new java.awt.Color(0, 255, 102));
        jlContenidoPista.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jlContenidoPista, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 300, 290, 140));

        jlContenidoHistoria.setBackground(new java.awt.Color(0, 0, 0));
        jlContenidoHistoria.setFont(new java.awt.Font("OCR A Extended", 0, 12)); // NOI18N
        jlContenidoHistoria.setForeground(new java.awt.Color(0, 179, 122));
        jlContenidoHistoria.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jlContenidoHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 450, 150));

        jlTituloHistoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/HistoriaTitulo.gif"))); // NOI18N
        jPanel2.add(jlTituloHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/Terminal.gif"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, -1));

        jtxtTerminal.setBackground(new java.awt.Color(0, 0, 0));
        jtxtTerminal.setColumns(20);
        jtxtTerminal.setFont(new java.awt.Font("Courier 10 Pitch", 0, 12)); // NOI18N
        jtxtTerminal.setForeground(new java.awt.Color(255, 255, 255));
        jtxtTerminal.setRows(5);
        jtxtTerminal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtTerminalKeyPressed(evt);
            }
        });
        jScrollPaneTerminal.setViewportView(jtxtTerminal);

        jPanel2.add(jScrollPaneTerminal, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 350, 410));

        jLabelFondo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/electrograma.gif"))); // NOI18N
        jPanel2.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 518));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 860, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jlCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCerrarMouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea Salir de Terminal", "Salir de Terminal", dialog);
        if (result == 0) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_jlCerrarMouseClicked

    private void jlMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMinimizarMouseClicked
        this.setState(Principal.ICONIFIED);
    }//GEN-LAST:event_jlMinimizarMouseClicked

    private void jtxtTerminalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtTerminalKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_RIGHT ) {
            try {
                int longPrompt = iPrincipal.getPrompt().length();
                int posCursor = jtxtTerminal.getCaretPosition();
                int lineaNro = jtxtTerminal.getLineOfOffset(posCursor);
                int posInicioLinea = jtxtTerminal.getLineStartOffset(lineaNro)+longPrompt;
                if(posCursor <= posInicioLinea) {
                    evt.consume();
                    jtxtTerminal.setCaretPosition(posInicioLinea);
                }
            } catch (BadLocationException ex) {
                Logger.getLogger(JuegoHistoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                evt.consume();
                int longPrompt = iPrincipal.getPrompt().length();
                int posCursor = jtxtTerminal.getCaretPosition();
                int lineaNro = jtxtTerminal.getLineOfOffset(posCursor);
                int posInicioLinea = jtxtTerminal.getLineStartOffset(lineaNro) + longPrompt;
                int posFinalLinea = jtxtTerminal.getLineEndOffset(lineaNro);
                String lineaTextoIngresada = jtxtTerminal.getText(posInicioLinea, posFinalLinea - posInicioLinea);
                System.out.println("* texto -> [" + lineaTextoIngresada + "]");
                // *****************************************
                // se envia a procesar la linea se comandos
                // *****************************************   
                //Se instancia terminal arriba
                String salidaDelComando = iPrincipal.manejoComandoDeITerminal(lineaTextoIngresada);

                jtxtTerminal.setText(jtxtTerminal.getText() + "\n" + salidaDelComando + "\n" + iPrincipal.getPrompt());
                jtxtTerminal.repaint();

            } catch (BadLocationException ex) {
                Logger.getLogger(JuegoHistoria.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jtxtTerminalKeyPressed

    private void jlMostrarPistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMostrarPistaMouseClicked

        //Deslizar label nombre
        AnimationClass adm = new AnimationClass();
        adm.jLabelXLeft(20, -290, 10, 5, jlMostrarPista);
        AnimationClass admm = new AnimationClass();
        admm.jLabelXRight(-290, 20, 10, 5, jlMostrarPista);
        //Deslizar base transparente
        AnimationClass admtransp = new AnimationClass();
        admtransp.jLabelXLeft(-290, 20, 10, 5, jlbtranpMostrarPista);
        AnimationClass admtranspp = new AnimationClass();
        admtranspp.jLabelXRight(20, -290, 10, 5, jlbtranpMostrarPista);

        //Desplaza a los demás fuera del frame
        //Aparezca el menu contenido Pista
        //************** Pista**************
        //Deslizar label nombre
        AnimationClass admCrearUsr1 = new AnimationClass();
        admCrearUsr1.jLabelXRight(-290, 20, 10, 5, jlOcultarPista);
        AnimationClass admmCrearUsr1 = new AnimationClass();
        admmCrearUsr1.jLabelXLeft(20, -290, 10, 5, jlOcultarPista);

        //Deslizar label nombre
        AnimationClass admCrearUsr = new AnimationClass();
        admCrearUsr.jLabelXRight(-290, 20, 10, 5, jlContenidoPista);
        AnimationClass admmCrearUsr = new AnimationClass();
        admmCrearUsr.jLabelXLeft(20, -290, 10, 5, jlContenidoPista);

        //Deslizar label nombre
        AnimationClass admCrearUsr2 = new AnimationClass();
        admCrearUsr2.jLabelXRight(-100, 20, 10, 5, jlTituloPista);
        AnimationClass admmCrearUsr2 = new AnimationClass();
        admmCrearUsr2.jLabelXLeft(20, -100, 10, 5, jlTituloPista);

        //Deslizar base transparente
        AnimationClass admtranspCrearUsr = new AnimationClass();
        admtranspCrearUsr.jLabelXRight(-290, 20, 10, 5, jlbtranpOcultarPista);
        AnimationClass admtransppCrearUsr = new AnimationClass();
        admtransppCrearUsr.jLabelXLeft(20, -290, 10, 5, jlbtranpOcultarPista);

    }//GEN-LAST:event_jlMostrarPistaMouseClicked

    private void jlOcultarPistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlOcultarPistaMouseClicked
        //Deslizar label nombre
        AnimationClass adm = new AnimationClass();
        adm.jLabelXLeft(20, -290, 10, 5, jlOcultarPista);
        AnimationClass admm = new AnimationClass();
        admm.jLabelXRight(-290, 20, 10, 5, jlOcultarPista);

        AnimationClass adm2 = new AnimationClass();
        adm2.jLabelXLeft(20, -100, 10, 5, jlTituloPista);
        AnimationClass admm2 = new AnimationClass();
        admm2.jLabelXRight(-100, 20, 10, 5, jlTituloPista);

        //Deslizar base transparente
        AnimationClass admtransp = new AnimationClass();
        admtransp.jLabelXLeft(-290, 20, 10, 5, jlbtranpOcultarPista);
        AnimationClass admtranspp = new AnimationClass();
        admtranspp.jLabelXRight(20, -290, 10, 5, jlbtranpOcultarPista);

        //Desplaza a los demás fuera del frame
        //Aparezca el menu contenido Pista
        //************** Pista**************
        //Deslizar label nombre
        AnimationClass admCrearUsr1 = new AnimationClass();
        admCrearUsr1.jLabelXRight(-290, 20, 10, 5, jlMostrarPista);
        AnimationClass admmCrearUsr1 = new AnimationClass();
        admmCrearUsr1.jLabelXLeft(20, -290, 10, 5, jlMostrarPista);

        //Deslizar label nombre
        AnimationClass admCrearUsr = new AnimationClass();
        admCrearUsr.jLabelXRight(-290, 20, 10, 5, jlContenidoPista);
        AnimationClass admmCrearUsr = new AnimationClass();
        admmCrearUsr.jLabelXLeft(20, -290, 10, 5, jlContenidoPista);

        //Deslizar base transparente
        AnimationClass admtranspCrearUsr = new AnimationClass();
        admtranspCrearUsr.jLabelXRight(-290, 20, 10, 5, jlbtranpMostrarPista);
        AnimationClass admtransppCrearUsr = new AnimationClass();
        admtransppCrearUsr.jLabelXLeft(20, -290, 10, 5, jlbtranpMostrarPista);


    }//GEN-LAST:event_jlOcultarPistaMouseClicked

    private void jSiguienteMisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSiguienteMisionActionPerformed
        iPrincipal.avanceMision();
    }//GEN-LAST:event_jSiguienteMisionActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPaneArbol;
    private javax.swing.JScrollPane jScrollPaneTerminal;
    private javax.swing.JButton jSiguienteMision;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel jlCerrar;
    private javax.swing.JLabel jlContenidoHistoria;
    private javax.swing.JLabel jlContenidoPista;
    private javax.swing.JLabel jlMinimizar;
    private javax.swing.JLabel jlMostrarPista;
    private javax.swing.JLabel jlOcultarPista;
    private javax.swing.JLabel jlTituloHistoria;
    private javax.swing.JLabel jlTituloPista;
    private javax.swing.JLabel jlbtranpMostrarPista;
    private javax.swing.JLabel jlbtranpOcultarPista;
    private javax.swing.JPanel jpanelEncabezado;
    private javax.swing.JTextArea jtxtTerminal;
    // End of variables declaration//GEN-END:variables

}
