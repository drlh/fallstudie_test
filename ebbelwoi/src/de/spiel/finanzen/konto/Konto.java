package de.spiel.finanzen.konto;

/**
 * abstrakte Klasse Konto
 * bietet Grundgerüst für sämtliche Konten des Kontenrahmens
 */
public abstract class Konto {
	private String name;
	protected double soll;
	protected double haben;

	private String type;

	protected double bv = 0.0;

	/**
	 * Konstruktor mit Name des Kontos
	 * @param name
	 */
	public Konto(String name) {
		this.name = name;
		this.haben = 0;
		this.soll = 0;
		this.type = this.getClass().getSimpleName();
	}

	/**
	 * Konstruktor mit Name und Stand des Kontos
	 * @param name
	 */
	public Konto(String name, double kontostand) {
		this.name = name;
		this.type = this.getClass().getSimpleName();
		this.kontoEroeffnen(kontostand);

	}

	// GETTER
	public double getBv() {
		return bv;
	}

	// GETTER
	public String getName() {
		return name;
	}

	// GETTER
	public double getSoll() {
		return soll;
	}

	// GETTER
	public double getHaben() {
		return haben;
	}

	// SETTER
	protected void setSoll(double soll) {
		this.soll = soll;
	}

	// SETTER
	protected void setHaben(double haben) {
		this.haben = haben;
	}

	/**
	 * zurücksetzen des Kontos
	 */
	protected void resetKonto() {
		this.setHaben(0);
		this.setSoll(0);
	}

	/**
	 * Erhöhung des Solls
	 * @param betrag
	 */
	public void sollBuchen(double betrag) {
		this.soll += betrag;
	}

	/**
	 * Erhöhung des Habens
	 * @param betrag
	 */
	public void habenBuchen(double betrag) {
		this.haben += betrag;
	}

	/**
	 * Minderung des Solls
	 * @param betrag
	 */
	private void sollVerringern(double betrag) {
		this.soll -= betrag;
	}

	/**
	 * Minderung des Habens
	 * @param betrag
	 */
	private void habenVerringern(double betrag) {
		this.haben -= betrag;
	}

	/**
	 * eröffnet das Konto mit einem bestimmten Betrag und bucht es je nach Typ
	 * auf die Soll oder haben Seite
	 * 
	 * @param betrag
	 *            zu verbuchender Kontostand
	 */
	private void kontoEroeffnen(double betrag) {
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
	public double getKontostand() {
		if (type.equals("Aktivkonto") | type.equals("Aufwandskonto")) {
			return getSoll() - getHaben();
		} else {
			return getHaben() - getSoll();
		}

	}

	/**
	 * Schließt das Konto ab.
	 */
	public abstract double kontoAbrechnen();

	@Override
	public String toString() {
		return this.type + "[name=" + name + " , soll=" + soll + ",haben="
				+ haben + "]";
	}
}
