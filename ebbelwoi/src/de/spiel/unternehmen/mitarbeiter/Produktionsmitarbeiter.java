package de.spiel.unternehmen.mitarbeiter;

/**
 * abstrakte KLasse Produktionsmitarbeiter, beerbt Mitarbeiter
 */
public abstract class Produktionsmitarbeiter extends Mitarbeiter {
	/**
	 * leerer Konstruktor
	 */
	public Produktionsmitarbeiter() {
		super();
	}

	/**
	 * Konstruktor mit Gehalt
	 * @param gehalt
	 */
	public Produktionsmitarbeiter(double gehalt) {
		super();
		setGehalt(gehalt);
	}
}
