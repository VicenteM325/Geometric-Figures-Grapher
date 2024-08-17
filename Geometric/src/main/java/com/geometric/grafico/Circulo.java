package com.geometric.grafico;

import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * @author vicente
 */
public class Circulo implements Figura {
    private String nombre;
    private int x, y, radio;
    private Color color;

    public Circulo(String nombre, int x, int y, int radio, Color color) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.color = color;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.drawOval(x - radio, y - radio, 2 * radio, 2 * radio);
    }
}
