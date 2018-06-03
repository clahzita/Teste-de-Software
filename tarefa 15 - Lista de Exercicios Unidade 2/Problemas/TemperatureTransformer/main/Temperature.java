package main;

import main.exception.TemperatureException;

public interface Temperature{  
    
	public double getValue();  
      
    public void setValue(double value) throws TemperatureException;  
      
    public double getFREEZE();  
      
    public double getBOIL();  
      
    public double getZERO();  
}  