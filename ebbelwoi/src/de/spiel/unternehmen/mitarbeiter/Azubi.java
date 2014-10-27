package de.spiel.unternehmen.mitarbeiter;

/**
 * Klasse für Azubi, beerbt Produktionsmitarbeiter
 */
public class Azubi extends Produktionsmitarbeiter {
	/**
	 * leerer Konstruktor
	 */
	public Azubi() {
		super();
		setGehalt(500);
	}
	
	/**
	 * Konstruktor mit Gehalt
	 * @param gehalt
	 */
	public Azubi(double gehalt) {
		super(gehalt);
	}

}
