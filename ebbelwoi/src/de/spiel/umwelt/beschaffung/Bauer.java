package de.spiel.umwelt.beschaffung;

/**
 * Klasse Bauer, beerbt Anbieter
 * kleiner Bauer, der �pfel mit hoher Qualit�t liefert, jedoch nur begrenzte Menge anbietet
 */
public class Bauer extends Anbieter {

	/**
	 * leerer Konstruktor
	 */
	public Bauer() {
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
