/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.questy;

import wof00.hra.Hrac;
import wof00.prostredie.Miestnost;
import wof00.veci.IVec;

/**
 *
 * @author janik
 */
public interface IQuest {
    public StavQuestu dajStav();
    public void hracVosielDoMiestnosti(Miestnost paMiestnost);
    public void hracZobralPredmet(IVec paPredmet);
    public void hracZahodilPredmet(IVec paPredmet);
    
    public void aktivujSa(Hrac paHrac);
    public void skontrolujRiesenie();
    public void ukonci();
}
