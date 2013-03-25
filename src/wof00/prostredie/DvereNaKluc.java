/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prostredie;

import hra.Hrac;

/**
 *
 * @author janik
 */
class DvereNaKluc implements IDvereNaKluc {
    private final Miestnost aMiestnost;
    private DvereNaKlucOpacne aOpacneDvere;
    private boolean aZamknute;

    public DvereNaKluc(Miestnost paMiestnost) {
        this.aMiestnost = paMiestnost;
        this.aOpacneDvere = null;
        this.aZamknute = true;
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
        if (aOpacneDvere == null) {
            aOpacneDvere = new DvereNaKlucOpacne(this, paMiestnost);
        }
        return aOpacneDvere;
    }

    @Override
    public boolean suZamknute() {
        return aZamknute;
    }

    @Override
    public void presielCezVas(Hrac paHrac) {
        
    }

    @Override
    public void odomkniZamkni() {
        aZamknute = !aZamknute;
    }
    
    @Override
    public IDvereNaKluc dajOpacne()
    {
        return aOpacneDvere;
    }
}
