package de.spiel;

import de.spiel.unternehmen.Unternehmen;

public class Spieler
{
    private String name;
    private Unternehmen unternehmen;
    
    public Spieler()
    {
	this.name = "kein Name";
	this.unternehmen = new Unternehmen();
    }
    
    public Spieler(String name)
    {
	this.name = name;
	this.unternehmen = new Unternehmen();
    }

    
    public String getName()
    {
        return name;
    }
    public Unternehmen getUnternehmen()
    {
        return unternehmen;
    }
    
    
}
