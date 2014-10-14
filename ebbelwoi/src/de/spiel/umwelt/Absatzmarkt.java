package de.spiel.umwelt;

import java.util.ArrayList;

import de.spiel.umwelt.absatz.Kunde;

public class Absatzmarkt {
	ArrayList<Kunde> kunden;
	ArrayList<Angebot> angeboteKneipen;
	ArrayList<Angebot> angeboteSupermarkt;
	double gesAbsatz;

	public Absatzmarkt() {
		// bei Spielstart: für jeden Spieler werden einige Kneipen und 1-2 Supermarktketten erzeugt
		kunden = new ArrayList<Kunde>();
		angeboteKneipen = new ArrayList<Angebot>();
		angeboteSupermarkt = new ArrayList<Angebot>();
	}

	public ArrayList<Angebot> getKneipenAngebote() {
		return angeboteKneipen;
	}
	
	public ArrayList<Angebot> getSupermarktAngebote() {
		return angeboteSupermarkt;
	}
}
