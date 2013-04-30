/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.vynimky;

/**
 *
 * @author janik
 */
public class PredmetNieJeVInventariException extends Exception {

    /**
     * Creates a new instance of
     * <code>PredmetNieJeVInventariException</code> without detail message.
     */
    public PredmetNieJeVInventariException() {
    }

    /**
     * Constructs an instance of
     * <code>PredmetNieJeVInventariException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public PredmetNieJeVInventariException(String msg) {
        super(msg);
    }
}
