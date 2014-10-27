package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.unternehmen.mitarbeiter.Mitarbeiter;
import de.spiel.unternehmen.mitarbeiter.Vertrieb;

/**
 * Klasse, die für das Marketing zuständig ist, beerbt Abteilung
 */
public class Marketing extends Abteilung {
	/**
	 * leerer Konstruktor
	 */
	public Marketing() {
		super();
		this.abteilungName = "Marketing";
		this.mitarbeiter = new ArrayList<Mitarbeiter>();
	}

	@Override
	public void addMitarbeiter() {
		this.mitarbeiter.add(new Vertrieb());
	}
}
