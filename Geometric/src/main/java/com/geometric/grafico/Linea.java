package com.geometric.grafico;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Linea implements Figura {

    private String nombre;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;

    public Linea(String nombre, int x1, int y1, int x2, int y2, Color color) {
        this.nombre = nombre;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

   

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
        
        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;

        g.setColor(Color.BLACK);
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(nombre);
        g.drawString(nombre, midX - textWidth / 2, midY - 5);
    }

    @Override
    public void mover(int dx, int dy) {
        // Mueve ambos puntos finales de la línea
        this.x1 += dx;
        this.y1 += dy;
        this.x2 += dx;
        this.y2 += dy;
    }

    @Override
    public int getX() {
        // Retorna la coordenada x del centro de la línea
        return (x1 + x2) / 2;
    }

    @Override
    public int getY() {
        // Retorna la coordenada y del centro de la línea
        return (y1 + y2) / 2;
    }

    @Override
    public void setX(int x) {
        // Ajusta la posición central de la línea
        int centerX = getX();
        int deltaX = x - centerX;
        this.x1 += deltaX;
        this.x2 += deltaX;
    }

    @Override
    public void setY(int y) {
        // Ajusta la posición central de la línea
        int centerY = getY();
        int deltaY = y - centerY;
        this.y1 += deltaY;
        this.y2 += deltaY;
    }

    // Getters y Setters adicionales
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

