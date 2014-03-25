/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.SysEnchere;

import Modele.Exceptions.NoPubliedException;
import Modele.Exceptions.MustBePositive;
import Modele.SysUser.Vendeur;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import Modele.SysAlerting.Alert;
import Modele.SysAlerting.Observable;
import Modele.SysAlerting.Observer;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ETD-P\boulkrinat-simon-barbero
 */
public class Enchere implements  Observable{
    
   


   private boolean publication=false;  //mettre une enum ici.  
   private Objet objet;
   private Date dateLimite;

    public Date getDateLimite() {
        return dateLimite;
    }
   private float prixMinimum;
   private float prixMaximum;
   private float prixReserve;
   private ArrayList<Offre> listOffre;
   private Map<Observer,List<Alert>> listObserver;

  
   
   public Enchere(Objet objet,Date dateLimite){
	   
       this.objet=objet;
       this.dateLimite=dateLimite;
       this.listObserver=new HashMap<Observer,List<Alert>>();
       this.listOffre=new ArrayList<Offre>();
      
   }

   
   public void retirer(){
	  
            this.publication=false;
            
            this.notifierObservateurs(Alert.AlertEnchereAnnulee); //on previens que une enchere a ete annulee
            
}
   
   
   //les setter et getter. A voir avec la visibilité (public, private) si ya pas moyen de simplifier

   public void addToObserverList(Map<Observer,List<Alert>> map, Observer key, Alert value)
   {
   List<Alert> valeursExistants=map.get(key);
   if(valeursExistants==null){
       valeursExistants=new ArrayList<Alert>();
       map.put(key,valeursExistants);
   }
   valeursExistants.add(value);
   //usage addToObserverList(listObserver,(Observer)o,Alert...)
   }
   
   public boolean removeToObserverList(Map<Observer,List<Alert>>map,Observer key, Alert value){
   List<Alert> valeursExistants=map.get(key);
   if(valeursExistants != null){
       return valeursExistants.remove(value);
   }
   return false;
   //usage removeToObserverList(listObserver,(Observer)o, Alert...)
   }
   
   public void setPublication(boolean publication) {
	this.publication = publication;
   }
   
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
   
     public Map<Observer, List<Alert>> getListObserver() {
        return listObserver;
    }
   

     public void ajouterOffre(Offre o) {
        
    	 notifierObservateurs(Alert.AlertOffreSuperieur); //prevenir que une offre est faite
    	 
    	 if(o.getPrix()>=this.prixReserve) //si le prix est superieu au prix de reserve, on lance une alerte aux observateurs
    	 {
    		 notifierObservateurs(Alert.AlertPrixDeReserveAtteint);
    		 
    	 }
    	  
    	 for(int i=0;i<listOffre.size();i++){ //on va verifier dans la liste des offres si le prix de l offre est inferieur a l offre ajoute
    		 if(o.getPrix()>listOffre.get(i).getPrix()){
    			 notifierObservateurs(Alert.AlertOffreSuperieur);
    		 }
    	 }
         
    
    	 listOffre.add(o);
         	 
    	
    	 

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
    
    public Objet getObjet() {
		return objet;
	}


	  @Override
	    public void ajouterObservateur(Observer o, Alert a) {
	        listObserver.put(o,a); //ajouter un observer pour un type d'alert
	    }

	    @Override
	    public void supprimerObservateur(Observer o,Alert a) {
	    	
	    		
	    		removeToObserverList(listObserver,o,a);
	    		 
	    }


		@Override
		public void notifierObservateurs(Alert a) {
			for (Observer key : listObserver.keySet()) { //iterator??
	    		
	  		  if(listObserver.get(key) == a){
	  			  
	  			  key.rafraichir(this,a);
	  		  }
	  		  //System.out.println("key: " + key + " value: " + map.get(key));
	  		}
			
		}


 

	

      
     
}
