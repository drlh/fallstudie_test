package de.spiel.umwelt.beschaffung;

/**
 * Klasse Nachfrage
 */
public class Nachfrage {
	private double menge;

	/**
	 * Konstruktor mit Mengenangabe
	 * @param menge
	 */
	public Nachfrage(double menge) {
		this.menge = menge;
	}

	// GETTER
	public double getMenge() {
		return menge;
	}
}
