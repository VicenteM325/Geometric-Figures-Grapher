package com.geometric.analisis;

//importaciones

import java_cup.runtime.Symbol;
import java.util.LinkedList;
import com.geometric.excepciones.Errores;

%%

//Codigo usuario
%{
     public LinkedList<Errores> listaErrores = new LinkedList<>();
%}

%init{
    yyline = 1;
    yycolumn = 1;
    listaErrores = new LinkedList<>();
%init}

%cup
%class scanner
%public
%line
%char
%column
%full
%ignorecase


PAR_A= "("
PAR_C=")"
MAS="+"
MENOS="-"
MULTIPLICACION="*"
DIVISION="/"
COMA=","
BLANCOS=[\  \r\t\f\n]+
ENTERO=[0-9]+
DECIMAL=[0-9]+"."[0-9]+
ID=[a-zA-z][a-zA-Z0-9_]*

//Palabras reservadas
     //colores
     AZUL = "azul"
     ROJO = "rojo"
     AMARILLO = "amarillo"
     VERDE ="verde"
     ROSADO="rosado"
     CELESTE="celeste"
    GRIS="gris"
    NEGRO="negro"
    ANARANJADO="anaranjado"
    
    //Instruccion
    OBJETO = "objeto"
    ANTERIOR="anterior"
    GRAFICAR = "graficar"
    CIRCULO = "circulo"
    CUADRADO = "cuadrado"
    RECTANGULO = "rectangulo"
    LINEA = "linea"
    POLIGONO = "poligono"

     //Tipos de animacion
     ANIMAR = "animar"
     CURVA = "curva" 

%%
<YYINITIAL> {GRAFICAR} {return new Symbol(sym.GRAFICAR, yyline, yycolumn,yytext()); }
<YYINITIAL> {ANIMAR} {return new Symbol(sym.ANIMAR, yyline, yycolumn,yytext()); }
<YYINITIAL> {CURVA} {return new Symbol(sym.CURVA, yyline, yycolumn,yytext()); }
<YYINITIAL> {OBJETO} {return new Symbol(sym.OBJETO, yyline, yycolumn,yytext()); }
<YYINITIAL> {ANTERIOR} {return new Symbol(sym.ANTERIOR, yyline, yycolumn,yytext()); }
<YYINITIAL> {CIRCULO} {return new Symbol(sym.CIRCULO, yyline, yycolumn,yytext()); }
<YYINITIAL> {CUADRADO} {return new Symbol(sym.CUADRADO, yyline, yycolumn,yytext()); }
<YYINITIAL> {RECTANGULO} {return new Symbol(sym.RECTANGULO, yyline, yycolumn,yytext()); }
<YYINITIAL> {LINEA} {return new Symbol(sym.LINEA, yyline, yycolumn,yytext()); }
<YYINITIAL> {POLIGONO} {return new Symbol(sym.POLIGONO, yyline, yycolumn,yytext()); }

<YYINITIAL> {AZUL} {return new Symbol(sym.AZUL, yyline, yycolumn,yytext()); }
<YYINITIAL> {ROJO} {return new Symbol(sym.ROJO, yyline, yycolumn,yytext()); }
<YYINITIAL> {AMARILLO} {return new Symbol(sym.AMARILLO, yyline, yycolumn,yytext()); }
<YYINITIAL> {VERDE} {return new Symbol(sym.VERDE, yyline, yycolumn,yytext()); }
<YYINITIAL> {ROSADO} {return new Symbol(sym.ROSADO, yyline, yycolumn,yytext()); }
<YYINITIAL> {CELESTE} {return new Symbol(sym.CELESTE, yyline, yycolumn,yytext()); }
<YYINITIAL> {GRIS} {return new Symbol(sym.GRIS, yyline, yycolumn,yytext()); }
<YYINITIAL> {NEGRO} {return new Symbol(sym.NEGRO, yyline, yycolumn,yytext()); }
<YYINITIAL> {ANARANJADO} {return new Symbol(sym.ANARANJADO, yyline, yycolumn,yytext()); }

<YYINITIAL> {ID} {return new Symbol(sym.ID, yyline, yycolumn, yytext());}

<YYINITIAL> {DECIMAL} {return new Symbol(sym.DECIMAL, yyline, yycolumn,yytext()); }
<YYINITIAL> {ENTERO} {return new Symbol(sym.ENTERO, yyline, yycolumn,yytext()); }

<YYINITIAL> {COMA} {return new Symbol(sym.COMA, yyline, yycolumn,yytext()); }
<YYINITIAL> {PAR_A} {return new Symbol(sym.PAR_A, yyline, yycolumn,yytext()); }
<YYINITIAL> {PAR_C} {return new Symbol(sym.PAR_C, yyline, yycolumn,yytext()); }

<YYINITIAL> {MAS} {return new Symbol(sym.MAS, yyline, yycolumn,yytext()); }
<YYINITIAL> {MENOS} {return new Symbol(sym.MENOS, yyline, yycolumn,yytext()); }
<YYINITIAL> {MULTIPLICACION} {return new Symbol(sym.MULTIPLICACION, yyline, yycolumn,yytext()); }
<YYINITIAL> {DIVISION} {return new Symbol(sym.DIVISION, yyline, yycolumn,yytext()); }

<YYINITIAL> {BLANCOS} { }

<YYINITIAL> . { /* Manejo de errores */ 
    System.err.println("Caracter no reconocido: " + yytext() + " en la línea " + yyline + " columna " + yycolumn);
    listaErrores.add(new Errores("LEXICO","El caracter "+
                yytext() + " no pertenece al lenguaje ", yyline, yycolumn));
}