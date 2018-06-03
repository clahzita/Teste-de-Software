package main;

import main.exception.TemperatureException;

public class FahrenheitTemperature implements Temperature{  
  
    private double value;  
  
    private final double FREEZE = 32;  
  
    private final double BOIL = 212;  
  
    private final double ZERO = -459.4;  
  
    public FahrenheitTemperature(){ }  
  
    public double getValue(){   
       return value;  
    }  
  
    public void setValue(double value) throws TemperatureException{  
       if(value < ZERO) throw new TemperatureException("Não há temperatura abaixo do zero absoluto");  
       else this.value = value;  
    }  
  
    public double getFREEZE(){ return FREEZE;}  
  
    public double getBOIL(){ return BOIL;}  
  
    public double getZERO(){ return ZERO;}  
  
    public String toString(){  
       return getValue()+" F";  
    }  
  
    public boolean equals(Object other){  
       if(other instanceof FahrenheitTemperature)     
        return (((FahrenheitTemperature) other).getValue() == getValue());  
       else return false;  
    }  
}