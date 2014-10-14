package de.spiel.umwelt.beschaffung;

public class Bauer extends Anbieter {
	private final int STUFE = 6;
	private final double MINP = 0.60;
	private final double MAXP = 1.00;

	public Bauer() {
		super();
		stufe.setAktuelleStufe(STUFE);
		preis = Math.floor((preis * (MAXP - MINP) + MINP) * 100) / 100;
	}
}
