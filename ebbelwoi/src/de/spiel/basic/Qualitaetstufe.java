package de.spiel.basic;

import java.util.Arrays;

public class Qualitaetstufe
{
    private int[] qualitaetsStufen = { 0, 1, 2, 3, 4, 5, 6 };
    private String[] qualitaetStufenBez = {"Verschimmelt", "Schlecht","Ausreichend","Mittel","Gut","Sehr Gut","Top"};
    private int aktuelleStufe;

    public Qualitaetstufe()
    {
	this.aktuelleStufe = 6;
    }

    public Qualitaetstufe(int stufe)
    {
	if (stufe > 6) aktuelleStufe= 6;
	if (stufe < 0) aktuelleStufe= 0;
	else aktuelleStufe = qualitaetsStufen[stufe];
    }

    public int getAktuelleStufe()
    {
        return aktuelleStufe;
    }
    
    public String getAktuelleBez()
    {
        return qualitaetStufenBez[aktuelleStufe];
    }

    public void qualitaetMindern()
    {
        if (aktuelleStufe > 0) this.aktuelleStufe -= 1;
    }

    public void setAktuelleStufe(int aktuelleStufe)
    {
        if (aktuelleStufe <= 6 && aktuelleStufe >= 0) this.aktuelleStufe = aktuelleStufe;
    }

    @Override
    public String toString()
    {
	return "Qualitaetstufe [aktuelleStufe= "+aktuelleStufe+", bezeichnung="+getAktuelleBez()+"]";
    }
    
    
    
    
}
