package com.geometric.grafico;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Polygon;

public class Poligono implements Figura {

    private String nombre;
    private int posX;
    private int posY;
    private int lados;
    private int ancho;
    private int alto;
    private Color color;

    public Poligono(String nombre, int posX, int posY, int lados, int ancho, int alto, Color color) {
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.lados = lados;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        Polygon poligono = new Polygon();
        double angleStep = 2 * Math.PI / lados;
        int sumX = 0;
        int sumY = 0;
    
        for (int i = 0; i < lados; i++) {
            int x = posX + (int) (ancho / 2 * Math.cos(i * angleStep));
            int y = posY + (int) (alto / 2 * Math.sin(i * angleStep));
            poligono.addPoint(x, y);
            
            sumX += x;
            sumY += y;
        }
        g.fillPolygon(poligono);

        int centerX = sumX / lados;
        int centerY = sumY / lados;

        g.setColor(Color.BLACK);
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(nombre);
        g.drawString(nombre, centerX - textWidth / 2, centerY - 5);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getLados() {
        return lados;
    }

    public void setLados(int lados) {
        this.lados = lados;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void mover(int dx, int dy) {
        this.posX += dx;
        this.posY += dy;
    }

    @Override
    public int getX() {
        return posX;
    }

    @Override
    public int getY() {
        return posY;
    }

    @Override
    public void setX(int x) {
        this.posX = x;
    }

    @Override
    public void setY(int y) {
        this.posY = y;
    }
}
