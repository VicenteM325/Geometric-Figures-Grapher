package com.geometric.instrucciones;


import com.geometric.abstracto.Instruccion;
import com.geometric.excepciones.Errores;
import com.geometric.simbolo.Arbol;
import com.geometric.simbolo.TablaSimbolos;
import com.geometric.simbolo.Tipo;
import com.geometric.simbolo.TipoDato;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author vicente
 */
public class GraficarRectangulo extends Instruccion {

    private String nombre;
    private Instruccion posX;
    private Instruccion posY;
    private Instruccion ancho;
    private Instruccion alto;
    private String color;

    // Constructor
    public GraficarRectangulo(String nombre, Instruccion posX, Instruccion posY, Instruccion ancho, Instruccion alto, String color, int linea, int columna) {
        super(new Tipo(TipoDato.VOID), linea, columna);
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object valorPosX = posX.interpretar(arbol, tabla);
        if (valorPosX instanceof Errores) return valorPosX;

        Object valorPosY = posY.interpretar(arbol, tabla);
        if (valorPosY instanceof Errores) return valorPosY;

        Object valorAncho = ancho.interpretar(arbol, tabla);
        if (valorAncho instanceof Errores) return valorAncho;

        Object valorAlto = alto.interpretar(arbol, tabla);
        if (valorAlto instanceof Errores) return valorAlto;

        if (!(valorPosX instanceof Integer) || !(valorPosY instanceof Integer) || !(valorAncho instanceof Integer) || !(valorAlto instanceof Integer)) {
            return new Errores("SEMANTICO", "Los valores de posición, ancho y alto deben ser enteros", this.linea, this.columna);
        }

        int x = (int) valorPosX;
        int y = (int) valorPosY;
        int ancho = (int) valorAncho;
        int alto = (int) valorAlto;

        graficarRectangulo(nombre, x, y, ancho, alto, color);

        return null;
    }

    private void graficarRectangulo(String nombre, int x, int y, int ancho, int alto, String color) {
        System.out.println("Graficando rectangulo '" + nombre + "' en (" + x + ", " + y + ") con ancho " + ancho + ", alto " + alto + " y color " + color);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Graficar Rectángulo: " + nombre);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new DibujarRectangulo(x, y, ancho, alto, color));
            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }

    private static class DibujarRectangulo extends JPanel {
        private int x;
        private int y;
        private int ancho;
        private int alto;
        private Color color;

        public DibujarRectangulo(int x, int y, int ancho, int alto, String color) {
            this.x = x;
            this.y = y;
            this.ancho = ancho;
            this.alto = alto;
            this.color = parseColor(color);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.fillRect(x - ancho / 2, y - alto / 2, ancho, alto);
        }

        private Color parseColor(String color) {
            switch (color.toLowerCase()) {
                case "azul":
                    return Color.BLUE;
                case "rojo":
                    return Color.RED;
                case "amarillo":
                    return Color.YELLOW;
                case "verde":
                    return Color.GREEN;
                default:
                    return Color.BLACK;
            }
        }
    }
}
