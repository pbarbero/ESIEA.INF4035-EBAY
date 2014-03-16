/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.SysUser;

import Modele.SysEnchere.Enchere;
import Modele.SysEnchere.Offre;

/**
 *
 * @author ETD-P\boulkrinat
 */
public class Acheteur extends Utilisateur {
    
    
    public void EmettreOffre(Offre o, Enchere e){
        if(e.isPublication() && !listEnchere.contains(e) && o.getPrix()>e.getPrixMinimum()){ //L'annonce est-elle publiée et l'acheteur est-il le propriétaire de cette annonce et le prix de l'offre est-elle bien supérieur au prix minimum?
            //voir si c'est possible d'utiliser les exceptions plutot...pour message d'erreurs personnalisés.
            e.getListOffre().add(o);
        }
    }
    
}
