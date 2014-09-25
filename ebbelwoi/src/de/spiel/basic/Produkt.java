package de.spiel.basic;

public class Produkt
{
    private String name;
    private double menge;
    private Qualitaetstufe qualitaet;

    public Produkt()
    {
	this.name = "Apfelwein";
	this.menge = 0.0;
	this.qualitaet = new Qualitaetstufe();
    }

    public Produkt(double menge)
    {
	this.name = "Apfelwein";
	this.menge = menge;
	this.qualitaet = new Qualitaetstufe();
    }

    public Produkt(double menge, int qualitaet)
    {
	this.name = "Apfelwein";
	this.menge = menge;
	this.qualitaet = new Qualitaetstufe(qualitaet);
    }

    public double getMenge()
    {
	int qualitaet = this.getQualitaet().getAktuelleStufe();
	double menge = 0.0;
	
	switch (qualitaet) {
	case 6:	return this.menge;
	case 5: return (this.menge * 0.9);
	case 4: return (this.menge * 0.8);
	case 3: return (this.menge * 0.6);
	case 2:	return (this.menge * 0.5);
	case 1:	return (this.menge * 0.3);
	default: return 0;
	}
	
    }

    public void setMenge(double menge)
    {
	this.menge = menge;
    }

    public Qualitaetstufe getQualitaet()
    {
	return qualitaet;
    }

    public void setQualitaet(int qualitaet)
    {
	this.qualitaet.setAktuelleStufe(qualitaet);
    }

    @Override
    public String toString()
    {
	return "Produkt [name=" + name + ", menge=" + menge + ", qualitaet="+ qualitaet + "]";
    }
    
    
}
