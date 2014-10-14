package de.spiel.finanzen.konto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Kontenplan
{
    // BILANZ
    // AKTIVA
    private HashMap<String, Konto> AV;
    private HashMap<String, Konto> UV;
    // PASSIVA
    private HashMap<String, Konto> EK;
    private HashMap<String, Konto> FK;

    // GUV
    private HashMap<String, Konto> ERTRAG;
    private HashMap<String, Konto> AUFWAND;

    public Kontenplan()
    {
	initKonten();
    }

    /**
     * Erstellt alle ben�tigten KOnten Kontenschl�ssel: AV - Konten im
     * Anlageverm�gen GS - Grundst�cke MA - Maschinen UV - Konten des
     * Umlaufverm�gens RS - Rhstoffe FE - Fertigerzeignisse BA - Bank EK -
     * Konten des Eigenkapitals EK - Eigenkapitla FK - Konten des Fremdkapitals
     * DA - Darlehen
     * 
     * ERTRAG - Ertragskonten f�r Ertr�ge die in die GuV zusammenlaufen EUE -
     * Umsatzerl�se
     * 
     * AUFWAND - Aufwandskonten f�r Aufw�nde die in die GuV zusammenlaufen AFA -
     * Abschreibungen AGE - Gehalt ARS - Aufwand f�r Rohstoffe
     */
    private void initKonten()
    {
	// BILANZ
	// AKTIVA
	AV = new HashMap<>();
	AV.put("GS", new Aktivkonto("Grundst�ck"));
	AV.put("MA", new Aktivkonto("Maschinen"));

	UV = new HashMap<>();
	UV.put("RS", new Aktivkonto("Rohstoffe"));
	UV.put("FE", new Aktivkonto("Fertigerzeugnisse"));
	UV.put("BA", new Aktivkonto("Bank"));

	// PASSIVA
	EK = new HashMap<>();
	EK.put("EK", new Passivkonto("Eigenkapital"));

	FK = new HashMap<>();
	FK.put("DA", new Passivkonto("Darlehen"));

	// GUV Konten
	ERTRAG = new HashMap<>();
	ERTRAG.put("EUE", new Ertragskonto("Umsatzerl�se"));

	AUFWAND = new HashMap<>();
	AUFWAND.put("AFA", new Aufwandskonto("Aufwand f�r Abschreibungen"));
	AUFWAND.put("AGE", new Aufwandskonto("Aufwand f�r Gehalt"));
	AUFWAND.put("ARS", new Aufwandskonto("Aufwand f�r Rohstoffe"));
    }

    private ArrayList<HashMap<String, Konto>> getAll()
    {
	ArrayList<HashMap<String, Konto>> k = new ArrayList<>();
	k.add(AV);
	k.add(UV);
	k.add(EK);
	k.add(FK);
	k.add(ERTRAG);
	k.add(AUFWAND);

	return k;
    }

    public boolean buchen(String soll, String haben, double betrag)
    {
	if (soll.equals(haben)) {
	    return false;
	} else {
	    ArrayList<HashMap<String, Konto>> k = getAll();

	    Konto kSoll = null;
	    Konto kHaben = null;

	    for (int i = 0; i < k.size(); i++) {
		if (k.get(i).get(soll) != null) kSoll = k.get(i).get(soll);
		if (k.get(i).get(haben) != null) kHaben = k.get(i).get(haben);
	    }

	    if (kSoll == null || kHaben == null) {
		return false;
	    } else {
		kSoll.erhoehen(betrag);
		kHaben.erhoehen(betrag);

		return true;
	    }

	}

    }
}
