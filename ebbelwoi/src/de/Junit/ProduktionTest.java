package de.Junit;

import org.junit.Test;

import de.*;
import de.spiel.basic.Rohstoff;
import de.spiel.unternehmen.Unternehmen;
import de.spiel.unternehmen.abteilung.produktion.*;
import de.spiel.unternehmen.maschinen.MaschineM1;
import de.spiel.unternehmen.mitarbeiter.*;

public class ProduktionTest
{

    @Test
    public void test()
    {
	Unternehmen un = new Unternehmen();
	
	Produktion p = un.getProduktion();

	Azubi ma = new Azubi();
	ma.upgrade();
	ma.upgrade();
	ma.upgrade();
	p.getMitarbeiterListe().add(ma);

	MaschineM1 m1 = new MaschineM1(ma);

	p.getMaschinenpark().add(m1);

	System.out.println(p.getMitarbeiterListe());
	
	Rohstoff r = new Rohstoff(100.0);
	System.out.println(r.toString());
	
	p.addAuftrag(m1, r);
	
	p.produzieren();
	
	System.out.println(p.getLager().toString());
    }

}
