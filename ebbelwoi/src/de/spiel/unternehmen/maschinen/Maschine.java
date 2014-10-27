package de.spiel.unternehmen.maschinen;

import de.spiel.basic.stufen.MaschinenStufen;
import de.spiel.unternehmen.mitarbeiter.Mitarbeiter;

/**
 * abstrakte Klasse Maschine
 */
public abstract class Maschine {
	protected double anschaffungskosten;
	protected int abschreibungsdauer;
	protected double abschreibung;
	protected double aktuellerWert;
	protected double fixkosten;

	protected double kapazitaet;
	protected double auswurf;
	protected Mitarbeiter maschinenfuehrer;

	private boolean bereit = false;

	private int anschaffungsrunde = 0;

	protected MaschinenStufen stufe;

	/**
	 * leerer Konstruktor
	 */
	public Maschine() {
		this.stufe = new MaschinenStufen();
	}

	// GETTER
	public double getAnschaffungskosten() {
		return anschaffungskosten;
	}

	// GETTER
	public int getAbschreibungsdauer() {
		return abschreibungsdauer;
	}

	// GETTER
	public double getAbschreibung() {
		if (aktuellerWert - abschreibung >= 0) {
			return abschreibung;
		} else
			return 0.0;
	}

	// GETTER
	public double getAktuellerWert() {
		return aktuellerWert;
	}

	// GETTER
	public double getFixkosten() {
		return fixkosten;
	}

	// GETTER
	public double getKapazitaet() {
		return kapazitaet;
	}

	// GETTER
	public double getAuswurf() {
		return auswurf;
	}

	// GETTER
	public Mitarbeiter getMaschinenfuehrer() {
		return maschinenfuehrer;
	}

	// GETTER
	public MaschinenStufen getStufe() {
		return stufe;
	}

	// GETTER
	public boolean isBereit() {
		return bereit;
	}

	// SETTER
	public void setMaschinenfuehrer(Mitarbeiter maschinenfuehrer) {
		this.setBereit(true);
		this.maschinenfuehrer = maschinenfuehrer;
	}

	// SETTER
	protected void setAktuellerWert(double aktuellerWert) {
		this.aktuellerWert = aktuellerWert;
	}

	// SETTER
	public void setBereit(boolean bereit) {
		this.bereit = bereit;
	}

	// OTHER
	protected void calcAbschreibung() {
		this.abschreibung = (anschaffungskosten / abschreibungsdauer) / 12;
	}

	protected void calcFixkosten() {
		this.fixkosten = (0.15 * anschaffungskosten) / 12;
	}

	public void doAbschreibung() {
		setAktuellerWert(aktuellerWert - abschreibung);
	}

}
