/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.SysAlerting;




/**
 *
 * @author ETD-P\boulkrinat-simon-barbero
 */
public interface Observer {
    //rafraichissement lorsqu'une nouvelle alerte est mise en place ! A voir avec publication
      public void rafraichir(Observable o, Alert a);

    
}
