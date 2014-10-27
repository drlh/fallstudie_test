package de.spiel.unternehmen.abteilung.produktion;

import java.util.ArrayList;

import de.spiel.basic.Produkt;
import de.spiel.basic.Rohstoff;
import de.spiel.unternehmen.abteilung.Abteilung;
import de.spiel.unternehmen.maschinen.Maschine;
import de.spiel.unternehmen.maschinen.MaschineM1;
import de.spiel.unternehmen.maschinen.MaschineM2;
import de.spiel.unternehmen.maschinen.MaschineM3;
import de.spiel.unternehmen.mitarbeiter.Azubi;
import de.spiel.unternehmen.mitarbeiter.Geselle;
import de.spiel.unternehmen.mitarbeiter.Meister;
import de.spiel.unternehmen.mitarbeiter.Mitarbeiter;

/**
 * Klasse Produktion, beerbt Abteilung
 */
public class Produktion extends Abteilung {
	private ArrayList<Maschine> maschinenpark;
	private ArrayList<Produktionsauftrag> auftraege;

	/**
	 * leerer Konstruktor
	 */
	public Produktion() {
		super();
		this.abteilungName = "Produktion";
		this.mitarbeiter = new ArrayList<Mitarbeiter>();
		this.maschinenpark = new ArrayList<Maschine>();
		this.auftraege = new ArrayList<Produktionsauftrag>();
	}

	@Override
	public void addMitarbeiter() {
	}

	// GETTER
	public ArrayList<Maschine> getMaschinenpark() {
		return maschinenpark;
	}

	/**
	 * Azubi der Produktion zuweisen
	 */
	public void addAzubi() {
		this.mitarbeiter.add(new Azubi());
	}

	/**
	 * Geselle der Produktion zuweisen
	 */
	public void addGeselle() {
		this.mitarbeiter.add(new Geselle());
	}

	/**
	 * Meister der Produktion zuweisen
	 */
	public void addMeister() {
		this.mitarbeiter.add(new Meister());
	}

	/**
	 * Maschine der Produktion zuweisen, benötigt Maschine als Argument
	 * @param m
	 */
	public void addMaschine(Maschine m) {
		if (getUnternehmen().getFinanzen().getKonten().getUV().get("BA")
				.getKontostand() > m.getAnschaffungskosten()) {
			this.maschinenpark.add(m);
			getUnternehmen().getFinanzen().bucheEinkaufMaschine(
					m.getAnschaffungskosten());
		}
	}

	/**
	 * MaschineM1 der Produktion zuweisen
	 */
	public void addM1() {
		MaschineM1 m = new MaschineM1();
		if (getUnternehmen().getFinanzen().getKonten().getUV().get("BA")
				.getKontostand() > m.getAnschaffungskosten()) {
			this.maschinenpark.add(m);
			getUnternehmen().getFinanzen().bucheEinkaufMaschine(
					m.getAnschaffungskosten());
		}

	}

	/**
	 * MaschineM2 der Produktion zuweisen
	 */
	public void addM2() {
		MaschineM2 m = new MaschineM2();
		if (getUnternehmen().getFinanzen().getKonten().getUV().get("BA")
				.getKontostand() > m.getAnschaffungskosten()) {
			this.maschinenpark.add(m);
			getUnternehmen().getFinanzen().bucheEinkaufMaschine(
					m.getAnschaffungskosten());
		}
	}

	/**
	 * MaschineM3 der Produktion zuweisen
	 */
	public void addM3() {
		MaschineM3 m = new MaschineM3();
		if (getUnternehmen().getFinanzen().getKonten().getUV().get("BA")
				.getKontostand() > m.getAnschaffungskosten()) {
			this.maschinenpark.add(m);
			getUnternehmen().getFinanzen().bucheEinkaufMaschine(
					m.getAnschaffungskosten());
		}
	}

	/**
	 * Maschine aus Maschinenpark verkaufen
	 * @param index
	 */
	public void verkaufeMaschine(int index) {
		Maschine m = maschinenpark.get(index);
		getUnternehmen().getFinanzen().bucheMaschinenverkauf(
				m.getAktuellerWert());
		this.maschinenpark.remove(index);
	}

	/**
	 * Produktionsauftrag anlegen
	 * @param maschine
	 * @param rohstoff
	 */
	public void addAuftrag(Maschine maschine, Rohstoff rohstoff) {
		this.auftraege.add(new Produktionsauftrag(maschine, rohstoff));
	}

	/**
	 * Grundlage: 4kg Äpfel - 3l Apfelwein (Quelle: siehe Seminararbeit)
	 */
	public void produzieren() {
		for (int i = 0; i < auftraege.size(); i++) {
			if (auftraege.get(i).getProduzierendeMaschine().isBereit()) {
				double menge = auftraege.get(i).getVerwendeterRohsoff()
						.getMenge();
				double produktivitaetMa = (double) auftraege.get(i)
						.getProduzierendeMaschine().getMaschinenfuehrer()
						.getBonus() / 100;
				double maschinenstufe = (double) auftraege.get(i)
						.getProduzierendeMaschine().getStufe().getBonus() / 100;
				double auswurf = auftraege.get(i).getProduzierendeMaschine()
						.getAuswurf();

				double ausbringungsmenge = ((menge * (1 - (auswurf
						- maschinenstufe - produktivitaetMa))) / (4 / 3));

				// auf 2 Nachkommastellen runden
				ausbringungsmenge = Math.floor(ausbringungsmenge * 100) / 100;

				this.getLager().addProdukt(new Produkt(ausbringungsmenge));
				System.out.println(ausbringungsmenge);
			}

		}
	}

	@Override
	public String toString() {
		return "Produktion [maschinenpark=" + maschinenpark + ", auftraege="
				+ auftraege + ", mitarbeiter=" + mitarbeiter + "]";
	}

}
