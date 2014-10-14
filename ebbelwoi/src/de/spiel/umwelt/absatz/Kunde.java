package de.spiel.umwelt.absatz;

import java.util.Random;

public class Kunde {
	double menge;
	double preis;
	
	public Kunde(){
		Random r = new Random();
		menge = r.nextDouble();
		preis = r.nextDouble();		
	}
	
	public double getMenge() {
		return menge;
	}

	public double getPreis() {
		return preis;
	}
	
}
