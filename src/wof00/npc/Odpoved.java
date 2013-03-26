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
    private final CastRozhovoru aCastRozhovoru;

    Odpoved(String paOdpoved, CastRozhovoru paCastRozhovoru) {
        this.aOdpoved = paOdpoved;
        this.aCastRozhovoru = paCastRozhovoru;
    }

    @Override
    public String toString() {
        return aOdpoved;
    }

    CastRozhovoru dajRozhovor() {
        return aCastRozhovoru;
    }
}
