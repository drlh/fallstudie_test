package de.spiel;

import java.util.ArrayList;

import de.spiel.umwelt.Umwelt;

public class Spiel 
{
    private ArrayList<Spieler> spieler;
    private static Umwelt umwelt;
    
    public Spiel()
    {
	this.spieler = new ArrayList<Spieler>();
    }

    public boolean add(Spieler arg0)
    {
	return spieler.add(arg0);
    }

    public Spieler get(int arg0)
    {
	return spieler.get(arg0);
    }

    public int size()
    {
	return spieler.size();
    }
    
    
    
}
