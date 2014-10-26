package de.spiel;

import de.spiel.unternehmen.Unternehmen;

public class Spieler
{
    private String name;
    private Unternehmen unternehmen;
    
    public Spieler()
    {
	this.name = "kein Name"+((int) Math.random()*10000);
	this.unternehmen = new Unternehmen();
	this.unternehmen.setSpielerName(name);
    }
    
    public Spieler(String name)
    {
	this.name = name;
	this.unternehmen = new Unternehmen();
	this.unternehmen.setSpielerName(name);
    }

    
    public String getName()
    {
        return name;
    }
    public Unternehmen getUnternehmen()
    {
        return unternehmen;
    }

    @Override
    public String toString()
    {
	return "Spieler [name=" + name+ "]";
    }
    
    
    
    
}
