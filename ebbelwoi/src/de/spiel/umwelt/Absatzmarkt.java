package de.spiel.umwelt;

import de.spiel.umwelt.absatz.*;

/**
 * Klasse Absatzmarkt
 * beinhaltet den Markt, auf dem die Spieler ihre Produkte verkaufen können
 */
public class Absatzmarkt {
	Kunde[] kundenListe = new Kunde[3];

	/**
	 * leerer Konstruktor
	 */
	public Absatzmarkt() {
		initKundenListe();
	}

	/**
	 * initialisiere Kundenliste
	 */
	private void initKundenListe() {
		kundenListe[0] = new Kneipe();
		kundenListe[1] = new Supermarktkette();
		kundenListe[2] = new Grosshandel();
	}

	// GETTER
	public Kunde[] getKundenListe() {
		return kundenListe;
	}

	// GETTER
	public Kunde getKneipe() {
		return (Kneipe) kundenListe[0];
	}

	// GETTER
	public Kunde getSupermarktkette() {
		return (Supermarktkette) kundenListe[1];
	}

	// GETTER
	public Kunde getGrosshandel() {
		return (Grosshandel) kundenListe[2];
	}

}
