package de.spiel.umwelt;

import de.spiel.umwelt.absatz.*;

public class Absatzmarkt {
	Kunde[] kundenListe = new Kunde[3];

	public Absatzmarkt() {
		initKundenListe();
	}

	private void initKundenListe() {
		kundenListe[0] = new Kneipe();
		kundenListe[1] = new Supermarktkette();
		kundenListe[2] = new Grosshandel();
	}

	public Kunde[] getKundenListe() {
		return kundenListe;
	}

	public Kunde getKneipe() {
		return (Kneipe) kundenListe[0];
	}

	public Kunde getSupermarktkette() {
		return (Supermarktkette) kundenListe[1];
	}
	
	public Kunde getGrosshandel() {
		return (Grosshandel) kundenListe[2];
	}

}
