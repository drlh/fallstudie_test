package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.finanzen.*;

public class Finanzen extends Abteilung
{
    private Kontenplan konten;
    private ArrayList<Bilanz> bilanzen;

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

    private Kontenplan getKonten()
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

}
