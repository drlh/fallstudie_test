package de.Junit;

import static org.junit.Assert.*;

import org.junit.Test;

import de.spiel.Spiel;
import de.spiel.Spieler;
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
	
	
	String ma1 = s.get(0).getUnternehmen().getEinkauf().getMitarbeiterListe().toString();
	String ma2 = s.get(0).getUnternehmen().getMarketing().getMitarbeiterListe().toString();
	String ma3 = s.get(0).getUnternehmen().getVerkauf().getMitarbeiterListe().toString();
	String ma4 = s.get(0).getUnternehmen().getProduktion().getMitarbeiterListe().toString();
	
	System.out.println(ma1);
	System.out.println(ma2);
	System.out.println(ma3);
	System.out.println(ma4);
    }

}
