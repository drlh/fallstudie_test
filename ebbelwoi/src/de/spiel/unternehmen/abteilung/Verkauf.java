package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.unternehmen.mitarbeiter.*;
import de.spiel.umwelt.Angebot;
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

	public Angebot KneipeAngebotErstellen(double preis) {
		Kneipe k = (Kneipe) this.getUnternehmen().getUmwelt().getAbsatz().getKneipe();
		Angebot a = new Angebot(k.getMenge(), preis);
		return a;
	}

	public Angebot SMAngebotErstellen(double preis) {
		Supermarktkette s = (Supermarktkette) this.getUnternehmen().getUmwelt().getAbsatz().getSupermarktkette();
		Angebot a = new Angebot(s.getMenge(), preis);
		return a;
	}

	public Angebot GHAngebotErstellen(double preis) {
		Grosshandel g = (Grosshandel) this.getUnternehmen().getUmwelt().getAbsatz().getGrosshandel();
		Angebot a = new Angebot(g.getMenge(), preis);
		return a;
	}

}
