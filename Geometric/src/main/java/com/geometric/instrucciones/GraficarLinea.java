package com.geometric.instrucciones;

import com.geometric.abstracto.Instruccion;
import com.geometric.excepciones.Errores;
import com.geometric.grafico.ColorUtil;
import com.geometric.grafico.Linea;
import com.geometric.grafico.Principal;
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
        
    // Interpretar las expresiones para las coordenadas x1, y1, x2, y2
    Object valorX1 = posX1.interpretar(arbol, tabla);
    if (valorX1 instanceof Errores) return valorX1;

    Object valorY1 = posY1.interpretar(arbol, tabla);
    if (valorY1 instanceof Errores) return valorY1;

    Object valorX2 = posX2.interpretar(arbol, tabla);
    if (valorX2 instanceof Errores) return valorX2;

    Object valorY2 = posY2.interpretar(arbol, tabla);
    if (valorY2 instanceof Errores) return valorY2;

    // Valida que todas las coordenadas sean enteros
    if (!(valorX1 instanceof Integer) || !(valorY1 instanceof Integer) || !(valorX2 instanceof Integer) || !(valorY2 instanceof Integer)) {
        return new Errores("SEMANTICO", "Las coordenadas de la línea deben ser enteros", this.linea, this.columna);
    }

    int x1 = (int) valorX1;
    int y1 = (int) valorY1;
    int x2 = (int) valorX2;
    int y2 = (int) valorY2;

        Color colorFigura;
        System.out.println("Graficando figura: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Posición: P1(" + x1 + ", " + y1 + ") P2(" + x2 + ", " + y2 + ")");
        System.out.println("Color: " + color);
        try {
            colorFigura = ColorUtil.getColorFromName(color);
        } catch (IllegalArgumentException e) {
            return new Errores("SEMANTICO", e.getMessage(), this.linea, this.columna);
        }

    Principal principal = Principal.getInstance();
    principal.getPanelDibujo().agregarFigura(new Linea(nombre, x1, y1, x2, y2, colorFigura));

    return null;
}
}
