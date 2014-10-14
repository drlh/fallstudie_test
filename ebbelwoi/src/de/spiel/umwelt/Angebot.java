package de.spiel.umwelt;

public class Angebot {
	private double preis;
	private double menge;
	
	public Angebot(double preis, double menge) {
		this.menge = menge;
		this.preis = preis;
	}

	public double getPreis() {
		return preis;
	}

	public double getMenge() {
		return menge;
	}

}
