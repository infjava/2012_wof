/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.npc;

/**
 *
 * @author janik
 */
public class NPC {
    private final String aMeno;
    private final CastRozhovoru aRozhovor;

    public NPC(String paMeno, CastRozhovoru paRozhovor) {
        this.aMeno = paMeno;
        this.aRozhovor = paRozhovor;
    }

    public String dajMeno() {
        return aMeno;
    }

    public CastRozhovoru dajRozhovor() {
        return aRozhovor;
    }
}
