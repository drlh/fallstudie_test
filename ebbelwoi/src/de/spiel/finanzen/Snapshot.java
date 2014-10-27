package de.spiel.finanzen;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Klasse Snapshot
 * erstellt einen Snapshot der Bilanz, zur Ausgabe in der GUI
 */
public class Snapshot {
	Hashtable<String, Double> aktiva;
	Hashtable<String, Double> passiva;

	/**
	 * leerer Konstruktor
	 */
	public Snapshot() {
		aktiva = new Hashtable<String, Double>();
		passiva = new Hashtable<String, Double>();
	}

	/**
	 * Aktiva werden hinzugefügt
	 * @param s
	 * @param d
	 */
	public void addAktiva(String s, double d) {
		aktiva.put(s, d);
	}

	/**
	 * Passiva werden hinzugefügt
	 * @param s
	 * @param d
	 */
	public void addPassiva(String s, double d) {
		passiva.put(s, d);
	}

	// GETTER
	public double getMaschinenkonto() {
		return aktiva.get("MA");
	}

	// GETTER
	public double getRohstoffkonto() {
		return aktiva.get("RS");
	}

	// GETTER
	public double getFertigerzeugniskonto() {
		return aktiva.get("FE");
	}

	// GETTER
	public double getBankkonto() {
		return aktiva.get("BA");
	}

	// GETTER
	public double getEKkonto() {
		return passiva.get("EK");
	}

	// GETTER
	public double getDarlehenkonto() {
		return passiva.get("DA");
	}

	// GETTER
	public int getAkitvaSize() {
		return aktiva.size();
	}

	// GETTER
	public int getPassivaSize() {
		return passiva.size();
	}

	/**
	 * gibt Summe aller Aktiva aus
	 * @return
	 */
	public double summeAktiva() {
		Enumeration<String> s = aktiva.keys();
		double d = 0.0;
		while (s.hasMoreElements()) {
			String string = (String) s.nextElement();
			d += aktiva.get(string);
		}
		return d;
	}

	/**
	 * gibt Summe aller Passiva aus
	 * @return
	 */
	public double summePassiva() {
		Enumeration<String> s = passiva.keys();
		double d = 0.0;
		while (s.hasMoreElements()) {
			String string = (String) s.nextElement();
			d += passiva.get(string);
		}
		return d;
	}
}
