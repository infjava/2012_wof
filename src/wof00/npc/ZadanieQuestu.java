/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.npc;

import wof00.hra.Hrac;
import wof00.questy.Quest;
import wof00.questy.StavQuestu;

/**
 *
 * @author janik
 */
public class ZadanieQuestu implements IStavRozhovoru {
    private final Quest aQuest;
    private final String aText;
    private final IStavRozhovoru aDalsia;

    public ZadanieQuestu(Quest paQuest, String paText, IStavRozhovoru paDalsia) {
        this.aQuest = paQuest;
        this.aText = paText;
        this.aDalsia = paDalsia;
    }

    @Override
    public String toString() {
        return aText;
    }

    @Override
    public IStavRozhovoru dajMoznost(int paMoznost) {
        return aDalsia;
    }

    @Override
    public IStavRozhovoru dajNasledujuciStav() {
        return aDalsia;
    }

    @Override
    public void vykonajAkciu(Hrac paHrac) {
        if (aQuest.dajStav() == StavQuestu.nezadany) {
            paHrac.zadajQuest(aQuest);
        } else {
            aQuest.skontrolujRiesenie();
            if (aQuest.dajStav() == StavQuestu.splneny) {
                aQuest.ukonci();
                System.out.println("Gratulujem ku prvej kradezi!");
            } else {
                System.out.println("Questy nevedieme!");
            }
        }
        
    }

    @Override
    public boolean jeKoncovy() {
        return false;
    }
    
}
