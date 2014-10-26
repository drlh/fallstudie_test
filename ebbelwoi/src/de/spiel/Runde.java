package de.spiel;

import java.util.ArrayList;

import de.spiel.basic.Produkt;
import de.spiel.basic.Rohstoff;
import de.spiel.umwelt.Absatz;
import de.spiel.umwelt.Absatzmarkt;
import de.spiel.umwelt.Umwelt;
import de.spiel.umwelt.absatz.Kunde;
import de.spiel.unternehmen.abteilung.Finanzen;
import de.spiel.unternehmen.abteilung.Lager;

/**
 * Diese Klasse kümmert sich um die Abrechnung der Eingaben Ergebnisse
 */
public class Runde {
	ArrayList<Spieler> spielerRunde;

	private int aktuellerSpieler = 0;

	/**
	 * Konstruktor der Runde mti Spielerliste
	 */
	public Runde(ArrayList<Spieler> spieler) {
		this.spielerRunde = spieler;
		Umwelt.neueRunde();
		this.neueRunde();
	}

	/**
	 * Verbucht die Anfangsbestände der Runden
	 */
	private void neueRunde() {
		for (int i = 0; i < spielerRunde.size(); i++) {
			Spieler s = spielerRunde.get(i);

			s.getUnternehmen().getFinanzen()
					.bucheLagerAnfangsbestandRohstoffe();
			s.getUnternehmen().getFinanzen().bucheLagerAnfangsbestandProdukt();
		}
	}

	// GETTER
	public int getAktuellerSpieler() {
		return aktuellerSpieler;
	}
	
	/**
	 * nächster Spieler kommt an die Reihe
	 */
	private void nextSpieler() {
		if (aktuellerSpieler < spielerRunde.size()) {
			aktuellerSpieler++;
			Spiel.aktuellerSpielerName = spielerRunde.get(aktuellerSpieler)
					.getName();
		} else {
			beenden();
		}

	}

	/**
	 * Startet die gesamte Rundenauswertung
	 */
	public void beenden() {
		abrechnenAngebote();

		Spieler s = null;

		for (int i = 0; i < spielerRunde.size(); i++) {
			s = spielerRunde.get(i);

			Finanzen f = s.getUnternehmen().getFinanzen();

			abrechnenGehalt(f);
			abrechnenZinsaufwand(f);
			abrechnenAFA(f);
			abrechnenFixkosten(f);

			abrechnenAbsatzSpieler(f);

			abrechnenLagerQualität(f);
			abrechnenLagerEndbestand(f);

			f.rundeAbrechnen();
		}
	}
	
	
	private void abrechnenGehalt(Finanzen f) {
		f.bucheGehalt();
	}

	private void abrechnenZinsaufwand(Finanzen f) {
		f.bucheZinsaufwand();
	}

	private void abrechnenAFA(Finanzen f) {
		f.bucheAFA();
	}

	private void abrechnenFixkosten(Finanzen f) {
		f.bucheFixkostenProd();
	}

	/**
	 * Startet die Abrechnung der Angebote
	 */
	private void abrechnenAngebote() {
		Kunde[] kunden = Umwelt.getAbsatz().getKundenListe();

		for (int i = 0; i < kunden.length; i++) {
			kunden[i].berechneAbsatz();
		}

	}

	private void abrechnenAbsatzSpieler(Finanzen f) {
		Absatz[] absatz = new Absatz[3];
		String s = f.getUnternehmen().getSpielerName();

		Absatzmarkt abm = Umwelt.getAbsatz();

		try {
			absatz[0] = abm.getKneipe().getAbsatz().get(s);
			absatz[1] = abm.getSupermarktkette().getAbsatz().get(s);
			absatz[2] = abm.getGrosshandel().getAbsatz().get(s);

			Lager l = f.getLager();
			Produkt p = null;

			for (int i = 0; i < absatz.length; i++) {
				Absatz a = absatz[i];

				// Bestände
				if (a != null) {
					int lagerpos = a.getLagerpos();
					p = l.getProdukt(lagerpos);
					double menge = a.getMenge();
					double differenz = 0.0;

					if (p.getMenge() - menge > 0) {
						differenz = p.getMenge() - menge;
						l.bestandMindernProdukt(differenz, lagerpos);
					} else if (p.getMenge() - menge == 0) {
						l.removeProdukt(lagerpos);
					}

					// Umsatz
					f.bucheUmsatz(a.getUmsatz());
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Mindert die Qualität der Bestände
	 * 
	 * @param f
	 */
	private void abrechnenLagerQualität(Finanzen f) {
		ArrayList<Produkt> p = f.getLager().getLagerlisteProdukt();
		ArrayList<Rohstoff> r = f.getLager().getLagerlisteRohstoffe();

		for (int j = 0; j < p.size(); j++) {
			p.get(j).getQualitaet().qualitaetMindern();
		}
		for (int j = 0; j < r.size(); j++) {
			r.get(j).getQualitaet().qualitaetMindern();
		}
	}

	private void abrechnenLagerEndbestand(Finanzen f) {
		f.bucheLagerEndbestandProdukt();
		f.bucheLagerEndbestandRohstoffe();
	}
}
