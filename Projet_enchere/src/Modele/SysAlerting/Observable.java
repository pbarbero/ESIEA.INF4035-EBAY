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
        public void ajouterObservateur(Observer o, Alert a);
        // Supprimer un observer
        public void supprimerObservateur(Observer o,Alert a);
        // Notifier tous les observer lors d'un changement d'état en fonction d'une alerte
        public void notifierObservateurs(Alert a);
    
}
