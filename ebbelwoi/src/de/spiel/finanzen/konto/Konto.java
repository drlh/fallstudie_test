package de.spiel.finanzen.konto;

public abstract class Konto
{
    private String name;
    private double soll;
    private double haben;

    protected boolean aktiv;
    protected boolean bestand;
    protected boolean ertrag;

    public Konto(String name)
    {
	this.name = name;
	this.haben = 0;
	this.soll = 0;
    }

    public Konto(String name, double kontostand)
    {
	this.name = name;
	this.erhoehen(kontostand);
    }

    private void sollErhoehen(double betrag)
    {
	this.soll += betrag;
    }

    private void sollVerringern(double betrag)
    {
	this.soll -= betrag;
    }

    private void habenErhoehen(double betrag)
    {
	this.haben += betrag;
    }

    private void habenVerringern(double betrag)
    {
	this.haben -= betrag;
    }
    
    protected void setType(boolean aktiv, boolean bestand, boolean ertrag)
    {
	this.aktiv = aktiv;
	this.bestand = bestand;
	this.ertrag = ertrag;
    }
    
    

    public void erhoehen(double betrag)
    {
	// Bestandskonten
	// Aktiva
	if (aktiv && bestand) sollErhoehen(betrag);
	// Passiva
	if (!aktiv && bestand) habenErhoehen(betrag);

	// Aufwands und Ertragskonten
	// Aufwand
	if (aktiv && !ertrag) sollErhoehen(betrag);
	// Ertrag
	if (!aktiv && !ertrag) habenErhoehen(betrag);

    }

    public void mindern(double betrag)
    {
	// Bestandskonten
	// Aktiv
	if (aktiv && bestand) habenErhoehen(betrag);
	// Passiva
	if (!aktiv && bestand) sollErhoehen(betrag);

	// Aufwands und Ertragskonten
	// Aufwand
	if (aktiv && !ertrag) habenErhoehen(betrag);
	// Ertrag
	if (!aktiv && !ertrag) sollErhoehen(betrag);

    }

    
    @Override
    public String toString()
    {
	return "Konto[name="+name+" , soll="+soll+",haben="+haben+"]";       
    }
}
