/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.veci;

import wof00.base.IPouzitelny;
import wof00.hra.Hrac;

/**
 *
 * @author janik
 */
public interface IVec extends IPouzitelny {
    public String dajNazov();
    public String dajPopis(Hrac paHrac);
}
