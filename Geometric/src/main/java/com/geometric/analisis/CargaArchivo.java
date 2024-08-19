
package com.geometric.analisis;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextArea;


/**
 *
 * @author vicente
 */
public class CargaArchivo {
    public ArrayList<String> leerFichero(File archivo, JTextArea textArea) throws FileNotFoundException, IOException {
        ArrayList<String> lineas = new ArrayList<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;

        textArea.setText(""); // Limpia el contenido existente del JTextArea

        while ((linea = br.readLine()) != null) {
            lineas.add(linea);
            textArea.append(linea + "\n"); // Agrega la línea al JTextArea
        }

        fr.close();
        return lineas;
    }
}
