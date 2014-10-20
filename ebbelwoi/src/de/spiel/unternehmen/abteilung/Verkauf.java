package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.unternehmen.mitarbeiter.*;
import de.spiel.umwelt.absatz.*;

public class Verkauf extends Abteilung {

	public Verkauf() {
		super();
		this.abteilungName = "Verkauf";
		this.mitarbeiter = new ArrayList<Mitarbeiter>();
	}

	@Override
	public void addMitarbeiter() {
		this.mitarbeiter.add(new Vertrieb());
	}

	public void KneipeAngebotErstellen() {
		Kneipe k = (Kneipe) this.getUnternehmen().getUmwelt().getAbsatz().getKneipe();
	}

	public void SMAngebotErstellen() {
		Supermarktkette s = (Supermarktkette) this.getUnternehmen().getUmwelt().getAbsatz().getSupermarktkette();
	}

	public void GHAngebotErstellen() {
		Grosshandel g = (Grosshandel) this.getUnternehmen().getUmwelt().getAbsatz().getGrosshandel();
	}

}
