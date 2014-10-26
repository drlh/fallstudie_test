package de.spiel.finanzen;

import java.util.ArrayList;
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
    public double getEKkonto()
    {
	return passiva.get("EK");
    }
    public double getDarlehenkonto()
    {
	return passiva.get("DA");
    }
    
    public double getAkitvaSize()
    {
	return aktiva.size();
    }
    
    public double getPassivaSize()
    {
	return passiva.size();
    }
}
