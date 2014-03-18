/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.SysAlerting;

/**
 *
 * @author KEMS
 */
public interface Observable {
    
      // Ajouter un observer
        public void ajouterObservateur(Observer o);
        // Supprimer un observer
        public void supprimerObservateur(Observer o);
        // Notifier tous les observer lors d'un changement d'état
        public void notifierObservateurs();
    
}
