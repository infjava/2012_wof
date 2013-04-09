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
public class Test implements IStavRozhovoru {
    private final TestovaOtazka aPrvaOtazka;
    private final String aUvod;

    public Test(String paUvod, TestovaOtazka paPrvaOtazka) {
        this.aPrvaOtazka = paPrvaOtazka;
        this.aUvod = paUvod;
    }

    @Override
    public String toString() {
        return aUvod;
    }
    
    @Override
    public IStavRozhovoru dajMoznost(int paMoznost) {
        return new TestovaOtazka(aPrvaOtazka, 0);
    }

    @Override
    public IStavRozhovoru dajNasledujuciStav() {
        return new TestovaOtazka(aPrvaOtazka, 0);
    }

    @Override
    public void vykonajAkciu(Hrac paHrac) {
        
    }

    @Override
    public boolean jeKoncovy() {
        return false;
    }
}
