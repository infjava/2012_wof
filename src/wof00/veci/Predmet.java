/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.veci;

import wof00.hra.Hrac;
import wof00.vynimky.PredmetSaNedaPouzitException;

/**
 *
 * @author janik
 */
public class Predmet implements IVec {

    private final String aNazov;
    private final String aPopis;

    public Predmet(String paNazov, String paPopis) {
        this.aNazov = paNazov;
        this.aPopis = paPopis;
    }

    @Override
    public String dajNazov() {
        return aNazov;
    }

    @Override
    public String dajPopis(Hrac paHrac) {
        return aPopis;
    }

    @Override
    public void pouzi(String paParameter, Hrac paHrac)
            throws PredmetSaNedaPouzitException {
        throw new PredmetSaNedaPouzitException("Predmet " + aNazov + " sa neda pouzit!");
    }
}
