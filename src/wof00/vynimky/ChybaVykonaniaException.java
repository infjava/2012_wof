/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.vynimky;

/**
 *
 * @author janik
 */
public class ChybaVykonaniaException extends Exception {

    /**
     * Creates a new instance of
     * <code>ChybaVykonaniaException</code> without detail message.
     */
    public ChybaVykonaniaException() {
    }

    /**
     * Constructs an instance of
     * <code>ChybaVykonaniaException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ChybaVykonaniaException(String msg) {
        super(msg);
    }

    public ChybaVykonaniaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChybaVykonaniaException(Throwable cause) {
        super(cause);
    }
    
    
}
