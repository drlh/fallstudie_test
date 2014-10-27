package de.spiel.unternehmen.mitarbeiter;

/**
 * Klasse für Marketing-Mitarbeiter, beerbt Mitarbeiter
 */
public class Marketing extends Mitarbeiter {
	/**
	 * leerer Konstruktor
	 */
	public Marketing() {
		super();
		setGehalt(1000);
	}

	/**
	 * Konstruktor mit Gehalt
	 * @param gehalt
	 */
	public Marketing(double gehalt) {
		super();
		setGehalt(gehalt);
	}

}
