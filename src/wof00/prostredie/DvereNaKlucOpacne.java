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
class DvereNaKlucOpacne implements IDvereNaKluc {
    private final DvereNaKluc aDvere;
    private final Miestnost aMiestnost;

    public DvereNaKlucOpacne(DvereNaKluc paDvere, Miestnost paMiestnost) {
        this.aDvere = paDvere;
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
        return aDvere;
    }

    @Override
    public boolean suZamknute() {
        return aDvere.suZamknute();
    }

    @Override
    public void presielCezVas(Hrac paHrac) {
        
    }

    @Override
    public void odomkniZamkni() {
        aDvere.odomkniZamkni();
    }

    @Override
    public IDvereNaKluc dajOpacne() {
        return aDvere;
    }
    
}
