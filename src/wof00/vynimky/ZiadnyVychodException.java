/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.vynimky;

/**
 *
 * @author janik
 */
public class ZiadnyVychodException extends ChodenieException {

    /**
     * Creates a new instance of
     * <code>ZiadnyVychodException</code> without detail message.
     */
    public ZiadnyVychodException() {
    }

    /**
     * Constructs an instance of
     * <code>ZiadnyVychodException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ZiadnyVychodException(String msg) {
        super(msg);
    }
}
