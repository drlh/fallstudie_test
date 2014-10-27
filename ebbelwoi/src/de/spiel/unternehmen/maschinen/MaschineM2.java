package de.spiel.unternehmen.maschinen;

import de.spiel.basic.stufen.MaschinenStufen;
import de.spiel.unternehmen.mitarbeiter.Produktionsmitarbeiter;

/**
 * Klasse MaschineM2, beerbt Maschine
 */
public class MaschineM2 extends Maschine {
	/**
	 * leerer Konstruktor
	 */
	public MaschineM2() {
		super();
		this.anschaffungskosten = 65000.0;
		this.aktuellerWert = anschaffungskosten;
		this.abschreibungsdauer = 5;
		calcAbschreibung();
		calcFixkosten();

		this.kapazitaet = 500000.0;
		this.auswurf = 0.2;
		this.maschinenfuehrer = null;

		this.stufe = new MaschinenStufen();
	}

	/**
	 * Konstruktor mit bedienendem Mitarbeiter
	 * @param mitarbeiter
	 */
	public MaschineM2(Produktionsmitarbeiter mitarbeiter) {
		super();
		this.anschaffungskosten = 65000.0;
		this.aktuellerWert = anschaffungskosten;
		this.abschreibungsdauer = 5;
		calcAbschreibung();
		calcFixkosten();

		this.kapazitaet = 500000.0;
		this.auswurf = 0.2;
		setMaschinenfuehrer(mitarbeiter);

		this.stufe = new MaschinenStufen();
	}
}
