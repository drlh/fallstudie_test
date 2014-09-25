package de.spiel.unternehmen.maschinen;

import de.spiel.basic.stufen.MaschinenStufen;

public abstract class Maschine
{
    MaschinenStufen stufe;

    public Maschine()
    {
	this.stufe = new MaschinenStufen();
    }
}
