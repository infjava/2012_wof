/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prostredie;

import java.util.Timer;
import hra.Hrac;

/**
 *
 * @author janik
 */
public class DvereISIC implements IDvere {
    private Miestnost aMiestnost;
    private boolean aZamknute;
    
    public DvereISIC(Miestnost paMiestnost) {
        this.aMiestnost = paMiestnost;
        aZamknute = true;
    }

    public String dajNazov() {
        return aMiestnost.dajNazov();
    }

    public Miestnost dajMiestnost() {
        return aMiestnost;
    }
    
    public boolean suZamknute() {
        return aZamknute;
    }

    public IDvere vytvorPodobne(Miestnost paMiestnost) {
        return new Dvere(paMiestnost);
    }

    public void odomkniVychod() {
        aZamknute = false;
    }

    public void presielCezVas(Hrac paHrac) {
        aZamknute = true;
    }
}
