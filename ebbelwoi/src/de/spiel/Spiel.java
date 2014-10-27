package de.spiel;

import java.util.ArrayList;

public class Spiel {
	private static ArrayList<Spieler> spieler;
	private static ArrayList<Runde> runden;

	public static int aktuelleRunde = 0;
	public static String aktuellerSpielerName = "";

	// SPIELKONSTANTEN
	public final static double KREDITZINS = 3.8;
	public final static double STARTGUTHABEN = 10000.0;
	/* Gleicher Einkaufspreis für alle */
	public final static double EINKAUFSPREIS = 1.0;
	/* Wert mit dem ein fertiges Produkt in der Bilanz angesetzt wird */
	public final static double PRODUKT_BILANZWERT = 1.2;

	public Spiel() {
		System.out.println("Spiel gestartet");
		Spiel.spieler = new ArrayList<Spieler>();
		Spiel.runden = new ArrayList<Runde>();

		try {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void startSpielFromGui(int spielerAnzahl,
			String[] spielerName, boolean[] kredit, int[] kreditBetrag) {
		if (aktuelleRunde == 0) {
			for (int i = 0; i < spielerAnzahl; i++) {
				spieler.add(new Spieler(spielerName[i]));
			}
			for (int i = 0; i < spielerAnzahl; i++) {
				if (kredit[i]) {
					spieler.get(i).getUnternehmen().getFinanzen().getKonten()
							.buchen("BA", "DA", kreditBetrag[i]);
				}
			}
		}
	}

	// SPIELER
	public boolean add(Spieler arg0) {
		return spieler.add(arg0);
	}

	public boolean add(Spieler arg0, double kredit) {
		arg0.getUnternehmen().getFinanzen().getKonten()
				.buchen("BA", "DA", kredit);
		return spieler.add(arg0);
	}

	public Spieler get(int arg0) {
		return spieler.get(arg0);
	}

	public static ArrayList<Spieler> getSpieler() {
		return spieler;
	}

	// RUNDEN
	public static int getAktuelleRundeNr() {
		return aktuelleRunde;
	}

	public static Runde getAktuelleRunde() {
		return runden.get(aktuelleRunde);
	}

	public Runde getRunde(int i) {
		return runden.get(i);
	}

	public void ersteRunde() {
		Spiel.runden.add(new Runde(spieler));

	}

	public void neueRunde() {
		rundeBeenden();
		Spiel.runden.add(new Runde(spieler));
		aktuelleRunde++;
	}

	public void nextSpieler() {
		int i = getAktuelleRunde().getAktuellerSpielerNr();
		if (i < spieler.size()-1) {
			getAktuelleRunde().setAktuellerSpielerNr(i + 1);
			Spiel.aktuellerSpielerName = getAktuelleRunde()
					.getAktuellerSpieler().getName();
		} else {
			neueRunde();
		}
	}

	private void rundeBeenden() {
		Spiel.runden.get(aktuelleRunde).beenden();
	}

	@Override
	public String toString() {
		return "Spiel [getSpieler()=" + getSpieler() + "]";
	}

}