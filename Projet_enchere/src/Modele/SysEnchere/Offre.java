/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.SysEnchere;

import java.util.ArrayList;

import Modele.SysAlerting.Observable;
import Modele.SysAlerting.Observer;
import Modele.SysUser.Acheteur;

/**
 *
 * @author ETD-P\boulkrinat-simon-barbero
 */
public class Offre {
    private Acheteur acheteur;
    private float prix;
  
    private ArrayList<Observer> listObserver;
    
    public Offre(Acheteur acheteur,float prix){
        
        this.acheteur=acheteur;
        this.prix=prix;
    }

    public float getPrix() {
        return prix;
    }

	public Acheteur getAcheteur() {
		return acheteur;
	}

	

    
}
