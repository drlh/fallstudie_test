package de.spiel.basic;

public class Produkt {
	private String name;
	private double menge;
	private Qualitaetstufe qualitaet;

	/**
	 * leerer Konstruktor
	 */
	public Produkt() {
		this.name = "Apfelwein";
		this.menge = 0.0;
		this.qualitaet = new Qualitaetstufe();
	}

	/**
	 * Konstruktor mit Mengenangabe
	 * 
	 * @param menge
	 */
	public Produkt(double menge) {
		this.name = "Apfelwein";
		this.menge = menge;
		this.qualitaet = new Qualitaetstufe();
	}

	/**
	 * Konstruktor mit Mengen- und Qualitätsangabe
	 * 
	 * @param menge
	 * @param qualitaet
	 */
	public Produkt(double menge, int qualitaet) {
		this.name = "Apfelwein";
		this.menge = menge;
		this.qualitaet = new Qualitaetstufe(qualitaet);
	}

	/**
	 * GETTER für Menge abhängig von Qualitätsstufe
	 * 
	 * @return
	 */
	public double getMenge() {
		int qualitaet = this.getQualitaet().getAktuelleStufe();

		switch (qualitaet) {
		case 6:
			return this.menge;
		case 5:
			return (this.menge * 0.9);
		case 4:
			return (this.menge * 0.8);
		case 3:
			return (this.menge * 0.6);
		case 2:
			return (this.menge * 0.5);
		case 1:
			return (this.menge * 0.3);
		default:
			return 0;
		}

	}

	// SETTER
	public void setMenge(double menge) {
		this.menge = menge;
	}

	// GETTER
	public Qualitaetstufe getQualitaet() {
		return qualitaet;
	}

	// SETTER
	public void setQualitaet(int qualitaet) {
		this.qualitaet.setAktuelleStufe(qualitaet);
	}

	public String getBezeichnung() {
		return name;
	}

	@Override
	public String toString() {
		return "Produkt [name=" + name + ", menge=" + menge + ", qualitaet="
				+ qualitaet + "]";
	}

}
