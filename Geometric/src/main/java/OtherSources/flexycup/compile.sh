#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar ~/NetBeansProjects/Geometric-Figures-Grapher/Geometric/lib/jflex-full-1.9.1.jar -d ../../../../../src/main/java/com/geometric/analisis/ Lexico.jflex

echo "STARTING CUP COMPILING"
java -jar ~/NetBeansProjects/Geometric-Figures-Grapher/Geometric/lib/java-cup-11b.jar -parser Sintactico Sintactico.cup
mv Sintactico.java ../../../../../src/main/java/com/geometric/analisis/Sintactico.java
mv sym.java ../../../../../src/main/java/com/geometric/analisis/sym.java

