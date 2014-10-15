package de.spiel.finanzen.konto;

public abstract class Konto {
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
	 * Gibt an ob das Konto ein Ertrags (true) oder Aufwandskonto (false) der
	 * GuV ist
	 */
	protected boolean ertrag;

	public Konto(String name) {
		this.name = name;
		this.haben = 0;
		this.soll = 0;
	}

	public Konto(String name, double kontostand) {
		this.name = name;
		this.sollBuchen(kontostand);
	}

	//Erhoehen
	public void sollBuchen(double betrag) {
		this.soll += betrag;
	}
	private void habenBuchen(double betrag) {
		this.haben += betrag;
	}
	
	//Verringern
	private void sollVerringern(double betrag) {
		this.soll -= betrag;
	}
	private void habenVerringern(double betrag) {
		this.haben -= betrag;
	}

	protected void setType(boolean aktiv, boolean bestand, boolean ertrag) {
		this.aktiv = aktiv;
		this.bestand = bestand;
		this.ertrag = ertrag;
	}





	public double kontoAbrechnen()
	{
		String type = this.getClass().getSimpleName();

		if (type.equals("Aktivkonto")) {
			
		}

		if (type.equals("Passivkonto")) {
			
		}

		if (type.equals("Ertragskonto")) {
			
		}

		if (type.equals("Aufwandskonto")) {
			
		}
		
		return 0.0;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+"[name=" + name + " , soll=" + soll + ",haben=" + haben
				+ "]";
	}
}
