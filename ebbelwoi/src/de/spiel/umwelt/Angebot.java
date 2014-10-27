package de.spiel.umwelt;

import de.spiel.basic.Produkt;

/**
 * Klasse Absatz
 * beinhaltet ein abzugebendes oder abgegebenes Angebot
 */
public class Angebot {
	private double preis;
	private double menge;

	private int lagerpos = Integer.MAX_VALUE;

	/**
	 * Konstruktor mit Preis- und Mengenangabe
	 * @param preis
	 * @param menge
	 */
	public Angebot(double preis, double menge) {
		this.menge = menge;
		this.preis = preis;
	}

	/**
	 * Konstruktor mit Preis- und Mengenangabe, sowie Lagerposition
	 * @param preis
	 * @param menge
	 * @param lagerpos
	 */
	public Angebot(double preis, double menge, int lagerpos) {
		this.menge = menge;
		this.preis = preis;
		this.lagerpos = lagerpos;
	}

	/**
	 * Konstruktor mit Angabe Produkt, sowie preis
	 * @param p
	 * @param preis
	 */
	public Angebot(Produkt p, double preis) {
		this.menge = p.getMenge();
		this.preis = preis;
	}

	// GETTER
	public double getPreis() {
		return preis;
	}

	// GETTER
	public double getMenge() {
		return menge;
	}

	// GETTER
	public int getLagerpos() {
		return lagerpos;
	}

	// SETTER
	public void setLagerpos(int lagerpos) {
		this.lagerpos = lagerpos;
	}

}
