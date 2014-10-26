package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.Spiel;
import de.spiel.basic.Rohstoff;
import de.spiel.finanzen.konto.Aktivkonto;
import de.spiel.finanzen.konto.Aufwandskonto;
import de.spiel.finanzen.konto.Bestandsveraenderungen;
import de.spiel.unternehmen.mitarbeiter.*;
import de.spiel.umwelt.beschaffung.*;

public class Einkauf extends Abteilung
{

    public Einkauf()
    {
	super();
	this.abteilungName = "Einkauf";
	this.mitarbeiter = new ArrayList<Mitarbeiter>();

    }

    @Override
    public void addMitarbeiter()
    {
	this.mitarbeiter.add(new Vertrieb());
    }
    
    /**
     * Kauft die gewünnschte Menge an Rohstoffen der besten Qualität ein
     * Lagert diese direkt ein und buch den Aufwand in {@link Aufwandskonto} Aufwand für Rohstoffe und {@link Aktivkonto} Bank
     * @param menge gewünnschte Menge
     */
    public void einkaufenRohstoffe(double menge)
    {
	Rohstoff r = new Rohstoff(menge);
	getUnternehmen().getLager().addRohstoff(r);
	
	double betrag = menge * Spiel.EINKAUFSPREIS;
	getUnternehmen().getFinanzen().bucheEinkaufRS(betrag);
    }

    // public double getBauernAngebot() {
    // Bauer b = this.getUnternehmen().getUmwelt().getBeschaffung().getBauer();
    // return b.getPreis();
    // }
    //
    // public double getGrosshaendlerAngebot() {
    // Grosshaendler g =
    // this.getUnternehmen().getUmwelt().getBeschaffung().getGrosshaendler();
    // return g.getPreis();
    // }

}
