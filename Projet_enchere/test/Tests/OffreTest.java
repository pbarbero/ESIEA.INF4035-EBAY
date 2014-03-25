package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Modele.SysEnchere.Enchere;
import Modele.SysEnchere.Offre;
import Modele.SysUser.Acheteur;

public class OffreTest {

    private Acheteur acheteur;
    private float prix;
    
    @Before
    public void setUp() throws Exception{
    	this.prix = 1;
    	 acheteur=new Acheteur("jean", "piere", "jp20014",new ArrayList<Enchere>(),new ArrayList<Offre>());
           
    }
	@Test
	public void testOffre() {
		assertTrue(this.prix > 0);
		assertNotNull(this.acheteur);
	}

	

	

}
