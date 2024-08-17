package com.geometric.instrucciones;

import com.geometric.abstracto.Instruccion;
import com.geometric.excepciones.Errores;
import com.geometric.simbolo.Arbol;
import com.geometric.simbolo.TablaSimbolos;
import com.geometric.simbolo.Tipo;
import com.geometric.simbolo.TipoDato;

/**
 *
 * @author vicente
 */
public class Print extends Instruccion {
    private Instruccion expresion;

    public Print(Instruccion expresion, int linea, int columna) {
        super(new Tipo(TipoDato.VOID), linea, columna);
        this.expresion = expresion;
    }

    @Override
    public Object interpretar(Arbol arbol, TablaSimbolos tabla) {
        var resultado = this.expresion.interpretar(arbol, tabla);
        if(resultado instanceof Errores){
            return resultado;
        }
        arbol.Print(resultado.toString());
        return null;
    }
    
    
    
}
