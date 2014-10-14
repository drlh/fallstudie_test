package de.spiel.umwelt.absatz;

public class Kneipe extends Kunde {
	private double MINAB = 500;
	private double MAXAB = 1500;
	private double MINP = 0.60;
	private double MAXP = 1.00;

	public Kneipe() {
		super();
		menge = Math.floor((menge * (MAXAB - MINAB) + MINAB) * 100) / 100;
		preis = Math.floor((preis * (MAXP - MINP) + MINP) * 100) / 100;
	}
}
