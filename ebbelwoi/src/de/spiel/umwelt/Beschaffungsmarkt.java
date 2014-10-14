package de.spiel.umwelt;

import java.util.ArrayList;

import de.spiel.umwelt.beschaffung.Anbieter;

public class Beschaffungsmarkt {
	ArrayList<Anbieter> anbieter;
	ArrayList<Angebot> angeboteBauern;
	ArrayList<Angebot> angeboteGrosshaendler;

	public Beschaffungsmarkt() {
		anbieter = new ArrayList<Anbieter>();
		angeboteBauern = new ArrayList<Angebot>();
		angeboteGrosshaendler = new ArrayList<Angebot>();
	}

	public ArrayList<Angebot> getBauernAngebot() {
		return angeboteBauern;
	}
	
	public ArrayList<Angebot> getGrosshaendlerAngebot() {
		return angeboteGrosshaendler;
	}
}
