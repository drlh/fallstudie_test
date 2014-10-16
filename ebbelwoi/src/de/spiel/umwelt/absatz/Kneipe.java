package de.spiel.umwelt.absatz;

public class Kneipe extends Kunde {

	public Kneipe() {
		super();
		initKunde();
	}

	@Override
	protected void initKunde() {
		MINAB = 500;
		MAXAB = 1500;
		MINP = 0.60;
		MAXP = 0.90;
		menge = Math.floor((menge * (MAXAB - MINAB) + MINAB) * 100) / 100;
		preis = Math.floor((preis * (MAXP - MINP) + MINP) * 100) / 100;
	}

}
