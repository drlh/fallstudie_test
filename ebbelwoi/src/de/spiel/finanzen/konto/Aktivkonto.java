package de.spiel.finanzen.konto;

public class Aktivkonto extends Konto
{
    
    
    public Aktivkonto(String name)
    {
	super(name);
    }

    public Aktivkonto(String name, double kontostand)
    {
	super(name, kontostand);
    }

    @Override
    public double kontoAbrechnen()
    {
	double differenz = 0.0;

	if (this.getName().equals("Rohstoffe") || this.getName().equals("Fertigerzeignisse")) {
	    bv = haben - soll;
	    double endbestand = getHaben();
	    this.resetKonto();
	    return endbestand;

	} else if (getSoll() > getHaben()) {
	    differenz = soll - haben;
	    this.resetKonto();
	    this.sollBuchen(differenz);
	    return getSoll();
	} else if (this.getSoll() == this.getHaben()) {
	    this.resetKonto();
	    return 0;
	} else {
	    return 0;
	}
    }
    


}
