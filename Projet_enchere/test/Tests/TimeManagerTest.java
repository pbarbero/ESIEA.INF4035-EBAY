/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Modele.SysEnchere.Enchere;
import Modele.SysEnchere.EtatEnchere;
import Modele.SysEnchere.Objet;
import Modele.SysOutils.TimeManager;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author USER
 */
public class TimeManagerTest {
    
    TimeManager tm;
    Date future;
    Enchere e1;
    
    @Before
    public void setUp(){
    	future=new Date(2014,03,23); 
        tm=new TimeManager(future);
        e1=new Enchere(new Objet(122188998, "Objet1"),new Date(2014,03,25));
            
    }
    @Test
    public void testVerifierDate() {
         tm.verifierDate(e1); //si la date est superieure a la date future, l enchere est terminee
         Assert.assertEquals(EtatEnchere.TERMINE,e1.getPublication());
    }
}
