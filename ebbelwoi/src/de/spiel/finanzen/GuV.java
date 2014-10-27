package de.spiel.finanzen;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Klasse GuV
 * beinhaltet die Gewinn- und Verlustrechnung eines Spielers
 */
public class GuV {
	Hashtable<String, Double> aufwand;
	Hashtable<String, Double> ertrag;
	Hashtable<String, Double> bv;

	/**
	 * leerer Konstruktor
	 */
	public GuV() {
		aufwand = new Hashtable<String, Double>();
		ertrag = new Hashtable<String, Double>();
		bv = new Hashtable<String, Double>();
	}

	// GETTER
	public Hashtable<String, Double> getAufwand() {
		return aufwand;
	}

	// GETTER
	public Hashtable<String, Double> getErtrag() {
		return ertrag;
	}

	// GETTER
	public Hashtable<String, Double> getBv() {
		return bv;
	}

	/**
	 * hinzufügen eines Aufwandskontos
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	public Double putAufwand(String arg0, Double arg1) {
		return aufwand.put(arg0, arg1);
	}

	/**
	 * hinzufügen eines Ertragskontos
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	public Double putErtrag(String arg0, Double arg1) {
		return ertrag.put(arg0, arg1);
	}

	/**
	 * hinzufügen einer Bestandsveränderung
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	public Double putBV(String arg0, Double arg1) {
		return bv.put(arg0, arg1);
	}

	// ERGEBNIS
	/**
	 * abrechnen des Ergebnisses aus der GuV
	 * @return
	 */
	protected double abrechnen() {
		Enumeration<String> aufwand = this.aufwand.keys();
		Enumeration<String> ertrag = this.ertrag.keys();
		Enumeration<String> bv = this.bv.keys();

		double aufwandSumme = 0.0;
		double ertragSumme = 0.0;
		double bvSumme = 0.0;

		double ergebnis = 0.0;

		while (aufwand.hasMoreElements()) {
			String s = (String) aufwand.nextElement();
			aufwandSumme += this.aufwand.get(s);
		}
		while (ertrag.hasMoreElements()) {
			String s = (String) ertrag.nextElement();
			ertragSumme += this.ertrag.get(s);
		}
		while (bv.hasMoreElements()) {
			String s = (String) bv.nextElement();
			ertragSumme += this.bv.get(s);
		}

		if (bvSumme < 0) {
			aufwandSumme += Math.abs(bvSumme);
		} else if (bvSumme > 0) {
			ertragSumme += bvSumme;
		}

		ergebnis = ertragSumme - aufwandSumme;

		return ergebnis;

	}
}
