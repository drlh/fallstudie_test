package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.unternehmen.mitarbeiter.*;
import de.spiel.umwelt.Angebot;

public class Einkauf extends Abteilung {
	ArrayList<Angebot> angebote;
	
	public Einkauf() {
		super();
		this.abteilungName = "Einkauf";
		this.mitarbeiter = new ArrayList<Mitarbeiter>();

	}

	@Override
	public void addMitarbeiter() {
		this.mitarbeiter.add(new Vertrieb());
	}

	public void getAngebot(boolean bauer) {
		//es fehlt eine Art getSpiel, damit man auf die Umwelt referenzieren kann
		if (bauer) {
			//getSpiel().getUmwelt().getBMarkt().getBauernAngebot();
		} else {
			//getSpiel().getUmwelt().getBMarkt().getGrosshaendlerAngebot();
		}		
	}

}
