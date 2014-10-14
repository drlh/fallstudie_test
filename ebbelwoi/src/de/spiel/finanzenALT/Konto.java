package de.spiel.finanzenALT;

import java.util.ArrayList;

public class Konto {
	private String kontoName;
	private double kontoStand;
	private ArrayList<Transaktion> liste;

	public Konto(String name, double anfangsbestand) {
		this.kontoName = name;
		this.kontoStand = anfangsbestand;
		liste = new ArrayList<Transaktion>();
	}

	// GETTER
	public String getKontoName() {
		return kontoName;
	}

	public double getKontoStand() {
		return kontoStand;
	}

	// OTHER METHODS
	public boolean einzahlen(double betrag, String abtName, String transTyp) {
		liste.add(new Transaktion(betrag, abtName, transTyp));
		if (betrag > 0) {
			this.kontoStand += betrag;
			return true;
		} else {
			return false;
		}
	}

	public boolean auszahlen(double betrag, String abtName, String transTyp) {
		liste.add(new Transaktion(betrag, abtName, transTyp));
		if (betrag > 0) {
			double div = kontoStand - betrag;
			if (div >= 0) {
				this.kontoStand -= betrag;
				return true;
			} else {
				if (div < 0) {
					this.kontoStand -= Math.abs(div);
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
	
	public ArrayList<Transaktion> getTransaktionsListe(){
		return liste;
	}
	
	@Override
	public String toString() {
		return "Konto [kontoName=" + kontoName + ", kontoStand=" + kontoStand
				+ "]";
	}

}
