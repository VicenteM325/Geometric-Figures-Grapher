package com.geometric.abstracto;

import com.geometric.simbolo.Arbol;
import com.geometric.simbolo.TablaSimbolos;
import com.geometric.simbolo.Tipo;

/**
 *
 * @author vicente
 */
public abstract class Instruccion {
    
    public Tipo tipo;
    public int linea;
    public int columna;

    public Instruccion(Tipo tipo, int linea, int columna) {
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;
    }
    
    public abstract Object interpretar(Arbol arbol, TablaSimbolos tabla);
    
}
