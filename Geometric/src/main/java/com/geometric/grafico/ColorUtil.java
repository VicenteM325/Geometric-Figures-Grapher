package com.geometric.grafico;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class ColorUtil {
    private static final Map<String, String> colorNames = new HashMap<>();

    static {
        colorNames.put("verde", "#00FF00");
        colorNames.put("rojo", "#FF0000");
        colorNames.put("azul", "#0000FF");
        colorNames.put("amarillo", "#FFD300");
        colorNames.put("rosado", "#FFC0CB");
        colorNames.put("celeste", "#87CEEB");
        colorNames.put("gris", "#808080");
        colorNames.put("negro", "#000000");
        colorNames.put("anaranjado", "#FFA500");
        
        
    }

    public static Color getColorFromName(String colorName) {
        String hex = colorNames.get(colorName.toLowerCase());
        if (hex != null) {
            return Color.decode(hex);
        } else {
            throw new IllegalArgumentException("Nombre de color no reconocido: " + colorName);
        }
    }
}