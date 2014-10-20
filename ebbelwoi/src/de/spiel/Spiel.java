package de.spiel;

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
	
	initSpieler();
    }

    private void initSpieler()
    {
	if (aktuelleRunde == 0) {
	    Scanner s = new Scanner(System.in);
	    int anzSpieler = 0;
	    
	    System.out.println("Wieviele Spieler sollen mitmachen?");
	    anzSpieler = Integer.parseInt(s.next());
	    
	    for (int i = 0; i < anzSpieler; i++) {
		System.out.println("Name Spieler "+(i+1)+": ");
		String name = s.next();
		spieler.add(new Spieler(name));
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
    
    public Runde  getAktuelleRunde()
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
