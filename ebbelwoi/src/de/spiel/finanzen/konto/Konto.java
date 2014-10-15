package de.spiel.finanzen.konto;

public abstract class Konto
{
    private String name;
    private double soll;
    private double haben;
    
    /**
     * Gibt an ob Konto aktiv (true) oder pasiv (false) ist
     */
    protected boolean aktiv;
    /**
     * Gibt an ob das Konto ein Konto der Bilanz ist (true)
     */
    protected boolean bestand;
    /**
     * Gibt an ob das Konto ein Ertrags (true) oder Aufwandskonto (false) der GuV ist
     */
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
	this.sollBuchen(kontostand);
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
    
    

    public void sollBuchen(double betrag)
    {
	// Bestandskonten
	// Aktiva
	if (aktiv && bestand && !ertrag) sollErhoehen(betrag);
	// Passiva
	if (!aktiv && bestand && !ertrag) sollErhoehen(betrag);

	// Aufwands und Ertragskonten
	// Aufwand
	if (aktiv && !ertrag && !bestand) sollErhoehen(betrag);
	// Ertrag
	if (!aktiv && !ertrag && !bestand) sollErhoehen(betrag);
    }

    public void habenBuchen(double betrag)
    {
	// Bestandskonten
	// Aktiv
	if (aktiv && bestand && !ertrag) habenErhoehen(betrag);
	// Passiva
	if (!aktiv && bestand && !ertrag) habenErhoehen(betrag);

	// Aufwands und Ertragskonten
	// Aufwand
	if (aktiv && !ertrag && !bestand) habenErhoehen(betrag);
	// Ertrag
	if (!aktiv && !ertrag && !bestand) habenErhoehen(betrag);
    }

    
    @Override
    public String toString()
    {
	return "Konto[name="+name+" , soll="+soll+",haben="+haben+"]";       
    }
}
