package de.spiel.basic;

public class Rohstoff {
	private String name;
	private double menge;
	private Qualitaetstufe qualitaet;

	/**
	 * leerer Konstruktor
	 */
	public Rohstoff() {
		this.name = "Äpfel";
		this.menge = 0.0;
		this.qualitaet = new Qualitaetstufe();
	}

	/**
	 * Konstruktor mit Mengenangabe
	 * 
	 * @param menge
	 */
	public Rohstoff(double menge) {
		this.name = "Äpfel";
		this.menge = menge;
		this.qualitaet = new Qualitaetstufe();
	}

	/**
	 * Konstruktor mit Mengen- und Qualitätsangabe
	 * 
	 * @param menge
	 * @param qualitaet
	 */
	public Rohstoff(double menge, int qualitaet) {
		this.name = "Äpfel";
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

	@Override
	public String toString() {
		return "Rohstoff [name=" + name + ", menge=" + menge + ", qualitaet="
				+ qualitaet + "]";
	}

}
