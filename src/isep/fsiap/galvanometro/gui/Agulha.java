/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.fsiap.galvanometro.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

/**
 *
 * @author Daniel Lopes
 */
public class Agulha implements Serializable {

    private int[] base;
    private int norma;
    private int[] posi;
    private int[] posf;

    public Agulha() {
        base = new int[2];
        norma = 140;

        posi = new int[2];
        posf = new int[2];
        base[0] = 313;
        base[1] = 180;

        posi[0] = 313;
        posi[1] = 40;

        posf[0] = 313;
        posf[1] = 40;
    }

    /**
     * @return the base
     */
    public int[] getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(int[] base) {
        this.base = base;
    }

    /**
     * @return the norma
     */
    public int getComp() {
        return norma;
    }

    /**
     * @param comp the norma to set
     */
    public void setComp(int comp) {
        this.norma = comp;
    }

    /**
     * @return the posi
     */
    public int[] getPosi() {
        return posi;
    }

    /**
     * @param posi the posi to set
     */
    public void setPosi(int[] posi) {
        this.posi = posi;
    }

    /**
     * @return the posf
     */
    public int[] getPosf() {
        return posf;
    }

    /**
     * @param posf the posf to set
     */
    public void setPosf(int[] posf) {
        this.posf = posf;
    }

    /**
     * pinta a agulha com as coordenadas nos campos
     *
     * @param g Graphics do painel
     */
    public void pintarAgulha(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        g2d.drawLine(this.getBase()[0], this.getBase()[1], this.getPosf()[0], this.getPosf()[1]);
        
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("base_x= " + String.valueOf(base[0]) + "\n").
                append("base_y= " + String.valueOf(base[1]) + "\n").
                append("comprimento = " + norma + "\n").
                append("posicao anteriorx = " + posi[0] + "\n").
                append("posicao anteriory = " + posi[1] + "\n").
                append("posicao actualx = " + posf[0] + "\n").
                append("posicao actualy = " + posf[1] + "\n");

        return s.toString();
    }
}
