package de.Junit;

import org.junit.Before;
import org.junit.Test;

import de.spiel.Spiel;
import de.spiel.Spieler;
import de.spiel.unternehmen.Unternehmen;
import de.spiel.unternehmen.maschinen.Maschine;
import de.spiel.unternehmen.maschinen.MaschineM1;
import de.spiel.unternehmen.mitarbeiter.Azubi;
import de.spiel.unternehmen.mitarbeiter.Vertrieb;

public class SpielTest
{
    Spiel s;
    
    Spieler eins;
    Spieler zwei;

    @Before
    public void setUp() throws Exception
    {
	s = new Spiel();
	
	eins = new Spieler("leo");
	zwei = new Spieler("fabian");
	
	s.add(eins, 50000.0);
	s.add(zwei, 50000.0);
	
	System.out.println(s);
    }

    @Test
    public void test()
    {
	//anfang
	s.ersteRunde(); 
	
	Unternehmen aktuellerSpieler = Spiel.getAktuelleRunde().getAktuellerSpieler().getUnternehmen();
	
	//leo
	/**
	 * Miatrbeiter erstellen
	 */
	Azubi m11 = new Azubi();
	/**
	 * Maschine erstellen
	 */
	Maschine ma11 = new MaschineM1(m11);
	
	//Fabi
	/**
	 * Mitarbeiter erstellen
	 */
	Azubi m21 = new Azubi();
	/**
	 * Maschine erstellen
	 */
	Maschine ma21 = new MaschineM1(m21);
	
	
	// #### 	LEO		#####
	/**
	 * Mitarbeiter hinzufügen
	 */
	aktuellerSpieler.getProduktion().getMitarbeiterListe().add(m11);
	/**
	 * Maschinenführer zuweisen
	 */
	aktuellerSpieler.getProduktion().addMaschine(ma11);
	
	/**
	 * Mitarbeiter im EK und VK hinzufügen
	 */
	aktuellerSpieler.getEinkauf().addMitarbeiter();
	aktuellerSpieler.getVerkauf().addMitarbeiter();
	
	/**
	 * Rohstoffeinkauf
	 */
	aktuellerSpieler.getEinkauf().einkaufenRohstoffe(1000);
	
	/**
	 * Produktionsauftrag erstellen
	 */
	aktuellerSpieler.getProduktion().addAuftrag(ma11, aktuellerSpieler.getLager().getRohstoff(0));
	/**
	 * produzieren
	 */
	aktuellerSpieler.getProduktion().produzieren();
	/**
	 * Angebot erstellen
	 */
	double mengeS1 = aktuellerSpieler.getLager().getLagerlisteProdukt().get(0).getMenge();
	aktuellerSpieler.getVerkauf().erstelleAngebotGroßhandel(mengeS1, 5.00, 0);
	
	/*
	 * NÄCHSTER SPIELER
	 */
	s.nextSpieler();
	
	
	
	// ###		FABI 		###
	/*
	 * SPIELER AKTUALISIEREN
	 */
	aktuellerSpieler = Spiel.getAktuelleRunde().getAktuellerSpieler().getUnternehmen();
	
	aktuellerSpieler.getProduktion().getMitarbeiterListe().add(m21);
	aktuellerSpieler.getProduktion().addMaschine(ma21);
	
	/**
	 * Mitarbeiter im EK und VK hinzufügen
	 */
	aktuellerSpieler.getEinkauf().addMitarbeiter();
	aktuellerSpieler.getVerkauf().addMitarbeiter();
	
	/**
	 * Rohstoffeinkauf
	 */
	aktuellerSpieler.getEinkauf().einkaufenRohstoffe(1500);
	
	/**
	 * Produktionsauftrag erstellen
	 */
	aktuellerSpieler.getProduktion().addAuftrag(ma11, aktuellerSpieler.getLager().getRohstoff(0));
	/**
	 * produzieren
	 */
	aktuellerSpieler.getProduktion().produzieren();
	
	/**
	 * Angebot erstellen
	 */
	double mengeS2 = aktuellerSpieler.getLager().getLagerlisteProdukt().get(0).getMenge();
	aktuellerSpieler.getVerkauf().erstelleAngebotGroßhandel(mengeS2, 4.00, 0);
	
	/*
	 * RUNDE WIRD BEENDET DA NUR 2 SPIELER VORHANDEN SIND
	 */
	s.nextSpieler();
    }

}
