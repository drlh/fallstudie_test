package de.spiel.unternehmen.mitarbeiter;

public abstract class Mitarbeiter 
{
	String nachname, vorname;
	
	String[] vornamen = {"Christina","Yannick","Niklas","Leo","Basti", "Fabi"};
	String[] nachnamen= {"Junghans", "Sarnoch","Miroll", "Hellwich","Brehm","Angst"};
	
	public Mitarbeiter() 
	{
		this.nachname = nachnamen[(int)( Math.random()*nachnamen.length)];
		this.vorname = vornamen[(int)(Math.random()*vornamen.length)];
	}
	
	
	@Override
	public String toString() 
	{
		return "Mitarbeiter[vorname="+vorname+", nachname="+nachname+"]";
	}
	

}
