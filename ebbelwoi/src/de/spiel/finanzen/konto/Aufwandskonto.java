package de.spiel.finanzen.konto;

/**
 * Klasse Aufwandskonto, beerbt Konto
 * Gerüst für Aufwandskonten des Kontenrahmens
 */
public class Aufwandskonto extends Konto {
	/**
	 * Konstruktor mit Name des Kontos
	 * @param name
	 */
	public Aufwandskonto(String name) {
		super(name);
	}

	/**
	 * Konstruktor mit Name und Stand des Kontos
	 * @param name
	 */
	public Aufwandskonto(String name, double kontostand) {
		super(name, kontostand);
	}

	@Override
	public double kontoAbrechnen() {
		double differenz = 0.0;

		if (this.getHaben() < getSoll()) {
			differenz = soll - haben;
			this.resetKonto();
			return differenz;
		} else if (this.getSoll() == this.getHaben()) {
			this.resetKonto();
			return 0;
		} else {
			return -1;
		}

	}
}
