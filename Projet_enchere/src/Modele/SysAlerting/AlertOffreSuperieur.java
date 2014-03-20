package Modele.SysAlerting;

import java.util.ArrayList;

public class AlertOffreSuperieur implements Observable {
	
	//Classe represantant : Une offre supérieure à celle émise par l'acheteur a été émise par un autre acheteur.
	
    private ArrayList<Observer> listObserver;
    
	@Override
    public void ajouterObservateur(Observer o) {
        listObserver.add(o); //ajouter un observer
    }

    @Override
    public void supprimerObservateur(Observer o) {
       listObserver.remove(o); //supprimer un observer
    }

    @Override
    public void notifierObservateurs() { 
       for(int i=0;i<listObserver.size();i++)
                {
                        Observer o =  listObserver.get(i);
                        o.rafraichir(this); //pour chaque observer, on rafraichi l'information
                }
    }
}
