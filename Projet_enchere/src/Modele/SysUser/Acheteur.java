/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.SysUser;

import java.util.ArrayList;

import Modele.Exceptions.*;
import Modele.SysAlerting.Alert;
import Modele.SysAlerting.Observable;
import Modele.SysAlerting.Observer;
import Modele.SysEnchere.Enchere;
import Modele.SysEnchere.Offre;


/**
 *
 * @author ETD-P\boulkrinat-simon-barbero
 */
public class Acheteur extends Utilisateur implements Observer{
//rajouter un observer???    
    
	public Acheteur(String nom,String prenom,String login,ArrayList <Enchere>listEnchere,ArrayList <Offre>listOffre)
	{
		super(nom, prenom,login,listEnchere,listOffre);
	}
	
    public void EmettreOffre(Offre o, Enchere e){
        //EXCEPTION
        //exception : thinking about it
        if(e.isPublication() && !listEnchere.contains(e) && o.getPrix()>e.getPrixMinimum()){ //L'annonce est-elle publiée et l'acheteur est-il le propriétaire de cette annonce et le prix de l'offre est-elle bien supérieur au prix minimum?
            //voir si c'est possible d'utiliser les exceptions plutot...pour message d'erreurs personnalisés.
           
            e.ajouterOffre(o);
        }
    }
    
    public void desactiverAlert(Alert a, Enchere e){
    	//Pour d�sactiver une alerte 
        for (Observer key : e.getListObserver().keySet()) { //iterator??
	    		
	  		  if(e.getListObserver().get(key) == a){
	  			  
	  			  e.getListObserver().remove(key);
	  		  }
	  		}
        
        
    	
    }

    
	@Override
	public void rafraichir(Observable o, Alert a) {
		switch (a) {

		case AlertPrixDeReserveAtteint:
			System.out.println("Le prix de r�serve a ete atteint sur l enchere de l objet " + ((Enchere)o).getObjet().identifiant );
			
		 break;

		case AlertEnchereAnnulee :
			System.out.println("enchere annulee sur l'objet : " + ((Enchere)o).getObjet().identifiant);
		 break;
		 
		case AlertOffreSuperieur :
			System.out.println("offre superieur sur l'objet : " + ((Enchere)o).getObjet().identifiant);
		 break;


		default: 
			System.out.println("Alerte non destinee");
		}
		
	}
    
}
