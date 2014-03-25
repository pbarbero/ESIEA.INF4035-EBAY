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

public class AcheteurTest {

    Vendeur v;
    Acheteur a;
    Offre o1;
    Offre o2;
    Enchere e1;
    Enchere e2;
    
	@Before
	public void setUp() throws Exception {
	      
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
            
            v.getListEnchere().add(e1); //remplace with      v.creerEnchere(e1);
            v.getListEnchere().add(e2);
            
            o1=new Offre(a,699);
            o2=new Offre(a,45);
            
	    a.getListOffre().add(o1);
            a.getListOffre().add(o2);
          
            v.publierEnchere(0);//premiere enchere publie
            a.EmettreOffre(o1, e1);
           
       }

	@Test
	public void testEmettreOffre() {
          //test si l offre est bien émise et bien receptionnee dans la liste d offre du vendeur
         
           
          Assert.assertEquals(o1, v.getListEnchere().get(0).getListOffre().get(0));
        }

        @Test
        public void testVoirAlertAnnule()throws IOException {
            //on va comparer sur la sortie standard l alert attendu (dans notre cas suite a une annonce retire)
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));
        try {
            v.retirerEnchere(0); //retirer la première enchere -> cela provoque une alerte a l acheteur
        } catch (NoPubliedException ex) {
            Logger.getLogger(AcheteurTest.class.getName()).log(Level.SEVERE, null, ex);
        }
           baos.flush();
           String printed=new String(baos.toByteArray());
           String[] linesOutput = printed.split(//
                   System.getProperty("line.separator"));
           Assert.assertEquals("enchere annulee sur l'objet : 122188998", linesOutput[0]); //comparaison avec la sortie standard splitte
	}
        
        @Test
        public void testVoirAlertPrixDeReserveAtteint()throws IOException {
            //on va comparer sur la sortie standard l alert attendu (dans notre cas suite a une annonce retire)
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));
        try {
            v.mettrePrixReserve(0,20); //mettre un prix de reserve a 20
            a.EmettreOffre(o2, e1);
        } catch (MustBePositive ex) {
            Logger.getLogger(AcheteurTest.class.getName()).log(Level.SEVERE, null, ex);
        }
           baos.flush();
           String printed=new String(baos.toByteArray());
           String[] linesOutput = printed.split(//
                   System.getProperty("line.separator"));
           Assert.assertEquals("Le prix de reserve a ete atteint sur l enchere de l objet 122188998", linesOutput[0]); //comparaison avec la sortie standard splitte
	}
        
        @Test
	public void testDesactiverAlert() throws IOException {
            //on desactive l alerte suite a une enchere annulee
            a.desactiverAlert(Alert.AlertEnchereAnnulee, e1);
            //on va comparer sur la sortie standard l alert attendu (dans notre cas suite a une annonce retire)
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));
        try {
            v.retirerEnchere(0); //retirer la première enchere -> cela provoque une alerte a l acheteur. Mais elle est desactivee donc il ne doit pas la voir
        } catch (NoPubliedException ex) {
            Logger.getLogger(AcheteurTest.class.getName()).log(Level.SEVERE, null, ex);
        }
           baos.flush();
           String printed=new String(baos.toByteArray());
           String[] linesOutput = printed.split(//
                   System.getProperty("line.separator"));
       Assert.assertEquals("",linesOutput[0]); //on ne doit rien voir affiche
            
        }


	
}
