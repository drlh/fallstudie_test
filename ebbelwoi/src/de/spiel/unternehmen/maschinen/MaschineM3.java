package de.spiel.unternehmen.maschinen;

import de.spiel.basic.stufen.MaschinenStufen;
import de.spiel.unternehmen.mitarbeiter.Produktionsmitarbeiter;

/**
 * Klasse MaschineM3, beerbt Maschine
 */
public class MaschineM3 extends Maschine {
	/**
	 * leerer Konstruktor
	 */
	public MaschineM3() {
		super();
		this.anschaffungskosten = 100000.0;
		this.aktuellerWert = anschaffungskosten;
		this.abschreibungsdauer = 5;
		calcAbschreibung();
		calcFixkosten();

		this.kapazitaet = 1000000.0;
		this.auswurf = 0.2;
		this.maschinenfuehrer = null;

		this.stufe = new MaschinenStufen();
	}

	/**
	 * Konstruktor mit bedienendem Mitarbeiter
	 * @param mitarbeiter
	 */
	public MaschineM3(Produktionsmitarbeiter mitarbeiter) {
		super();
		this.anschaffungskosten = 100000.0;
		this.aktuellerWert = anschaffungskosten;
		this.abschreibungsdauer = 5;
		calcAbschreibung();
		calcFixkosten();

		this.kapazitaet = 1000000.0;
		this.auswurf = 0.2;
		setMaschinenfuehrer(mitarbeiter);

		this.stufe = new MaschinenStufen();
	}
}
