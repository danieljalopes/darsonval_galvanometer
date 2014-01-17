/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package isep.fsiap.galvanometro.file_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Lopes
 */
public class Export {
    
    
    Formatter outf;
    
    /**
     * abre o ficheiro
     * @param f ficheiro a usar
     */
    public void openFile(File f){
        try{
            outf = new Formatter(f);
            
            
        }catch (FileNotFoundException fe){
            JOptionPane.showMessageDialog(null,"Ficheiro não encontrado","Ficheiro não encontrado"
                    , JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * escreve no ficheiro
     * @param s 
     */
    public void addText(StringBuilder s){
        outf.format("%s", s.toString());
    }
    
    /**
     * fecha o ficheiro
     */
    public void close(){
        outf.flush();
        outf.close();
    }
}
