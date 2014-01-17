/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package isep.fsiap.galvanometro.file_io;

import isep.fsiap.galvanometro.business.BusinessModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Lopes <1070912@isep.ipp.pt>
 */
public class LoadBinFile {
    
    private ObjectInputStream inf;
    
    
    /**
     * abre o ficheiro
     *
     * @param file o ficheiro a abrir
     */
    public void openFile(String file) {

        try {
            inf = new ObjectInputStream(new FileInputStream(file));

        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Não foi possivel abrir o ficheiro "
                    + file + ".", "Erro Input/Output", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    /**
     * carrega o objecto BusinessModel do ficheiro
     * @return BusinessModel
     */
    public BusinessModel loadBusinessModelFromFile(){
        BusinessModel b = new BusinessModel();
         try {
          b = (BusinessModel)  inf.readObject();
          
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Não foi possivel escrever no ficheiro.",
                    "Erro Input/Output", JOptionPane.ERROR_MESSAGE);
           
        } catch (ClassNotFoundException cnfe){
             JOptionPane.showMessageDialog(null, "Classe não encontrada.",
                    "Erro Input/Output", JOptionPane.ERROR_MESSAGE);
        }
         return b;
    }
   
/**
 * fecha o ficheiro
 */
    public void closeFile() {
        try {
            if (inf != null) {
                
                inf.close();
            }
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Não foi possivel fechar o ficheiro."
                    , "Erro Input/Output", JOptionPane.ERROR_MESSAGE);
           
        }
    }
    
    
}
