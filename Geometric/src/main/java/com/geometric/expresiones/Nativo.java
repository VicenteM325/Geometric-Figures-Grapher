package com.geometric.expresiones;

import com.geometric.abstracto.Instruccion;
import com.geometric.simbolo.Arbol;
import com.geometric.simbolo.TablaSimbolos;
import com.geometric.simbolo.Tipo;

/**
 *
 * @author vicente
 */
public class Nativo extends Instruccion {
    
    public Object valor;

    public Nativo(Object valor, Tipo tipo, int linea, int columna) {
        super(tipo, linea, columna);
        this.valor = valor;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        return this.valor;
    }

    
    
    
}
