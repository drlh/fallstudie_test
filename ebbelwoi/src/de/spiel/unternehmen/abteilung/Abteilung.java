package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.finanzenALT.*;
import de.spiel.unternehmen.Unternehmen;
import de.spiel.unternehmen.mitarbeiter.Mitarbeiter;

public abstract class Abteilung
{
    protected String abteilungName;
    protected ArrayList<Mitarbeiter> mitarbeiter;

    private static Unternehmen unternehmen;

    public Abteilung()
    {
    }

    public static void setUnternehmen(Unternehmen unternehmen)
    {
	Abteilung.unternehmen = unternehmen;
    }

    public Konto getKonto()
    {
	return unternehmen.getKonto();
    }

    public Lager getLager()
    {
	return unternehmen.getLager();
    }

    public abstract void addMitarbeiter();

    public void addMitarbeiterO(Mitarbeiter obj)
    {
	this.mitarbeiter.add(obj);
    }

    public Mitarbeiter get(int arg0)
    {
	return mitarbeiter.get(arg0);
    }

    public ArrayList<Mitarbeiter> getMitarbeiterListe()
    {
	return this.mitarbeiter;
    }

    public Mitarbeiter remove(int arg0)
    {
	return mitarbeiter.remove(arg0);
    }

    public boolean remove(Object arg0)
    {
	return mitarbeiter.remove(arg0);
    }

    public int size()
    {
	return mitarbeiter.size();
    }

}
