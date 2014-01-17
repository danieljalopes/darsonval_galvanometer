/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package isep.fsiap.galvanometro.exceptions;

/**
 *
 * @author Daniel Lopes
 */
public class GalvaOverFlowException extends Exception {
    /**
     * A menssagem a enviar
     */
    private String msg;
    /**
     * Creates a new instance of <code>GalvaOverFlowException</code> without
     * detail message.
     */
    public GalvaOverFlowException() {
    }

    /**
     * Constructs an instance of <code>GalvaOverFlowException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public GalvaOverFlowException(String msg) {
        super(msg);
        this.msg = msg;
    }
    @Override
    public String toString(){
        return msg;
    }
}
