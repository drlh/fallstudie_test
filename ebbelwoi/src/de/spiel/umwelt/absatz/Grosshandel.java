package de.spiel.umwelt.absatz;

public class Grosshandel extends Kunde
{
    
    public Grosshandel(){
	super();
	initKunde();
    }
    
    @Override
    protected void initKunde()
    {
	MINAB = 3000;
	MAXAB = 10000;
	menge = Math.floor((menge * (MAXAB - MINAB) + MINAB) * 100) / 100;
    }

}
