package de.spiel.umwelt.absatz;

/**
 * Klasse Supermarktkette, beerbt Kunde
 * nimmt groﬂe Mengen ab
 */
public class Supermarktkette extends Kunde {

	/**
	 * leerer Konstruktor
	 */
	public Supermarktkette() {
		super();
		initKunde();
	}

	@Override
	protected void initKunde() {
		MINAB = 5000;
		MAXAB = 15000;
		menge = Math.floor((menge * (MAXAB - MINAB) + MINAB) * 100) / 100;
	}
}
