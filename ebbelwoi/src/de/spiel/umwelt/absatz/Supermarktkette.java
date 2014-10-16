package de.spiel.umwelt.absatz;

public class Supermarktkette extends Kunde {

	public Supermarktkette() {
		super();
	}

	@Override
	protected void initKunde() {
		MINAB = 5000;
		MAXAB = 15000;
		MINP = 0.40;
		MAXP = 0.70;
		menge = Math.floor((menge * (MAXAB - MINAB) + MINAB) * 100) / 100;
		preis = Math.floor((preis * (MAXP - MINP) + MINP) * 100) / 100;
	}
}
