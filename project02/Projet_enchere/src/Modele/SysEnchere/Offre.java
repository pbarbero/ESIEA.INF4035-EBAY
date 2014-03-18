/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.SysEnchere;

import Modele.SysUser.Acheteur;

/**
 *
 * @author ETD-P\boulkrinat
 */
public class Offre {
    private Acheteur a;
    private float prix;
    
    public Offre(Acheteur a,float prix){
        
        this.a=a;
        this.prix=prix;
    }

    public float getPrix() {
        return prix;
    }
    
    
}
