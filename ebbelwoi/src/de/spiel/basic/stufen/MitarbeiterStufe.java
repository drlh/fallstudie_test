package de.spiel.basic.stufen;

public class MitarbeiterStufe extends Stufe
{
    public MitarbeiterStufe()
    {
	super();
	this.setBonus();
    }

    @Override
    public void setBonus()
    {
	this.bonus[0] = 2;
	this.bonus[1] = 4;
	this.bonus[2] = 6;
	
    }
}
