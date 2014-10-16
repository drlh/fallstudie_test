package de.spiel.umwelt.beschaffung;

public class Grosshaendler extends Anbieter {

	public Grosshaendler() {
		super();
		stufe.setAktuelleStufe(defstufe);
		preis = Math.floor((preis * (MAXP - MINP) + MINP) * 100) / 100;
	}

	@Override
	protected void initAnbieter() {
		defstufe = 6;
		MINP = 0.60;
		MAXP = 1.00;
	}

}