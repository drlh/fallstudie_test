package de.spiel.umwelt.absatz;

/**
 * Klasse Grosshandel, beerbt Kunde
 * Grosshandel als Abnehmer, nimmt mittlere Mengen ab
 */
public class Grosshandel extends Kunde {

	/**
	 * leerer Konstruktor
	 */
	public Grosshandel() {
		super();
		initKunde();
	}

	@Override
	protected void initKunde() {
		MINAB = 3000;
		MAXAB = 10000;
		menge = Math.floor((menge * (MAXAB - MINAB) + MINAB) * 100) / 100;
	}

}
