package de.spiel.umwelt;

import java.util.ArrayList;

import de.spiel.umwelt.absatz.Kneipe;
import de.spiel.umwelt.absatz.Kunde;
import de.spiel.umwelt.absatz.Supermarktkette;

public class Absatzmarkt
{
    Kunde[] kundenListe = new Kunde[3];

    public Absatzmarkt()
    {
	initKundenListe();
    }

    private void initKundenListe()
    {
	kundenListe[0] = new Kneipe();
	kundenListe[1] = new Supermarktkette();
	kundenListe[2] = new Supermarktkette();
    }

    public Kunde[] getKundenListe()
    {
	return kundenListe;
    }
    
    private Kunde getKneipe()
    {
	return (Kneipe) kundenListe[0];
    }
    
    private Kunde getSupermarktkette()
    {
	return (Supermarktkette) kundenListe[1];
    }
    
    

}
