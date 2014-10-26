package de.spiel.finanzen;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

public class Snapshot
{
    Hashtable<String, Double> aktiva;
    Hashtable<String, Double> passiva;
    
    public Snapshot()
    {
	
    }
    
    public void addAktiva(String s, double d)
    {
	aktiva.put(s, d);
    }
    
    public void addPassiva(String s, double d)
    {
	passiva.put(s, d);
    }
    
    
    
    public double getMaschinenkonto()
    {
	return aktiva.get("MA");
    }
    
    public double getRohstoffkonto()
    {
	return aktiva.get("RS");
    }
    public double getFertigerzeugniskonto()
    {
	return aktiva.get("FE");
    }
    public double getBankkonto()
    {
	return aktiva.get("BA");
    }
    
    public double getEKkonto()
    {
	return passiva.get("EK");
    }
    public double getDarlehenkonto()
    {
	return passiva.get("DA");
    }
    
    public int getAkitvaSize()
    {
	return aktiva.size();
    }
    
    public int getPassivaSize()
    {
	return passiva.size();
    }
    
    //Summen
    public double summeAktiva()
    {
	Enumeration<String> s = aktiva.keys();
	double d = 0.0;
	while (s.hasMoreElements()) {
	    String string = (String) s.nextElement();
	    d += aktiva.get(string);
	}
	return d;
    }
    
    public double summePassiva()
    {
	Enumeration<String> s = passiva.keys();
	double d = 0.0;
	while (s.hasMoreElements()) {
	    String string = (String) s.nextElement();
	    d += passiva.get(string);
	}
	return d;
    }
}
