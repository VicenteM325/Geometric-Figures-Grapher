package com.geometric.instrucciones;


import com.geometric.abstracto.Instruccion;
import com.geometric.excepciones.Errores;
import com.geometric.grafico.ColorUtil;
import com.geometric.grafico.Principal;
import com.geometric.grafico.Rectangulo;
import com.geometric.simbolo.Arbol;
import com.geometric.simbolo.TablaSimbolos;
import com.geometric.simbolo.Tipo;
import com.geometric.simbolo.TipoDato;

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
        Object valorPosY = posY.interpretar(arbol, tabla);
        Object valorAncho = ancho.interpretar(arbol, tabla);
        Object valorAlto = alto.interpretar(arbol, tabla);

        if (!(valorPosX instanceof Integer) || !(valorPosY instanceof Integer) || !(valorAncho instanceof Integer) || !(valorAlto instanceof Integer)) {
            return new Errores("SEMANTICO", "Los valores de posición, ancho y alto deben ser enteros", this.linea, this.columna);
        }

        int x = (int) valorPosX;
        int y = (int) valorPosY;
        int w = (int) valorAncho;
        int h = (int) valorAlto;
        
        System.out.println("Graficando figura: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Posición: (" + x + ", " + y + ")");
        System.out.println("Ancho: " + w);
        System.out.println("Alto: " + h);
        System.out.println("Color: " + color);
        
        Color colorFigura;
        try {
            colorFigura = ColorUtil.getColorFromName(color);
        } catch (IllegalArgumentException e) {
            return new Errores("SEMANTICO", e.getMessage(), this.linea, this.columna);
        }

        Principal principal = Principal.getInstance();
        principal.getPanelDibujo().agregarFigura(new Rectangulo(nombre, x, y, w, h, colorFigura));

        return null;
    }
}
