package de.spiel.finanzen;

import java.util.Hashtable;

public class Bilanz
{
    Hashtable<String, Double> aktiva;
    Hashtable<String, Double> passiva;
    
    private GuV guv;

    double ergebnis = 0.0;

    public Bilanz(GuV guv)
    {
	aktiva = new Hashtable<String, Double>();
	passiva = new Hashtable<String, Double>();
	this.guv = guv;
    }

    public Hashtable<String, Double> getAktiva()
    {
	return aktiva;
    }

    public Hashtable<String, Double> getPassiva()
    {
	return passiva;
    }

    public double getErgebnis()
    {
	return ergebnis;
    }

    public void setErgebnis(double ergebnis)
    {
	this.ergebnis = ergebnis;
    }

    public Double putAktiva(String arg0, Double arg1)
    {
	return aktiva.put(arg0, arg1);
    }
    
    public Double putPassiva(String arg0, Double arg1)
    {
	return passiva.put(arg0, arg1);
    }

    /**
     * Stellt die Bilanz auf
     */
    public void aufstellenBilanz()
    {
	this.ergebnis = guv.abrechnen();
	
	double ekNeu = passiva.get("EK");
	ekNeu += ergebnis;
	
	passiva.put("EK", ekNeu);
	
	System.out.println(toString());
    }
    
    @Override
    public String toString()
    {
       String s ="Aktiva\t\t\tBILANZ\t\t\tPassiva"+
	       	"\n________________________________________________________";
       
       
       
       return s;
    }
    
    
    

}
