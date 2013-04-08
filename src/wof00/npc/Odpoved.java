/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.npc;

/**
 *
 * @author janik
 */
class Odpoved {
    private final String aOdpoved;
    private final IStavRozhovoru aCastRozhovoru;

    Odpoved(String paOdpoved, IStavRozhovoru paCastRozhovoru) {
        this.aOdpoved = paOdpoved;
        this.aCastRozhovoru = paCastRozhovoru;
    }

    @Override
    public String toString() {
        return aOdpoved;
    }

    IStavRozhovoru dajRozhovor() {
        return aCastRozhovoru;
    }
}
