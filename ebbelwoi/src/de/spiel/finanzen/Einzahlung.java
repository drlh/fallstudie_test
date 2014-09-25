package de.spiel.finanzen;

public class Einzahlung extends Transaktion
{

    public Einzahlung(Konto k, double betrag)
    {
	super(k, betrag);
	einzahlen();
    }

    private boolean einzahlen()
    {
	boolean b = this.getK().einzahlen(getBetrag());
	if (b == true) Konto.transkationsNr++;
	return b;
    }

}
