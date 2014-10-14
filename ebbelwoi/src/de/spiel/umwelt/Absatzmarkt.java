package de.spiel.umwelt;

import java.util.ArrayList;

import de.spiel.umwelt.absatz.Kunde;

public class Absatzmarkt {
	ArrayList<Kunde> kunden;
	double gesAbsatz;

	public Absatzmarkt() {
		kunden = new ArrayList<Kunde>();
		// wie wird befüllt?
	}

	public double getPotAbsatz() {
		gesAbsatz = 0;
		for (int i = 0; i < kunden.size(); i++) {
			gesAbsatz += kunden.get(i).getAbsatz();
		}
		return gesAbsatz;
	}
}
