
package presentacion;

import AppPackage.AnimationClass;
import javax.swing.JOptionPane;
import logica.ControladorSesion;
import static logica.ISistemaPrincipalImpl.iSesion;
import static logica.ISistemaPrincipalImpl.usuariosDelJuego;
import logica.interfaces.ISistemaSesion;

public class ControladorSesionVentana extends javax.swing.JFrame {

    private int nroCampaniaElegidoInterfaz;
   
    public ControladorSesionVentana() {
        
        iSesion.setUsuariosDeJuego(usuariosDelJuego);
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
        jtxtNickname = new javax.swing.JTextField();
        jpxContrasenia = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelingresar = new javax.swing.JLabel();
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
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, -1));

        jtxtNickname.setBackground(new java.awt.Color(0, 0, 0));
        jtxtNickname.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        jtxtNickname.setForeground(new java.awt.Color(153, 153, 153));
        jtxtNickname.setText("Usuario...");
        jtxtNickname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 181, 115)));
        jPanel2.add(jtxtNickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 150, 30));

        jpxContrasenia.setBackground(new java.awt.Color(0, 0, 0));
        jpxContrasenia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jpxContrasenia.setForeground(new java.awt.Color(153, 153, 153));
        jpxContrasenia.setText("Contraseña");
        jpxContrasenia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(19, 181, 115)));
        jPanel2.add(jpxContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 150, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/icons8_User_96px_2.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 80, -1, 90));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/icons8_Key_32px.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        jLabelingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/ingresar.gif"))); // NOI18N
        jPanel2.add(jLabelingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabelEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/Enter_ON.png"))); // NOI18N
        jLabelEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEntrarMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, -1));

        jLabelSubfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/SubFondoIngresar.png"))); // NOI18N
        jPanel2.add(jLabelSubfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        jLabelFondo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/electrograma.gif"))); // NOI18N
        jPanel2.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 518));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 640, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int getNroCampaniaElegidoInterfaz() {
        return nroCampaniaElegidoInterfaz;
    }

    public void setNroCampaniaElegidoInterfaz(int nroCampaniaElegidoInterfaz) {
        this.nroCampaniaElegidoInterfaz = nroCampaniaElegidoInterfaz;
    }
    
    
    
    private void jlCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCerrarMouseClicked
        int dialog=JOptionPane.YES_NO_OPTION;
        int result=JOptionPane.showConfirmDialog(null,"Desea Salir de Ingresar","Salir de Ingresar",dialog);
        if (result==0)
            this.setVisible(false);
    }//GEN-LAST:event_jlCerrarMouseClicked

    private void jlMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMinimizarMouseClicked
        this.setState(Principal.ICONIFIED);
    }//GEN-LAST:event_jlMinimizarMouseClicked

    private void jLabelEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEntrarMouseClicked
        iSesion.login(jtxtNickname.getText(),jpxContrasenia.getText());
        if ( (iSesion.getUsuariosDeJuego().existeNickname(jtxtNickname.getText())) && (jpxContrasenia.getText().equals(iSesion.getuEnSesion().getContrasenia())) ){
            
            if (iSesion.getNroCampania()!=nroCampaniaElegidoInterfaz){
                int dialog=JOptionPane.YES_NO_OPTION;
                int result=JOptionPane.showConfirmDialog(null,"Usted estaba en la campania nro"+iSesion.getNroCampania()+" Desea hacer esta Campania de todas maneras?",String.valueOf(nroCampaniaElegidoInterfaz),dialog);
                if (result==0){
                    iSesion.setNroCampania(nroCampaniaElegidoInterfaz);
                    //abre terminal
                    JuegoHistoria term=new JuegoHistoria();
                    this.setVisible(false);
                    term.setVisible(true);
                }
                else{
                    this.setVisible(false);
                    JOptionPane.showConfirmDialog(null,"Elija la campania"+iSesion.getNroCampania(),
                    String.valueOf(nroCampaniaElegidoInterfaz),JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                    
                }
            } 
            else{
                //eligio la campania en la que estaba
                JuegoHistoria term=new JuegoHistoria();
                this.setVisible(false);
                term.setVisible(true);
            }
            
        }
        
        
    }//GEN-LAST:event_jLabelEntrarMouseClicked


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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelEntrar;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelSubfondo;
    private javax.swing.JLabel jLabelingresar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlCerrar;
    private javax.swing.JLabel jlMinimizar;
    private javax.swing.JPanel jpanelEncabezado;
    private javax.swing.JPasswordField jpxContrasenia;
    private javax.swing.JTextField jtxtNickname;
    // End of variables declaration//GEN-END:variables
}
