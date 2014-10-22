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

	public double getBauernAngebot() {
		Bauer b = this.getUnternehmen().getUmwelt().getBeschaffung().getBauer();
		return b.getPreis();
	}
	
	public double getGrosshaendlerAngebot() {
		Grosshaendler g = this.getUnternehmen().getUmwelt().getBeschaffung().getGrosshaendler();
		return g.getPreis();
	}

}
