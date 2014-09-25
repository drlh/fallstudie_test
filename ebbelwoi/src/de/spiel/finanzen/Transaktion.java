package de.spiel.finanzen;

public final class Transaktion 
{

	private static int transaktionsNr;
	
	private double betrag;
	private String abtName;
	private String transTyp;
	private int transNr;
	
	public Transaktion(double betrag, String abtName, String transTyp)
	{
		transNr = transaktionsNr;
		transaktionsNr++;
		
		this.betrag = betrag;
		this.abtName = abtName;
		this.transTyp = transTyp;
		
	}
	public double getBetrag() {
		return betrag;
	}

	public int getTransaktionsNr() {
		return transaktionsNr;
	}
	
	public String getAbtName() {
		return abtName;
	}
	public String getTransTyp() {
		return transTyp;
	}
	@Override
	public String toString() {
		return "Transaktion [betrag=" + betrag + ", abtName=" + abtName
				+ ", transTyp=" + transTyp + ", transNr=" + transNr + "]";
	}
	
}
