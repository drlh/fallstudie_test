package de.spiel.finanzen;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import de.spiel.finanzen.konto.Aktivkonto;
import de.spiel.finanzen.konto.Aufwandskonto;
import de.spiel.finanzen.konto.Bestandsveraenderungen;
import de.spiel.finanzen.konto.Ertragskonto;
import de.spiel.finanzen.konto.Konto;
import de.spiel.finanzen.konto.Passivkonto;

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
    private HashMap<String, Konto> BV;

    public Kontenplan()
    {
	initKonten();
    }

    /**
     * Erstellt alle ben�tigten Konten mit Kontenschl�ssel: 
     * AV - Konten im Anlageverm�gen 
     * 		GS - Grundst�cke 
     * 		MA - Maschinen 
     * 
     * UV - Konten des Umlaufverm�gens 
     * 		RS - Rohstoffe 
     * 		FE - Fertigerzeignisse 
     * 		BA - Bank 
     * 
     * EK - Konten des Eigenkapitals 
     * 		EK - Eigenkapitl 
     *
     * FK - Konten des Fremdkapitals
     * 		DA - Darlehen
     * 
     * ERTRAG - Ertragskonten f�r Ertr�ge die in die GuV zusammenlaufen 
     * 		EUE -Umsatzerl�se
     * 
     * AUFWAND - Aufwandskonten f�r Aufw�nde die in die GuV zusammenlaufen 
     * 		AFA - Abschreibungen 
     * 		AGE - Gehalt 
     * 		ARS - Aufwand f�r Rohstoffe
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
	UV.put("BA", new Aktivkonto("Bank"));
	UV.put("FE", new Aktivkonto("Fertigerzeugnisse"));
	

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
	
	BV = new HashMap<>();
	BV.put("BV", new Bestandsveraenderungen("Bestandsver�nderung"));
    }

    public ArrayList<HashMap<String, Konto>> getAll()
    {
	ArrayList<HashMap<String, Konto>> k = new ArrayList<>();
	k.add(AV);
	k.add(UV);
	k.add(EK);
	k.add(FK);
	k.add(ERTRAG);
	k.add(AUFWAND);
	k.add(BV);

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
		kSoll.sollBuchen(betrag);
		kHaben.habenBuchen(betrag);

		return true;
	    }

	}

    }
}
