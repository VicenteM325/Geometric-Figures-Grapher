package com.geometric.grafico;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangulo implements Figura {

    private String nombre;
    private int posX;
    private int posY;
    private int ancho;
    private int alto;
    private Color color;

    public Rectangulo(String nombre, int posX, int posY, int ancho, int alto, Color color) {
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(posX, posY, ancho, alto);
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
