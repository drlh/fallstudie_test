package de.spiel.finanzen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
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
	String s = "Aktiva\t\t\tBILANZ\t\t\tPassiva"
		+ "\n________________________________________________________\n";

	ArrayList<String> aktiva = Collections.list(this.aktiva.keys());
	ArrayList<String> passiva = Collections.list(this.passiva.keys());

	int size = 0;
	double summeAktiva = 0.0;
	double summePassiva = 0.0;

	if (this.aktiva.size() > this.passiva.size()) {
	    size = this.aktiva.size();
	} else {
	    size = this.passiva.size();
	}

	try {
	    for (int i = 0; i < size; i++) {
		if (i < this.aktiva.size()) {
		    String a = aktiva.get(i);
		    double d = this.aktiva.get(a);
		    summeAktiva += d;
		    
		    s += a + "\t\t" + d;
		}
		s+="\t|";
		if (i < this.passiva.size()) {
		    String p = passiva.get(i);
		    double d = this.passiva.get(p);
		    summePassiva += d;
		    
		    s += "\t"+p + "\t\t" + d;
		}
		s+="\n";
	    }
	    
	} catch (NullPointerException e) {
	    // TODO: handle exception
	}
	s+="________________________________________________________\n";
	s+=summeAktiva+"\t\t\t\t\t\t"+summePassiva;
	
	s+= "\n\nErgebnis: "+this.getErgebnis();
	return s;
    }

}
