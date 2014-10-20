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
    public void addMitarbeiter() {}
    
    
    public Kontenplan getKonten()
    {
	return konten;
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
