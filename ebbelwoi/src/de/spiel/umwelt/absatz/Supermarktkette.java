package de.spiel.umwelt.absatz;

public class Supermarktkette extends Kunde {

	public Supermarktkette() {
		super();
		initKunde();
	}

	@Override
	protected void initKunde() {
		MINAB = 5000;
		MAXAB = 15000;
		menge = Math.floor((menge * (MAXAB - MINAB) + MINAB) * 100) / 100;
	}
}
