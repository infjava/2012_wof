/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prostredie;

import wof00.hra.Hrac;

/**
 *
 * @author janik
 */
public interface IDvere {

    public String dajNazov();
    public Miestnost dajMiestnost();
    public IDvere vytvorPodobne(Miestnost paMiestnost);
    public boolean suZamknute();
    public void presielCezVas(Hrac paHrac);
}
