package de.spiel.umwelt;

import de.spiel.basic.Produkt;

public class Angebot {
	private double preis;
	private double menge;

	public Angebot(double preis, double menge) {
		this.menge = menge;
		this.preis = preis;
	}

	public Angebot(Produkt p, double preis) {
		this.menge = p.getMenge();
		this.preis = preis;
	}

	public double getPreis() {
		return preis;
	}

	public double getMenge() {
		return menge;
	}

}
