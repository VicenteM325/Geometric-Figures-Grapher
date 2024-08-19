package com.geometric.instrucciones;

import com.geometric.abstracto.Instruccion;
import com.geometric.excepciones.Errores;
import com.geometric.grafico.Circulo;
import com.geometric.grafico.ColorUtil;
import com.geometric.grafico.Principal;
import com.geometric.simbolo.Arbol;
import com.geometric.simbolo.TablaSimbolos;
import com.geometric.simbolo.Tipo;
import com.geometric.simbolo.TipoDato;

import java.awt.Color;



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

    public GraficarCirculo(String nombre, Instruccion posX, Instruccion posY, Instruccion radio, String color, int linea, int columna) {
        super(new Tipo(TipoDato.VOID), linea, columna);
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.radio = radio;
        this.color = color;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object valorPosX = posX.interpretar(arbol, tabla);
        if (valorPosX instanceof Errores) return valorPosX;

        Object valorPosY = posY.interpretar(arbol, tabla);
        if (valorPosY instanceof Errores) return valorPosY;

        Object valorRadio = radio.interpretar(arbol, tabla);
        if (valorRadio instanceof Errores) return valorRadio;

//        if (!(valorPosX instanceof Integer) || !(valorPosY instanceof Integer) || !(valorRadio instanceof Integer)) {
//            return new Errores("SEMANTICO", "Los valores de posición y radio deben ser enteros", this.linea, this.columna);
//        }
        if (!(valorPosX instanceof Number) || !(valorPosY instanceof Number)
                || !(valorRadio instanceof Number)) {
            return new Errores("SEMANTICO", "Los valores de posición, lados, ancho y alto deben ser numéricos", this.linea, this.columna);
        }

        int x = ((Number) valorPosX).intValue();
        int y = ((Number) valorPosY).intValue();
        int r = ((Number) valorRadio).intValue();
      

        System.out.println("Graficando figura: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Posición: (" + x + ", " + y + ")");
        System.out.println("Radio: " + r);
        System.out.println("Color: " + color);
        
        Color colorFigura;
        try {
            colorFigura = ColorUtil.getColorFromName(color);
        } catch (IllegalArgumentException e) {
            return new Errores("SEMANTICO", e.getMessage(), this.linea, this.columna);
        }

        Principal principal = Principal.getInstance();
        principal.getPanelDibujo().agregarFigura(new Circulo(nombre, x, y, r, colorFigura));
        principal.agregarFiguraAlReporte("Círculo", color);

        return null;
    }
}