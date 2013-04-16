/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.questy;

import wof00.hra.Hrac;
import wof00.veci.IVec;
import wof00.veci.Kluc;

/**
 *
 * @author janik
 */
public class ZiskanieKluca extends Quest {
    @Override
    public String toString() {
        return "Ziskaj kluc od nejakej ucebne";
    }

    @Override
    public void hracZobralPredmet(IVec paPredmet) {
        if (paPredmet instanceof Kluc && this.dajStav() == StavQuestu.zadany) {
            System.out.println("ziskal si kluc a splnil quest");
            this.nastavStav(StavQuestu.ukonceny);
        }
    }
}
