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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radio, y - radio, 2 * radio, 2 * radio);
    }
    
     @Override
    public void mover(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
