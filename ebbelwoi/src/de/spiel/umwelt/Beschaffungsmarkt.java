package de.spiel.umwelt;

import java.util.ArrayList;

import de.spiel.umwelt.absatz.Kunde;
import de.spiel.umwelt.beschaffung.Anbieter;

public class Beschaffungsmarkt {
	double gesAngebot;
	ArrayList<Anbieter> anbieter;

	public Beschaffungsmarkt() {
		anbieter = new ArrayList<Anbieter>();
		// wie wird befüllt?
	}

	public double getPotAngebot() {
		gesAngebot = 0;
		for (int i = 0; i < anbieter.size(); i++) {
			gesAngebot += anbieter.get(i).getAngebot();
		}
		return gesAngebot;
	}
}
