/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.veci;

import wof00.hra.Hrac;
import wof00.prostredie.IDvere;
import wof00.prostredie.DvereISIC;

/**
 *
 * @author janik
 */
public class ISIC implements IVec {

    public ISIC() {
    }

    @Override
    public String dajNazov() {
        return "isic";
    }

    @Override
    public String dajPopis(Hrac paHrac) {
        return "ISIC hraca " + paHrac.dajMenoHraca();
    }

    @Override
    public void pouzi(String paSmer, Hrac paHrac) {
        IDvere dvere = paHrac.dajAktualnuMiestnost().dajDvereVSmere(paSmer);
        if (dvere instanceof DvereISIC) {
            DvereISIC vychod = (DvereISIC) dvere;

            if (vychod != null) {
                vychod.odomkniVychod();
            }
        }
    }
}
