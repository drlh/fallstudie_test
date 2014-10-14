package de.spiel.umwelt.absatz;

public class Supermarktkette extends Kunde {
	private double MINAB = 5000;
	private double MAXAB = 15000;
	private double MINP = 0.40;
	private double MAXP = 0.70;

	public Supermarktkette() {
		super();
		menge = Math.floor((menge * (MAXAB - MINAB) + MINAB) * 100) / 100;
		preis = Math.floor((preis * (MAXP - MINP) + MINP) * 100) / 100;
	}
}
