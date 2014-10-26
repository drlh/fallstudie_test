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
			/*absatz[0] = ab.getKneipe().getAbsatz().get("Spieler1");
			absatz[1] = ab.getKneipe().getAbsatz().get("Spieler2");
			absatz[2] = ab.getKneipe().getAbsatz().get("Spieler3");
			absatz[3] = ab.getSupermarktkette().getAbsatz().get("Spieler2");
			absatz[4] = ab.getSupermarktkette().getAbsatz().get("Spieler3");
			
			for (int i = 0; i < absatz.length; i++) {
				if (absatz[i] != null) {
					System.out.println(absatz[i].toString());
				}				
			}*/
			System.out.println("Kneipe:\nAngebote:\n");
			ab.getKneipe().getAngebote().toString();
			System.out.println("\ntatsächliche Absätze:\n");
			ab.getKneipe().getAbsatz().toString();
			System.out.println("Supermarktkette:\nAngebote:\n");
			ab.getSupermarktkette().getAngebote().toString();
			System.out.println("\ntatsächliche Absätze:\n");
			ab.getSupermarktkette().getAbsatz().toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
