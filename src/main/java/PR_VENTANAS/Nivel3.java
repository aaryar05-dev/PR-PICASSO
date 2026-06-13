/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PR_VENTANAS;

import PR_Usuarios.Usuarios;
import PR_Usuarios.GestionUsuarios;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import PR_RECURSOS.Sonidos;
import javax.swing.ImageIcon;

public class Nivel3 extends javax.swing.JFrame implements BaseNVL {
    private Usuarios usuarioActual;
    private GestionUsuarios gestor;
    private Sonidos musica = new Sonidos();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Nivel3.class.getName());

    /**
     * Creates new form Nivel3
     */
    public Nivel3() {
        initComponents();
        configurarCrucigrama();
    }
    
    public Nivel3(Usuarios usuarioActual, GestionUsuarios gestor) {
        initComponents();
        setTitle("PR-PICASSO");
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("PR_RECURSOS/sonic.png")).getImage());
        this.usuarioActual = usuarioActual;
        this.gestor = gestor;
        configurarCrucigrama();
        musica.reproducir("PR_RECURSOS/nivel3.wav");
        tutorial();
    }
    
    private void tutorial(){
        JOptionPane.showMessageDialog(this,"MUNDO 3 - CRUCIGRAMA\n\n"
            + "Completa el crucigrama utilizando las pistas.\n"
            + "Cada casilla admite una sola letra.\n\n"
            + "Cuando termines, presiona CONFIRMAR.");
    }
    
    private void configurarCasilla(JTextField campo) {
        campo.setHorizontalAlignment(JTextField.CENTER);
        campo.addKeyListener(new java.awt.event.KeyAdapter() 
        {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char letra = evt.getKeyChar();

                if (!Character.isLetter(letra)) {
                    evt.consume();
                    return;
                }

                if (campo.getText().length() >= 1) {
                    evt.consume();
                    return;
                }

                campo.setText(String.valueOf(letra).toUpperCase());
                evt.consume();
            }
        });
    }
    
    private void configurarCrucigrama() {
        configurarCasilla(jtxtP1);
        configurarCasilla(jtxtO1);
        configurarCasilla(jtxtE1);
        configurarCasilla(jtxtM1);
        configurarCasilla(jtxtA1);

        configurarCasilla(jtxtC2);
        configurarCasilla(jtxtU2);
        configurarCasilla(jtxtN2);
        configurarCasilla(jtxtT2);
        configurarCasilla(jtxtO2);

        configurarCasilla(jtxtF3);
        configurarCasilla(jtxtA3);
        configurarCasilla(jtxtB3);
        configurarCasilla(jtxtU3);
        configurarCasilla(jtxtL3);

        configurarCasilla(jtxtU4);
        configurarCasilla(jtxtT4);
        configurarCasilla(jtxtO4);
        configurarCasilla(jtxtR4);

        configurarCasilla(jtxtL5);
        configurarCasilla(jtxtI5);
        configurarCasilla(jtxtB5);
        configurarCasilla(jtxtR5);

        configurarCasilla(jtxtR6);
        configurarCasilla(jtxtI6);
        configurarCasilla(jtxtM6);
        configurarCasilla(jtxtA6);

        configurarCasilla(jtxtN7);
        configurarCasilla(jtxtA7);
        configurarCasilla(jtxtAA7);
        configurarCasilla(jtxtR7);

        configurarCasilla(jtxtL8);
        configurarCasilla(jtxtE8);
        configurarCasilla(jtxtR8);
        configurarCasilla(jtxtA8);
    }
    
    @Override
    public boolean verificarRespuesta() {

        String poema =
            jtxtP1.getText() +
            jtxtO1.getText() +
            jtxtE1.getText() +
            jtxtM1.getText() +
            jtxtA1.getText();

        String cuento =
            jtxtC2.getText() +
            jtxtU2.getText() +
            jtxtE1.getText() +
            jtxtN2.getText() +
            jtxtT2.getText() +
            jtxtO2.getText();

        String fabula =
            jtxtF3.getText() +
            jtxtA3.getText() +
            jtxtB3.getText() +
            jtxtU3.getText() +
            jtxtL3.getText() +
            jtxtA1.getText();

        String autor =
            jtxtA1.getText() +
            jtxtU4.getText() +
            jtxtT4.getText() +
            jtxtO4.getText() +
            jtxtR4.getText();

        String libro =
            jtxtL5.getText() +
            jtxtI5.getText() +
            jtxtB5.getText() +
            jtxtR5.getText() +
            jtxtO2.getText();

        String rima =
            jtxtR6.getText() +
            jtxtI6.getText() +
            jtxtM6.getText() +
            jtxtA6.getText();

        String narrar =
            jtxtN7.getText() +
            jtxtA7.getText() +
            jtxtR4.getText() +
            jtxtR6.getText() +
            jtxtAA7.getText() +
            jtxtR7.getText();

        String letra =
            jtxtL8.getText() +
            jtxtE8.getText() +
            jtxtT4.getText() +
            jtxtR8.getText() +
            jtxtA8.getText();

        return poema.equalsIgnoreCase("POEMA")
            && cuento.equalsIgnoreCase("CUENTO")
            && fabula.equalsIgnoreCase("FABULA")
            && autor.equalsIgnoreCase("AUTOR")
            && libro.equalsIgnoreCase("LIBRO")
            && rima.equalsIgnoreCase("RIMA")
            && narrar.equalsIgnoreCase("NARRAR")
            && letra.equalsIgnoreCase("LETRA");
    }
    
    private void regresarMenu() {
        M_Niveles menu = new M_Niveles(usuarioActual, gestor);
        menu.setVisible(true);
        this.dispose();
    }
    
    @Override
    public void completarNivel() {
        usuarioActual.setNivel3(1);
        gestor.actualizarUsuario(usuarioActual);
        JOptionPane.showMessageDialog(this,"¡Felicidades! Has completado el crucigrama.");
        musica.detener();
    }
    
    @Override
    public void mostrarPregunta() {}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnRegresar = new javax.swing.JButton();
        jbtnConfResp = new javax.swing.JButton();
        jbtnPistas = new javax.swing.JButton();
        jtxtP1 = new javax.swing.JTextField();
        jtxtO1 = new javax.swing.JTextField();
        jtxtE1 = new javax.swing.JTextField();
        jtxtM1 = new javax.swing.JTextField();
        jtxtA1 = new javax.swing.JTextField();
        jtxtC2 = new javax.swing.JTextField();
        jtxtU2 = new javax.swing.JTextField();
        jtxtN2 = new javax.swing.JTextField();
        jtxtT2 = new javax.swing.JTextField();
        jtxtO2 = new javax.swing.JTextField();
        jtxtF3 = new javax.swing.JTextField();
        jtxtB3 = new javax.swing.JTextField();
        jtxtU3 = new javax.swing.JTextField();
        jtxtL3 = new javax.swing.JTextField();
        jtxtA3 = new javax.swing.JTextField();
        jtxtU4 = new javax.swing.JTextField();
        jtxtT4 = new javax.swing.JTextField();
        jtxtO4 = new javax.swing.JTextField();
        jtxtR4 = new javax.swing.JTextField();
        jtxtL5 = new javax.swing.JTextField();
        jtxtI5 = new javax.swing.JTextField();
        jtxtB5 = new javax.swing.JTextField();
        jtxtR5 = new javax.swing.JTextField();
        jtxtR6 = new javax.swing.JTextField();
        jtxtI6 = new javax.swing.JTextField();
        jtxtM6 = new javax.swing.JTextField();
        jtxtA6 = new javax.swing.JTextField();
        jtxtN7 = new javax.swing.JTextField();
        jtxtA7 = new javax.swing.JTextField();
        jtxtAA7 = new javax.swing.JTextField();
        jtxtR7 = new javax.swing.JTextField();
        jtxtE8 = new javax.swing.JTextField();
        jtxtL8 = new javax.swing.JTextField();
        jtxtA8 = new javax.swing.JTextField();
        jtxtR8 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jbtnTutorial = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlblMundo = new javax.swing.JLabel();
        jlblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnRegresar.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jbtnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PR_RECURSOS/flecha.png"))); // NOI18N
        jbtnRegresar.setText("REGRESAR");
        jbtnRegresar.addActionListener(this::jbtnRegresarActionPerformed);
        getContentPane().add(jbtnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jbtnConfResp.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jbtnConfResp.setText("Confirmar respuestas");
        jbtnConfResp.addActionListener(this::jbtnConfRespActionPerformed);
        getContentPane().add(jbtnConfResp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jbtnPistas.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jbtnPistas.setText("Pistas");
        jbtnPistas.addActionListener(this::jbtnPistasActionPerformed);
        getContentPane().add(jbtnPistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 30, -1, -1));

        jtxtP1.addActionListener(this::jtxtP1ActionPerformed);
        getContentPane().add(jtxtP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 131, 30, 30));

        jtxtO1.addActionListener(this::jtxtO1ActionPerformed);
        getContentPane().add(jtxtO1, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 131, 30, 30));

        jtxtE1.addActionListener(this::jtxtE1ActionPerformed);
        getContentPane().add(jtxtE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 131, 30, 30));

        jtxtM1.addActionListener(this::jtxtM1ActionPerformed);
        getContentPane().add(jtxtM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 131, 30, 30));

        jtxtA1.addActionListener(this::jtxtA1ActionPerformed);
        getContentPane().add(jtxtA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 131, 30, 30));

        jtxtC2.addActionListener(this::jtxtC2ActionPerformed);
        getContentPane().add(jtxtC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 59, 30, 30));

        jtxtU2.addActionListener(this::jtxtU2ActionPerformed);
        getContentPane().add(jtxtU2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 95, 30, 30));

        jtxtN2.addActionListener(this::jtxtN2ActionPerformed);
        getContentPane().add(jtxtN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 167, 30, 30));

        jtxtT2.addActionListener(this::jtxtT2ActionPerformed);
        getContentPane().add(jtxtT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 203, 30, 30));

        jtxtO2.addActionListener(this::jtxtO2ActionPerformed);
        getContentPane().add(jtxtO2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 239, 30, 30));

        jtxtF3.addActionListener(this::jtxtF3ActionPerformed);
        getContentPane().add(jtxtF3, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 95, 30, 30));

        jtxtB3.addActionListener(this::jtxtB3ActionPerformed);
        getContentPane().add(jtxtB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 167, 30, 30));

        jtxtU3.addActionListener(this::jtxtU3ActionPerformed);
        getContentPane().add(jtxtU3, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 203, 30, 30));

        jtxtL3.addActionListener(this::jtxtL3ActionPerformed);
        getContentPane().add(jtxtL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 239, 30, 30));

        jtxtA3.addActionListener(this::jtxtA3ActionPerformed);
        getContentPane().add(jtxtA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 275, 30, 30));

        jtxtU4.addActionListener(this::jtxtU4ActionPerformed);
        getContentPane().add(jtxtU4, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 275, 30, 30));

        jtxtT4.addActionListener(this::jtxtT4ActionPerformed);
        getContentPane().add(jtxtT4, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 275, 30, 30));

        jtxtO4.addActionListener(this::jtxtO4ActionPerformed);
        getContentPane().add(jtxtO4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 275, 30, 30));

        jtxtR4.addActionListener(this::jtxtR4ActionPerformed);
        getContentPane().add(jtxtR4, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 275, 30, 30));

        jtxtL5.addActionListener(this::jtxtL5ActionPerformed);
        getContentPane().add(jtxtL5, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 239, 30, 30));

        jtxtI5.addActionListener(this::jtxtI5ActionPerformed);
        getContentPane().add(jtxtI5, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 239, 30, 30));

        jtxtB5.addActionListener(this::jtxtB5ActionPerformed);
        getContentPane().add(jtxtB5, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 239, 30, 30));

        jtxtR5.addActionListener(this::jtxtR5ActionPerformed);
        getContentPane().add(jtxtR5, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 239, 30, 30));

        jtxtR6.addActionListener(this::jtxtR6ActionPerformed);
        getContentPane().add(jtxtR6, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 239, 30, 30));

        jtxtI6.addActionListener(this::jtxtI6ActionPerformed);
        getContentPane().add(jtxtI6, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 239, 30, 30));

        jtxtM6.addActionListener(this::jtxtM6ActionPerformed);
        getContentPane().add(jtxtM6, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 239, 30, 30));

        jtxtA6.addActionListener(this::jtxtA6ActionPerformed);
        getContentPane().add(jtxtA6, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 239, 30, 30));

        jtxtN7.addActionListener(this::jtxtN7ActionPerformed);
        getContentPane().add(jtxtN7, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 167, 30, 30));

        jtxtA7.addActionListener(this::jtxtA7ActionPerformed);
        getContentPane().add(jtxtA7, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 203, 30, 30));

        jtxtAA7.addActionListener(this::jtxtAA7ActionPerformed);
        getContentPane().add(jtxtAA7, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 311, 30, 30));

        jtxtR7.addActionListener(this::jtxtR7ActionPerformed);
        getContentPane().add(jtxtR7, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 347, 30, 30));

        jtxtE8.addActionListener(this::jtxtE8ActionPerformed);
        getContentPane().add(jtxtE8, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 239, 30, 30));

        jtxtL8.addActionListener(this::jtxtL8ActionPerformed);
        getContentPane().add(jtxtL8, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 203, 30, 30));

        jtxtA8.addActionListener(this::jtxtA8ActionPerformed);
        getContentPane().add(jtxtA8, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 347, 30, 30));

        jtxtR8.addActionListener(this::jtxtR8ActionPerformed);
        getContentPane().add(jtxtR8, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 311, 30, 30));

        jLabel2.setText("8");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        jLabel3.setText("1");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        jLabel4.setText("2");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        jLabel5.setText("3");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        jLabel6.setText("4");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        jLabel7.setText("5");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel8.setText("6");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

        jLabel9.setText("7");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, -1, -1));

        jbtnTutorial.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jbtnTutorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PR_RECURSOS/infos.png"))); // NOI18N
        jbtnTutorial.setText("info");
        jbtnTutorial.addActionListener(this::jbtnTutorialActionPerformed);
        getContentPane().add(jbtnTutorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlblMundo.setFont(new java.awt.Font("NSimSun", 1, 18)); // NOI18N
        jlblMundo.setText("MUNDO 3 - CRUCIGRAMA");
        jPanel1.add(jlblMundo);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 230, 40));

        jlblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PR_RECURSOS/fondo5.png"))); // NOI18N
        getContentPane().add(jlblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPistasActionPerformed
        JOptionPane.showMessageDialog(this,
            "PISTAS DEL CRUCIGRAMA\n\n"
                    
            + "HORIZONTALES:\n"
            + "1. Texto literario escrito en versos.\n"
            + "4. Persona que escribe una obra.\n"
            + "5. Conjunto de hojas escritas o impresas encuadernadas.\n"
            + "6. Semejanza de sonidos al final de las palabras.\n\n"
                
            + "VERTICALES:\n"
            + "2. Narración breve con personajes y acontecimientos.\n"
            + "3. Relato que deja una enseñanza o moraleja.\n"
            + "7. Contar una historia o acontecimiento mediante palabras.\n"
            + "8. Unidad básica con la que se forman las palabras."
        );
    }//GEN-LAST:event_jbtnPistasActionPerformed

    private void jtxtP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtP1ActionPerformed

    private void jtxtN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtN2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtN2ActionPerformed

    private void jtxtE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtE1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtE1ActionPerformed

    private void jtxtO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtO1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtO1ActionPerformed

    private void jtxtA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtA1ActionPerformed

    private void jtxtM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtM1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtM1ActionPerformed

    private void jtxtU2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtU2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtU2ActionPerformed

    private void jtxtC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtC2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtC2ActionPerformed

    private void jtxtT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtT2ActionPerformed

    private void jtxtO2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtO2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtO2ActionPerformed

    private void jtxtR7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtR7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtR7ActionPerformed

    private void jtxtR6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtR6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtR6ActionPerformed

    private void jtxtR4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtR4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtR4ActionPerformed

    private void jtxtT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtT4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtT4ActionPerformed

    private void jtxtU4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtU4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtU4ActionPerformed

    private void jtxtF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtF3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtF3ActionPerformed

    private void jtxtN7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtN7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtN7ActionPerformed

    private void jtxtA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtA3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtA3ActionPerformed

    private void jtxtU3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtU3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtU3ActionPerformed

    private void jtxtL3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtL3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtL3ActionPerformed

    private void jtxtO4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtO4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtO4ActionPerformed

    private void jtxtB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtB3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtB3ActionPerformed

    private void jtxtA7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtA7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtA7ActionPerformed

    private void jtxtB5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtB5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtB5ActionPerformed

    private void jtxtR5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtR5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtR5ActionPerformed

    private void jtxtL5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtL5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtL5ActionPerformed

    private void jtxtI5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtI5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtI5ActionPerformed

    private void jtxtM6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtM6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtM6ActionPerformed

    private void jtxtE8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtE8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtE8ActionPerformed

    private void jtxtI6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtI6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtI6ActionPerformed

    private void jtxtA6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtA6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtA6ActionPerformed

    private void jtxtL8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtL8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtL8ActionPerformed

    private void jtxtA8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtA8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtA8ActionPerformed

    private void jtxtR8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtR8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtR8ActionPerformed

    private void jtxtAA7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtAA7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtAA7ActionPerformed

    private void jbtnConfRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnConfRespActionPerformed

        if(verificarRespuesta()) {
            completarNivel();
            JOptionPane.showMessageDialog(this,"¡Muy bien! Completaste el Mundo 3.");

            M_Niveles menu = new M_Niveles(usuarioActual, gestor);
            menu.setVisible(true);

            this.dispose();


        } else {
            JOptionPane.showMessageDialog(this, "Hay palabras incorrectas en el crucigrama.");
        }
    }//GEN-LAST:event_jbtnConfRespActionPerformed

    private void jbtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegresarActionPerformed
        regresarMenu();
        musica.detener();
    }//GEN-LAST:event_jbtnRegresarActionPerformed

    private void jbtnTutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTutorialActionPerformed
        tutorial();
    }//GEN-LAST:event_jbtnTutorialActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Nivel3().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnConfResp;
    private javax.swing.JButton jbtnPistas;
    private javax.swing.JButton jbtnRegresar;
    private javax.swing.JButton jbtnTutorial;
    private javax.swing.JLabel jlblFondo;
    private javax.swing.JLabel jlblMundo;
    private javax.swing.JTextField jtxtA1;
    private javax.swing.JTextField jtxtA3;
    private javax.swing.JTextField jtxtA6;
    private javax.swing.JTextField jtxtA7;
    private javax.swing.JTextField jtxtA8;
    private javax.swing.JTextField jtxtAA7;
    private javax.swing.JTextField jtxtB3;
    private javax.swing.JTextField jtxtB5;
    private javax.swing.JTextField jtxtC2;
    private javax.swing.JTextField jtxtE1;
    private javax.swing.JTextField jtxtE8;
    private javax.swing.JTextField jtxtF3;
    private javax.swing.JTextField jtxtI5;
    private javax.swing.JTextField jtxtI6;
    private javax.swing.JTextField jtxtL3;
    private javax.swing.JTextField jtxtL5;
    private javax.swing.JTextField jtxtL8;
    private javax.swing.JTextField jtxtM1;
    private javax.swing.JTextField jtxtM6;
    private javax.swing.JTextField jtxtN2;
    private javax.swing.JTextField jtxtN7;
    private javax.swing.JTextField jtxtO1;
    private javax.swing.JTextField jtxtO2;
    private javax.swing.JTextField jtxtO4;
    private javax.swing.JTextField jtxtP1;
    private javax.swing.JTextField jtxtR4;
    private javax.swing.JTextField jtxtR5;
    private javax.swing.JTextField jtxtR6;
    private javax.swing.JTextField jtxtR7;
    private javax.swing.JTextField jtxtR8;
    private javax.swing.JTextField jtxtT2;
    private javax.swing.JTextField jtxtT4;
    private javax.swing.JTextField jtxtU2;
    private javax.swing.JTextField jtxtU3;
    private javax.swing.JTextField jtxtU4;
    // End of variables declaration//GEN-END:variables
}
