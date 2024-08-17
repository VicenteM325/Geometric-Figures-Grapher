
package com.geometric;

import com.geometric.abstracto.Instruccion;
import com.geometric.analisis.Sintactico;
import com.geometric.analisis.scanner;
import com.geometric.grafico.Principal;
import com.geometric.simbolo.Arbol;
import com.geometric.simbolo.TablaSimbolos;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.LinkedList;

/**
 *
 * @author vicente
 */
public class Geometric {

    public static void main(String[] args) {
/*        try{
            String texto = "graficar poligono ( PoligA, 55*(1+1), 75, 8, 75, 50, VeRde) graficar cuadrado (cuad1, 30, 40, 15, azul) graficar poligono (poli1, 110, 120, 6, 25, 30, rojo)\n graficar linea (linea_Amarillo, 12 * 3 + 2, 15, 4 / 4, 50 * 1, azul)";
            scanner s = new scanner(new BufferedReader(new StringReader(texto)));
            Sintactico p = new Sintactico(s);
            var resultado = p.parse();
            var ast = new Arbol((LinkedList<Instruccion>)resultado.value);
            var tabla = new TablaSimbolos();
            tabla.setNombre("GLOBAL");
            ast.setConsola("");
            for(var a : ast.getInstrucciones()){
                var res = a.interpretar(ast, tabla);
            }
            System.out.println(ast.getConsola());
        
        }catch(Exception ex){
            System.out.println("Algo salió mal");
            System.out.println(ex);
        }*/
        Principal p = new Principal();
        p.setVisible(true);
    }
}
