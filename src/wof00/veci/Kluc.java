/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.veci;

import wof00.hra.Hrac;
import wof00.prostredie.IDvereNaKluc;
import wof00.prostredie.IDvere;
import wof00.prostredie.Miestnost;

/**
 *
 * @author janik
 */
public class Kluc implements IVec {

    private final IDvereNaKluc aDvere;

    public Kluc(IDvereNaKluc paDvere) {
        this.aDvere = paDvere;
    }

    @Override
    public String dajNazov() {
        return "kluc od " + aDvere.dajNazov();
    }

    @Override
    public String dajPopis(Hrac paHrac) {
        return "Odomykaju miestnost " + aDvere.dajNazov();
    }

    @Override
    public boolean pouzi(String paParameter, Hrac paHrac) {
        Miestnost miestnost = paHrac.dajAktualnuMiestnost();
        IDvere dvere = miestnost.dajDvereVSmere(aDvere.dajNazov());

        if (dvere != aDvere) {
            IDvereNaKluc opacne = aDvere.dajOpacne();
            dvere = miestnost.dajDvereVSmere(opacne.dajNazov());
            
            if (dvere != opacne) {
                return false;
            }
        }
        
        aDvere.odomkniZamkni();

        return false;
    }

    public IDvereNaKluc dajDvere() {
        return aDvere;
    }
}
