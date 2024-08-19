package com.geometric.instrucciones;

import com.geometric.abstracto.Instruccion;
import com.geometric.excepciones.Errores;
import com.geometric.grafico.Figura;
import com.geometric.grafico.Principal;
import com.geometric.simbolo.Arbol;
import com.geometric.simbolo.TablaSimbolos;
import com.geometric.simbolo.Tipo;
import com.geometric.simbolo.TipoDato;
import javax.swing.Timer;

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


        // Obtener la última figura agregada
        Figura figura = Principal.getInstance().getUltimaFigura();
        if (figura == null) {
            System.out.println("No hay figura para animar.");
            System.out.println("Última figura agregada: " + Principal.getInstance().getUltimaFigura());
            return null;
        }

        // Implementar la lógica para animar la figura
        switch (tipoAnimacion.toLowerCase()) {
            case "linea":
                animarLinea(figura, destinoX, destinoY, orden);
                break;
            case "curva":
                animarCurva(figura, destinoX, destinoY, orden);
                break;
            default:
                System.out.println("Tipo de animación no reconocido: " + tipoAnimacion);
                return null;
        }

        return null;
    }

    private void animarLinea(Figura figura, int destinoX, int destinoY, int orden) {
        Timer timer = new Timer(orden, e -> {
            int dx = Integer.compare(destinoX, figura.getX());
            int dy = Integer.compare(destinoY, figura.getY());

            if (dx == 0 && dy == 0) {
                ((Timer) e.getSource()).stop(); // Detener la animación
            } else {
                figura.mover(dx, dy);
                Principal.getInstance().getPanelDibujo().repaint();
            }
        });
        timer.start();
    }

    private void animarCurva(Figura figura, int destinoX, int destinoY, int orden) {
        Timer timer = new Timer(orden, e -> {
            int dx = Integer.compare(destinoX, figura.getX());
            int dy = Integer.compare(destinoY, figura.getY());

            if (dx == 0 && dy == 0) {
                ((Timer) e.getSource()).stop(); // Detener la animación
            } else {
                figura.mover(dx * 2, dy * 2); // Ajustar el movimiento para simular una curva
                Principal.getInstance().getPanelDibujo().repaint();
            }
        });
        timer.start();
    }
}
