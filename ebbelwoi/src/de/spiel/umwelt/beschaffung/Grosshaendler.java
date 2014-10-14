package de.spiel.umwelt.beschaffung;

public class Grosshaendler extends Anbieter {
	private double angebot;

	public Grosshaendler(double angebot) {
		super();
		this.angebot = angebot;
	}

	public double getAngebot() {
		return angebot;
	}	
	
}