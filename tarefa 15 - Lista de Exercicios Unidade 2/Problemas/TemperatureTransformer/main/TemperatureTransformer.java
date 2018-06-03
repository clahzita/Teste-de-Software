package main;

import java.text.DecimalFormat;

public class TemperatureTransformer{  
  
    public TemperatureTransformer(){ }  
  
    public Temperature convert(Temperature temp) throws Exception{  
    	if(temp == null) {
    		throw new NullPointerException("Objeto nulo, instancie a variável");
    	}
   
    	
       if(temp instanceof CelsiusTemperature)
    	   return convertToFahrenheit(temp);
       else 
    	   return convertToCelsius(temp);
    }  
  
    private Temperature convertToFahrenheit(Temperature celsius) throws Exception{  
       FahrenheitTemperature f = new FahrenheitTemperature();  
       double cvalue = celsius.getValue();   
       System.out.println("celsius value:"+cvalue);
       double fvalue = 1.8*cvalue+f.getFREEZE(); // formulinha 1 :)
       System.out.println("fah value:"+fvalue);
       f.setValue(fvalue);  
       return f;  
    }  
  
    private Temperature convertToCelsius(Temperature fahrenheit) throws Exception{  
       CelsiusTemperature c = new CelsiusTemperature();  
       double fvalue = fahrenheit.getValue();   
       System.out.println("fahreiinheit value"+fvalue);
       double cvalue = (5*fvalue-5*fahrenheit.getFREEZE())/9;// formulinha 2 ?! consertada! :)
       System.out.println("fahreiinheit value"+fvalue);
       c.setValue(cvalue);  
       return c;  
    }  
  
}  