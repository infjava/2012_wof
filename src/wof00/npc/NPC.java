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
    private final IStavRozhovoru aRozhovor;

    public NPC(String paMeno, IStavRozhovoru paRozhovor) {
        this.aMeno = paMeno;
        this.aRozhovor = paRozhovor;
    }

    public String dajMeno() {
        return aMeno;
    }

    public IStavRozhovoru dajRozhovor() {
        return aRozhovor;
    }
}
