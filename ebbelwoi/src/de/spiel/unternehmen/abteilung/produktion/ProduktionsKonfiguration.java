package de.spiel.unternehmen.abteilung.produktion;

import de.spiel.basic.Rohstoff;

public class ProduktionsKonfiguration {
	/**
	 * anzahl = -1 -> Rohstoff aufbrauchen
	 */
	private int anzahl[];
	private Rohstoff rohstoffe[];
	public ProduktionsKonfiguration(int anzMaschinen) {
		anzahl = new int[anzMaschinen];
		rohstoffe = new Rohstoff[anzMaschinen];
	}
	public void befehl(int maschinenNr, int anz, Rohstoff roh){
		anzahl[maschinenNr] = anz;
		rohstoffe[maschinenNr] = roh;
	}
	public int[] getAnzahl() {
		return anzahl;
	}
	public Rohstoff[] getRohstoffe() {
		return rohstoffe;
	}
	
}
