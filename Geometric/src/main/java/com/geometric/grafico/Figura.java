package com.geometric.grafico;

import java.awt.Graphics;

/**
 *
 * @author vicente
 */
public interface Figura {
    void dibujar(Graphics g);
    void mover(int dx, int dy);
    
    int getX(); 
    int getY(); 
    void setX(int x); 
    void setY(int y);
}
