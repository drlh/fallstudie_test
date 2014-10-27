package de.spiel.finanzen;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import de.spiel.finanzen.konto.Aktivkonto;
import de.spiel.finanzen.konto.Aufwandskonto;
import de.spiel.finanzen.konto.Bestandsveraenderungen;
import de.spiel.finanzen.konto.Ertragskonto;
import de.spiel.finanzen.konto.Konto;
import de.spiel.finanzen.konto.Passivkonto;

/**
 * Klasse Kontenplan
 * beinhaltet alle Konten eines Spielers
 */
public class Kontenplan {
	// BILANZ
	// AKTIVA
	private Hashtable<String, Konto> AV;
	private Hashtable<String, Konto> UV;
	// PASSIVA
	private Hashtable<String, Konto> EK;
	private Hashtable<String, Konto> FK;

	// GUV
	private Hashtable<String, Konto> ERTRAG;
	private Hashtable<String, Konto> AUFWAND;
	private Hashtable<String, Konto> BV;

	/**
	 * leerer Konstruktor
	 */
	public Kontenplan() {
		initKonten();
	}

	/**
	 * Erstellt alle ben�tigten Konten mit Kontenschl�ssel: AV - Konten im
	 * Anlageverm�gen MA - Maschinen
	 * 
	 * UV - Konten des Umlaufverm�gens RS - Rohstoffe FE - Fertigerzeignisse BA
	 * - Bank
	 * 
	 * EK - Konten des Eigenkapitals EK - Eigenkapitl
	 * 
	 * FK - Konten des Fremdkapitals DA - Darlehen
	 * 
	 * ERTRAG - Ertragskonten f�r Ertr�ge die in die GuV zusammenlaufen
	 * EUE-Umsatzerl�se
	 * 
	 * AUFWAND - Aufwandskonten f�r Aufw�nde die in die GuV zusammenlaufen AFA -
	 * Abschreibungen AGE - Gehalt ARS - Aufwand f�r Rohstoffe AMA - Aufwand f�r
	 * Maschinen AFS - Aufwand f�r Schulungen AFZ - Aufwand f�r Zinsen BV -
	 * Bestandsver�nderungen BV - Bestandsver�nderungskonto
	 */
	private void initKonten() {
		// BILANZ
		// AKTIVA
		AV = new Hashtable<>();
		AV.put("MA", new Aktivkonto("Maschinen"));

		UV = new Hashtable<>();
		UV.put("RS", new Aktivkonto("Rohstoffe"));
		UV.put("BA", new Aktivkonto("Bank"));
		UV.put("FE", new Aktivkonto("Fertigerzeugnisse"));

		// PASSIVA
		EK = new Hashtable<>();
		EK.put("EK", new Passivkonto("Eigenkapital"));

		FK = new Hashtable<>();
		FK.put("DA", new Passivkonto("Darlehen"));

		// GUV Konten
		ERTRAG = new Hashtable<>();
		ERTRAG.put("EUE", new Ertragskonto("Umsatzerl�se"));

		AUFWAND = new Hashtable<>();
		AUFWAND.put("AFA", new Aufwandskonto("Aufwand f�r Abschreibungen"));
		AUFWAND.put("AFZ", new Aufwandskonto("Aufwand f�r Zinsen"));
		AUFWAND.put("AGE", new Aufwandskonto("Aufwand f�r Gehalt"));
		AUFWAND.put("ARS", new Aufwandskonto("Aufwand f�r Rohstoffe"));
		AUFWAND.put("AMA", new Aufwandskonto("Aufwand f�r Maschinen"));
		AUFWAND.put("AFS", new Aufwandskonto("Aufwand f�r Schulungen"));

		BV = new Hashtable<>();
		BV.put("BV", new Bestandsveraenderungen("Bestandsver�nderung"));
	}

	/**
	 * gibt alle Konten als ArrayList<Hashtable<String, Konto>> zur�ck
	 * @return
	 */
	public ArrayList<Hashtable<String, Konto>> getAll() {
		ArrayList<Hashtable<String, Konto>> k = new ArrayList<>();
		k.add(AV);
		k.add(UV);
		k.add(EK);
		k.add(FK);
		k.add(ERTRAG);
		k.add(AUFWAND);
		k.add(BV);

		return k;
	}

	/**
	 * bucht eine Buchung mit Betrag x, Soll an Haben
	 * @param soll
	 * @param haben
	 * @param betrag
	 * @return
	 */
	public boolean buchen(String soll, String haben, double betrag) {
		if (soll.equals(haben)) {
			return false;
		} else {
			ArrayList<Hashtable<String, Konto>> k = getAll();

			Konto kSoll = null;
			Konto kHaben = null;

			for (int i = 0; i < k.size(); i++) {
				if (k.get(i).get(soll) != null)
					kSoll = k.get(i).get(soll);
				if (k.get(i).get(haben) != null)
					kHaben = k.get(i).get(haben);
			}

			if (kSoll == null || kHaben == null) {
				return false;
			} else {
				kSoll.sollBuchen(betrag);
				kHaben.habenBuchen(betrag);

				return true;
			}

		}

	}

	/**
	 * Aufstellung der Bilanz
	 * @return
	 */
	public Bilanz erstelleBilanz() {
		GuV guv = erstelleGuV();
		Bilanz b = new Bilanz(guv);

		// AV
		Enumeration<String> bezeichnungenAV = AV.keys();
		Enumeration<String> bezeichnungenUV = UV.keys();

		// UV
		Enumeration<String> bezeichnungenEK = EK.keys();
		Enumeration<String> bezeichnungenFK = FK.keys();

		while (bezeichnungenAV.hasMoreElements()) {
			String s = (String) bezeichnungenAV.nextElement();
			double d = AV.get(s).kontoAbrechnen();
			b.putAktiva(s, new Double(d));
		}
		while (bezeichnungenUV.hasMoreElements()) {
			String s = (String) bezeichnungenUV.nextElement();

			double d = UV.get(s).kontoAbrechnen();
			if (s == "RS") {
				guv.getBv().put("RS", UV.get("RS").getBv());
			}
			if (s == "FE") {
				guv.getBv().put("FE", UV.get("FE").getBv());
			}
			b.putAktiva(s, new Double(d));

		}
		while (bezeichnungenEK.hasMoreElements()) {
			String s = (String) bezeichnungenEK.nextElement();
			double d = EK.get(s).kontoAbrechnen();
			b.putPassiva(s, new Double(d));
		}
		while (bezeichnungenFK.hasMoreElements()) {
			String s = (String) bezeichnungenFK.nextElement();
			double d = FK.get(s).kontoAbrechnen();
			b.putPassiva(s, new Double(d));
		}

		return b;
	}

	/**
	 * GuV wird aufgestellt
	 * @return
	 */
	private GuV erstelleGuV() {
		GuV guv = new GuV();

		Enumeration<String> bezeichnungenAufwand = AUFWAND.keys();
		Enumeration<String> bezeichnungenErtrag = ERTRAG.keys();
		Enumeration<String> bezeichnungenBV = BV.keys();

		while (bezeichnungenAufwand.hasMoreElements()) {
			String konto = bezeichnungenAufwand.nextElement();
			double wert = AUFWAND.get(konto).kontoAbrechnen();
			guv.putAufwand(konto, new Double(wert));
		}

		while (bezeichnungenErtrag.hasMoreElements()) {
			String konto = bezeichnungenErtrag.nextElement();
			double wert = ERTRAG.get(konto).kontoAbrechnen();
			guv.putErtrag(konto, new Double(wert));
		}

		while (bezeichnungenBV.hasMoreElements()) {
			String konto = bezeichnungenBV.nextElement();
			double wert = BV.get(konto).kontoAbrechnen();
			guv.putBV(konto, new Double(wert));
		}

		return guv;
	}

	// GETTER
	public Hashtable<String, Konto> getAV() {
		return AV;
	}

	// GETTER
	public Hashtable<String, Konto> getUV() {
		return UV;
	}

	// GETTER
	public Hashtable<String, Konto> getEK() {
		return EK;
	}

	// GETTER
	public Hashtable<String, Konto> getFK() {
		return FK;
	}

	// GETTER
	public Hashtable<String, Konto> getERTRAG() {
		return ERTRAG;
	}

	// GETTER
	public Hashtable<String, Konto> getAUFWAND() {
		return AUFWAND;
	}

	// GETTER
	public Hashtable<String, Konto> getBV() {
		return BV;
	}

}
