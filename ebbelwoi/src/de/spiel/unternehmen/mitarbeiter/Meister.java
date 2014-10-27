package de.spiel.unternehmen.mitarbeiter;

/**
 * Klasse für Meister, beerbt Produktionsmitarbeiter
 */
public class Meister extends Produktionsmitarbeiter {
	/**
	 * leerer Konstruktor
	 */
	public Meister() {
		super();
		setGehalt(2500);
	}
	
	/**
	 * Konstruktor mit Gehalt
	 * @param gehalt
	 */
	public Meister(double gehalt) {
		super(gehalt);
	}

}
