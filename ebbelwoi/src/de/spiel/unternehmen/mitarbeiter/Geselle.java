package de.spiel.unternehmen.mitarbeiter;

/**
 * Klasse f�r Geselle, beerbt Produktionsmitarbeiter
 */
public class Geselle extends Produktionsmitarbeiter {
	/**
	 * leerer Konstruktor
	 */
	public Geselle() {
		super();
		setGehalt(1500);
	}
	
	/**
	 * Konstruktor mit Gehalt
	 * @param gehalt
	 */
	public Geselle(double gehalt) {
		super(gehalt);
	}
}
