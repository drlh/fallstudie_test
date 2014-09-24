package de.spiel;

import de.spiel.unternehmen.Unternehmen;

public class Spieler
{
    private String name;
    private Unternehmen unternehmen;
    
    public Spieler()
    {
	this.name = "";
    }
    
    public Spieler(String name)
    {
	this.name = name;
    }
}
