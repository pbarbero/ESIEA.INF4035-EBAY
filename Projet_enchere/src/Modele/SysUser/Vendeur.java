/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.SysUser;

import Modele.SysAlerting.Alert;
import Modele.SysAlerting.Observable;
import Modele.SysAlerting.Observer;
import Modele.SysEnchere.Enchere;
import Modele.SysEnchere.Objet;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ETD-P\boulkrinat
 */
public class Vendeur extends Utilisateur implements Observer{
  
    private Map<Observer,Alert> listObserver;
    private ArrayList<Enchere> listEnchere;
    
    
    public Vendeur(){
      
     listObserver=new HashMap<Observer,Alert>();

    }
    
    /*public void creerEnchere(Objet objet,int identifiant, String description, Date dateLimite){
        listEnchere.add(new Enchere(objet,dateLimite));
    }
     A garder pour les tests?? */
    
     public void creerEnchere(Enchere e){
        listEnchere.add(e);
    }   
     
    
    public void publierEnchere(int i){
    
    	listEnchere.get(i).setPublication(true);;
    }
    
     public void retirerEnchere(int i) throws NoPubliedException{
    //EXCEPTION
         //exception : you can't "retirer" if the "enchere" is not "publié" 
        if(!listEnchere.get(i).isPublication()){
	  throw new NoPubliedException("The enchere is not publied");}
	  
        listEnchere.get(i).retirer();
             
    }
     

	public void mettrePrixMaximum(int i, float prix) throws MustBePositive {
         if(prix <= 0){throw new MustBepositive("Prix Maximum must be positive")}
         
         listEnchere.get(i).setPrixMaximum(prix); 
     }
     
     public void mettrePrixMinimum(int i, float prix){
         //EXCEPTION
         //exception : it must be > 0
         if(prix <= 0){throw new MustBepositive("Prix Minimum must be positive")}
         listEnchere.get(i).setPrixMinimum(prix); 
     }
     
     public void mettrePrixReserve(int i, float prix){
         //EXCEPTION      
         //exception : it must be > 0
         if(prix <= 0){throw new MustBepositive("Prix Reserve must be positive")}
        listEnchere.get(i).setPrixReserve(prix);
     
     }
     
     public void voirPrixDeReserve(int i) throws Exception{
         //EXCEPTION
      
         //exception :the "prix de reserve" must exist
         
         if(listEnchere.get(i).getPrixReserve()==null){throw new Exception("PrixDeReserve does not exist")}
         listEnchere.get(i).getPrixReserve();
     }

	@Override
	public void rafraichir(Observable o, Alert a) {
	switch(a){
	case AlertOffreSurEnchere :
		System.out.println("une offre est faite sur votre Enchere sur l objet: " + ((Enchere)o).getObjet().identifiant);
	 break;


	default: 
		System.out.println("Alerte non destinee");
	}
		
	}

  
    

	

	

	
}
