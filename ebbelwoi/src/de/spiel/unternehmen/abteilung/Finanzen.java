package de.spiel.unternehmen.abteilung;

import java.lang.reflect.Array;
import java.util.ArrayList;

import de.spiel.Spiel;
import de.spiel.finanzen.*;
import de.spiel.unternehmen.maschinen.Maschine;
import de.spiel.unternehmen.mitarbeiter.Mitarbeiter;

public class Finanzen extends Abteilung
{
    private Kontenplan konten;
    private ArrayList<Bilanz> bilanzen;

    private boolean start = true;

    public Finanzen()
    {
	super();
	this.abteilungName = "Finanzen";
	this.konten = new Kontenplan();
	this.bilanzen = new ArrayList<Bilanz>();

    }

    @Override
    // Wird nicht benutzt
    public void addMitarbeiter()
    {
    }

    public Kontenplan getKonten()
    {
	return konten;
    }

    public Bilanz getBilanz(int runde)
    {
	return this.bilanzen.get(runde);
    }

    public boolean buchen(String soll, String haben, double betrag)
    {
	return konten.buchen(soll, haben, betrag);
    }

    public void rundeAbrechnen()
    {
	Bilanz b = konten.erstelleBilanz();
	b.aufstellenBilanz();
	bilanzen.add(b);
    }

    // SPEZIFISCHE BUCHUNGEN
    /* Aufwand */
    /**
     * 
     */
    private void bucheStartguthaben()
    {
	if (start) {
	    this.getKonten().getUV().get("BA").sollBuchen(Spiel.STARTGUTHABEN);
	    start = false;
	}
    }

    /**
     * 
     */
    private void bucheGehalt()
    {
	ArrayList<ArrayList<Mitarbeiter>> maUn = new ArrayList<ArrayList<Mitarbeiter>>();

	for (int i = 0; i < 5; i++) {
	    maUn.add(getUnternehmen().getAbteilung(i).getMitarbeiterListe());
	}

	for (int i = 0; i < maUn.size(); i++) {
	    ArrayList<Mitarbeiter> ma = maUn.get(i);

	    for (int j = 0; j < ma.size(); j++) {

		double d = ma.get(i).getGehalt();

		if (d > 0) this.buchen("AGE", "BA", d);

	    }
	}
    }

    /**
     * 
     */
    private void bucheAFA()
    {
	ArrayList<Maschine> maschinen = getUnternehmen().getProduktion()
		.getMaschinenpark();

	for (int i = 0; i < maschinen.size(); i++) {
	    double d = maschinen.get(i).getAbschreibung();

	    if (d > 0) this.buchen("AFA", "MA", d);
	}
    }

    private void bucheFixkostenProd()
    {
	ArrayList<Maschine> maschinen = getUnternehmen().getProduktion()
		.getMaschinenpark();

	for (int i = 0; i < maschinen.size(); i++) {
	    double d = maschinen.get(i).getAbschreibung();

	    if (d > 0) this.buchen("AMA", "BA", d);
	}
    }

    private void bucheZinsaufwand()
    {
	double kreditbetrag = this.getKonten().getFK().get("DA")
		.getKontostand();

	if (kreditbetrag > 0) {
	    double zinsAufwand = kreditbetrag * (Spiel.KREDITZINS / 100);
	    this.buchen("AFZ", "BA", zinsAufwand);
	}

    }
}
