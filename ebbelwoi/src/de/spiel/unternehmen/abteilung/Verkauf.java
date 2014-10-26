package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.Spiel;
import de.spiel.unternehmen.mitarbeiter.*;
import de.spiel.umwelt.Absatzmarkt;
import de.spiel.umwelt.Angebot;
import de.spiel.umwelt.Umwelt;
import de.spiel.umwelt.absatz.*;

public class Verkauf extends Abteilung
{

    public Verkauf()
    {
	super();
	this.abteilungName = "Verkauf";
	this.mitarbeiter = new ArrayList<Mitarbeiter>();
    }

    @Override
    public void addMitarbeiter()
    {
	this.mitarbeiter.add(new Vertrieb());
    }

    // public Angebot KneipeAngebotErstellen(double preis) {
    // Kneipe k = (Kneipe)
    // this.getUnternehmen().getUmwelt().getAbsatz().getKneipe();
    // Angebot a = new Angebot(k.getMenge(), preis);
    // return a;
    // }
    //
    // public Angebot SMAngebotErstellen(double preis) {
    // Supermarktkette s = (Supermarktkette)
    // this.getUnternehmen().getUmwelt().getAbsatz().getSupermarktkette();
    // Angebot a = new Angebot(s.getMenge(), preis);
    // return a;
    // }
    //
    // public Angebot GHAngebotErstellen(double preis) {
    // Grosshandel g = (Grosshandel)
    // this.getUnternehmen().getUmwelt().getAbsatz().getGrosshandel();
    // Angebot a = new Angebot(g.getMenge(), preis);
    // return a;
    // }

    
 // Funktionen ohne Gui
    public void erstelleAngebotKneipe(double menge, double preis)
    {
	erstelleAngebot("KN", menge, preis);
    }

    public void erstelleAngebotSupermarkt(double menge, double preis)
    {
	erstelleAngebot("SU", menge, preis);
    }

    public void erstelleAngebotGro�handel(double menge, double preis)
    {
	erstelleAngebot("GR", menge, preis);
    }

    private void erstelleAngebot(String s, double menge, double preis)
    {
	String spielerName = getUnternehmen().getSpielerName();
	Angebot a = new Angebot(preis, menge);
	Absatzmarkt am = Umwelt.getAbsatz();

	switch (s) {
	case "GR":
	    am.getGrosshandel().erstelleAngebot(spielerName, a);
	    break;
	case "KN":
	    am.getKneipe().erstelleAngebot(spielerName, a);
	    break;
	case "SU":
	    am.getSupermarktkette().erstelleAngebot(spielerName, a);
	    break;
	}
    }
    
//FUNKTIONEN mit GUI
    
    public void erstelleAngebotKneipe(double menge, double preis, int lagerpos)
    {
	erstelleAngebotPos("KN", menge, preis, lagerpos);
    }

    public void erstelleAngebotSupermarkt(double menge, double preis, int lagerpos)
    {
	erstelleAngebotPos("SU", menge, preis, lagerpos);
    }

    public void erstelleAngebotGro�handel(double menge, double preis, int lagerpos)
    {
	erstelleAngebotPos("GR", menge, preis, lagerpos);
    }

    private void erstelleAngebotPos(String s, double menge, double preis, int lagerpos)
    {
	String spielerName = getUnternehmen().getSpielerName();
	Angebot a = new Angebot(preis, menge);
	a.setLagerpos(lagerpos);
	
	Absatzmarkt am = Umwelt.getAbsatz();

	switch (s) {
	case "GR":
	    am.getGrosshandel().erstelleAngebot(spielerName, a);
	    break;
	case "KN":
	    am.getKneipe().erstelleAngebot(spielerName, a);
	    break;
	case "SU":
	    am.getSupermarktkette().erstelleAngebot(spielerName, a);
	    break;
	}
    };

}
