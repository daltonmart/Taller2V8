
package presentacion;

import AppPackage.AnimationClass;
import javax.swing.JOptionPane;
import logica.interfaces.ISistemaPrincipal;
import logica.ISistemaPrincipalImpl;



public final class Principal extends javax.swing.JFrame {
    public static ISistemaPrincipal iPrincipal=new ISistemaPrincipalImpl();
    
    
    public Principal() {
        iPrincipal.cargarHistoria();
        iPrincipal.cargarUsuariosDelJuego();        
        iPrincipal.cargarRedInicial();
        
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlBienvenida = new javax.swing.JLabel();
        jlCrearUsr = new javax.swing.JLabel();
        jlbtranpCrearUsr = new javax.swing.JLabel();
        jlBorrarUsr = new javax.swing.JLabel();
        jlbtranpBorrarUsr = new javax.swing.JLabel();
        jlAdministrar = new javax.swing.JLabel();
        jlbtranpAdm = new javax.swing.JLabel();
        jlCampania1 = new javax.swing.JLabel();
        jlbtranpCampania1 = new javax.swing.JLabel();
        jlCampania2 = new javax.swing.JLabel();
        jlbtranpCampania2 = new javax.swing.JLabel();
        jlCampania3 = new javax.swing.JLabel();
        jlbtranpCampania3 = new javax.swing.JLabel();
        jlCampania4 = new javax.swing.JLabel();
        jlbtranpCampania4 = new javax.swing.JLabel();
        jlIniciarJuego = new javax.swing.JLabel();
        jlbtranpIniciarJuego = new javax.swing.JLabel();
        jlCreditos = new javax.swing.JLabel();
        jlbtranpCred = new javax.swing.JLabel();
        jlFondo = new javax.swing.JLabel();
        jpanelEncabezado = new javax.swing.JPanel();
        jlCerrar = new javax.swing.JLabel();
        jlMinimizar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlBienvenida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/bienvenida.gif"))); // NOI18N
        getContentPane().add(jlBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 370, 40));

        jlCrearUsr.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jlCrearUsr.setForeground(new java.awt.Color(255, 255, 255));
        jlCrearUsr.setText("      Crear Usuario");
        jlCrearUsr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlCrearUsr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCrearUsrMouseClicked(evt);
            }
        });
        getContentPane().add(jlCrearUsr, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 180, 290, 40));

        jlbtranpCrearUsr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/b2.png"))); // NOI18N
        jlbtranpCrearUsr.setText("transp");
        getContentPane().add(jlbtranpCrearUsr, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 180, 290, 40));

        jlBorrarUsr.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jlBorrarUsr.setForeground(new java.awt.Color(255, 255, 255));
        jlBorrarUsr.setText("      Borrar Usuario");
        jlBorrarUsr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlBorrarUsr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlBorrarUsrMouseClicked(evt);
            }
        });
        getContentPane().add(jlBorrarUsr, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 250, 290, 40));

        jlbtranpBorrarUsr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/b2.png"))); // NOI18N
        jlbtranpBorrarUsr.setText("transp");
        getContentPane().add(jlbtranpBorrarUsr, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 250, 290, 40));

        jlAdministrar.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jlAdministrar.setForeground(new java.awt.Color(255, 255, 255));
        jlAdministrar.setText("      Administrar Usuario");
        jlAdministrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlAdministrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlAdministrarMouseClicked(evt);
            }
        });
        getContentPane().add(jlAdministrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 290, 40));

        jlbtranpAdm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/b2.png"))); // NOI18N
        jlbtranpAdm.setText("transp");
        getContentPane().add(jlbtranpAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 290, 40));

        jlCampania1.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jlCampania1.setForeground(new java.awt.Color(255, 255, 255));
        jlCampania1.setText("           Campaña 1");
        jlCampania1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlCampania1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCampania1MouseClicked(evt);
            }
        });
        getContentPane().add(jlCampania1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 150, 290, 40));

        jlbtranpCampania1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/b2.png"))); // NOI18N
        jlbtranpCampania1.setText("transp");
        getContentPane().add(jlbtranpCampania1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 150, 290, 40));

        jlCampania2.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jlCampania2.setForeground(new java.awt.Color(255, 255, 255));
        jlCampania2.setText("           Campaña 2");
        jlCampania2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlCampania2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCampania2MouseClicked(evt);
            }
        });
        getContentPane().add(jlCampania2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 200, 290, 40));

        jlbtranpCampania2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/b2.png"))); // NOI18N
        jlbtranpCampania2.setText("transp");
        getContentPane().add(jlbtranpCampania2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 200, 290, 40));

        jlCampania3.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jlCampania3.setForeground(new java.awt.Color(255, 255, 255));
        jlCampania3.setText("           Campaña 3");
        jlCampania3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlCampania3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCampania3MouseClicked(evt);
            }
        });
        getContentPane().add(jlCampania3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 250, 290, 40));

        jlbtranpCampania3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/b2.png"))); // NOI18N
        jlbtranpCampania3.setText("transp");
        getContentPane().add(jlbtranpCampania3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 250, 290, 40));

        jlCampania4.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jlCampania4.setForeground(new java.awt.Color(255, 255, 255));
        jlCampania4.setText("           Campaña 4");
        jlCampania4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlCampania4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCampania4MouseClicked(evt);
            }
        });
        getContentPane().add(jlCampania4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 300, 290, 40));

        jlbtranpCampania4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/b2.png"))); // NOI18N
        jlbtranpCampania4.setText("transp");
        getContentPane().add(jlbtranpCampania4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 300, 290, 40));

        jlIniciarJuego.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jlIniciarJuego.setForeground(new java.awt.Color(255, 255, 255));
        jlIniciarJuego.setText("         Iniciar Juego");
        jlIniciarJuego.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlIniciarJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlIniciarJuegoMouseClicked(evt);
            }
        });
        getContentPane().add(jlIniciarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 290, 40));

        jlbtranpIniciarJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/b2.png"))); // NOI18N
        jlbtranpIniciarJuego.setText("transp");
        getContentPane().add(jlbtranpIniciarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 290, 40));

        jlCreditos.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jlCreditos.setForeground(new java.awt.Color(255, 255, 255));
        jlCreditos.setText("           Créditos");
        getContentPane().add(jlCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 290, 40));

        jlbtranpCred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/b2.png"))); // NOI18N
        jlbtranpCred.setText("transp");
        getContentPane().add(jlbtranpCred, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 290, 40));

        jlFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/imagenes/electrograma.gif"))); // NOI18N
        getContentPane().add(jlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 640, 380));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 640, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
    private void jlAdministrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAdministrarMouseClicked

        //Deslizar label nombre
        AnimationClass adm=new AnimationClass();
        adm.jLabelXLeft(170,10,10,5,jlAdministrar);
        AnimationClass admm=new AnimationClass();
        admm.jLabelXRight(10,170,10,5,jlAdministrar);
        //Deslizar base transparente
        AnimationClass admtransp=new AnimationClass();
        admtransp.jLabelXLeft(170,10,10,5,jlbtranpAdm);
        AnimationClass admtranspp=new AnimationClass();
        admtranspp.jLabelXRight(10,170,10,5,jlbtranpAdm);
        
        //Desplaza a los demás fuera del frame
        
        //Desliza ************Iniciar************
        //Deslizar label nombre
        AnimationClass admIniciar=new AnimationClass();
        admIniciar.jLabelXLeft(170,-290,10,5,jlIniciarJuego);
        AnimationClass admmIniciar=new AnimationClass();
        admmIniciar.jLabelXRight(-290,170,10,5,jlIniciarJuego);
        //Deslizar base transparente
        AnimationClass admtranspIniciar=new AnimationClass();
        admtranspIniciar.jLabelXLeft(170,-290,10,5,jlbtranpIniciarJuego);
        AnimationClass admtransppIniciar=new AnimationClass();
        admtransppIniciar.jLabelXRight(-290,170,10,5,jlbtranpIniciarJuego);
        
        //Desliza *********Creditos*************
        //Deslizar label nombre
        AnimationClass admCreditos=new AnimationClass();
        admCreditos.jLabelXLeft(170,-290,10,5,jlCreditos);
        AnimationClass admmCreditos=new AnimationClass();
        admmCreditos.jLabelXRight(-290,170,10,5,jlCreditos);
        //Deslizar base transparente
        AnimationClass admtranspCreditos=new AnimationClass();
        admtranspCreditos.jLabelXLeft(170,-290,10,5,jlbtranpCred);
        AnimationClass admtransppCreditos=new AnimationClass();
        admtransppCreditos.jLabelXRight(-290,170,10,5,jlbtranpCred);
        
    //*********************************************************************    
        
        //Aparezca el menu contenido Administrar
        //**************Boton Crear usuario**************
        //Deslizar label nombre
        AnimationClass admCrearUsr=new AnimationClass();
        admCrearUsr.jLabelXRight(-290,180,10,5,jlCrearUsr);
        AnimationClass admmCrearUsr=new AnimationClass();
        admmCrearUsr.jLabelXLeft(180,-290,10,5,jlCrearUsr);
        
        //Deslizar base transparente
        AnimationClass admtranspCrearUsr=new AnimationClass();
        admtranspCrearUsr.jLabelXRight(-290,180,10,5,jlbtranpCrearUsr);
        AnimationClass admtransppCrearUsr=new AnimationClass();
        admtransppCrearUsr.jLabelXLeft(180,-290,10,5,jlbtranpCrearUsr);
        
        //**************Boton Crear usuario**************
        //Deslizar label nombre
        AnimationClass admBorrarUsr=new AnimationClass();
        admBorrarUsr.jLabelXRight(-290,180,10,5,jlBorrarUsr);
        AnimationClass admmBorrarUsr=new AnimationClass();
        admmBorrarUsr.jLabelXLeft(180,-290,10,5,jlBorrarUsr);
        
        //Deslizar base transparente
        AnimationClass admtranspBorrarUsr=new AnimationClass();
        admtranspBorrarUsr.jLabelXRight(-290,180,10,5,jlbtranpBorrarUsr);
        AnimationClass admtransppBorrarUsr=new AnimationClass();
        admtransppBorrarUsr.jLabelXLeft(180,-290,10,5,jlbtranpBorrarUsr);
        
    }//GEN-LAST:event_jlAdministrarMouseClicked

    private void jlCrearUsrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCrearUsrMouseClicked
        CrearUsuario crUsr=new CrearUsuario();
        crUsr.setVisible(true); 
        
    }//GEN-LAST:event_jlCrearUsrMouseClicked

    private void jlCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCerrarMouseClicked
        int dialog=JOptionPane.YES_NO_OPTION;
        int result=JOptionPane.showConfirmDialog(null,"Desea Salir de PowerHack","Salir de PowerHack",dialog);
        if (result==0)
            System.exit(0);
    }//GEN-LAST:event_jlCerrarMouseClicked

    private void jlMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMinimizarMouseClicked
        this.setState(Principal.ICONIFIED);
    }//GEN-LAST:event_jlMinimizarMouseClicked

        
    private void jlBorrarUsrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlBorrarUsrMouseClicked
        BorrarUsuario bu= new BorrarUsuario();
        bu.setVisible(true);
    }//GEN-LAST:event_jlBorrarUsrMouseClicked

    private void jlIniciarJuegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlIniciarJuegoMouseClicked
        
        //Deslizar label nombre
        AnimationClass adm=new AnimationClass();
        adm.jLabelXLeft(170,-30,10,5,jlIniciarJuego);
        AnimationClass admm=new AnimationClass();
        admm.jLabelXRight(-30,170,10,5,jlIniciarJuego);
        //Deslizar base transparente
        AnimationClass admtransp=new AnimationClass();
        admtransp.jLabelXLeft(170,-30,10,5,jlbtranpIniciarJuego);
        AnimationClass admtranspp=new AnimationClass();
        admtranspp.jLabelXRight(-30,170,10,5,jlbtranpIniciarJuego);
        
        //Desplaza a los demás fuera del frame
        
        //Desliza ************Administrar************
        //Deslizar label nombre
        AnimationClass admIniciar=new AnimationClass();
        admIniciar.jLabelXLeft(170,-290,10,5,jlAdministrar);
        AnimationClass admmIniciar=new AnimationClass();
        admmIniciar.jLabelXRight(-290,170,10,5,jlAdministrar);
        //Deslizar base transparente
        AnimationClass admtranspIniciar=new AnimationClass();
        admtranspIniciar.jLabelXLeft(170,-290,10,5,jlbtranpAdm);
        AnimationClass admtransppIniciar=new AnimationClass();
        admtransppIniciar.jLabelXRight(-290,170,10,5,jlbtranpAdm);
        
        //Desliza *********Creditos*************
        //Deslizar label nombre
        AnimationClass admCreditos=new AnimationClass();
        admCreditos.jLabelXLeft(170,-290,10,5,jlCreditos);
        AnimationClass admmCreditos=new AnimationClass();
        admmCreditos.jLabelXRight(-290,170,10,5,jlCreditos);
        //Deslizar base transparente
        AnimationClass admtranspCreditos=new AnimationClass();
        admtranspCreditos.jLabelXLeft(170,-290,10,5,jlbtranpCred);
        AnimationClass admtransppCreditos=new AnimationClass();
        admtransppCreditos.jLabelXRight(-290,170,10,5,jlbtranpCred);
        
    //*********************************************************************    
        
        //Aparezca el menu contenido Iniciar
        //**************Boton Campania1**************
        //Deslizar label nombre
        AnimationClass admCrearUsr=new AnimationClass();
        admCrearUsr.jLabelXRight(-290,180,10,5,jlCampania1);
        AnimationClass admmCrearUsr=new AnimationClass();
        admmCrearUsr.jLabelXLeft(180,-290,10,5,jlCampania1);
        
        //Deslizar base transparente
        AnimationClass admtranspCrearUsr=new AnimationClass();
        admtranspCrearUsr.jLabelXRight(-290,180,10,5,jlbtranpCampania1);
        AnimationClass admtransppCrearUsr=new AnimationClass();
        admtransppCrearUsr.jLabelXLeft(180,-290,10,5,jlbtranpCampania1);
        
        //**************Boton Campania2**************
        //Deslizar label nombre
        AnimationClass admBorrarUsr=new AnimationClass();
        admBorrarUsr.jLabelXRight(-290,180,10,5,jlCampania2);
        AnimationClass admmBorrarUsr=new AnimationClass();
        admmBorrarUsr.jLabelXLeft(180,-290,10,5,jlCampania2);
        
        //Deslizar base transparente
        AnimationClass admtranspBorrarUsr=new AnimationClass();
        admtranspBorrarUsr.jLabelXRight(-290,180,10,5,jlbtranpCampania2);
        AnimationClass admtransppBorrarUsr=new AnimationClass();
        admtransppBorrarUsr.jLabelXLeft(180,-290,10,5,jlbtranpCampania2);
        
        //**************Boton Campania3**************
        //Deslizar label nombre
        AnimationClass admCampania3=new AnimationClass();
        admCampania3.jLabelXRight(-290,180,10,5,jlCampania3);
        AnimationClass admmCampania3=new AnimationClass();
        admmCampania3.jLabelXLeft(180,-290,10,5,jlCampania3);
        
        //Deslizar base transparente
        AnimationClass admtranspCampania3=new AnimationClass();
        admtranspCampania3.jLabelXRight(-290,180,10,5,jlbtranpCampania3);
        AnimationClass admtransppCampania3=new AnimationClass();
        admtransppCampania3.jLabelXLeft(180,-290,10,5,jlbtranpCampania3);
        
        //**************Boton Campania4**************
        //Deslizar label nombre
        AnimationClass admCampania4=new AnimationClass();
        admCampania4.jLabelXRight(-290,180,10,5,jlCampania4);
        AnimationClass admmCampania4=new AnimationClass();
        admmCampania4.jLabelXLeft(180,-290,10,5,jlCampania4);
        
        //Deslizar base transparente
        AnimationClass admtranspCampania4=new AnimationClass();
        admtranspCampania4.jLabelXRight(-290,180,10,5,jlbtranpCampania4);
        AnimationClass admtransppCampania4=new AnimationClass();
        admtransppCampania4.jLabelXLeft(180,-290,10,5,jlbtranpCampania4);
        
    }//GEN-LAST:event_jlIniciarJuegoMouseClicked

    private void jlCampania1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCampania1MouseClicked
        
        ControladorSesionVentana ingr=new ControladorSesionVentana();
        ingr.setNroCampaniaElegidoInterfaz(1);
        ingr.setVisible(true);
    }//GEN-LAST:event_jlCampania1MouseClicked

    private void jlCampania2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCampania2MouseClicked

        ControladorSesionVentana ingr=new ControladorSesionVentana();
        ingr.setNroCampaniaElegidoInterfaz(2);
        ingr.setVisible(true);
    }//GEN-LAST:event_jlCampania2MouseClicked

    private void jlCampania3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCampania3MouseClicked
        ControladorSesionVentana ingr=new ControladorSesionVentana();
        ingr.setNroCampaniaElegidoInterfaz(3);
        ingr.setVisible(true);
    }//GEN-LAST:event_jlCampania3MouseClicked

    private void jlCampania4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCampania4MouseClicked
        ControladorSesionVentana ingr=new ControladorSesionVentana();
        ingr.setNroCampaniaElegidoInterfaz(4);
        ingr.setVisible(true);
    }//GEN-LAST:event_jlCampania4MouseClicked


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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlAdministrar;
    private javax.swing.JLabel jlBienvenida;
    private javax.swing.JLabel jlBorrarUsr;
    private javax.swing.JLabel jlCampania1;
    private javax.swing.JLabel jlCampania2;
    private javax.swing.JLabel jlCampania3;
    private javax.swing.JLabel jlCampania4;
    private javax.swing.JLabel jlCerrar;
    private javax.swing.JLabel jlCrearUsr;
    private javax.swing.JLabel jlCreditos;
    private javax.swing.JLabel jlFondo;
    private javax.swing.JLabel jlIniciarJuego;
    private javax.swing.JLabel jlMinimizar;
    private javax.swing.JLabel jlbtranpAdm;
    private javax.swing.JLabel jlbtranpBorrarUsr;
    private javax.swing.JLabel jlbtranpCampania1;
    private javax.swing.JLabel jlbtranpCampania2;
    private javax.swing.JLabel jlbtranpCampania3;
    private javax.swing.JLabel jlbtranpCampania4;
    private javax.swing.JLabel jlbtranpCrearUsr;
    private javax.swing.JLabel jlbtranpCred;
    private javax.swing.JLabel jlbtranpIniciarJuego;
    private javax.swing.JPanel jpanelEncabezado;
    // End of variables declaration//GEN-END:variables
}
