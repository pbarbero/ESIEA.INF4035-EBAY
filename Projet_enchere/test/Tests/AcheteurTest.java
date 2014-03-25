package Tests;

import Modele.SysAlerting.Alert;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Modele.SysEnchere.Enchere;
import Modele.SysEnchere.Objet;
import Modele.SysEnchere.Offre;
import Modele.SysUser.Acheteur;
import Modele.SysUser.Utilisateur;
import Modele.SysUser.Vendeur;
import junit.framework.Assert;

public class AcheteurTest {
	
    String nom;
    String prenom;
    String login;
    Vendeur v;
    Acheteur a;
    Offre o1;
    Offre o2;
    Enchere e1;
    Enchere e2;
    
	@Before
	public void setUp() throws Exception {
	    nom = "Barbero";
	    prenom = "Pilar";
	    login = "barberoiriarte";
            
            a=new Acheteur("jean", "piere", "jp20014",new ArrayList<Enchere>(),new ArrayList<Offre>());
            v= new Vendeur("david", "henry", "dadhenry",new ArrayList<Enchere>(),new ArrayList<Offre>());
            e1=new Enchere(new Objet(123456, "Objet1"),new Date(2014,03,15));
            e1.ajouterObservateur(a, Alert.AlertEnchereAnnulee);
            e1.ajouterObservateur(a, Alert.AlertOffreSuperieur);
            e1.ajouterObservateur(a, Alert.AlertPrixDeReserveAtteint);
            e1.ajouterObservateur(a, Alert.AlertOffreSurEnchere);
            e2=new Enchere(new Objet(1234567, "Objet2"),new Date(2014,03,06));
            e2.ajouterObservateur(a, Alert.AlertEnchereAnnulee);
            e2.ajouterObservateur(a, Alert.AlertOffreSuperieur);
            e2.ajouterObservateur(a, Alert.AlertPrixDeReserveAtteint);
            e2.ajouterObservateur(a, Alert.AlertOffreSurEnchere);
            
            v.getListEnchere().add(e1);
            v.getListEnchere().add(e2);
            
            o1=new Offre(a,699);
            o2=new Offre(a,45);
            
	    a.getListOffre().add(o1);
            a.getListOffre().add(o2);
            v.publierEnchere(0);//premiere enchere
            
            a.EmettreOffre(o1, v.getListEnchere().get(0));
           
       }

	@Test
	public void testEmettreOffre() {
          //test si l offre est bien émise
          Assert.assertEquals(o1, v.getListEnchere().get(0).getListOffre().get(0));
        }

	@Test
	public void testDesactiverAlert() {
	  
	}

//	@Test
/**	public void testRafraichir() {
		fail("Not yet implemented");
	}**/

	//@Test
	/**public void testAjouterObservateur() {
		fail("Not yet implemented");
	}**/

	//@Test
	/**public void testSupprimerObservateur() {
		fail("Not yet implemented");
	}**/

	//@Test
	/**public void testNotifierObservateurs() {
		fail("Not yet implemented");
	}**/

}
