/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.fsiap.galvanometro.file_io;


import isep.fsiap.galvanometro.business.BusinessModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Operações com ficheiros binários
 *
 * @author Daniel Lopes <1070912@isep.ipp.pt>
 */
public class SaveBinFile {

    private ObjectOutputStream outf;

    public SaveBinFile() {
    }
    
    
    
    /**
     * abre o ficheiro
     *
     * @param file o ficheiro a abrir
     */
    public void openFile(String file) {

        try {
            outf = new ObjectOutputStream(new FileOutputStream(file));

        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Não foi possivel abrir o ficheiro "
                    + file + ".", "Erro Input/Output", JOptionPane.ERROR_MESSAGE);
        }
    }
public void addBusinessModelToFile(BusinessModel b){
      try {
            outf.writeObject((Object) b);
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Não foi possivel escrever no ficheiro.",
                    "Erro Input/Output", JOptionPane.ERROR_MESSAGE);
           
        }
}
    /**
     * adiciona os objectos ao ficheiro
     *
     * @param o
     */
    public void addArrayListToFile(ArrayList o) {
        try {
            outf.writeObject(o);
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Não foi possivel escrever no ficheiro.",
                    "Erro Input/Output", JOptionPane.ERROR_MESSAGE);
           
        }
    }

    public void closeFile() {
        try {
            if (outf != null) {
                outf.close();
            }
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Não foi possivel fechar o ficheiro."
                    , "Erro Input/Output", JOptionPane.ERROR_MESSAGE);
           
        }
    }
}
