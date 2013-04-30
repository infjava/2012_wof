/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import wof00.hra.Hrac;
import wof00.vynimky.ChybaVykonaniaException;
import wof00.vynimky.PredmetNieJeVInventariException;
import wof00.vynimky.PredmetSaNedaPouzitException;

/**
 *
 * @author janik
 */
public class VykonavacPouzi implements IVykonavac {

    @Override
    public void vykonaj(String paParameter, Hrac paHrac)
            throws ChybaVykonaniaException {
        String[] parametre = paParameter.split("->", 2);
        String nazovPredmetu = parametre[0].trim();
        String parameter = null;
        
        if (parametre.length > 1) {
            parameter = parametre[1].trim();
        }
        
        try {
            paHrac.pouzi(nazovPredmetu, parameter);
        } catch (PredmetNieJeVInventariException ex) {
            System.out.println(ex.getMessage());
            throw new ChybaVykonaniaException("Nepodarilo sa pouzit predmet", ex);
        } catch (PredmetSaNedaPouzitException ex) {
            System.out.println(ex.getMessage());
            throw new ChybaVykonaniaException("Nepodarilo sa pouzit predmet", ex);
        }
    }
    
    @Override
    public boolean maSaUkladat() {
        return true;
    }
}
