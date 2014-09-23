package de.spiel.unternehmen.mitarbeiter;

import de.spiel.basic.stufen.MitarbeiterStufe;

public abstract class Mitarbeiter
{
    String nachname, vorname;
    MitarbeiterStufe stufe;

    String[] vornamen = { "Christina", "Yannick", "Niklas", "Leo", "Basti",
	    "Fabi" };
    String[] nachnamen = { "Junghans", "Sarnoch", "Miroll", "Hellwich",
	    "Brehm", "Angst" };

    public Mitarbeiter()
    {
	this.nachname = nachnamen[(int) (Math.random() * nachnamen.length)];
	this.vorname = vornamen[(int) (Math.random() * vornamen.length)];
	this.stufe = new MitarbeiterStufe();
    }

    public void upgrade()
    {
	this.stufe.upgrade();
    }

    public int getStufe()
    {
	return stufe.getStufe();
    }

    public int getBonus()
    {
	return this.stufe.getBonus();
    }

    @Override
	public String toString() 
	{
		return this.getClass().getName()+"[vorname="+vorname+", nachname="+nachname+", stufe="+this.getStufe()+"]";
	}

}
