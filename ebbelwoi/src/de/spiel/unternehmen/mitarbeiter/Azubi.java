package de.spiel.unternehmen.mitarbeiter;

public class Azubi extends Produktionsmitarbeiter
{
    public Azubi()
    {
	super();
	setGehalt(500);
    }
    
    public Azubi(double gehalt)
    {
	super(gehalt);
    }

}
