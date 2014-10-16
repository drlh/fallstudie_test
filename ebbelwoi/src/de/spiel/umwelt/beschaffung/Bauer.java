package de.spiel.umwelt.beschaffung;

public class Bauer extends Anbieter {
	
	public Bauer() {
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
