package de.spiel.umwelt;

/**
 * Klasse Umwelt
 * statisch für jeweils ein Spiel erzeugt
 * beinhaltet die komplette Umwelt des Unternehmens mit Märkten etc.
 */
public class Umwelt {
	private static Beschaffungsmarkt beschaffung;
	private static Absatzmarkt absatz;

	/**
	 * leerer Konstruktor
	 */
	public Umwelt() {
		Umwelt.setBeschaffung(new Beschaffungsmarkt());
		Umwelt.setAbsatz(new Absatzmarkt());
	}

	/**
	 * triggern einer neuen Runde
	 */
	public static void neueRunde() {
		setBeschaffung(new Beschaffungsmarkt());
		setAbsatz(new Absatzmarkt());
	}

	// GETTER
	public static Beschaffungsmarkt getBeschaffung() {
		return beschaffung;
	}

	// SETTER
	public static void setBeschaffung(Beschaffungsmarkt beschaffung) {
		Umwelt.beschaffung = beschaffung;
	}

	// GETTER
	public static Absatzmarkt getAbsatz() {
		return absatz;
	}

	// SETTER
	public static void setAbsatz(Absatzmarkt absatz) {
		Umwelt.absatz = absatz;
	}
}
