package de.Junit;

import org.junit.*;

import de.spiel.umwelt.*;
import de.spiel.umwelt.absatz.Kunde;
import de.spiel.unternehmen.Unternehmen;

/**
 * @author D060317
 *
 */
public class AbsatzTest {
	Absatzmarkt ab = new Absatzmarkt();
	Absatz[] absatz = new Absatz[5];

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Unternehmen un = new Unternehmen();
		ab = un.getUmwelt().getAbsatz();
		
	}

	@Test
	public void test() {
		//Erstellen verschiedener Angebote zum Testen
		Angebot a1 = new Angebot(3.5, 1500);
		Angebot a2 = new Angebot(4.2, 300);
		Angebot a3 = new Angebot(3.5, 1100);
		Angebot a4 = new Angebot(4.1, 600);
		Angebot a5 = new Angebot(3.9, 700);
		//Abgeben der Angebote an die Kunden, jeweils zwei an die Kneipe und 2 an die Supermarktkette
		Kunde[] kunden = ab.getKundenListe();
		kunden[0].erstelleAngebot("Spieler1", a2);
		kunden[0].erstelleAngebot("Spieler2", a4);
		kunden[0].erstelleAngebot("Spieler3", a5);
		kunden[1].erstelleAngebot("Spieler2", a3);
		kunden[1].erstelleAngebot("Spieler3", a1);
		
		//Abrechnung wird durchgeführt
		for (int i = 0; i < kunden.length; i++) {
			kunden[i].berechneAbsatz();
		}
		
		//tatsächliche Absätze werden geprüft
		try {
			Absatz a;
			absatz[0] = ab.getKneipe().getAbsatz().get("Spieler1");
			absatz[1] = ab.getKneipe().getAbsatz().get("Spieler2");
			absatz[2] = ab.getKneipe().getAbsatz().get("Spieler3");
			absatz[3] = ab.getSupermarktkette().getAbsatz().get("Spieler2");
			absatz[4] = ab.getSupermarktkette().getAbsatz().get("Spieler3");
			
			System.out.println("Umsätze Spieler1:\n");	
			a = absatz[0];
			System.out.println("Kneipe:" + a.getUmsatz());
			System.out.println("\nAbsätze Spieler2:\n");	
			a = absatz[1];
			System.out.println("Kneipe:" + a.getUmsatz() + "\n");
			a = absatz[3];
			System.out.println("Supermarktkette:" + a.getUmsatz());
			System.out.println("\nAbsätze Spieler3:\n");
			a = absatz[2];
			System.out.println("Kneipe:" + a.getUmsatz() + "\n");
			a = absatz[4];
			System.out.println("Supermarktkette:" + a.getUmsatz());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
