package de.spiel;

import java.util.ArrayList;

import de.spiel.umwelt.Umwelt;
import de.spiel.unternehmen.abteilung.Finanzen;

/**
 * Diese Klasse kümmert sich um die Abrechnung der Eingaben Ergebnisse
 * 
 * @author hellwl
 * 
 */
public class Runde
{
    ArrayList<Spieler> spielerRunde;

    private int aktuellerSpieler = 0;

    public Runde(ArrayList<Spieler> spieler)
    {
	this.spielerRunde = spieler;
	Umwelt.neueRunde();
	this.neueRunde();
    }

    /**
     * Verbucht die Anfangsbestände der Runden
     */
    private void neueRunde()
    {
	for (int i = 0; i < spielerRunde.size(); i++) {
	    Spieler s = spielerRunde.get(i);

	    s.getUnternehmen().getFinanzen()
		    .bucheLagerAnfangsbestandRohstoffe();
	    s.getUnternehmen().getFinanzen().bucheLagerAnfangsbestandProdukt();
	}
    }

    public int getAktuellerSpieler()
    {
	return aktuellerSpieler;
    }

    private void nextSpieler()
    {
	if (aktuellerSpieler < spielerRunde.size()) {
	    aktuellerSpieler++;
	    Spiel.aktuellerSpielerName = spielerRunde.get(aktuellerSpieler)
		    .getName();
	} else {
	    beenden();
	}

    }

    /**
     * Startet die gesammte Rundenauswertung
     */
    public void beenden()
    {
	Spieler s = null;

	for (int i = 0; i < spielerRunde.size(); i++) {
	    s = spielerRunde.get(i);

	    Finanzen f = s.getUnternehmen().getFinanzen();

	    f.bucheGehalt();
	    f.bucheZinsaufwand();
	    f.bucheAFA();
	    f.bucheFixkostenProd();
	    
	    f.bucheLagerEndbestandProdukt();
	    f.bucheLagerEndbestandRohstoffe();
	    
	}
	
	

    }
}
