package de.spiel.finanzen.konto;

public class Ertragskonto extends Konto
{
    public Ertragskonto(String name)
    {
	super(name);
    }

    public Ertragskonto(String name, double kontostand)
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
	    return differenz;
	} else if (this.getSoll() == this.getHaben()) {
	    this.resetKonto();
	    return 0;
	} else {
	    return -1;
	}

    }
}
