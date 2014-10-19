package de.spiel.finanzen.konto;

public class Passivkonto extends Konto
{
    public Passivkonto(String name)
    {
	super(name);
    }
    
    public Passivkonto(String name, double kontostand)
    {
	super(name, kontostand);
    }

    @Override
    public double kontoAbrechnen()
    {
	double differenz = 0.0;
	
	if (this.getHaben() > getSoll()) {
	    differenz = haben - soll;
	    this.resetKonto();
	    this.habenBuchen(differenz);
	    return getHaben();
	}else if (this.getSoll() == this.getHaben()) {
	    this.resetKonto();
	    return 0;
	}else {
	    return -1;
	}
	
    }
}
