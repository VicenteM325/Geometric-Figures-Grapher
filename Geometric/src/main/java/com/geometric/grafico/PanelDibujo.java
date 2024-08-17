package com.geometric.grafico;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author vicente
 */
public class PanelDibujo extends JPanel {
    private java.util.List<Figura> figuras = new java.util.ArrayList<>();

    public void agregarFigura(Figura figura) {
        figuras.add(figura);
        repaint();  // Solicita que se vuelva a dibujar el panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Figura figura : figuras) {
            figura.dibujar(g);
        }
    }
}
