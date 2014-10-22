package de.spiel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import de.spiel.umwelt.Umwelt;

public class Spiel
{
    private ArrayList<Spieler> spieler;
    private ArrayList<Runde> runden;

    public static int aktuelleRunde = 0;

    public Spiel()
    {
	System.out.println("Spiel gestartet");
	this.spieler = new ArrayList<Spieler>();
	this.runden = new ArrayList<Runde>();

	try {
	    initSpieler();
	    initKredite();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    private void initSpieler() throws NumberFormatException, IOException
    {
	if (aktuelleRunde == 0) {
	    BufferedReader s = new BufferedReader(new InputStreamReader(
		    System.in));

	    int anzSpieler = 0;

	    System.out.println("Wieviele Spieler sollen mitmachen?");
	    anzSpieler = Integer.parseInt(s.readLine());

	    for (int i = 0; i < anzSpieler; i++) {
		System.out.println("Name Spieler " + (i + 1) + ": ");
		String name = s.readLine();
		spieler.add(new Spieler(name));
	    }

	    // s.close();
	}

    }

    private void initKredite() throws NumberFormatException, IOException
    {
	if (aktuelleRunde == 0) {

	    int kredit = 0;
	    boolean answered = false;

	    for (int i = 0; i < spieler.size(); i++) {
		BufferedReader s = new BufferedReader(new InputStreamReader(
			System.in));
		boolean kred = false;
		System.out.println(spieler.get(i).getName());

		System.out
			.println("Möchten Sie einen Kredit aufnehmen? (j für ja, n für nein):");
		
		while (answered == false) {

		    String scannBool = s.readLine();
		    
		    if (scannBool != "J" && scannBool != "j"
			    && scannBool != "N" && scannBool != "n") {
			System.out
				.println("Sie haben eine nicht interpretierbare Eingabe getätigt! Bitte versuchen Sie es erneut: ");
			scannBool = s.readLine();
		    }
		    if (scannBool == "j" || scannBool == "J") {
			kred = true;
			answered = true;
		    }else{
			kred = false;
			answered = true;
		    }
			
		}

		if (kred == true) {
		    System.out
			    .println("Bitte geben Sie die Kredithöhe in €(bis max. 100000 ein:");
		    kredit = Integer.parseInt(s.readLine());
		    if (kredit >= 0 && kredit <= 100000) {
			System.out.println("Kredit wurde genehmigt!");
			spieler.get(i).getUnternehmen().getFinanzen()
				.getKonten().buchen("BA", "DA", kredit);

		    } else {
			while (kredit < 0 || kredit > 100000) {
			    System.out
				    .println("Kredithöhe liegt nicht im gegeben Rahmen! Versuchen Sie es erneut:");
			    kredit = 0;
			    kredit = Integer.parseInt(s.readLine());
			}
		    }
		}
		// s.close();
	    }

	}

    }

    // SPIELER
    public boolean add(Spieler arg0)
    {
	return spieler.add(arg0);
    }

    public Spieler get(int arg0)
    {
	return spieler.get(arg0);
    }

    public ArrayList<Spieler> getSpieler()
    {
	return spieler;
    }

    // RUNDEN
    public static int getAktuelleRundeNr()
    {
	return aktuelleRunde;
    }

    public Runde getAktuelleRunde()
    {
	return runden.get(aktuelleRunde);
    }

    public Runde getRunde(int i)
    {
	return runden.get(i);
    }

    public void neueRunde()
    {
	this.getRunde(aktuelleRunde).beenden();
	this.runden.add(new Runde(spieler));
	aktuelleRunde++;
    }

}
