package com.geometric.Exportar;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author vicente
 */
public class ExportarImagen {
     public static void exportarPanelComoPNG(JPanel panel) {
        // Crear el JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar imagen como PNG");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PNG Image", "png"));

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            // Asegurarse de que el archivo tenga la extensión .png
            if (!archivo.getAbsolutePath().endsWith(".png")) {
                archivo = new File(archivo.getAbsolutePath() + ".png");
            }

            int width = panel.getWidth();
            int height = panel.getHeight();
            BufferedImage imagen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics g = imagen.createGraphics();
            panel.paint(g);
            g.dispose();

            try {
                ImageIO.write(imagen, "PNG", archivo);
                JOptionPane.showMessageDialog(null, "Imagen exportada a " + archivo.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al exportar la imagen.");
            }
        }
    }
    
}
