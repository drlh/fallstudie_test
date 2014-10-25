package de.spiel.unternehmen.abteilung;

import java.lang.reflect.Array;
import java.util.ArrayList;

import de.spiel.Spiel;
import de.spiel.basic.Produkt;
import de.spiel.basic.Rohstoff;
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
//ERFOLGSWIRKSAM
    /* Aufwand */
    /**
     * 
     */
    public void bucheStartguthaben()
    {
	if (start) {
	    this.getKonten().getUV().get("BA").sollBuchen(Spiel.STARTGUTHABEN);
	    start = false;
	}
    }

    /**
     * 
     */
    public void bucheGehalt()
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
    public void bucheAFA()
    {
	ArrayList<Maschine> maschinen = getUnternehmen().getProduktion()
		.getMaschinenpark();

	for (int i = 0; i < maschinen.size(); i++) {
	    double d = maschinen.get(i).getAbschreibung();

	    if (d > 0) this.buchen("AFA", "MA", d);
	}
    }

    /**
     * 
     */
    public void bucheFixkostenProd()
    {
	ArrayList<Maschine> maschinen = getUnternehmen().getProduktion()
		.getMaschinenpark();

	for (int i = 0; i < maschinen.size(); i++) {
	    double d = maschinen.get(i).getAbschreibung();

	    if (d > 0) this.buchen("AMA", "BA", d);
	}
    }

    public void bucheZinsaufwand()
    {
	double kreditbetrag = this.getKonten().getFK().get("DA")
		.getKontostand();

	if (kreditbetrag > 0) {
	    double zinsAufwand = kreditbetrag * ((Spiel.KREDITZINS / 100)/12);
	    this.buchen("AFZ", "BA", zinsAufwand);
	}
    }
    
    /**
     * 
     * @param betrag
     */
    public void bucheSchulungsaufwand(double betrag)
    {
	this.buchen("AFS", "BA", betrag);
    }
    
    /**
     * 
     * @param betrag
     */
    public void bucheMaschinenUpgrade(double betrag)
    {
	this.buchen("AMA", "BA", betrag);
    }
   
    /* Ertrag */
    /**
     * 
     * @param betrag
     */
    public void bucheUmsatz(double betrag)
    {
	this.buchen("BA", "EUE", betrag);
    }
    
//ERFOLGSNEUTRAL
    /**
     * 
     * @param betrag
     */
    public void bucheEinkaufRS(double betrag)
    {
	this.buchen("RS", "BA", betrag);
    }
    
    /**
     * 
     * @param betrag
     */
    public void bucheEinkaufMaschine(double betrag)
    {
	this.buchen("MA", "BA", betrag);
    }
    
    /**
     * 
     * @param betrag
     */
    public void bucheTilgungKredit(double betrag)
    {
	this.buchen("DA", "BA", betrag);

    }
    
//BESTÄNDE
    /**
     * 
     * @param menge
     */
    public void bucheLagerAnfangsbestandRS(double menge)
    {
	double wert = menge * Spiel.EINKAUFSPREIS;
	getUnternehmen().getFinanzen().getKonten().getUV().get("RS").sollBuchen(wert);
    }
    
    /**
     * 
     */
    public void bucheLagerEndbestandRS()
    {
	double bestand = 0.0;
	ArrayList<Rohstoff> rs = getUnternehmen().getLager().getLagerlisteRohstoffe();
	
	for (int i = 0; i < rs.size(); i++) {
	    bestand += rs.get(i).getMenge();
	}
	
	double wert = bestand * Spiel.EINKAUFSPREIS;
	getUnternehmen().getFinanzen().getKonten().getUV().get("RS").habenBuchen(wert);
    }
    
    /**
     * 
     * @param menge
     */
    public void bucheLagerAnfangsbestandProdukt(double menge)
    {
	double wert = menge * Spiel.PRODUKT_BILANZWERT;
	getUnternehmen().getFinanzen().getKonten().getUV().get("FE").sollBuchen(wert);
    }
    
    /**
     * 
     */
    public void bucheLagerEndbestandProdukt()
    {
	double bestand = 0.0;
	ArrayList<Produkt> p = getUnternehmen().getLager().getLagerlisteProdukt();
	
	for (int i = 0; i < p.size(); i++) {
	    bestand += p.get(i).getMenge();
	}
	
	double wert = bestand * Spiel.PRODUKT_BILANZWERT;
	getUnternehmen().getFinanzen().getKonten().getUV().get("FE").habenBuchen(wert);
    }
}
