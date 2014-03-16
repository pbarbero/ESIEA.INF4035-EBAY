/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.SysEnchere;

import Modele.SysUser.Vendeur;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ETD-P\boulkrinat
 */
public class Enchere {
    
   private boolean publication=false;  //mettre une enum ici.  
   private Objet objet;
   private Date dateLimite;
   private float prixMinimum;
   private float prixMaximum;
   private float prixReserve;
   private ArrayList<Offre> listOffre;

  
   
   public Enchere(Objet objet,Date dateLimite){
       
       this.objet=objet;
       this.dateLimite=dateLimite;
   }
   
   public void publier(){
   
           this.publication=true;
            
}

   public void retirer(){

            this.publication=false;

}
   
   
   //les setter et getter. A voir avec la visibilité (public, private) si ya pas moyen de simplifier
   public void setPrixMaximum(float prixMaximum) {
        this.prixMaximum = prixMaximum;
    }

    public void setPrixMinimum(float prixMinimum) {
        this.prixMinimum = prixMinimum;
    }
    
    public void setPrixReserve(float prixReserve) {
        this.prixReserve = prixReserve;
    }
    
    
    public boolean isPublication() {
            return publication;
    }
    
     public ArrayList<Offre> getListOffre() {
        return listOffre;
    }

    public void setListOffre(ArrayList<Offre> listOffre) {
        this.listOffre = listOffre;
    }
    
     public float getPrixMaximum() {
        return prixMaximum;
    }

    public float getPrixMinimum() {
        return prixMinimum;
    }

    public float getPrixReserve() {
        return prixReserve;
    }

      
     
}
