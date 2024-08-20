package com.geometric.grafico;

import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author vicente
 */
public class Animador {

    private ArrayList<Runnable> animacionesPendientes;
    private static Animador instance;

    private Animador() {
        this.animacionesPendientes = new ArrayList<>();
    }

    public static Animador getInstance() {
        if (instance == null) {
            instance = new Animador();
        }
        return instance;
    }

    public void guardarAnimacion(Figura figura, String tipoAnimacion, int destinoX, int destinoY, int orden) {
        Runnable animacion = () -> {
            switch (tipoAnimacion.toLowerCase()) {
                case "linea":
                    animarLinea(figura, destinoX, destinoY, orden);
                    break;
                case "curva":
                    animarCurva(figura, destinoX, destinoY, orden);
                    break;
                default:
                    System.out.println("Tipo de animación no reconocido: " + tipoAnimacion);
                    break;
            }
        };
        animacionesPendientes.add(animacion);
    }

    public void ejecutarAnimaciones() {
        Principal principal = Principal.getInstance();
        PanelDibujo panelDibujo = principal.getPanelDibujo();

        // Crear un temporizador para ejecutar animaciones en orden
        Timer timer = new Timer(0, e -> {
            if (!animacionesPendientes.isEmpty()) {
                Runnable animacion = animacionesPendientes.remove(0);
                animacion.run();
            } else {
                ((Timer) e.getSource()).stop();
            }
            panelDibujo.repaint();
        });
        timer.start();
    }

    private void animarLinea(Figura figura, int destinoX, int destinoY, int orden) {
        Timer timer = new Timer(orden, e -> {
            int dx = Integer.compare(destinoX, figura.getX());
            int dy = Integer.compare(destinoY, figura.getY());

            if (dx == 0 && dy == 0) {
                ((Timer) e.getSource()).stop();
            } else {
                figura.mover(dx, dy);
                Principal.getInstance().getPanelDibujo().repaint();
            }
        });
        timer.start();
    }

    private void animarCurva(Figura figura, int destinoX, int destinoY, int orden) {
        int startX = figura.getX();
        int startY = figura.getY();
        int controlX = (startX + destinoX) / 2;
        int controlY = Math.min(startY, destinoY) - Math.abs(destinoY - startY) / 2;


        final int interval = 20;

        final long duration = orden * 1000; // Duración total basada en el valor de orden

        // Tiempo de inicio
        final long startTime = System.currentTimeMillis();

        Timer timer = new Timer(interval, e -> {
            long elapsed = System.currentTimeMillis() - startTime;
            float t = Math.min(elapsed / (float) duration, 1);

            if (t >= 1) {
                ((Timer) e.getSource()).stop();
                figura.setX(destinoX);
                figura.setY(destinoY);
                Principal.getInstance().getPanelDibujo().repaint();
            } else {
                float u = 1 - t;
                int x = (int) (Math.pow(u, 2) * startX
                        + 2 * u * t * controlX
                        + Math.pow(t, 2) * destinoX);
                int y = (int) (Math.pow(u, 2) * startY
                        + 2 * u * t * controlY
                        + Math.pow(t, 2) * destinoY);
                figura.setX(x);
                figura.setY(y);
                Principal.getInstance().getPanelDibujo().repaint();
            }
        });

        timer.start();
    }
}
