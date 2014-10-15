package de.spiel.unternehmen.abteilung;

import java.util.HashMap;

import de.spiel.finanzen.Kontenplan;
import de.spiel.finanzen.konto.*;
import de.spiel.unternehmen.Unternehmen;

import java.lang.System.*;

public class Finanzen extends Abteilung
{
    private Kontenplan konten;

    public Finanzen()
    {
	super();
	this.abteilungName = "Finanzen";
	this.konten = new Kontenplan();

    }


    @Override
    // Wird nicht benutzt
    public void addMitarbeiter() {}


}
