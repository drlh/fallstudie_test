package de.spiel.unternehmen.mitarbeiter;

import de.spiel.basic.stufen.MitarbeiterStufe;

public abstract class Mitarbeiter
{
    String nachname, vorname;
    MitarbeiterStufe stufe;
    private double gehalt;

    String[] vornamen = { "Christina", "Yannick", "Niklas", "Leo", "Basti","Fabi" };
    String[] nachnamen = { "Junghans", "Sarnoch", "Miroll", "Hellwich","Brehm", "Angst" };

    public Mitarbeiter()
    {
	this.nachname = nachnamen[(int) (Math.random() * nachnamen.length)];
	this.vorname = vornamen[(int) (Math.random() * vornamen.length)];
	this.stufe = new MitarbeiterStufe();
	this.gehalt = 0.0;
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
    
    public double getGehalt()
    {
	return gehalt;
    }

    
    protected void setGehalt(double gehalt)
    {
	this.gehalt = gehalt;
    }
    @Override
	public String toString() 
	{
		return this.getClass().getSimpleName()+"[vorname="+vorname+", nachname="+nachname+", stufe="+this.getStufe()+"]";
	}

}
