package de.Junit;

import org.junit.Test;

import de.spiel.Spiel;
import de.spiel.Spieler;
import de.spiel.basic.Produkt;
import de.spiel.basic.Rohstoff;
import de.spiel.unternehmen.Unternehmen;
import de.spiel.unternehmen.mitarbeiter.Azubi;
import de.spiel.unternehmen.mitarbeiter.Mitarbeiter;
import de.spiel.unternehmen.mitarbeiter.Vertrieb;

public class SpielTest
{

    @Test
    public void test()
    {
	Spiel s = new Spiel();
	
	Spieler s1 = new Spieler("Leo");
	Spieler s2 = new Spieler("Fabi");
	
	s.add(s1);
	s.add(s2);
	
	Mitarbeiter s1m1 = new Vertrieb();
	Mitarbeiter s1m2 = new Vertrieb();
	Mitarbeiter s1m3 = new Vertrieb();
	Mitarbeiter s1m4 = new Azubi();
	
	Mitarbeiter s2m1 = new Vertrieb();
	Mitarbeiter s2m2 = new Vertrieb();
	Mitarbeiter s2m3 = new Vertrieb();
	Mitarbeiter s2m4 = new Azubi();
	
	s.get(0).getUnternehmen().getEinkauf().addMitarbeiterO(s1m1);
	s.get(0).getUnternehmen().getMarketing().addMitarbeiterO(s1m2);
	s.get(0).getUnternehmen().getVerkauf().addMitarbeiterO(s1m3);
	s.get(0).getUnternehmen().getProduktion().addMitarbeiterO(s1m4);
	
	s.get(1).getUnternehmen().getEinkauf().addMitarbeiterO(s2m1);
	s.get(1).getUnternehmen().getMarketing().addMitarbeiterO(s2m2);
	s.get(1).getUnternehmen().getVerkauf().addMitarbeiterO(s2m3);
	s.get(1).getUnternehmen().getProduktion().addMitarbeiterO(s2m4);
	
	double d = s.get(0).getUnternehmen().getKonto().getKontoStand();
	double e = s.get(0).getUnternehmen().getKonto().getKontoStand();
	System.out.println(d);
	System.out.println(e);
	
	Unternehmen sU1 = s.get(0).getUnternehmen();
	Unternehmen sU2 = s.get(1).getUnternehmen();
	
	sU1.getKonto().einzahlen(100, "Einkauf", "Rücksendung");
	sU1.getEinkauf().getKonto().einzahlen(100, "Einkauf", "Rücksendung");
	sU1.getEinkauf().getKonto().einzahlen(100, "Einkauf", "Rücksendung");
	
	String s1Konto = ""+sU1.getKonto().getTransaktionsListe().toString();
	System.out.println(s1Konto);
	
	Rohstoff r1 = new Rohstoff(100.0);
	sU1.getLager().addRohstoff(r1);
	sU1.getLager().getLagerlisteRohstoffe().get(0).getQualitaet().qualitaetMindern();
	String l1 = sU1.getLager().getRohstoff(0).toString()+"";
	System.out.println(l1);
	

    }

}
