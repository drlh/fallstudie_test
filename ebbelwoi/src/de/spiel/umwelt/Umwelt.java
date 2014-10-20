package de.spiel.umwelt;

public class Umwelt
{
    private static Beschaffungsmarkt beschaffung;
    private static Absatzmarkt absatz;

    public Umwelt()
    {
	Umwelt.setBeschaffung(new Beschaffungsmarkt());
	Umwelt.setAbsatz(new Absatzmarkt());
    }
    

    public static void neueRunde()
    {
	setBeschaffung(new Beschaffungsmarkt());
	setAbsatz(new Absatzmarkt());
    }


    //Beschaffung
    public static Beschaffungsmarkt getBeschaffung()
    {
	return beschaffung;
    }
    public static void setBeschaffung(Beschaffungsmarkt beschaffung)
    {
	Umwelt.beschaffung = beschaffung;
    }


    //Absatz
    public static Absatzmarkt getAbsatz()
    {
	return absatz;
    }
    public static void setAbsatz(Absatzmarkt absatz)
    {
	Umwelt.absatz = absatz;
    }
}
