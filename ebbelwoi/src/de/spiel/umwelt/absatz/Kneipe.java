package de.spiel.umwelt.absatz;

/**
 * Klasse Kneipe, beerbt Kunde
 * nimmt kleine Mengen ab
 */
public class Kneipe extends Kunde {

	/**
	 * leerer Konstruktor
	 */
	public Kneipe() {
		super();
		initKunde();
	}

	@Override
	protected void initKunde() {
		MINAB = 500;
		MAXAB = 1500;
		menge = Math.floor((menge * (MAXAB - MINAB) + MINAB) * 100) / 100;
	}

}
