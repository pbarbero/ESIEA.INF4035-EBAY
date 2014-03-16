/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.SysUser;

import Modele.SysEnchere.Enchere;
import Modele.SysEnchere.Objet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ETD-P\boulkrinat
 */
public class Vendeur extends Utilisateur {
  
   
    
    
    public Vendeur(){
     
        
    }
    
    /*public void creerEnchere(Objet objet,int identifiant, String description, Date dateLimite){
        listEnchere.add(new Enchere(objet,dateLimite));
    }
     A garder pour les tests?? */
    
     public void creerEnchere(Enchere e){
        listEnchere.add(e);
    }
   
     
    
    public void publierEnchere(int i){
    
        listEnchere.get(i).publier();
    }
    
     public void retirerEnchere(int i){
    
        listEnchere.get(i).retirer();
    }
     
     public void mettrePrixMaximum(int i, float prix){
         
         listEnchere.get(i).setPrixMaximum(prix); 
     }
     
     public void mettrePrixMinimum(int i, float prix){
         
         listEnchere.get(i).setPrixMinimum(prix); 
     }
     
     public void mettrePrixReserve(int i, float prix){
         
        listEnchere.get(i).setPrixReserve(prix);
     
     }
     
     public void voirPrixDeReserve(int i){
         
         listEnchere.get(i).getPrixReserve();
     }
    
    
}
