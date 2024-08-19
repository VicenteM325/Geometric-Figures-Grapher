package com.geometric.instrucciones;

import com.geometric.abstracto.Instruccion;
import com.geometric.excepciones.Errores;
import com.geometric.grafico.ColorUtil;
import com.geometric.grafico.Cuadrado;
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
        Object valorPosY = posY.interpretar(arbol, tabla);
        Object valorLado = tamano.interpretar(arbol, tabla);
        
        if (!(valorPosX instanceof Number) || !(valorPosY instanceof Number)
                || !(valorLado instanceof Number)) {
            return new Errores("SEMANTICO", "Los valores de posición, lado, y alto deben ser numéricos", this.linea, this.columna);
        }

        int x = ((Number) valorPosX).intValue();
        int y = ((Number) valorPosY).intValue();
        int l = ((Number) valorLado).intValue();


        Color colorFigura;
        System.out.println("Graficando figura: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Posición: (" + x + ", " + y + ")");
        System.out.println("Tamaño Lado: " + l);
        System.out.println("Color: " + color);
        try {
            colorFigura = ColorUtil.getColorFromName(color);
        } catch (IllegalArgumentException e) {
            return new Errores("SEMANTICO", e.getMessage(), this.linea, this.columna);
        }
        
        Principal principal = Principal.getInstance();
        principal.getPanelDibujo().agregarFigura(new Cuadrado(nombre, x, y, l, colorFigura));
        principal.agregarFiguraAlReporte("Cuadrado", color);

        return null;
    }
}
