package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.unternehmen.mitarbeiter.*;
import de.spiel.umwelt.beschaffung.*;

public class Einkauf extends Abteilung {
	
	public Einkauf() {
		super();
		this.abteilungName = "Einkauf";
		this.mitarbeiter = new ArrayList<Mitarbeiter>();

	}

	@Override
	public void addMitarbeiter() {
		this.mitarbeiter.add(new Vertrieb());
	}

	public void getBauernAngebot() {
		Bauer b = this.getUnternehmen().getUmwelt().getBeschaffung().getBauer();
		double bauernAngebot = b.getPreis();
	}
	
	public void getGrosshaendlerAngebot() {
		Grosshaendler g = this.getUnternehmen().getUmwelt().getBeschaffung().getGrosshaendler();
		double grosshAngebot = g.getPreis();
	}

}
