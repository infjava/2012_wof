/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.base;

import wof00.hra.Hrac;
import wof00.vynimky.PredmetSaNedaPouzitException;

/**
 *
 * @author janik
 */
public interface IPouzitelny {
    public void pouzi(String paParameter, Hrac paHrac)
            throws PredmetSaNedaPouzitException;
}
