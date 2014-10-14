package de.spiel.umwelt.beschaffung;

public class Bauer extends Anbieter {
	private double angebot;

	public Bauer(double angebot) {
		super();
		this.angebot = angebot;
	}

	public double getAngebot() {
		return angebot;
	}

}
