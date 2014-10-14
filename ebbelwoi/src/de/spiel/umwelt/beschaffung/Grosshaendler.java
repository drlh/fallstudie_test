package de.spiel.umwelt.beschaffung;

public class Grosshaendler extends Anbieter {
	private final int STUFE = 4;
	private final double MINP = 0.40;
	private final double MAXP = 0.70;

	public Grosshaendler() {
		super();
		stufe.setAktuelleStufe(STUFE);
		preis = Math.floor((preis * (MAXP - MINP) + MINP) * 100) / 100;
	}	
	
}