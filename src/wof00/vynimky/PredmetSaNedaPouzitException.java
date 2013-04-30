/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.vynimky;

/**
 *
 * @author janik
 */
public class PredmetSaNedaPouzitException extends Exception {

    /**
     * Creates a new instance of
     * <code>PredmetSaNedaPouzitException</code> without detail message.
     */
    public PredmetSaNedaPouzitException() {
    }

    /**
     * Constructs an instance of
     * <code>PredmetSaNedaPouzitException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public PredmetSaNedaPouzitException(String msg) {
        super(msg);
    }
}
