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

    public PanelDibujo() {
        this.figuras = new ArrayList<>();
        setPreferredSize(new Dimension(800, 800));
    }

    public void agregarFigura(Figura figura) {
        figuras.add(figura);
        System.out.println("Figura agregada: " + figura);
        repaint(); // Redibujar el panel después de agregar una figura
    }
    public ArrayList<Figura> getFiguras() {
        return figuras;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Figura figura : figuras) {
            figura.dibujar(g); // Dibujar cada figura en la lista
        }
    }
}
