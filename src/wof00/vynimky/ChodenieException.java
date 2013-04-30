/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.vynimky;

/**
 *
 * @author janik
 */
public abstract class ChodenieException extends Exception {

    /**
     * Creates a new instance of
     * <code>ChodenieException</code> without detail message.
     */
    public ChodenieException() {
    }

    /**
     * Constructs an instance of
     * <code>ChodenieException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ChodenieException(String msg) {
        super(msg);
    }
}
