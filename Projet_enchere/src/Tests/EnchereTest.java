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
import Modele.SysEnchere.Objet;
import Modele.SysEnchere.Offre;

public class EnchereTest {
	
	 private Objet objet;
	 private Date dateLimite;
	 private float prixMinimum;
	 private float prixMaximum;
	 private float prixReserve;
	 private ArrayList<Offre> listOffre;
	 private Map<Observer,Alert> listObserver;
	 private boolean publication=false;

	@Before
	public void setUp() throws Exception {
		this.objet = new Objet(111,"descrip");
		this.dateLimite = new Date(1991,04,15);
		this.prixMaximum = 200;
		this.prixMinimum = 100;
		this.prixReserve = 150;
		this.listOffre = new ArrayList<Offre>();
		this.listObserver = new HashMap<Observer,Alert>();
		
	}


	@Test
	public void testRetirer() {
		assertEquals(false,this.publication);
	}

//	@Test
/*	public void testAjouterObservateur() {


	}*/

//	@Test
/*	public void testSupprimerObservateur() {
		fail("Not yet implemented");
	}*/

//	@Test
/*	public void testNotifierObservateurs() {
		fail("Not yet implemented");
	}*/

}
