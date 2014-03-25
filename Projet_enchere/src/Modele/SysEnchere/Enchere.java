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
    
   


   private EtatEnchere publication;  
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
       //prix de base obligatoire pour n'importe quelle enchere (aucun => -1)
       this.prixMinimum=-1;
       this.prixMaximum=-1;
       this.prixReserve=-1;
      
   }

   
   public void retirer(){
	  
           
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
   
   public void setPublication(EtatEnchere publication) {
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
    

    public EtatEnchere getPublication() {
            return publication;
    }
    
     public ArrayList<Offre> getListOffre() {
        return listOffre;
    }
   
     public Map<Observer, List<Alert>> getListObserver() {
        return listObserver;
    }
   

     public void ajouterOffre(Offre o) {
    	
    	 if(this.prixReserve!=-1&&o.getPrix()>=this.prixReserve) //si le prix est superieur au prix de reserve (et que le prix de reserve existe donc != -1), on lance une alerte aux observateurs
    	 {
          
    		 notifierObservateurs(Alert.AlertPrixDeReserveAtteint);
    		 
    	 }
    	  
    	 if(!listOffre.isEmpty()&&o.getPrix()>getPrixMaximumListOffre()){ //si il y a eu au moins une offre
    			 notifierObservateurs(Alert.AlertOffreSuperieur);
    		 }
    	 
         
         notifierObservateurs(Alert.AlertOffreSurEnchere); //notifier vendeur qu une offre est faite sur son annonce
    	 listOffre.add(o);
   
     }
    
    public float getPrixMaximumListOffre() { //change to Collections.max...
        float prixMax=0;
        for(int i=0;i<listOffre.size();i++){
            for(int j=i;j<listOffre.size();j++){
                if(listOffre.get(i).getPrix()>listOffre.get(j).getPrix()){
                    prixMax=listOffre.get(i).getPrix();
                }
            }
        }
        return prixMax; 
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
	       addToObserverList(listObserver,o,a); //ajouter un observer pour un type d'alert
	    }

	    @Override
	    public void supprimerObservateur(Observer o,Alert a) {
	    	
	    		
	    		removeToObserverList(listObserver,o,a);
	    		 
	    }


		@Override
		public void notifierObservateurs(Alert a) {
			for (Observer key : listObserver.keySet()) { //iterator??
	    		
	  		  if(listObserver.get(key).contains(a)){
	  			  
	  			  key.rafraichir(this,a);
	  		  }
	  		}
			
		}


 

	

      
     
}
