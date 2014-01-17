/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package isep.fsiap.galvanometro.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Daniel Lopes <1070912@isep.ipp.pt>
 */
public class JBackgroundPanel extends JPanel{
    /**
     * guarda a imagem
     */
    private BufferedImage img;
    
    private String fileName;
    
    /**
     * construtor por defeito
     */
    public JBackgroundPanel(){
       try {
          
      img = ImageIO.read(new File("./circuito_main_escala.png"));
    } catch(IOException e) {
           JOptionPane.showMessageDialog(null, "Ficheiro \"circuito_main_escala.png\" não encontrado.");
    }
  }
    /**
     * Construtor que selecciona a imagem
     * @param imgFile ficheiro a construir
     */
  public JBackgroundPanel(String imgFile){
      fileName = imgFile;
       try {
     URL imageurl = getClass().getResource(this.fileName);
      // File f  = new File(imageurl);

        img = ImageIO.read(imageurl);
    } catch(IOException e) {
        JOptionPane.showMessageDialog(null, "Ficheiro \" "
                + this.fileName.toString() + "\" não encontrado.");
    }   
  }
  
  /**
   * pinta o painel com a imagem escolhida
   * @param g 
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // paint the background image and scale it to fill the entire space
    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
  }
  
  /**
   * insere imagem como background do painel em tempo de execução
   * @param imgFile 
   */
  public void setBackground(String imgFile){
         try {
             this.fileName = imgFile;
     URL imageurl = getClass().getResource(fileName);
      // File f  = new File(imageurl);

        img = ImageIO.read(imageurl);
    } catch(IOException e) {
        JOptionPane.showMessageDialog(null, "Ficheiro \" "
                + imgFile.toString() + "\" não encontrado.");
    }   
         repaint();
  }
  public String getBackgroundFileName(){
      return this.fileName;
  }
    
}
