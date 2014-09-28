package de.spiel.basic.stufen;

public class MaschinenStufen extends Stufe
{
    public MaschinenStufen()
    {
	super();
	this.setBonus();
    }

    @Override
    public void setBonus()
    {
	this.bonus[0] = 2;
	this.bonus[1] = 3;
	this.bonus[2] = 4;
    }

}
