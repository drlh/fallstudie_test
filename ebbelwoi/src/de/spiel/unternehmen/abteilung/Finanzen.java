package de.spiel.unternehmen.abteilung;

import java.lang.reflect.Array;
import java.util.ArrayList;

import de.spiel.Spiel;
import de.spiel.basic.Produkt;
import de.spiel.basic.Rohstoff;
import de.spiel.finanzen.*;
import de.spiel.umwelt.Absatz;
import de.spiel.umwelt.Absatzmarkt;
import de.spiel.umwelt.Umwelt;
import de.spiel.unternehmen.maschinen.Maschine;
import de.spiel.unternehmen.mitarbeiter.Mitarbeiter;

/**
 * Klasse Finanzen beinhaltet komplettes Buchungssystem etc, beerbt Abteilung
 */
public class Finanzen extends Abteilung {
	private Kontenplan konten;
	private ArrayList<Bilanz> bilanzen;

	private boolean start = true;

	/**
	 * leerer Konstruktor
	 */
	public Finanzen() {
		super();
		this.abteilungName = "Finanzen";
		this.konten = new Kontenplan();
		this.bilanzen = new ArrayList<Bilanz>();

	}

	@Override
	// Wird nicht benutzt
	public void addMitarbeiter() {
	}

	// GETTER
	public Kontenplan getKonten() {
		return konten;
	}

	// GETTER
	public Snapshot getBilanzSnapshot() {
		Snapshot b = new Snapshot();

		b.addAktiva("MA", getKonten().getAV().get("MA").getKontostand());
		b.addAktiva("RS", getKonten().getUV().get("RS").getKontostand());
		b.addAktiva("FE", getKonten().getUV().get("FE").getKontostand());
		b.addAktiva("BA", getKonten().getUV().get("BA").getKontostand());

		b.addPassiva("EK", getKonten().getEK().get("EK").getKontostand());
		b.addPassiva("DA", getKonten().getFK().get("DA").getKontostand());

		return b;
	}

	// GETTER
	public Bilanz getBilanz(int runde) {
		return this.bilanzen.get(runde);
	}

	/**
	 * Buchungsvorgang, Soll an Haben mit Betrag
	 * @param soll
	 * @param haben
	 * @param betrag
	 * @return
	 */
	public boolean buchen(String soll, String haben, double betrag) {
		return konten.buchen(soll, haben, betrag);
	}

	/**
	 * abrechnen am Ende der Runde
	 */
	public void rundeAbrechnen() {
		Bilanz b = konten.erstelleBilanz();
		b.aufstellenBilanz();
		bilanzen.add(b);
	}

	// SPEZIFISCHE BUCHUNGEN
	// ERFOLGSWIRKSAM
	/* Aufwand */
	/**
     * Startguthaben wird gebucht
     */
	public void bucheStartguthaben() {
		if (start) {
			// this.getKonten().getUV().get("BA").sollBuchen(Spiel.STARTGUTHABEN);
			this.buchen("BA", "EK", 10000.0);
			start = false;
		}
	}

	/**
     * Gehaltsbuchungen werden durchgeführt
     */
	public void bucheGehalt() {
		ArrayList<ArrayList<Mitarbeiter>> maUn = new ArrayList<ArrayList<Mitarbeiter>>();

		for (int i = 0; i < 5; i++) {
			maUn.add(getUnternehmen().getAbteilung(i).getMitarbeiterListe());
		}

		for (int i = 0; i < maUn.size(); i++) {
			ArrayList<Mitarbeiter> ma = maUn.get(i);

			try {
				for (int j = 0; j < ma.size(); j++) {

					try {
						double d = ma.get(i).getGehalt();
						if (d > 0)
							this.buchen("AGE", "BA", d);
					} catch (IndexOutOfBoundsException e) {
						// TODO: handle exception
					}

				}

			} catch (NullPointerException e) {
				// TODO: handle exception
			}
		}
	}

	/**
     * AfA-Buchungen werden gebucht
     */
	public void bucheAFA() {
		ArrayList<Maschine> maschinen = getUnternehmen().getProduktion()
				.getMaschinenpark();

		for (int i = 0; i < maschinen.size(); i++) {
			Maschine m = maschinen.get(i);
			double d = m.getAbschreibung();
			if (d > 0) {
				this.buchen("AFA", "MA", d);
				m.doAbschreibung();
			}
		}
	}

	/**
     * Fixkosten der Produktion werden gebucht
     */
	public void bucheFixkostenProd() {
		ArrayList<Maschine> maschinen = getUnternehmen().getProduktion()
				.getMaschinenpark();

		for (int i = 0; i < maschinen.size(); i++) {
			double d = maschinen.get(i).getAbschreibung();

			if (d > 0)
				this.buchen("AMA", "BA", d);
		}
	}

	/**
	 * Buchungen der Zinsaufwände
	 */
	public void bucheZinsaufwand() {
		double kreditbetrag = this.getKonten().getFK().get("DA")
				.getKontostand();

		if (kreditbetrag > 0) {
			double zinsAufwand = kreditbetrag * ((Spiel.KREDITZINS / 100) / 12);
			zinsAufwand = Math.floor((zinsAufwand * 100) + 0.5) / 100;
			this.buchen("AFZ", "BA", zinsAufwand);
		}
	}

	/**
	 * Buchung des Schulungsaufwand
	 * @param betrag
	 */
	public void bucheSchulungsaufwand(double betrag) {
		this.buchen("AFS", "BA", betrag);
	}

	/**
	 * Buchung des Aufwandes für Maschinenupgrade
	 * @param betrag
	 */
	public void bucheMaschinenUpgrade(double betrag) {
		this.buchen("AMA", "BA", betrag);
	}

	/**
	 * Buchung Anschaffung Maschine
	 * @param betrag
	 */
	public void bucheMaschinenAnschaffung(double betrag) {
		this.buchen("MA", "BA", betrag);
	}

	/**
	 * Buchung Verkauf Maschine
	 * @param betrag
	 */
	public void bucheMaschinenverkauf(double betrag) {
		this.buchen("BA", "MA", betrag);
	}

	/* Ertrag */
	/**
     * Buchung des Umsatzes an die Bank (Bank an UefeE)
     */
	public void bucheUmsatz(double betrag) {
		this.buchen("BA", "EUE", betrag);
	}

	// ERFOLGSNEUTRAL
	/**
	 * Buchung der Rohstoffainkäufe (Rohstoffe an Bank)
	 * @param betrag
	 */
	public void bucheEinkaufRS(double betrag) {
		this.buchen("RS", "BA", betrag);
	}

	/**
	 * Buchung Maschinenkauf (Maschine an Bank)
	 * @param betrag
	 */
	public void bucheEinkaufMaschine(double betrag) {
		this.buchen("MA", "BA", betrag);
	}

	/**
	 * Buchung Tilgung eines Kredits (Darlehen an Bank)
	 * @param betrag
	 */
	public void bucheTilgungKredit(double betrag) {
		this.buchen("DA", "BA", betrag);

	}

	// BESTÄNDE
	/**
     * Buchung Anfangsbestand Rohstoffe
     */
	public void bucheLagerAnfangsbestandRohstoffe() {
		double wert = getUnternehmen().getLager().getMengeRohstoffe()
				* Spiel.EINKAUFSPREIS;
		getKonten().getUV().get("RS").sollBuchen(wert);
	}

	/**
     * Buchung Endbestand Rohstoffe
     */
	public void bucheLagerEndbestandRohstoffe() {
		double wert = getUnternehmen().getLager().getMengeRohstoffe()
				* Spiel.EINKAUFSPREIS;
		getKonten().getUV().get("RS").habenBuchen(wert);
	}

	/**
     * Buchung Anfangsbestand Produkt
     */
	public void bucheLagerAnfangsbestandProdukt() {
		double wert = getUnternehmen().getLager().getMengeProdukte()
				* Spiel.PRODUKT_BILANZWERT;
		getKonten().getUV().get("FE").sollBuchen(wert);
	}

	/**
     * Buchung Endbestand Produkt
     */
	public void bucheLagerEndbestandProdukt() {
		double wert = getUnternehmen().getLager().getMengeProdukte()
				* Spiel.PRODUKT_BILANZWERT;
		getKonten().getUV().get("FE").habenBuchen(wert);
	}

}
