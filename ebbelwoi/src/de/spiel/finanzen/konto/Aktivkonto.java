package de.spiel.finanzen.konto;

/**
 * Klasse Aktivkonto, beerbt Konto
 * Gerüst für Aktivkonten der Bilanz
 */
public class Aktivkonto extends Konto {

	/**
	 * Konstruktor mit Name des Kontos
	 * @param name
	 */
	public Aktivkonto(String name) {
		super(name);
	}

	/**
	 * Konstruktor mit Name und Stand des Kontos
	 * @param name
	 * @param kontostand
	 */
	public Aktivkonto(String name, double kontostand) {
		super(name, kontostand);
	}

	@Override
	public double kontoAbrechnen() {
		double differenz = 0.0;

		if (this.getName().equals("Rohstoffe")
				|| this.getName().equals("Fertigerzeignisse")) {
			bv = haben - soll;
			double endbestand = getHaben();
			this.resetKonto();
			return endbestand;

		} else if (getSoll() > getHaben()) {
			differenz = soll - haben;
			this.resetKonto();
			this.sollBuchen(differenz);
			return getSoll();
		} else if (this.getSoll() == this.getHaben()) {
			this.resetKonto();
			return 0;
		} else {
			return 0;
		}
	}

}
