package de.spiel.unternehmen.mitarbeiter;

public class Geselle extends Produktionsmitarbeiter
{
    public Geselle()
    {
	super();
	setGehalt(1500);
    }

    public Geselle(double gehalt)
    {
	super(gehalt);
    }
}
