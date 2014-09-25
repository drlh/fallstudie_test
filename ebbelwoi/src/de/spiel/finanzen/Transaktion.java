package de.spiel.finanzen;

public abstract class Transaktion 
{
	private Konto k;
	private double betrag;
	private int transaktionsNr;
	
	public Transaktion(Konto k, double betrag)
	{
		this.k = k;
		this.betrag = betrag;
		this.transaktionsNr = Konto.transkationsNr;
	}

	public Konto getK() {
		return k;
	}

	public double getBetrag() {
		return betrag;
	}

	public int getTransaktionsNr() {
		return transaktionsNr;
	}
	
	
	
}
