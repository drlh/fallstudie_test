package de.Junit;

import java.util.Enumeration;

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
		
		//Abrechnung wird durchgef�hrt
		for (int i = 0; i < kunden.length; i++) {
			kunden[i].berechneAbsatz();
		}
		
		//tats�chliche Abs�tze werden gepr�ft
		try {
			System.out.println("Kneipe:\nAngebote:\n");
			Enumeration<String> enumkneipean = ab.getKneipe().getAngebote().keys();
			while (enumkneipean.hasMoreElements()) {
				String string = (String) enumkneipean.nextElement();
				System.out.println(string);
			}
			System.out.println("\ntats�chliche Abs�tze:\n");
			Enumeration<String> enumkneipeab = ab.getKneipe().getAbsatz().keys();
			while (enumkneipeab.hasMoreElements()) {
				String string = (String) enumkneipeab.nextElement();
				System.out.println(string);
			}
			System.out.println("Supermarktkette:\nAngebote:\n");
			Enumeration<String> enumsuperan = ab.getSupermarktkette().getAngebote().keys();
			while (enumsuperan.hasMoreElements()) {
				String string = (String) enumsuperan.nextElement();
				System.out.println(string);
			}
			System.out.println("\ntats�chliche Abs�tze:\n");
			Enumeration<String> enumsuperab = ab.getSupermarktkette().getAbsatz().keys();
			while (enumsuperab.hasMoreElements()) {
				String string = (String) enumsuperab.nextElement();
				System.out.println(string);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
