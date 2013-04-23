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
class DvereZamykatelne implements IDvereNaKluc {
    private final Miestnost aMiestnost;
    private DvereZamykatelneOpacne aOpacneDvere;
    private boolean aZamknute;

    public DvereZamykatelne(Miestnost paMiestnost) {
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
            aOpacneDvere = new DvereZamykatelneOpacne(this, paMiestnost);
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
