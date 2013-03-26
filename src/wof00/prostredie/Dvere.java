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
class Dvere implements IDvere {
    private final Miestnost aMiestnost;

    public Dvere(Miestnost paMiestnost) {
        this.aMiestnost = paMiestnost;
    }

    @Override
    public String dajNazov() {
        return aMiestnost.dajNazov();
    }

    @Override
    public Miestnost dajMiestnost() {
        return aMiestnost;
    }

    @Override
    public IDvere vytvorPodobne(Miestnost paMiestnost) {
        return new Dvere(paMiestnost);
    }

    @Override
    public boolean suZamknute() {
        return false;
    }

    @Override
    public void presielCezVas(Hrac paHrac) {
        
    }
    
}
