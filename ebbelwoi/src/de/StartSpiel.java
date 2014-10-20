package de;

import de.spiel.Spiel;

public class StartSpiel 
{
   
    
    public static void main(String[] args)
    {
	Spiel s = new Spiel();
	String ss = s.getSpieler().toString();
	
	System.out.println(ss);
    }
}
