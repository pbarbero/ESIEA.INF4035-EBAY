package Modele.SysAlerting;

import java.util.ArrayList;

public class AlertOffreSurEnchere implements Observable {
	
	//Classe represantant : Une alerte automatique est ajout�e sur une ench�re pour pr�venir le vendeur d�s qu'une offre est faite sur son ench�re.
   
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
