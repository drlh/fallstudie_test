package de.spiel.finanzen.konto;

public abstract class Konto
{
    private String name;
    private double soll;
    private double haben;

    private String type;

    public Konto(String name)
    {
	this.name = name;
	this.haben = 0;
	this.soll = 0;
    }

    public Konto(String name, double kontostand)
    {
	this.name = name;
	this.type = this.getClass().getSimpleName();
	this.kontoEroeffnen(kontostand);

    }

    // GET
    public String getName()
    {
	return name;
    }

    private double getSoll()
    {
	return soll;
    }

    private double getHaben()
    {
	return haben;
    }

    // SET
    private void setSoll(double soll)
    {
	this.soll = soll;
    }

    private void setHaben(double haben)
    {
	this.haben = haben;
    }

    private void resetKonto()
    {
	this.setHaben(0);
	this.setSoll(0);
    }

    // Erhoehen
    public void sollBuchen(double betrag)
    {
	this.soll += betrag;
    }

    public void habenBuchen(double betrag)
    {
	this.haben += betrag;
    }

    // Verringern
    private void sollVerringern(double betrag)
    {
	this.soll -= betrag;
    }

    private void habenVerringern(double betrag)
    {
	this.haben -= betrag;
    }

    /**
     * eröffnet das Konto mit einem bestimmten Betrag und bucht es je nach Typ
     * auf die Soll oder haben Seite
     * 
     * @param betrag
     *            zu verbuchender Kontostand
     */
    private void kontoEroeffnen(double betrag)
    {
	if (type.equals("Aktivkonto") | type.equals("Aufwandskonto")) {
	    sollBuchen(betrag);
	}
	if (type.equals("Passivkonto") | type.equals("Ertragskonto")) {
	    habenBuchen(betrag);
	}

    }

    /**
     * Gibt den Kontostand zurück
     */
    private double getKontostand()
    {
	if (type.equals("Aktivkonto") | type.equals("Aufwandskonto")) {
	    return getSoll();
	} else {
	    return getHaben();
	}

    }

    /**
     * Schließt das Konto ab.
     */
    public abstract void kontoAbrechnen();

    @Override
    public String toString()
    {
	return this.type + "[name=" + name + " , soll=" + soll + ",haben="
		+ haben + "]";
    }
}
