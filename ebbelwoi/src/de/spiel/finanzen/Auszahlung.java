package de.spiel.finanzen;

public class Auszahlung extends Transaktion
{

    public Auszahlung(Konto k, double betrag)
    {
	super(k, betrag);
	auszahlen();
    }

    private boolean auszahlen()
    {
	boolean b = this.getK().auszahlen(getBetrag());
	if (b == true) {
	    Konto.transkationsNr++;
	}
	return b;
    }

}
