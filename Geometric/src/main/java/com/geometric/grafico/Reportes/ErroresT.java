package com.geometric.grafico.Reportes;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vicente
 */
public class ErroresT extends javax.swing.JPanel {
    
    private DefaultTableModel tableModel;

    /**
     * Creates new form Errores
     */
    public ErroresT() {
        initComponents();
        configurarTabla();
    }
    private void configurarTabla(){
        String[] columnNames = {"Tipo", "Linea", "Columna", "Descripción (Lexema)"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tbErroresLS.setModel(tableModel);
        
    }

    public void agregarError(String tipo, int linea, int columna, String descripcion) {
        tableModel.addRow(new Object[]{tipo, linea, columna, descripcion});
        tbErroresLS.revalidate();
        tbErroresLS.repaint();
    }

    public JTable getTbErroresLS() {
        return tbErroresLS;
    }

    public void setTbErroresLS(JTable tbErroresLS) {
        this.tbErroresLS = tbErroresLS;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbErroresLS = new javax.swing.JTable();
        jLabelErroresLS = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(20, 34, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbErroresLS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbErroresLS);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 880, 430));

        jLabelErroresLS.setBackground(new java.awt.Color(231, 232, 231));
        jLabelErroresLS.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabelErroresLS.setForeground(new java.awt.Color(231, 232, 231));
        jLabelErroresLS.setText("REPORTE ERRORES LEXICOS Y SINTÁCTICOS");
        jPanel1.add(jLabelErroresLS, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 550, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelErroresLS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbErroresLS;
    // End of variables declaration//GEN-END:variables
}
