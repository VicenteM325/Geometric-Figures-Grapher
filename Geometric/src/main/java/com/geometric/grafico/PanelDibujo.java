package com.geometric.grafico;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author vicente
 */
public class PanelDibujo extends JPanel {

    private ArrayList<Figura> figuras;

    private double scaleFactor = 1.0; 

    public PanelDibujo() {
        this.figuras = new ArrayList<>();
        setPreferredSize(new Dimension(800, 800));
    }

    public void agregarFigura(Figura figura) {
        figuras.add(figura);
        System.out.println("Figura agregada: " + figura);
        repaint();
    }

    public ArrayList<Figura> getFiguras() {
        return figuras;
    }

    public void setScaleFactor(double scaleFactor) {
        this.scaleFactor = scaleFactor;
        revalidate();
        repaint();
    }

    public double getScaleFactor() {
        return scaleFactor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.scale(scaleFactor, scaleFactor);

        for (Figura figura : figuras) {
            figura.dibujar(g2d);
        }

        g2d.dispose();
    }
}
