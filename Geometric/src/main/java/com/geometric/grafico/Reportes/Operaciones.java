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
    private DefaultTableModel tableModelAnimacion;


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
        
        // Configurar la tabla de Animacion
        String[] columnNamesAnimacion = {"Animacion", "Cantidad"};
        tableModelAnimacion = new DefaultTableModel(columnNamesAnimacion, 0);
        tbAnimacion.setModel(tableModelAnimacion);
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
    
    public void agregarAnimacion(String animacion) {
        boolean animacionExiste = false;
        for (int i = 0; i < tableModelAnimacion.getRowCount(); i++) {
            if (tableModelAnimacion.getValueAt(i, 0).equals(animacion)) {
                int cantidad = (int) tableModelAnimacion.getValueAt(i, 1);
                tableModelAnimacion.setValueAt(cantidad + 1, i, 1);
                animacionExiste = true;
                break;
            }
        }
        if (!animacionExiste) {
            tableModelAnimacion.addRow(new Object[]{animacion, 1});
        }
        tbAnimacion.revalidate();
        tbAnimacion.repaint();
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
    
     public JTable getTbAnimacion() {
        return tbAnimacion;
    }

    public void setTbAnimacion(JTable tbAnimacion) {
        this.tbAnimacion = tbAnimacion;
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
        jScrollPane4 = new javax.swing.JScrollPane();
        tbAnimacion = new javax.swing.JTable();
        jLabelAnimacion = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(20, 34, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbOperaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbOperaciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 470, 210));

        jLabelColores.setBackground(new java.awt.Color(231, 232, 231));
        jLabelColores.setForeground(new java.awt.Color(231, 232, 231));
        jLabelColores.setText("REPORTE COLORES");
        jPanel1.add(jLabelColores, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

        tbColores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbColores);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 470, 230));

        jLabel2.setBackground(new java.awt.Color(231, 232, 231));
        jLabel2.setForeground(new java.awt.Color(231, 232, 231));
        jLabel2.setText("REPORTE OPERACIONES");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        jLabelFiguras.setBackground(new java.awt.Color(231, 232, 231));
        jLabelFiguras.setForeground(new java.awt.Color(231, 232, 231));
        jLabelFiguras.setText("REPORTE FIGURAS");
        jPanel1.add(jLabelFiguras, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, -1, 30));

        tbFiguras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbFiguras);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 480, 230));

        tbAnimacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbAnimacion);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 480, 210));

        jLabelAnimacion.setBackground(new java.awt.Color(231, 232, 231));
        jLabelAnimacion.setForeground(new java.awt.Color(231, 232, 231));
        jLabelAnimacion.setText("REPORTE ANIMACION");
        jPanel1.add(jLabelAnimacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));

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
    private javax.swing.JLabel jLabelAnimacion;
    private javax.swing.JLabel jLabelColores;
    private javax.swing.JLabel jLabelFiguras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbAnimacion;
    private javax.swing.JTable tbColores;
    private javax.swing.JTable tbFiguras;
    private javax.swing.JTable tbOperaciones;
    // End of variables declaration//GEN-END:variables
}
