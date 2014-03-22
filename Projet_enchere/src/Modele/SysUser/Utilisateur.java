/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.SysUser;

import Modele.Exceptions.NoPubliedException;
import Modele.Exceptions.MustBePositive;
import Modele.SysEnchere.*;
import java.util.ArrayList;
/**
 *
 * @author ETD-P\boulkrinat-simon-barbero
 */
public abstract class Utilisateur {
    
    String nom;
    String prenom;
    String login;
    ArrayList <Enchere>listEnchere;
    ArrayList <Enchere>listOffre;
    
    public Utilisateur(String nom, String prenom, String login, 
    		ArrayList<Enchere> listEnchere) {
    	this.nom = nom;
    	this.prenom = prenom;
    	this.login = login;
    	this.listEnchere = listEnchere;
    	//this.listOffre = listOffre;
    	
    	
    }
    
    
}
