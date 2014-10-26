package de.spiel.unternehmen.maschinen;

import de.spiel.basic.stufen.MaschinenStufen;
import de.spiel.unternehmen.mitarbeiter.Mitarbeiter;

public abstract class Maschine
{
    protected double anschaffungskosten;
    protected int abschreibungsdauer;
    protected double abschreibung;
    protected double aktuellerWert;
    protected double fixkosten;

    protected double kapazitaet;
    protected double auswurf;
    protected Mitarbeiter maschinenfuehrer;

    protected MaschinenStufen stufe;

    public Maschine()
    {
	this.stufe = new MaschinenStufen();
    }

    // GETTER
    public double getAnschaffungskosten()
    {
	return anschaffungskosten;
    }

    public int getAbschreibungsdauer()
    {
	return abschreibungsdauer;
    }

    public double getAbschreibung()
    {
	if (aktuellerWert-abschreibung >= 0) {
	    return abschreibung;
	}else
	    return 0.0;
	
    }

    public double getAktuellerWert()
    {
	return aktuellerWert;
    }

    public double getFixkosten()
    {
	return fixkosten;
    }

    public double getKapazitaet()
    {
	return kapazitaet;
    }

    public double getAuswurf()
    {
	return auswurf;
    }

    public Mitarbeiter getMaschinenfuehrer()
    {
	return maschinenfuehrer;
    }

    public MaschinenStufen getStufe()
    {
	return stufe;
    }

    // SETTER
    public void setMaschinenfuehrer(Mitarbeiter maschinenfuehrer)
    {
	this.maschinenfuehrer = maschinenfuehrer;
    }

    protected void setAktuellerWert(double aktuellerWert)
    {
	this.aktuellerWert = aktuellerWert;
    }

    // OTHER
    protected void calcAbschreibung()
    {
	this.abschreibung = anschaffungskosten / abschreibungsdauer;
    }

    protected void calcFixkosten()
    {
	this.fixkosten = 0.15 * anschaffungskosten;
    }

    protected void doAbschreibung()
    {
	setAktuellerWert(aktuellerWert - abschreibung);
    }

}
