
package presentacion;

import AppPackage.AnimationClass;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.ControladorUsuario;
import logica.DataUsuarioJuego;
import static logica.ISistemaPrincipalImpl.usuariosDelJuego;
import logica.interfaces.ISistemaUsuario;

public class BorrarUsuario extends javax.swing.JFrame {
    ISistemaUsuario iUsuario= new ControladorUsuario();
    
    public BorrarUsuario() {
        
        iUsuario.setUsaUsuariosDelJuego(usuariosDelJuego);
        
        initComponents();
        this.setLocationRelativeTo(null);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelEncabezado = new javax.swing.JPanel();
        jlCerrar = new javax.swing.JLabel();
        jlMinimizar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabelNombreVentana = new javax.swing.JLabel();
        jLabelBorrar = new javax.swing.JLabel();
        jLabelEntrar = new javax.swing.JLabel();
        jLabelSubfondo = new javax.swing.JLabel();
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
                .addContainerGap(570, Short.MAX_VALUE)
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

        getContentPane().add(jpanelEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 60));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/icons8_customer_32px_1.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, -1));

        jTextUsuario.setBackground(new java.awt.Color(0, 0, 0));
        jTextUsuario.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        jTextUsuario.setForeground(new java.awt.Color(153, 153, 153));
        jTextUsuario.setText("Usuario a borrar...");
        jTextUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 181, 115)));
        jPanel2.add(jTextUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 160, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/icons8_User_96px_2.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 80, -1, 90));

        jLabelNombreVentana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/crearUsuario.gif"))); // NOI18N
        jPanel2.add(jLabelNombreVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabelBorrar.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabelBorrar.setText("    Borrar");
        jLabelBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBorrarMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 130, 40));

        jLabelEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/fondoEnter.png"))); // NOI18N
        jLabelEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabelEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        jLabelSubfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/SubFondoIngresar.png"))); // NOI18N
        jPanel2.add(jLabelSubfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        jLabelFondo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/electrograma.gif"))); // NOI18N
        jPanel2.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 518));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 640, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCerrarMouseClicked
        int dialog=JOptionPane.YES_NO_OPTION;
        int result=JOptionPane.showConfirmDialog(null,"Desea Salir de Crear Usuario","Salir de Crear Usuario",dialog);
        if (result==0)
            this.setVisible(false);
    }//GEN-LAST:event_jlCerrarMouseClicked

    private void jlMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMinimizarMouseClicked
        this.setState(Principal.ICONIFIED);
    }//GEN-LAST:event_jlMinimizarMouseClicked

    private void jLabelBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBorrarMouseClicked
        
        iUsuario.bajaUsuario(jTextUsuario.getText());
        
        jTextUsuario.setText(null);
        
    }//GEN-LAST:event_jLabelBorrarMouseClicked


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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelBorrar;
    private javax.swing.JLabel jLabelEntrar;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelNombreVentana;
    private javax.swing.JLabel jLabelSubfondo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextUsuario;
    private javax.swing.JLabel jlCerrar;
    private javax.swing.JLabel jlMinimizar;
    private javax.swing.JPanel jpanelEncabezado;
    // End of variables declaration//GEN-END:variables
}
