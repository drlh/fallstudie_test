package de.spiel.finanzen.konto;

/**
 * Klasse Bestandsveraenderungen, beerbt Konto
 * Ger�st f�r Bestandsver�nderungskonten
 */
public class Bestandsveraenderungen extends Konto {
	/**
	 * Konstruktor mit Name des Kontos
	 * @param name
	 */
	public Bestandsveraenderungen(String name) {
		super(name);
	}

	@Override
	public double kontoAbrechnen() {
		double differenz = 0.0;

		if (getSoll() > getHaben()) {
			differenz = soll - haben;
			return differenz * (-1);
		} else if (getSoll() < getHaben()) {
			differenz = haben - soll;
			return differenz;
		} else {
			return 0;
		}

	}

}
