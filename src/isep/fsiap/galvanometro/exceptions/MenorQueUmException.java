/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package isep.fsiap.galvanometro.exceptions;

/**
 *
 * @author Daniel Lopes <1070912@isep.ipp.pt>
 */
public class MenorQueUmException extends Exception {

    /**
     * Creates a new instance of <code>MenorQueUmException</code> without detail
     * message.
     */
    public MenorQueUmException() {
    }

    /**
     * Constructs an instance of <code>MenorQueUmException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MenorQueUmException(String msg) {
        super(msg);
    }
}
