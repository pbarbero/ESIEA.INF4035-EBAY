/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.SysUser;

import Modele.Exceptions.NoPubliedException;
import Modele.Exceptions.MustBePositive;
import Modele.SysAlerting.Alert;
import Modele.SysAlerting.Observable;
import Modele.SysAlerting.Observer;
import Modele.SysEnchere.Enchere;
import Modele.SysEnchere.EtatEnchere;
import Modele.SysEnchere.Objet;
import Modele.SysEnchere.Offre;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ETD-P\boulkrinat-simon-barbero
 */
public class Vendeur extends Utilisateur implements Observer{
  
    private Map<Observer,Alert> listObserver;
 
    
    public Vendeur(String nom,String prenom,String login,ArrayList <Enchere>listEnchere,ArrayList <Offre>listOffre)
    {
		super(nom, prenom,login,listEnchere,listOffre);
	
        listObserver=new HashMap<Observer,Alert>();

    }
    
    /*public void creerEnchere(Objet objet,int identifiant, String description, Date dateLimite){
        listEnchere.add(new Enchere(objet,dateLimite));
    }
     A garder pour les tests?? */
    
     public void creerEnchere(Enchere e) throws NullPointerException{
        if(e!=null)
        {
                e.setPublication(EtatEnchere.CREE);//Enchere creee
        	listEnchere.add(e);
        }
        else
        	throw new NullPointerException();
        
       
    }   
     
    
    public void publierEnchere(int i){
    
    	listEnchere.get(i).setPublication(EtatEnchere.PUBLIE);
    }
    
     public void retirerEnchere(int i) throws NoPubliedException{
    //EXCEPTION
         //exception : you can't "retirer" if the "enchere" is not "publié" 
        if(!(listEnchere.get(i).getPublication()==EtatEnchere.PUBLIE)){
	  throw new NoPubliedException("The enchere is not publied");}
	  
        listEnchere.get(i).setPublication(EtatEnchere.ANNULE);
        listEnchere.get(i).retirer();
             
    }
     

	public void mettrePrixMaximum(int i, float prix) throws MustBePositive {
         if(prix <= 0){throw new MustBePositive("Prix Maximum must be positive");}
         
         listEnchere.get(i).setPrixMaximum(prix); 
     }
     
     public void mettrePrixMinimum(int i, float prix) throws MustBePositive{
         //EXCEPTION
         //exception : it must be > 0
         if(prix <= 0){throw new MustBePositive("Prix Minimum must be positive");}
         listEnchere.get(i).setPrixMinimum(prix); 
     }
     
     public void mettrePrixReserve(int i, float prix) throws MustBePositive{
         //EXCEPTION      
         //exception : it must be > 0
         if(prix <= 0){throw new MustBePositive("Prix Reserve must be positive");}
        listEnchere.get(i).setPrixReserve(prix);
     
     }
     
     public float voirPrixDeReserve(int i) throws Exception{ 
         if(listEnchere.get(i).getPrixReserve()==0.0f){throw new Exception("PrixDeReserve does not exist");}
         return listEnchere.get(i).getPrixReserve();
     }

	@Override
	public void rafraichir(Observable o, Alert a) {
	switch(a){
	case AlertOffreSurEnchere :
		System.out.println("une offre est faite sur votre Enchere sur l objet: " + ((Enchere)o).getObjet().identifiant);
	 break;


	default: 
		
	}
		
	}

  
    

	

	

	
}
