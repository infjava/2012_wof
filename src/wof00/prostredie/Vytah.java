/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prostredie;

import java.util.ArrayList;
import wof00.base.IPouzitelny;
import wof00.hra.Hrac;

/**
 *
 * @author janik
 */
public class Vytah extends Miestnost implements IPouzitelny {
    private ArrayList<IDvereNaKluc> aVychody;
    // poschodie - index v zozname vychodov
    private int aPoschodie;
    private int aSmer;
    
    
    public Vytah(String paNazov, String paPopis) {
        super(paNazov, paPopis);
        
        aVychody = new ArrayList<IDvereNaKluc>();
        
        aPoschodie = 1;
        aSmer = 1;
    }

    public void pridajPoschodie(Miestnost paMiestnost) {
        IDvereNaKluc dvere = new DvereZamykatelne(paMiestnost);
        
        aVychody.add(dvere);
        if (aVychody.size() == aPoschodie + 1) {
            dvere.odomkniZamkni();
        }
        
        dvere.dajMiestnost()
            .nastavVychod(
                dvere.vytvorPodobne(this),
                false
            );
    }

    @Override
    protected void infoOMiestnostiVychody() {
        System.out.println("Vychody: " + aVychody.get(aPoschodie).dajNazov());
    }

    @Override
    public IDvere dajDvereVSmere(String paSmer) {
        final IDvere aktualnyVychod = aVychody.get(aPoschodie);
        
        if (aktualnyVychod.dajNazov().equals(paSmer)) {
            return aktualnyVychod;
        } else {
            return null;
        }
    }

    @Override
    public void pouzi(String paParameter, Hrac paHrac) {
        aVychody.get(aPoschodie).odomkniZamkni();
        
        if (aPoschodie == aVychody.size() - 1 || aPoschodie == 0) {
            aSmer = -aSmer;
        }
        
        aPoschodie+=aSmer;
        aVychody.get(aPoschodie).odomkniZamkni();
        
        this.infoOMiestnosti();
    }
}
