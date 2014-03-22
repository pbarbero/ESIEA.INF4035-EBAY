package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import Modele.Exceptions.MustBePositive;
import Modele.SysAlerting.Alert;
import Modele.SysAlerting.Observer;
import Modele.SysEnchere.Enchere;
import Modele.SysUser.Acheteur;
import Modele.SysUser.Vendeur;

public class VendeurTest {
	
    private Map<Observer,Alert> listObserver;
    private ArrayList<Enchere> listEnchere;
    private Vendeur vend;

	@Before
	public void setUp() throws Exception {
		
	    this.listObserver = new HashMap<Observer,Alert>();
	    listObserver.put(new Acheteur("barbero","pilar","5897542", 
				null), Alert.AlertEnchereAnnulee);
	    
	    
	    this.listEnchere  = new ArrayList<Enchere>();
	    vend = new Vendeur("dasilva", "paco", "aw43q4", 
	    	listEnchere);
	}

	@Test
	public void testCreerEnchere(Enchere e) {
		assertNotNull(e);
	}

	@Test
	public void testPublierEnchere(Enchere e) {
		assertEquals(false,e.isPublication());
	}

	@Test
	public void testRetirerEnchere() {
		fail("Not yet implemented");
	}

	@Test
	public void testMettrePrixMaximum() {
		try{
			vend.mettrePrixMaximum(1,-10f);
			fail("Shouldn't reach this");
			
		}catch(MustBePositive e){System.err.println("Exception caught");}
	}

	@Test
	public void testMettrePrixMinimum() {
		try{
			vend.mettrePrixMaximum(1,-10f);
			fail("Shouldn't reach this");
			
		}catch(MustBePositive e){System.err.println("Exception caught");}
	}

	@Test
	public void testMettrePrixReserve() {
		try{
			vend.mettrePrixMaximum(1,-10f);
			fail("Shouldn't reach this");
			
		}catch(MustBePositive e){System.err.println("Exception caught");}
	}

	//@Test
	/**public void testVoirPrixDeReserve() {
		fail("Not yet implemented");
	}**/

	//@Test
	/**public void testRafraichir() {
		fail("Not yet implemented");
	}**/

}
