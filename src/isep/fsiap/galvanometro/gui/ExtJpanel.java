/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.fsiap.galvanometro.gui;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Daniel Lopes <1070912@isep.ipp.pt>
 */
public class ExtJpanel extends JPanel {

    // private Image agulha;
    //  private Double angAnt;
    Agulha agulha = new Agulha();

    public ExtJpanel() {
        super();

    }

    /**
     * incializa a agulha do galvanómetro
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
       agulha.pintarAgulha(g);
    }

 

    /**
     * desenha nova linha de acordo com a inclinação dada
     *
     * @param ang angulo de inclinação
     */
    public void inclinarAgulha(double ang) {
        agulha.getPosi()[0] = agulha.getPosf()[0];
        agulha.getPosi()[1] = agulha.getPosf()[1];

        ang += Math.PI / 2;
        agulha.getPosf()[0] = (int) (agulha.getBase()[0] + agulha.getComp() * Math.cos(ang));
        agulha.getPosf()[1] = (int) (agulha.getBase()[1] - agulha.getComp() * Math.sin(ang));
        repaint();

    }

}
