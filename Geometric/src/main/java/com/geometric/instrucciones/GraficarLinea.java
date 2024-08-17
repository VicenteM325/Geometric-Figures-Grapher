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
public class GraficarLinea extends Instruccion {

    private String nombre;
    private Instruccion posX1;
    private Instruccion posY1;
    private Instruccion posX2;
    private Instruccion posY2;
    private String color;

    // Constructor
    public GraficarLinea(String nombre, Instruccion posX1, Instruccion posY1, Instruccion posX2, Instruccion posY2, String color, int linea, int columna) {
        super(new Tipo(TipoDato.VOID), linea, columna);
        this.nombre = nombre;
        this.posX1 = posX1;
        this.posY1 = posY1;
        this.posX2 = posX2;
        this.posY2 = posY2;
        this.color = color;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object valorPosX1 = posX1.interpretar(arbol, tabla);
        if (valorPosX1 instanceof Errores) return valorPosX1;

        Object valorPosY1 = posY1.interpretar(arbol, tabla);
        if (valorPosY1 instanceof Errores) return valorPosY1;

        Object valorPosX2 = posX2.interpretar(arbol, tabla);
        if (valorPosX2 instanceof Errores) return valorPosX2;

        Object valorPosY2 = posY2.interpretar(arbol, tabla);
        if (valorPosY2 instanceof Errores) return valorPosY2;

        if (!(valorPosX1 instanceof Integer) || !(valorPosY1 instanceof Integer) || !(valorPosX2 instanceof Integer) || !(valorPosY2 instanceof Integer)) {
            return new Errores("SEMANTICO", "Los valores de posición deben ser enteros", this.linea, this.columna);
        }

        int x1 = (int) valorPosX1;
        int y1 = (int) valorPosY1;
        int x2 = (int) valorPosX2;
        int y2 = (int) valorPosY2;

        graficarLinea(nombre, x1, y1, x2, y2, color);

        return null;
    }

    private void graficarLinea(String nombre, int x1, int y1, int x2, int y2, String color) {
        System.out.println("Graficando linea '" + nombre + "' en P1(" + x1 + ", " + y1 + "), P2(" + x2 + ", " + y2 + ")" + " y color " + color);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Graficar Línea: " + nombre);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new DibujarLinea(x1, y1, x2, y2, color));
            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }

    private static class DibujarLinea extends JPanel {
        private int x1;
        private int y1;
        private int x2;
        private int y2;
        private Color color;

        public DibujarLinea(int x1, int y1, int x2, int y2, String color) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = parseColor(color);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.drawLine(x1, y1, x2, y2);
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
