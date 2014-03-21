/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.SysUser;

import Modele.SysAlerting.Alert;
import Modele.SysAlerting.AlertEnchereAnnulee;
import Modele.SysAlerting.AlertOffreSuperieur;
import Modele.SysAlerting.AlertOffreSurEnchere;
import Modele.SysAlerting.AlertPrixDeReserveAtteint;
import Modele.SysAlerting.Observable;
import Modele.SysAlerting.Observer;
import Modele.SysEnchere.Enchere;
import Modele.SysEnchere.Offre;


/**
 *
 * @author ETD-P\boulkrinat
 */
public class Acheteur extends Utilisateur implements Observer{
//rajouter un observer???    
    
    public void EmettreOffre(Offre o, Enchere e){
        //EXCEPTION
        //exception : thinking about it
        if(e.isPublication() && !listEnchere.contains(e) && o.getPrix()>e.getPrixMinimum()){ //L'annonce est-elle publi√©e et l'acheteur est-il le propri√©taire de cette annonce et le prix de l'offre est-elle bien sup√©rieur au prix minimum?
            //voir si c'est possible d'utiliser les exceptions plutot...pour message d'erreurs personnalis√©s.
            e.getListOffre().add(o);
        }
    }
    
    public void desactiverAlert(Alert a){
    	//Pour dÈsactiver une alerte

    	
    	
    }
	@Override
	public void rafraichir(Observable o) {
		 if(o instanceof AlertOffreSuperieur) 
         {      
			  
			  System.out.println("Une offre avec un prix supÈrieur ÈtÈ faite par ");//completer
                 
         }  
		 else  if(o instanceof AlertPrixDeReserveAtteint) 
         {      
			  
			  System.out.println("Prix de reserve atteint par ");//completer
                 
         }  
		 
		 else if(o instanceof AlertEnchereAnnulee) 
         {      
			  
			 System.out.println("Enchere sur l'objet"+((AlertEnchereAnnulee)o).getE().getObjet().identifiant+"a ete annulee par "+);//completer   
         }  
		 
		
	}

   

   
    
}
