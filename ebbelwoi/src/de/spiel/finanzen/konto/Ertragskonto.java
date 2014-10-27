package de.spiel.finanzen.konto;

/**
 * Klasse Ertragskonto, beerbt Konto
 */
public class Ertragskonto extends Konto {
	/**
	 * Konstruktor mit Name des Kontos
	 * @param name
	 */
	public Ertragskonto(String name) {
		super(name);
	}

	/**
	 * Konstruktor mit Name und Stand des Kontos
	 * @param name
	 * @param kontostand
	 */
	public Ertragskonto(String name, double kontostand) {
		super(name, kontostand);
	}

	@Override
	public double kontoAbrechnen() {
		double differenz = 0.0;

		if (this.getHaben() > getSoll()) {
			differenz = haben - soll;
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
