package de.spiel.unternehmen.maschinen;

import de.spiel.basic.stufen.MaschinenStufen;
import de.spiel.unternehmen.mitarbeiter.Produktionsmitarbeiter;

/**
 * Klasse MaschineM1, beerbt Maschine
 */
public class MaschineM1 extends Maschine {
	/**
	 * leerer Konstruktor
	 */
	public MaschineM1() {
		super();
		this.anschaffungskosten = 30000.0;
		this.aktuellerWert = anschaffungskosten;
		this.abschreibungsdauer = 5;
		calcAbschreibung();
		calcFixkosten();

		this.kapazitaet = 100000.0;
		this.auswurf = 0.2;
		this.maschinenfuehrer = null;

		this.stufe = new MaschinenStufen();
	}

	/**
	 * Konstruktor mit bedienendem Mitarbeiter
	 * @param mitarbeiter
	 */
	public MaschineM1(Produktionsmitarbeiter mitarbeiter) {
		super();
		this.anschaffungskosten = 30000.0;
		this.aktuellerWert = anschaffungskosten;
		this.abschreibungsdauer = 5;
		calcAbschreibung();
		calcFixkosten();

		this.kapazitaet = 100000.0;
		this.auswurf = 0.2;
		setMaschinenfuehrer(mitarbeiter);

		this.stufe = new MaschinenStufen();

	}
}
