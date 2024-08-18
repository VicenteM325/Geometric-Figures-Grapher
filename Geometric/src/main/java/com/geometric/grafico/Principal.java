package com.geometric.grafico;

import com.geometric.abstracto.Instruccion;
import com.geometric.analisis.Sintactico;
import com.geometric.analisis.scanner;
import com.geometric.excepciones.Errores;
import com.geometric.simbolo.Arbol;
import com.geometric.simbolo.TablaSimbolos;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author vicente
 */
public class Principal extends javax.swing.JFrame {
    private static Principal instance;
    
    private PanelDibujo panelDibujo;
    private JPanel panelFiguras;
     private ArrayList<Figura> figuras;
     private Figura ultimaFigura;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        panelEntrada.setLayout(new BorderLayout());
        panelDibujo = new PanelDibujo();
        panelEntrada.add(panelDibujo, BorderLayout.CENTER);
        btnVerFiguras.setVisible(false); // Inicia oculto
        btnVerFiguras.setEnabled(false);
        figuras = new ArrayList<>();

    }
    
    public static Principal getInstance() {
        if (instance == null) {
            instance = new Principal();
        }
        return instance;
    }
    
     public ArrayList<Figura> getFiguras() {
        return figuras;
    }
     public void agregarFigura(Figura figura) {
        panelDibujo.agregarFigura(figura);
        ultimaFigura = figura;  // Actualizar la última figura
    }

    public Figura getUltimaFigura() {
        return ultimaFigura;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEntrada = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaEntrada = new javax.swing.JTextArea();
        btnCompilar = new javax.swing.JButton();
        jLabelEntrada = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextConsola = new javax.swing.JTextArea();
        btnVerFiguras = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabelEntrada1 = new javax.swing.JLabel();
        btnAnimar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelEntrada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextAreaEntrada.setColumns(20);
        jTextAreaEntrada.setRows(5);
        jScrollPane1.setViewportView(jTextAreaEntrada);

        panelEntrada.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 660, 240));

        btnCompilar.setText("COMPILAR");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });
        panelEntrada.add(btnCompilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, -1, -1));

        jLabelEntrada.setText("CONSOLA");
        panelEntrada.add(jLabelEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jTextConsola.setColumns(20);
        jTextConsola.setRows(5);
        jScrollPane2.setViewportView(jTextConsola);

        panelEntrada.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 660, 190));

        btnVerFiguras.setText("Ver Figuras");
        btnVerFiguras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerFigurasActionPerformed(evt);
            }
        });
        panelEntrada.add(btnVerFiguras, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 140, 30));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        panelEntrada.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, -1, -1));

        jLabelEntrada1.setText("ENTRADA");
        panelEntrada.add(jLabelEntrada1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        btnAnimar.setText("Animar");
        panelEntrada.add(btnAnimar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
         try {
        String texto = jTextAreaEntrada.getText();
        scanner s = new scanner(new BufferedReader(new StringReader(texto)));
        Sintactico p = new Sintactico(s);
        var resultado = p.parse();

        // Capturar los errores léxicos y sintácticos
        LinkedList<Errores> lista = new LinkedList<>();
        lista.addAll(s.listaErrores);
        lista.addAll(p.listaErrores);

        if (lista.isEmpty()) {
            // Si no hay errores, continuar con la interpretación
            var ast = new Arbol((LinkedList<Instruccion>) resultado.value);
            var tabla = new TablaSimbolos();
            tabla.setNombre("Global");
            ast.setConsola("");

            for (var a : ast.getInstrucciones()) {
                if (a == null) continue;
                var res = a.interpretar(ast, tabla);
                if (res instanceof Errores) lista.add((Errores) res);
            }

            if (lista.isEmpty()) {
                jTextConsola.setText("No se encontraron errores.");
                btnVerFiguras.setVisible(true);
                btnVerFiguras.setEnabled(true);
            } else {
                mostrarErrores(lista);
                btnVerFiguras.setVisible(false);
                btnVerFiguras.setEnabled(false);
            }
        } else {
            // Mostrar los errores sintácticos y léxicos
            mostrarErrores(lista);
            btnVerFiguras.setVisible(false);
            btnVerFiguras.setEnabled(false);
        }
    } catch (Exception ex) {
        ex.printStackTrace(); 
        jTextConsola.setText("Ocurrió un error al intentar compilar.");
    }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnVerFigurasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerFigurasActionPerformed
        SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("Figuras Graficadas");
        PanelDibujo panelDibujo = Principal.getInstance().getPanelDibujo();
        
        // Crear JScrollPane y añadir el panel de dibujo
        JScrollPane scrollPane = new JScrollPane(panelDibujo);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Crear botones de zoom
        JButton btnZoomIn = new JButton("Zoom In");
        btnZoomIn.addActionListener(e -> {
            panelDibujo.setScaleFactor(panelDibujo.getScaleFactor() * 1.1);
        });

        JButton btnZoomOut = new JButton("Zoom Out");
        btnZoomOut.addActionListener(e -> {
            panelDibujo.setScaleFactor(panelDibujo.getScaleFactor() / 1.1);
        });

        // Crear un panel para los botones de control
        JPanel controlPanel = new JPanel();
        controlPanel.add(btnZoomIn);
        controlPanel.add(btnZoomOut);
        
        // Añadir el panel de control en la parte inferior
        frame.add(controlPanel, BorderLayout.SOUTH);

        // Configurar la ventana
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        System.out.println("Graficando figuras...");
        System.out.println("Figuras graficadas.");
    });
    }//GEN-LAST:event_btnVerFigurasActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        jTextConsola.setText("");
        jTextAreaEntrada.setText("");
        btnVerFiguras.setVisible(false);
        btnVerFiguras.setEnabled(false);
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    public PanelDibujo getPanelDibujo() {
        return panelDibujo;
    }
    
    private void mostrarErrores(LinkedList<Errores> lista) {
    StringBuilder errores = new StringBuilder();
    for (var error : lista) {
        errores.append(error.toString()).append("\n");
    }
    jTextConsola.setText(errores.toString());
}
    
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
    private javax.swing.JButton btnAnimar;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVerFiguras;
    private javax.swing.JLabel jLabelEntrada;
    private javax.swing.JLabel jLabelEntrada1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaEntrada;
    private javax.swing.JTextArea jTextConsola;
    private javax.swing.JPanel panelEntrada;
    // End of variables declaration//GEN-END:variables
}
