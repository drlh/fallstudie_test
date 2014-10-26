package de.spiel.umwelt.absatz;

import java.util.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

import de.spiel.umwelt.Absatz;
import de.spiel.umwelt.Angebot;

public abstract class Kunde
{

    protected double MINAB;
    protected double MAXAB;
    protected double menge;

    // Angebote
    // ArrayList<Angebot> angebote;
    Hashtable<String, Angebot> angebote;
    // Absatz
    // ArrayList<Absatz> absatz;
    Hashtable<String, Absatz> absatz;

    public Kunde()
    {
	Random r = new Random();
	menge = r.nextDouble();

	// angebote = new ArrayList<Angebot>();
	// absatz = new ArrayList<Absatz>();
	angebote = new Hashtable<String, Angebot>();
	absatz = new Hashtable<String, Absatz>();
    }

    public double getMenge()
    {
	return menge;
    }

    /**
     * legt die Grenzen der Intervalle fest und errechnet den aktuellen Bedarf
     * und Preis
     */
    protected abstract void initKunde();

    // public ArrayList<Angebot> getAngebote()
    // {
    // return angebote;
    // }
    //
    // public ArrayList<Absatz> getAbsatz()
    // {
    // return absatz;
    // }

    public Hashtable<String, Absatz> getAbsatz()
    {
	return absatz;
    }

    public Hashtable<String, Angebot> getAngebote()
    {
	return angebote;
    }
    
    public void erstelleAngebot(String spielerName, Angebot a)
    {
	getAngebote().put(spielerName, a);

    }

    // /**
    // * Berechnet den Absatz aus den Angeboten. Dabei wird immer nach dem
    // * günstigstem Preis geschaut.
    // */
    // public void berechneAbsatz()
    // {
    // double restNachfrage = menge;
    //
    // double besterPreis = Double.MAX_VALUE;
    // int bestesAngebot = -1;
    // Angebot best = null;
    //
    // boolean[] aktuelleAngebote = new boolean[angebote.size()];
    //
    // for (int i = 0; i < aktuelleAngebote.length; i++) {
    // aktuelleAngebote[i] = true;
    // }
    //
    // while (restNachfrage > 0) {
    // for (int i = 0; i < angebote.size(); i++) {
    // if (aktuelleAngebote[i] == true) {
    //
    // Angebot a = angebote.get(i);
    //
    // if (besterPreis > a.getPreis()) {
    // besterPreis = a.getPreis();
    // bestesAngebot = i;
    // }
    // }
    // }
    // if (bestesAngebot >= 0) {
    // best = angebote.get(bestesAngebot);
    // }else break;
    //
    // if (restNachfrage - best.getMenge() < 0) {
    // absatz.add(bestesAngebot,
    // new Absatz(restNachfrage, best.getPreis()));
    // break;
    // } else if (restNachfrage - angebote.get(bestesAngebot).getMenge() >= 0) {
    // double dif = (best.getMenge() - restNachfrage) + (-1);
    // restNachfrage -= dif;
    // absatz.add(bestesAngebot, new Absatz(best));
    // aktuelleAngebote[bestesAngebot] = false;
    // }
    //
    // bestesAngebot = -1;
    // besterPreis = Double.MAX_VALUE;
    // }
    // }
    /**
     * Berechnet den Absatz aus den Angeboten. Dabei wird immer nach dem
     * günstigstem Preis geschaut.
     */
    public void berechneAbsatz()
    {
	double restNachfrage = menge;
	
	double besterPreis = Double.MAX_VALUE;
	String bestesAngebot = ""; //Spielername als Schlüssel
	Angebot best = null;

	List<String> spieler = Collections.list(angebote.keys());

	while (restNachfrage > 0) {
	    for (int i = 0; i < spieler.size(); i++) {
		Angebot a = angebote.get(spieler.get(i));

		if (besterPreis > a.getPreis()) {
		    besterPreis = a.getPreis();
		    bestesAngebot = spieler.get(i);
		}
	    }
	    
	    if (!bestesAngebot.equals("")) {
		best = angebote.get(bestesAngebot);
	    } else
		break;
	    
	    if (restNachfrage - best.getMenge() < 0) {
		absatz.put(bestesAngebot,
			new Absatz(restNachfrage, best.getPreis()));
		break;
	    } else if (restNachfrage - angebote.get(bestesAngebot).getMenge() >= 0) {
		double dif = (best.getMenge() - restNachfrage) + (-1);
		restNachfrage -= dif;
		absatz.put(bestesAngebot, new Absatz(best));
		spieler.remove(bestesAngebot);
	    }

	    bestesAngebot = "";
	    besterPreis = Double.MAX_VALUE;
	}
    }
}
