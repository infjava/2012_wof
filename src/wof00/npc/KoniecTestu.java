/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.npc;

import wof00.hra.Hrac;

/**
 *
 * @author janik
 */
class KoniecTestu implements IStavRozhovoru {
    private final int aBody;
    private final IStavRozhovoru aDalsia;

    public KoniecTestu(int paBody, IStavRozhovoru paDalsia) {
        this.aBody = paBody;
        this.aDalsia = paDalsia;
    }

    @Override
    public String toString() {
        return "Koniec testu. Pocet bodov: " + aBody;
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
        
    }

    @Override
    public boolean jeKoncovy() {
        return true;
    }
}
