package Tests;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import Modele.SysAlerting.Alert;
import Modele.SysAlerting.Observer;
import Modele.SysEnchere.Enchere;
import Modele.SysEnchere.Objet;
import Modele.SysEnchere.Offre;
import Modele.SysUser.Acheteur;
import Modele.SysUser.Vendeur;
import org.junit.Assert;

public class EnchereTest {
	
	 Objet objet;
	 Date dateLimite;
	 float prixMinimum;
	 float prixMaximum;
	 float prixReserve;
	 ArrayList<Offre> listOffre;
	 Map<Observer,Alert> listObserver;
	 boolean publication=false;
         Vendeur v;
         Acheteur a;
         Offre o1;
         Offre o2;
         Enchere e1;
         Enchere e2;

	@Before
	public void setUp() throws Exception {
	    objet = new Objet(111,"descrip");
	    dateLimite = new Date(1991,04,15);
	    prixMaximum = 200;
	    prixMinimum = 100;
	    prixReserve = 150;     
            a=new Acheteur("jean", "piere", "jp20014",new ArrayList<Enchere>(),new ArrayList<Offre>());
            v= new Vendeur("david", "henry", "dadhenry",new ArrayList<Enchere>(),new ArrayList<Offre>());
            e1=new Enchere(new Objet(122188998, "Objet1"),new Date(2014,03,15));
            e1.ajouterObservateur(a, Alert.AlertEnchereAnnulee);
            e1.ajouterObservateur(a, Alert.AlertOffreSuperieur);
            e1.ajouterObservateur(a, Alert.AlertPrixDeReserveAtteint);
            e1.ajouterObservateur(a, Alert.AlertOffreSurEnchere);
            e2=new Enchere(new Objet(665566776, "Objet2"),new Date(2014,03,06));
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
          
            v.publierEnchere(0);//premiere enchere publie
         
		
	}


	@Test
	public void testRetirer() {
		assertEquals(false,this.publication);
	}

	@Test
	public void testGetPrixMaximumListOffre() {
               a.EmettreOffre(o1, e1);
               a.EmettreOffre(o2, e1);
               Assert.assertEquals(699,e1.getPrixMaximumListOffre(),0);

	}

}
