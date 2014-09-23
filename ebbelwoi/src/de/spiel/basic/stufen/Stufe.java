package de.spiel.basic.stufen;

public abstract class Stufe
{
    private int stufe = 0;
    protected int[] bonus = new int[3];

    public Stufe()
    {

    }

    public void upgrade()
    {
	if (this.stufe <= 3) {
	    this.stufe++;
	}
    }

    public int getStufe()
    {
	return stufe;
    }

    private int getStufenBonus(int stufe)
    {
	if (stufe > 0) {
	    return this.bonus[stufe - 1];
	} else {
	    return 0;
	}
    }

    public int getBonus()
    {
	return getStufenBonus(this.stufe);
    }

    public abstract void setBonus();

}
