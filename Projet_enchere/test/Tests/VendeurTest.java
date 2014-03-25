package Tests;

import Modele.Exceptions.MustBePositive;
import Modele.Exceptions.NoPubliedException;
import Modele.SysAlerting.Alert;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Modele.SysEnchere.Enchere;
import Modele.SysEnchere.EtatEnchere;
import Modele.SysEnchere.Objet;
import Modele.SysEnchere.Offre;
import Modele.SysUser.Acheteur;
import Modele.SysUser.Utilisateur;
import Modele.SysUser.Vendeur;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;

public class VendeurTest {
	
 
    Vendeur v;
    Acheteur a;
    Offre o1;
    Enchere e1;
  
	@Before
	public void setUp() throws Exception {
		      
            a=new Acheteur("jean", "piere", "jp20014",new ArrayList<Enchere>(),new ArrayList<Offre>());
            v= new Vendeur("david", "henry", "dadhenry",new ArrayList<Enchere>(),new ArrayList<Offre>());
            e1=new Enchere(new Objet(122188998, "Objet1"),new Date(2014,03,15));
            e1.ajouterObservateur(a, Alert.AlertOffreSurEnchere);
            e1.ajouterObservateur(a, Alert.AlertOffreSuperieur);
            e1.ajouterObservateur(a, Alert.AlertPrixDeReserveAtteint);
            e1.ajouterObservateur(a, Alert.AlertOffreSurEnchere);
            e1.ajouterObservateur(v, Alert.AlertOffreSurEnchere);
            o1=new Offre(a,699);
            a.getListOffre().add(o1);
          
           
	}
        
       

	@Test
	public void testCreerEnchere() {
             
                v.creerEnchere(e1); //Please replace v.getListEnchere().add(e1) to this in Tests.*
            
		Assert.assertNotNull(e1); //si l enchere a bien ete creee
                
                Assert.assertEquals(EtatEnchere.CREE, e1.getPublication()); //voir si l enchere a bien changee d etat
	}

	@Test
	public void testPublierEnchere() {
                v.creerEnchere(e1);//elle doit etre creee au prealable
                v.publierEnchere(0);
		Assert.assertEquals(EtatEnchere.PUBLIE,e1.getPublication());
	}

	@Test
	public void testRetirerEnchere() throws NoPubliedException {
		v.creerEnchere(e1); //elle doit etre creee au prealable
                v.publierEnchere(0); //et publiee au prealable avant d etre retirer
                v.retirerEnchere(0);
                Assert.assertEquals(EtatEnchere.ANNULE,e1.getPublication());
	
	}
        

	@Test
	public void testMettrePrixMaximum() {
             v.creerEnchere(e1);//elle doit etre creee au prealable
                
		try{
			v.mettrePrixMaximum(0,-10f);
			fail("Shouldn't reach this");
			
		}catch(MustBePositive e){System.err.println("Exception caught");}
	}

	@Test
	public void testMettrePrixMinimum() {
            v.creerEnchere(e1);//elle doit etre creee au prealable
               
		try{
			v.mettrePrixMaximum(0,-10f);
			fail("Shouldn't reach this");
			
		}catch(MustBePositive e){System.err.println("Exception caught");}
	}

	@Test
	public void testMettrePrixReserve() {
            v.creerEnchere(e1);//elle doit etre creee au prealable
               
		try{
			v.mettrePrixMaximum(0,-10f);
			fail("Shouldn't reach this");
			
		}catch(MustBePositive e){System.err.println("Exception caught");}
	}

	@Test
	public void testVoirPrixDeReserve() {
		v.creerEnchere(e1);//elle doit etre creee au prealable
               try{
			v.mettrePrixReserve(0,9);
			
			
		}catch(MustBePositive e){System.err.println("Exception caught");}
        try {
            Assert.assertEquals(9, v.voirPrixDeReserve(0),0);
        } catch (Exception ex) {
            Logger.getLogger(VendeurTest.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

        
	

}
