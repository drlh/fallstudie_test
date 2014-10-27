package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.unternehmen.Unternehmen;
import de.spiel.unternehmen.mitarbeiter.Mitarbeiter;

/**
 * abstrakte Klasse Abteilung, bietet Grundgerüst für alle Abteilungen
 */
public abstract class Abteilung {
	protected String abteilungName;
	protected ArrayList<Mitarbeiter> mitarbeiter;

	private Unternehmen unternehmen;
	
	/**
	 * leerer Konstruktor
	 */
	public Abteilung() {
	}

	// SETTER
	public void setUnternehmen(Unternehmen unternehmen) {
		this.unternehmen = unternehmen;
	}

	// public Konto getKonto() {
	// return unternehmen.getKonto();
	// }

	// GETTER
	public Unternehmen getUnternehmen() {
		return unternehmen;
	}

	// GETTER
	public Lager getLager() {
		return unternehmen.getLager();
	}

	/**
	 * hinzufügen eines Mitarbeiters, ABSTRACT!
	 */
	public abstract void addMitarbeiter();

	public void addMitarbeiterO(Mitarbeiter obj) {
		this.mitarbeiter.add(obj);
	}

	// GETTER
	public Mitarbeiter get(int arg0) {
		return mitarbeiter.get(arg0);
	}

	// GETTER
	public ArrayList<Mitarbeiter> getMitarbeiterListe() {
		return this.mitarbeiter;
	}

	/**
	 * Mitarbeiter aus der Abteilung entlassen
	 * @param arg0
	 * @return
	 */
	public Mitarbeiter remove(int arg0) {
		return mitarbeiter.remove(arg0);
	}

	public boolean remove(Object arg0) {
		return mitarbeiter.remove(arg0);
	}

	// GETTER
	public int size() {
		return mitarbeiter.size();
	}

}
