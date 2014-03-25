/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.SysOutils;

import Modele.SysEnchere.Enchere;
import java.util.Date;

/**
 *
 * @author ETD-P\boulkrinat-simon-barbero
 */
public class TimeManager {
    
    
    //Classe permettant de desactiver une enchere si la date limite est passee
    
    private Date future;
    public TimeManager(Date future){
        this.future=future; //date a laquelle on souhaite verifier si on a depasse la limite ou pas
    }
    
    public void verifierDate(Enchere e){
        if(future.after(e.getDateLimite())){
            e.retirer();
        }
    }
}
