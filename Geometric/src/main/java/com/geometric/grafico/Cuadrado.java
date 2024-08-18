package com.geometric.grafico;

import java.awt.Color;
import java.awt.Graphics;

public class Cuadrado implements Figura {

    private String nombre;
    private int posX;
    private int posY;
    private int lado;
    private Color color;

    public Cuadrado(String nombre, int posX, int posY, int lado, Color color) {
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.lado = lado;
        this.color = color;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(posX, posY, lado, lado);
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

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
