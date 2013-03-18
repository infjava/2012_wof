/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00;

/**
 *
 * @author janik
 */
public class VykonavacPouzi implements IVykonavac {

    @Override
    public boolean vykonaj(String paParameter, Hrac paHrac) {
        String[] parametre = paParameter.split("->", 2);
        String nazovPredmetu = parametre[0];
        String parameter = null;
        
        if (parametre.length > 1) {
            parameter = parametre[1];
        }
        
//        Predmet predmet = paHrac.dajPredmet(nazovPredmetu);
//        
//        return predmet.pouzi(parameter, paHrac);
        
        return paHrac.pouziPredmet(nazovPredmetu, parameter);
    }
    
}
