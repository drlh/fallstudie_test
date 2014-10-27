package de.spiel.unternehmen.abteilung.produktion;

import de.spiel.basic.Rohstoff;
import de.spiel.unternehmen.maschinen.Maschine;

/**
 * Klasse Produktionsauftrag
 */
public class Produktionsauftrag {
	private Maschine produzierendeMaschine;
	private Rohstoff verwendeterRohsoff;

	/**
	 * Konstruktor mit Maschine, die produzieren soll und Rohstoff, der verarbeitet werden soll
	 * @param maschine
	 * @param rohstoff
	 */
	public Produktionsauftrag(Maschine maschine, Rohstoff rohstoff) {
		this.produzierendeMaschine = maschine;
		this.verwendeterRohsoff = rohstoff;
	}

	// GETTER
	public Maschine getProduzierendeMaschine() {
		return produzierendeMaschine;
	}

	// GETTER
	public Rohstoff getVerwendeterRohsoff() {
		return verwendeterRohsoff;
	}

	@Override
	public String toString() {
		return "Produktionsauftrag [produzierendeMaschine="
				+ produzierendeMaschine + ", verwendeterRohsoff="
				+ verwendeterRohsoff + "]";
	}

}
