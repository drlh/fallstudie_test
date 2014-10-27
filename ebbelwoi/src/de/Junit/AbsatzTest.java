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
		Angebot a1 = new Angebot(3.5, 7000);
		Angebot a2 = new Angebot(4.2, 300);
		Angebot a3 = new Angebot(3.5, 5000);
		Angebot a4 = new Angebot(4.1, 600);
		Angebot a5 = new Angebot(3.9, 400);
		//Abgeben der Angebote an die Kunden, jeweils zwei an die Kneipe und 2 an die Supermarktkette
		Kunde[] kunden = ab.getKundenListe();
		kunden[0].erstelleAngebot("Spieler1", a2);
		kunden[0].erstelleAngebot("Spieler2", a4);
		kunden[0].erstelleAngebot("Spieler3", a5);
		kunden[1].erstelleAngebot("Spieler3", a3);
		kunden[1].erstelleAngebot("Spieler2", a1);
		
		//Abrechnung wird durchgeführt
		for (int i = 0; i < kunden.length; i++) {
			kunden[i].berechneAbsatz();
		}
		
		//tatsächliche Absätze werden geprüft
		try {
			System.out.println("Kneipe:\nverfügbares Volumen:\n" + ab.getKneipe().getMenge() + "\nAngebote:\n");
			Enumeration<String> enumkneipean = ab.getKneipe().getAngebote().keys();
			while (enumkneipean.hasMoreElements()) {
				String string = (String) enumkneipean.nextElement();
				double menge = ab.getKneipe().getAngebote().get(string).getMenge();
				double preis = ab.getKneipe().getAngebote().get(string).getPreis();
				System.out.println(string + " Menge: " + menge + " Preis: " + preis + "€");
			}
			System.out.println("\ntatsächliche Absätze:\n");
			Enumeration<String> enumkneipeab = ab.getKneipe().getAbsatz().keys();
			while (enumkneipeab.hasMoreElements()) {
				String string = (String) enumkneipeab.nextElement();
				double umsatz = ab.getKneipe().getAbsatz().get(string).getUmsatz();
				System.out.println(string + " Umsatz: " + umsatz + "€");
			}
			System.out.println("\nSupermarktkette:\nverfügbares Volumen:\n" + ab.getSupermarktkette().getMenge() + "\nAngebote:\n");
			Enumeration<String> enumsuperan = ab.getSupermarktkette().getAngebote().keys();
			while (enumsuperan.hasMoreElements()) {
				String string = (String) enumsuperan.nextElement();
				double menge = ab.getSupermarktkette().getAngebote().get(string).getMenge();
				double preis = ab.getSupermarktkette().getAngebote().get(string).getPreis();
				System.out.println(string + " Menge: " + menge + " Preis: " + preis + "€");
			}
			System.out.println("\ntatsächliche Absätze:\n");
			Enumeration<String> enumsuperab = ab.getSupermarktkette().getAbsatz().keys();
			while (enumsuperab.hasMoreElements()) {
				String string = (String) enumsuperab.nextElement();
				double umsatz = ab.getSupermarktkette().getAbsatz().get(string).getUmsatz();
				System.out.println(string + " Umsatz: " + umsatz + "€");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
