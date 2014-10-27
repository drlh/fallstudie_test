package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.basic.Produkt;
import de.spiel.basic.Rohstoff;

/**
 * Klasse Lager, beinhaltet alle Rohstoffe, fertigen Erzeugnisse etc.
 */
public class Lager {
	private ArrayList<Produkt> lagerlisteProdukt;
	private ArrayList<Rohstoff> lagerlisteRohstoffe;

	/**
	 * leerer Konstruktor
	 */
	public Lager() {
		this.lagerlisteProdukt = new ArrayList<Produkt>();
		this.lagerlisteRohstoffe = new ArrayList<Rohstoff>();
	}

	// GETTER
	public ArrayList<Produkt> getLagerlisteProdukt() {
		return lagerlisteProdukt;
	}

	// GETTER
	public ArrayList<Rohstoff> getLagerlisteRohstoffe() {
		return lagerlisteRohstoffe;
	}

	/**
	 * hinzufügen Produkt zum Lager
	 * @param arg0
	 */
	public void addProdukt(Produkt arg0) {
		lagerlisteProdukt.add(arg0);
	}

	// GETTER
	public Produkt getProdukt(int arg0) {
		return lagerlisteProdukt.get(arg0);
	}

	/**
	 * Produkt aus Lager entfernen
	 * @param arg0
	 * @return
	 */
	public Produkt removeProdukt(int arg0) {
		return lagerlisteProdukt.remove(arg0);
	}

	public void removeProdukt(Object arg0) {
		lagerlisteProdukt.remove(arg0);
	}

	/**
	 * hinzufüge Rohstoffzum Lager
	 * @param arg0
	 */
	public void addRohstoff(Rohstoff arg0) {
		lagerlisteRohstoffe.add(arg0);
	}

	// GETTER
	public Rohstoff getRohstoff(int arg0) {
		return lagerlisteRohstoffe.get(arg0);
	}

	/**
	 * Rohstoff aus Lager entfernen
	 * @param arg0
	 * @return
	 */
	public Rohstoff removeRohstoff(int arg0) {
		return lagerlisteRohstoffe.remove(arg0);
	}

	public void removeRohstoff(Object arg0) {
		lagerlisteRohstoffe.remove(arg0);
	}

	// GETTER
	public double getMengeProdukte() {
		double d = 0.0;

		for (int i = 0; i < lagerlisteProdukt.size(); i++) {
			d += lagerlisteProdukt.get(i).getMenge();
		}

		return d;
	}

	// GETTER
	public double getMengeRohstoffe() {
		double d = 0.0;

		for (int i = 0; i < lagerlisteRohstoffe.size(); i++) {
			d += lagerlisteRohstoffe.get(i).getMenge();
		}

		return d;
	}

	/**
	 * Minderung des Produktbestandes
	 * @param mindermenge
	 * @param index
	 */
	public void bestandMindernProdukt(double mindermenge, int index) {
		double menge = getProdukt(index).getMenge() - mindermenge;
		getProdukt(index).setMenge(menge);
	}

	/**
	 * Minderung des Rohstoffbestandes
	 * 
	 * @param mindermenge
	 * @param index
	 */
	public void bestandMindernRohstoff(double mindermenge, int index) {
		double menge = getRohstoff(index).getMenge() - mindermenge;
		getRohstoff(index).setMenge(menge);
	}

	@Override
	public String toString() {
		return "Lager [lagerlisteProdukt=" + lagerlisteProdukt
				+ ", lagerlisteRohstoffe=" + lagerlisteRohstoffe + "]";
	}

}
