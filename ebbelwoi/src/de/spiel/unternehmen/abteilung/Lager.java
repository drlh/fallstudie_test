package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.basic.Produkt;
import de.spiel.basic.Rohstoff;

public class Lager {
	private ArrayList<Produkt> lagerlisteProdukt;
	private ArrayList<Rohstoff> lagerlisteRohstoffe;

	public Lager() {
		this.lagerlisteProdukt = new ArrayList<Produkt>();
		this.lagerlisteRohstoffe = new ArrayList<Rohstoff>();
	}

	public ArrayList<Produkt> getLagerlisteProdukt() {
		return lagerlisteProdukt;
	}

	public ArrayList<Rohstoff> getLagerlisteRohstoffe() {
		return lagerlisteRohstoffe;
	}

	public void addProdukt(Produkt arg0) {
		lagerlisteProdukt.add(arg0);
	}

	public Produkt getProdukt(int arg0) {
		return lagerlisteProdukt.get(arg0);
	}

	public Produkt removeProdukt(int arg0) {
		return lagerlisteProdukt.remove(arg0);
	}

	public void removeProdukt(Object arg0) {
		lagerlisteProdukt.remove(arg0);
	}

	public void addRohstoff(Rohstoff arg0) {
		lagerlisteRohstoffe.add(arg0);
	}

	public Rohstoff getRohstoff(int arg0) {
		return lagerlisteRohstoffe.get(arg0);
	}

	public Rohstoff removeRohstoff(int arg0) {
		return lagerlisteRohstoffe.remove(arg0);
	}

	public void removeRohstoff(Object arg0) {
		lagerlisteRohstoffe.remove(arg0);
	}

}
