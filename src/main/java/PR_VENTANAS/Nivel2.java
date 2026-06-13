/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PR_VENTANAS;

import PR_Usuarios.Usuarios;
import PR_Usuarios.GestionUsuarios;
import javax.swing.JOptionPane;
import PR_RECURSOS.Sonidos;
import javax.swing.ImageIcon;

public class Nivel2 extends javax.swing.JFrame implements BaseNVL{
   
    private Usuarios usuarioActual;
    private GestionUsuarios gestor;
    private Sonidos musica = new Sonidos();
    private int preguntaActual = 0;
    private String opcionSeleccionada = "";
    
    private String[][] opciones = {
    {"Avión", "Havión", "Abión", "Avíon"},
    {"Escuelaa", "Hescuela", "Escuela", "Ezcuela"},
    {"shapato", "Zapato", "Sapato", "Zhapato"},
    {"Lapis", "Lápiz", "Lápis", "Lapíz"},
    {"Cuaderno", "Cuadermo", "Cuaderrno", "Cuadernno"},
    {"Burro", "Vurro", "Búrro", "Vuro"},
    {"Biblioteka", "Bibiloteca", "Biblioteca", "Viblioteca"},
    {"Computadorá", "Conputadora", "Computadóra", "Computadora"}
    };

    private String[] respuestas = { 
        "Avión",
        "Escuela",
        "Zapato",
        "Lápiz",
        "Cuaderno",
        "Burro",
        "Biblioteca",
        "Computadora"
    };
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Nivel2.class.getName());

    /**
     * Creates new form Nivel2
     */
    public Nivel2() {
        initComponents();
    }
    public Nivel2(Usuarios usuarioActual, GestionUsuarios gestor) {
        initComponents();
        setTitle("PR-PICASSO");
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("PR_RECURSOS/sonic.png")).getImage());
        this.usuarioActual = usuarioActual;
        this.gestor = gestor;
        
       
        jlblMundo.setForeground(java.awt.Color.WHITE);
        jlblPregunta.setForeground(java.awt.Color.WHITE);
        
        jbtnOpcion1.setForeground(java.awt.Color.WHITE);
        jbtnOpcion2.setForeground(java.awt.Color.WHITE);
        jbtnOpcion3.setForeground(java.awt.Color.WHITE);
        jbtnOpcion4.setForeground(java.awt.Color.WHITE);
        
        mostrarPregunta();
        musica.reproducir("PR_RECURSOS/nivel2.wav");
        tutorial();
    }
    
    private void tutorial(){
        JOptionPane.showMessageDialog(this,
                "¡BIENVENIDO A TAGROF!\n\n" +
                "TAGROF es el mundo de la ortografía.\n" +
                "Aquí demostrarás tu habilidad para reconocer las palabras escritas correctamente.\n\n" +
                "REGLAS DEL MUNDO:\n" +
                "• Observa atentamente la imagen mostrada.\n" +
                "• Analiza las opciones disponibles.\n" +
                "• Selecciona la palabra escrita correctamente.\n" +
                "• Cada respuesta correcta te permitirá avanzar.\n\n" +
                "Completa todos los desafíos para obtener la medalla de TAGROF.\n\n" +
                "¡La buena ortografía será tu mejor aliada en esta aventura!");
    }
    
    @Override
    public void mostrarPregunta() {
        jlblPregunta.setText("Observa la imagen y elige la palabra escrita correctamente:");

        jbtnOpcion1.setText(opciones[preguntaActual][0]);
        jbtnOpcion2.setText(opciones[preguntaActual][1]);
        jbtnOpcion3.setText(opciones[preguntaActual][2]);
        jbtnOpcion4.setText(opciones[preguntaActual][3]);

        jlblImagen.setText("");
        jlblImagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource(imagenes[preguntaActual])));

        opcionSeleccionada = "";
    }
    
    private String[] imagenes = {
        "PR_RECURSOS/alter1.png",
        "PR_RECURSOS/alter2.png",
        "PR_RECURSOS/alter3.png",
        "PR_RECURSOS/alter4.png",
        "PR_RECURSOS/alter5.png",
        "PR_RECURSOS/alter6.png",
        "PR_RECURSOS/alter7.png",
        "PR_RECURSOS/alter8.png"
    };
    @Override
    public boolean verificarRespuesta() {
        return opcionSeleccionada.equals(respuestas[preguntaActual]);
    }

    @Override
    public void completarNivel() {
        usuarioActual.setNivel2(1);
        gestor.actualizarUsuario(usuarioActual);
        
        JOptionPane.showMessageDialog(this, "¡Muy bien! Completaste el Mundo 2.");
        musica.detener();
    }

    private void regresarMenu() {
        M_Niveles menu = new M_Niveles(usuarioActual, gestor);
        menu.setVisible(true);
        this.dispose();
    }

    private void validarOpcion() {
        if (verificarRespuesta()) {
            preguntaActual++;

            if (preguntaActual < opciones.length) {
                JOptionPane.showMessageDialog(this, "¡Correcto! Siguiente pregunta.");
                mostrarPregunta();
            } else {
                completarNivel();
                regresarMenu();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Respuesta incorrecta. Intenta nuevamente.");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblMundo = new javax.swing.JLabel();
        jlblImagen = new javax.swing.JLabel();
        jbtnOpcion1 = new javax.swing.JButton();
        jbtnOpcion2 = new javax.swing.JButton();
        jbtnOpcion3 = new javax.swing.JButton();
        jbtnOpcion4 = new javax.swing.JButton();
        jbtnRegresar = new javax.swing.JButton();
        jbtnTutorial = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlblPregunta = new javax.swing.JLabel();
        jlblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblMundo.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jlblMundo.setText("MUNDO 2 - ORTOGRAFIA");
        getContentPane().add(jlblMundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, -1, -1));

        jlblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PR_RECURSOS/alter1.png"))); // NOI18N
        getContentPane().add(jlblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        jbtnOpcion1.setBackground(new java.awt.Color(153, 102, 0));
        jbtnOpcion1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jbtnOpcion1.setText("OPCION 1");
        jbtnOpcion1.addActionListener(this::jbtnOpcion1ActionPerformed);
        getContentPane().add(jbtnOpcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jbtnOpcion2.setBackground(new java.awt.Color(153, 102, 0));
        jbtnOpcion2.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jbtnOpcion2.setText("OPCION 2");
        jbtnOpcion2.addActionListener(this::jbtnOpcion2ActionPerformed);
        getContentPane().add(jbtnOpcion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jbtnOpcion3.setBackground(new java.awt.Color(153, 102, 0));
        jbtnOpcion3.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jbtnOpcion3.setText("OPCION 3");
        jbtnOpcion3.addActionListener(this::jbtnOpcion3ActionPerformed);
        getContentPane().add(jbtnOpcion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, -1));

        jbtnOpcion4.setBackground(new java.awt.Color(153, 102, 0));
        jbtnOpcion4.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jbtnOpcion4.setText("OPCION 4");
        jbtnOpcion4.addActionListener(this::jbtnOpcion4ActionPerformed);
        getContentPane().add(jbtnOpcion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, -1, -1));

        jbtnRegresar.setFont(new java.awt.Font("Papyrus", 1, 12)); // NOI18N
        jbtnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PR_RECURSOS/flecha.png"))); // NOI18N
        jbtnRegresar.setText("REGRESAR");
        jbtnRegresar.addActionListener(this::jbtnRegresarActionPerformed);
        getContentPane().add(jbtnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 397, 180, 50));

        jbtnTutorial.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jbtnTutorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PR_RECURSOS/infos.png"))); // NOI18N
        jbtnTutorial.setText("info");
        jbtnTutorial.addActionListener(this::jbtnTutorialActionPerformed);
        getContentPane().add(jbtnTutorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, -1, -1));

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jlblPregunta.setFont(new java.awt.Font("High Tower Text", 1, 18)); // NOI18N
        jlblPregunta.setText("Observa la imagen y elige la palabra escrita correctamente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jlblPregunta)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jlblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 510, 40));

        jlblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PR_RECURSOS/fondo4.png"))); // NOI18N
        getContentPane().add(jlblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnOpcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOpcion2ActionPerformed
        opcionSeleccionada = jbtnOpcion2.getText();
        validarOpcion();
    }//GEN-LAST:event_jbtnOpcion2ActionPerformed

    private void jbtnOpcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOpcion1ActionPerformed
        opcionSeleccionada = jbtnOpcion1.getText();
        validarOpcion();
    }//GEN-LAST:event_jbtnOpcion1ActionPerformed

    private void jbtnOpcion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOpcion3ActionPerformed
        opcionSeleccionada = jbtnOpcion3.getText();
        validarOpcion();
    }//GEN-LAST:event_jbtnOpcion3ActionPerformed

    private void jbtnOpcion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOpcion4ActionPerformed
        opcionSeleccionada = jbtnOpcion4.getText();
        validarOpcion();
    }//GEN-LAST:event_jbtnOpcion4ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Nivel2().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnOpcion1;
    private javax.swing.JButton jbtnOpcion2;
    private javax.swing.JButton jbtnOpcion3;
    private javax.swing.JButton jbtnOpcion4;
    private javax.swing.JButton jbtnRegresar;
    private javax.swing.JButton jbtnTutorial;
    private javax.swing.JLabel jlblFondo;
    private javax.swing.JLabel jlblImagen;
    private javax.swing.JLabel jlblMundo;
    private javax.swing.JLabel jlblPregunta;
    // End of variables declaration//GEN-END:variables
}
