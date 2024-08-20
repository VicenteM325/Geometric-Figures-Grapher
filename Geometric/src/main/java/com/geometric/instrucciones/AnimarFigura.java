package com.geometric.instrucciones;

import com.geometric.abstracto.Instruccion;
import com.geometric.excepciones.Errores;
import com.geometric.grafico.Animador;
import com.geometric.grafico.Figura;
import com.geometric.grafico.Principal;
import com.geometric.simbolo.Arbol;
import com.geometric.simbolo.TablaSimbolos;
import com.geometric.simbolo.Tipo;
import com.geometric.simbolo.TipoDato;

/**
 *
 * @author vicente
 */
public class AnimarFigura extends Instruccion {
    private String tipoAnimacion;
    private Instruccion destinoX;
    private Instruccion destinoY;
    private Instruccion orden;

    public AnimarFigura(String tipoAnimacion, Instruccion destinoX, Instruccion destinoY, Instruccion orden, int linea, int columna) {
        super(new Tipo(TipoDato.VOID),linea, columna);
        this.tipoAnimacion = tipoAnimacion;
        this.destinoX = destinoX;
        this.destinoY = destinoY;
        this.orden = orden;
    }

    public String getTipoAnimacion() {
        return tipoAnimacion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        Object valorDestinoX = destinoX.interpretar(arbol, tabla);
        Object valorDestinoY = destinoY.interpretar(arbol, tabla);
        Object valorOrden = orden.interpretar(arbol, tabla);

        if (valorDestinoX instanceof Errores) return valorDestinoX;
        if (valorDestinoY instanceof Errores) return valorDestinoY;
        if (valorOrden instanceof Errores) return valorOrden;
        
        if (!(valorDestinoX instanceof Number) || !(valorDestinoY instanceof Number)
                || !(valorOrden instanceof Number)) {
            return new Errores("SEMANTICO", "Los valores de posición, lados, ancho y alto deben ser numéricos", this.linea, this.columna);
        }

        int destinoX = ((Number) valorDestinoX).intValue();
        int destinoY = ((Number) valorDestinoY).intValue();
        int orden = ((Number) valorOrden).intValue();


       Figura figura = Principal.getInstance().getUltimaFigura();
        if (figura == null) {
            System.out.println("No hay figura para animar.");
            return null;
        }

        Animador animador = Animador.getInstance();
        Principal principal = Principal.getInstance();
        animador.guardarAnimacion(figura, tipoAnimacion, destinoX, destinoY, orden);
        principal.agregarAnimacionAlReporte(tipoAnimacion);

        return null;
    }
 
}
