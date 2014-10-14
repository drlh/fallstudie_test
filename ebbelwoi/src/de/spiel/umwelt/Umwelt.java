package de.spiel.umwelt;

public class Umwelt {
	private Beschaffungsmarkt beschaffung;
	private Absatzmarkt absatz;

	public Umwelt() {
		this.beschaffung = new Beschaffungsmarkt();
		this.absatz = new Absatzmarkt();
	}
}
