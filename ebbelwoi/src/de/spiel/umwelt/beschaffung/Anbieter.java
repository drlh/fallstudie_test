package de.spiel.umwelt.beschaffung;

import java.util.Random;
import de.spiel.basic.Qualitaetstufe;

/**
 * abstrakte Klasse Anbieter
 * beinhaltet die Anbieter auf dem Beschaffungsmarkt
 */
public abstract class Anbieter {
	protected double MINP;
	protected double MAXP;
	protected int defstufe;
	protected double preis;
	protected Qualitaetstufe stufe = new Qualitaetstufe();

	/**
	 * leerer Konstruktor
	 */
	public Anbieter() {
		Random r = new Random();
		preis = r.nextDouble();
		initAnbieter();
	}

	// GETTER
	public double getPreis() {
		return preis;
	}

	/**
	 * abstrakte Methode
	 * Initialisierung der Anbieter
	 */
	protected abstract void initAnbieter();

}
