package de.spiel.umwelt.beschaffung;

/**
 * Klasse Grosshaendler, beerbt Anbieter
 * bietet große Mengen an Äpfeln an, jedoch nur mit guter Qualität
 */
public class Grosshaendler extends Anbieter {

	/**
	 * leerer Konstruktor
	 */
	public Grosshaendler() {
		super();
		stufe.setAktuelleStufe(defstufe);
		preis = Math.floor((preis * (MAXP - MINP) + MINP) * 100) / 100;
	}

	@Override
	protected void initAnbieter() {
		defstufe = 6;
		MINP = 0.60;
		MAXP = 1.00;
	}

}