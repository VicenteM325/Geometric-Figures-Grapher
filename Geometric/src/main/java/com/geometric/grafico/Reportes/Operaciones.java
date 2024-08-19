package com.geometric.grafico.Reportes;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vicente
 */
public class Operaciones extends javax.swing.JPanel {
    
    private DefaultTableModel tableModel;
    private DefaultTableModel tableModelColores;
    private DefaultTableModel tableModelFiguras;


    public Operaciones() {
        initComponents();
        configurarTabla();
    }
    
    private void configurarTabla(){
        String[] columnNames = {"Operador", "Linea", "Columna", "Ocurrencia"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tbOperaciones.setModel(tableModel);
        
        // Configurar la tabla de colores
        String[] columnNamesColores = {"Color", "Cantidad"};
        tableModelColores = new DefaultTableModel(columnNamesColores, 0);
        tbColores.setModel(tableModelColores);
        
        // Configurar la tabla de figuras
        String[] columnNamesFiguras = {"Figura", "Cantidad"};
        tableModelFiguras = new DefaultTableModel(columnNamesFiguras, 0);
        tbFiguras.setModel(tableModelFiguras);
    }

    public void agregarOperacion(String operador, int linea, int columna, String operacion) {
        tableModel.addRow(new Object[]{operador, linea, columna, operacion});
        tbOperaciones.revalidate();
        tbOperaciones.repaint();
        imprimirFilas();
    }
    
    public void agregarColor(String color) {
        boolean colorExiste = false;
        for (int i = 0; i < tableModelColores.getRowCount(); i++) {
            if (tableModelColores.getValueAt(i, 0).equals(color)) {
                int cantidad = (int) tableModelColores.getValueAt(i, 1);
                tableModelColores.setValueAt(cantidad + 1, i, 1);
                colorExiste = true;
                break;
            }
        }
        if (!colorExiste) {
            tableModelColores.addRow(new Object[]{color, 1});
        }
        tbColores.revalidate();
        tbColores.repaint();
    }

    public void agregarFigura(String figura) {
        boolean figuraExiste = false;
        for (int i = 0; i < tableModelFiguras.getRowCount(); i++) {
            if (tableModelFiguras.getValueAt(i, 0).equals(figura)) {
                int cantidad = (int) tableModelFiguras.getValueAt(i, 1);
                tableModelFiguras.setValueAt(cantidad + 1, i, 1);
                figuraExiste = true;
                break;
            }
        }
        if (!figuraExiste) {
            tableModelFiguras.addRow(new Object[]{figura, 1});
        }
        tbFiguras.revalidate();
        tbFiguras.repaint();
    }

    public JTable getTbColores() {
        return tbColores;
    }

    public void setTbColores(JTable tbColores) {
        this.tbColores = tbColores;
    }

    public JTable getTbFiguras() {
        return tbFiguras;
    }

    public void setTbFiguras(JTable tbFiguras) {
        this.tbFiguras = tbFiguras;
    }

    public JTable getTbOperaciones() {
        return tbOperaciones;
    }

    public void setTbOperaciones(JTable tbOperaciones) {
        this.tbOperaciones = tbOperaciones;
    }
    

    public void imprimirFilas() {
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        for (int j = 0; j < tableModel.getColumnCount(); j++) {
            System.out.print(tableModel.getValueAt(i, j) + " ");
        }
        System.out.println();
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbOperaciones = new javax.swing.JTable();
        jLabelColores = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbColores = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabelFiguras = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbFiguras = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbOperaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbOperaciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 460, 200));

        jLabelColores.setText("REPORTE COLORES");
        jPanel1.add(jLabelColores, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));

        tbColores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbColores);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 470, 200));

        jLabel2.setText("REPORTE OPERACIONES");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));

        jLabelFiguras.setText("REPORTE FIGURAS");
        jPanel1.add(jLabelFiguras, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 284, -1, 30));

        tbFiguras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbFiguras);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 470, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelColores;
    private javax.swing.JLabel jLabelFiguras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbColores;
    private javax.swing.JTable tbFiguras;
    private javax.swing.JTable tbOperaciones;
    // End of variables declaration//GEN-END:variables
}
