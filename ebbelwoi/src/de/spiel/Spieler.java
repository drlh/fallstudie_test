package de.spiel;

import de.spiel.unternehmen.Unternehmen;

/**
 * Klasse für die Spieler
 *
 */
public class Spieler {
	private String name;
	private Unternehmen unternehmen;

	/**
	 * leerer Konstruktor mit Standardname
	 */
	public Spieler() {
		this.name = "kein Name" + ((int) Math.random() * 10000);
		this.unternehmen = new Unternehmen();
		this.unternehmen.setSpielerName(name);
	}

	/**
	 * Konstruktor mit Name
	 * @param name
	 */
	public Spieler(String name) {
		this.name = name;
		this.unternehmen = new Unternehmen();
		this.unternehmen.setSpielerName(name);
	}

	// GETTER
	public String getName() {
		return name;
	}

	// GETTER
	public Unternehmen getUnternehmen() {
		return unternehmen;
	}

	@Override
	public String toString() {
		return "Spieler [name=" + name + "]";
	}

}
