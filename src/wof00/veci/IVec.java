/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.veci;

import hra.Hrac;

/**
 *
 * @author janik
 */
public interface IVec {
    public String dajNazov();
    public String dajPopis(Hrac paHrac);
    public boolean pouzi(String paParameter, Hrac paHrac);
}
