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
public class GraficarPoligono extends Instruccion {

    private String nombre;
    private Instruccion posX;
    private Instruccion posY;
    private Instruccion cantidadLados;
    private Instruccion ancho;
    private Instruccion alto;
    private String color;

    // Constructor
    public GraficarPoligono(String nombre, Instruccion posX, Instruccion posY, Instruccion cantidadLados, Instruccion ancho, Instruccion alto, String color, int linea, int columna) {
        super(new Tipo(TipoDato.VOID), linea, columna);
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.cantidadLados = cantidadLados;
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

        Object valorCantidadLados = cantidadLados.interpretar(arbol, tabla);
        if (valorCantidadLados instanceof Errores) return valorCantidadLados;

        Object valorAncho = ancho.interpretar(arbol, tabla);
        if (valorAncho instanceof Errores) return valorAncho;

        Object valorAlto = alto.interpretar(arbol, tabla);
        if (valorAlto instanceof Errores) return valorAlto;

        if (!(valorPosX instanceof Integer) || !(valorPosY instanceof Integer) || !(valorCantidadLados instanceof Integer) || !(valorAncho instanceof Integer) || !(valorAlto instanceof Integer)) {
            return new Errores("SEMANTICO", "Los valores de posición, cantidad de lados, ancho y alto deben ser enteros", this.linea, this.columna);
        }

        int x = (int) valorPosX;
        int y = (int) valorPosY;
        int lados = (int) valorCantidadLados;
        int ancho = (int) valorAncho;
        int alto = (int) valorAlto;

        graficarPoligono(nombre, x, y, lados, ancho, alto, color);

        return null;
    }

    private void graficarPoligono(String nombre, int x, int y, int lados, int ancho, int alto, String color) {
        System.out.println("Graficando poligono '" + nombre + "' en (" + x + ", " + y + "), con (" + lados + " lados, Ancho " + ancho + " alto " + alto + ")" + " y color " + color);            
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Graficar Polígono: " + nombre);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new DibujarPoligono(x, y, lados, ancho, alto, color));
            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }

    private static class DibujarPoligono extends JPanel {
        private int x;
        private int y;
        private int lados;
        private int ancho;
        private int alto;
        private Color color;

        public DibujarPoligono(int x, int y, int lados, int ancho, int alto, String color) {
            this.x = x;
            this.y = y;
            this.lados = lados;
            this.ancho = ancho;
            this.alto = alto;
            this.color = parseColor(color);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);

            int[] xPoints = new int[lados];
            int[] yPoints = new int[lados];

            double angle = 2 * Math.PI / lados;
            for (int i = 0; i < lados; i++) {
                xPoints[i] = (int) (x + ancho * Math.cos(i * angle));
                yPoints[i] = (int) (y + alto * Math.sin(i * angle));
            }

            g.fillPolygon(xPoints, yPoints, lados);
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
