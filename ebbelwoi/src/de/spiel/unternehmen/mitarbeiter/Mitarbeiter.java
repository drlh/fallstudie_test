package de.spiel.unternehmen.mitarbeiter;

import de.spiel.basic.stufen.MitarbeiterStufe;

/**
 * Klasse Mitarbeiter
 */
public abstract class Mitarbeiter {
	String nachname, vorname;
	MitarbeiterStufe stufe;
	private double gehalt;

	String[] vornamen = { "Christina", "Yannick", "Niklas", "Leo", "Basti",
			"Fabi" };
	String[] nachnamen = { "Junghans", "Sarnoch", "Miroll", "Hellwich",
			"Brehm", "Angst" };
	
	/**
	 * leerer Konstruktor
	 */
	public Mitarbeiter() {
		this.nachname = nachnamen[(int) (Math.random() * nachnamen.length)];
		this.vorname = vornamen[(int) (Math.random() * vornamen.length)];
		this.stufe = new MitarbeiterStufe();
		this.gehalt = 0.0;
	}

	/**
	 * Schulung des Mitarbeiters
	 */
	public void upgrade() {
		this.stufe.upgrade();
	}

	// GETTER
	public int getStufe() {
		return stufe.getStufe();
	}

	// GETTER
	public String getName() {
		return vorname + " " + nachname;
	}

	// GETTER
	public int getBonus() {
		return this.stufe.getBonus();
	}

	// GETTER
	public double getGehalt() {
		return gehalt;
	}

	// SETTER
	protected void setGehalt(double gehalt) {
		this.gehalt = gehalt;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[vorname=" + vorname
				+ ", nachname=" + nachname + ", stufe=" + this.getStufe() + "]";
	}

}
