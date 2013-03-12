/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00;

/**
 *
 * @author janik
 */
public class VykonavacZober implements IVykonavac {

    @Override
    public boolean vykonaj(String paParameter, Hrac paHrac) {
        if (paParameter == null) {
            System.out.println("Co chces zobrat?");
        } else {
            paHrac.zober(paParameter);
        }
        
        return false;
    }
    
}
