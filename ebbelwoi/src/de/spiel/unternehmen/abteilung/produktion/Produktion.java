package de.spiel.unternehmen.abteilung.produktion;

import java.util.ArrayList;

import org.junit.Ignore;

import de.spiel.basic.Produkt;
import de.spiel.basic.Rohstoff;
import de.spiel.unternehmen.abteilung.Abteilung;
import de.spiel.unternehmen.maschinen.Maschine;
import de.spiel.unternehmen.mitarbeiter.*;

public class Produktion extends Abteilung
{
    private ArrayList<Maschine> maschinenpark;
    private ArrayList<Produktionsauftrag> auftraege;

    public Produktion()
    {
	super();
	this.abteilungName = "Produktion";
	this.mitarbeiter = new ArrayList<Mitarbeiter>();
	this.maschinenpark = new ArrayList<Maschine>();
	this.auftraege = new ArrayList<Produktionsauftrag>();
    }

    @Override
    public void addMitarbeiter()
    {
    }

    // GETTER
    public ArrayList<Maschine> getMaschinenpark()
    {
	return maschinenpark;
    }

    // Mitarbeiter
    public void addAzubi()
    {
	this.mitarbeiter.add(new Azubi());
    }

    public void addGeselle()
    {
	this.mitarbeiter.add(new Geselle());
    }

    public void addMeister()
    {
	this.mitarbeiter.add(new Meister());
    }

    // Produktion
    public void addAuftrag(Maschine maschine, Rohstoff rohstoff)
    {
	this.auftraege.add(new Produktionsauftrag(maschine, rohstoff));
    }

    /**
     * Grundlage: 1kg Äpfel - 0,33l Apfelwein (Quelle:
     */
    public void produzieren()
    {
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
			- maschinenstufe - produktivitaetMa))) / (4/3));

		// auf 2 Nachkommastellen runden
		ausbringungsmenge = Math.floor(ausbringungsmenge * 100) / 100;

		this.getLager().addProdukt(new Produkt(ausbringungsmenge));
		System.out.println(ausbringungsmenge);
	    }

	}
    }

    @Override
    public String toString()
    {
	return "Produktion [maschinenpark=" + maschinenpark + ", auftraege="
		+ auftraege + ", mitarbeiter=" + mitarbeiter + "]";
    }

}
