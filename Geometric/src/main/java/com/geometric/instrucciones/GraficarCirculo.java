package com.geometric.instrucciones;

import com.geometric.abstracto.Instruccion;
import com.geometric.excepciones.Errores;
import com.geometric.simbolo.Arbol;
import com.geometric.simbolo.TablaSimbolos;
import com.geometric.simbolo.Tipo;
import com.geometric.simbolo.TipoDato;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 *
 * @author vicente
 */
public class GraficarCirculo extends Instruccion {

    private String nombre;
    private Instruccion posX;
    private Instruccion posY;
    private Instruccion radio;
    private String color;

    // Constructor
    public GraficarCirculo(String nombre, Instruccion posX, Instruccion posY, Instruccion radio, String color, int linea, int columna) {
        super(new Tipo(TipoDato.VOID), linea, columna);  // No necesitamos un tipo específico aquí
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.radio = radio;
        this.color = color;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        // Interpretar las expresiones de posición y radio
        Object valorPosX = posX.interpretar(arbol, tabla);
        if (valorPosX instanceof Errores) return valorPosX;

        Object valorPosY = posY.interpretar(arbol, tabla);
        if (valorPosY instanceof Errores) return valorPosY;

        Object valorRadio = radio.interpretar(arbol, tabla);
        if (valorRadio instanceof Errores) return valorRadio;

        // Verificar que los valores interpretados sean números enteros
        if (!(valorPosX instanceof Integer) || !(valorPosY instanceof Integer) || !(valorRadio instanceof Integer)) {
            return new Errores("SEMANTICO", "Los valores de posición y radio deben ser enteros", this.linea, this.columna);
        }

        // Convertir a int
        int x = (int) valorPosX;
        int y = (int) valorPosY;
        int r = (int) valorRadio;

        // Lógica para graficar el círculo
        graficarCirculo(nombre, x, y, r, color);

        return null; // No hay un valor de retorno en esta instrucción
    }

    private void graficarCirculo(String nombre, int x, int y, int radio, String color) {
        System.out.println("Graficando círculo '" + nombre + "' en (" + x + ", " + y + ") con radio " + radio + " y color " + color);
        // Crear y mostrar la ventana gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Graficar Círculo: " + nombre);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new DibujarCirculo(x, y, radio, color));
            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }

    // Clase interna para dibujar el círculo
    private static class DibujarCirculo extends JPanel {
        private int x;
        private int y;
        private int radio;
        private Color color;

        public DibujarCirculo(int x, int y, int radio, String color) {
            this.x = x;
            this.y = y;
            this.radio = radio;
            this.color = parseColor(color);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.fillOval(x - radio, y - radio, 2 * radio, 2 * radio);
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
                    return Color.BLACK;  // Color por defecto si el color no es reconocido
            }
        }
    }
}