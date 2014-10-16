package de.spiel.umwelt.absatz;

import java.util.Random;

public abstract class Kunde {
    
	private double MINAB;
	private double MAXAB;
	private double MINP;
	private double MAXP ;
	
	private double preis;
	private double menge;
	
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
	
	/**
	 * legt die Grenzen der Intervalle fest und errechnet den aktuellen Bedarf und Preis
	 */
	protected abstract void initKunde();
	
}
