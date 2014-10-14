package de.spiel.umwelt.beschaffung;

import java.util.Random;
import de.spiel.basic.Qualitaetstufe;

public class Anbieter {
	double preis;
	Qualitaetstufe stufe;
	
	public Anbieter(){
		Random r = new Random();
		preis = r.nextDouble();		
	}

	public double getPreis() {
		return preis;
	}

}
