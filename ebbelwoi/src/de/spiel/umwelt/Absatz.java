package de.spiel.umwelt;

/**
 * Klasse Absatz
 * beinhaltet die einzeln getätigten Absätze
 */
public class Absatz {
	private double preis;
	private double menge;

	private int lagerpos = Integer.MAX_VALUE;

	/**
	 * Konstruktor mit Preis- und Mengenangabe
	 * @param menge
	 * @param preis
	 */
	public Absatz(double menge, double preis) {
		this.menge = menge;
		this.preis = preis;
	}

	/**
	 * Konstruktor mit Angebot
	 * @param angebot
	 */
	public Absatz(Angebot angebot) {
		this.menge = angebot.getMenge();
		this.preis = angebot.getPreis();
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
	public double getUmsatz() {
		return this.preis * ((double) menge);
	}

	// GETTER
	public int getLagerpos() {
		return lagerpos;
	}

	// SETTER
	public void setLagerpos(int lagerpos) {
		this.lagerpos = lagerpos;
	}

	@Override
	public String toString() {
		return "Absatz [preis=" + preis + ", menge=" + menge + ", getUmsatz()="
				+ getUmsatz() + "]";
	}

}