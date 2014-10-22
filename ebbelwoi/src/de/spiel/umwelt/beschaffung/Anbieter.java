package de.spiel.umwelt.beschaffung;

import java.util.Random;
import de.spiel.basic.Qualitaetstufe;

public abstract class Anbieter {
	protected double MINP;
	protected double MAXP;
	protected int defstufe;
	protected double preis;
	protected Qualitaetstufe stufe = new Qualitaetstufe();
	
	public Anbieter(){
		Random r = new Random();
		preis = r.nextDouble();	
		initAnbieter();
	}

	public double getPreis() {
		return preis;
	}
	
	protected abstract void initAnbieter();

}
