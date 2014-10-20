package de.spiel;

import java.util.ArrayList;

import de.spiel.umwelt.Umwelt;

/**
 * Diese Klasse kümmert sich um die Abrechnung der Eingaben Ergebnisse 
 * @author hellwl
 *
 */
public class Runde
{
    ArrayList<Spieler> spielerRunde;
    
    private static int aktuellerSpieler = 0;
    
    public Runde(ArrayList<Spieler> spieler)
    {
	this.spielerRunde = spieler;
	Umwelt.neueRunde();
    }
    
    
    public static int getAktuellerSpieler()
    {
	return aktuellerSpieler;
    }
    
    private void nextSpieler()
    {
	if (aktuellerSpieler < spielerRunde.size()) {
	    aktuellerSpieler++;
	}else {
	    beenden();
	}

    }

    /**
     * Startet die gesammte Rundenauswertung
     */
    public void beenden()
    {
	
	
    }
}
