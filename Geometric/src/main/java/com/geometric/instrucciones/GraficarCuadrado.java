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
public class GraficarCuadrado extends Instruccion {

    private String nombre;
    private Instruccion posX;
    private Instruccion posY;
    private Instruccion tamano;
    private String color;

    // Constructor
    public GraficarCuadrado(String nombre, Instruccion posX, Instruccion posY, Instruccion tamano, String color, int linea, int columna) {
        super(new Tipo(TipoDato.VOID), linea, columna);
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.tamano = tamano;
        this.color = color;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object valorPosX = posX.interpretar(arbol, tabla);
        if (valorPosX instanceof Errores) return valorPosX;

        Object valorPosY = posY.interpretar(arbol, tabla);
        if (valorPosY instanceof Errores) return valorPosY;

        Object valorTamano = tamano.interpretar(arbol, tabla);
        if (valorTamano instanceof Errores) return valorTamano;

        if (!(valorPosX instanceof Integer) || !(valorPosY instanceof Integer) || !(valorTamano instanceof Integer)) {
            return new Errores("SEMANTICO", "Los valores de posición y tamaño deben ser enteros", this.linea, this.columna);
        }

        int x = (int) valorPosX;
        int y = (int) valorPosY;
        int tam = (int) valorTamano;

        graficarCuadrado(nombre, x, y, tam, color);

        return null;
    }

    private void graficarCuadrado(String nombre, int x, int y, int tamano, String color) {
        System.out.println("Graficando cuadrado '" + nombre + "' en (" + x + ", " + y + ") con tamaño " + tamano + " y color " + color);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Graficar Cuadrado: " + nombre);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new DibujarCuadrado(x, y, tamano, color));
            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }

    private static class DibujarCuadrado extends JPanel {
        private int x;
        private int y;
        private int tamano;
        private Color color;

        public DibujarCuadrado(int x, int y, int tamano, String color) {
            this.x = x;
            this.y = y;
            this.tamano = tamano;
            this.color = parseColor(color);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.fillRect(x - tamano / 2, y - tamano / 2, tamano, tamano);
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
