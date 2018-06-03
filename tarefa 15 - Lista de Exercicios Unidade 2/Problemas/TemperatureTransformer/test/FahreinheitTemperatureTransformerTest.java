package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.CelsiusTemperature;
import main.FahrenheitTemperature;
import main.Temperature;
import main.TemperatureTransformer;
import main.exception.TemperatureException;

@RunWith(Parameterized.class)
public class FahreinheitTemperatureTransformerTest {
	
	@Parameters(name = "CT{index}: convert[{0}F]= {1}C")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { 31.9, -0.05555556, true}, { 32.0, 0.0, true },
											  { 32.1, 0.05555556, true }, { 212, 100, true },
											  { -459.4, -273, true }, { -459.5, -273.05556, false },
											  { 211.9, 99.944444, true }, { -459.3, -272.94444, true },
											  { 212.1 , 100.05556, false }, { 0.0, 0.0, false }//usado para testar o null
										    });
	}
	
	/**
	 * Unit Rule for test exceptions
	 */
	@org.junit.Rule  
	public ExpectedException exception = ExpectedException.none();  
 
	
	private TemperatureTransformer transformer;
	private Temperature fahreinheit;
	
	private double inputFahreinheitValue;
	private double inputExpectedCelsius;
	private boolean inputIsValid;
	
	public FahreinheitTemperatureTransformerTest(double fahreinheitValue, double expectedCelsius, boolean isValid) throws Exception {
		inputFahreinheitValue = fahreinheitValue;
		inputExpectedCelsius = expectedCelsius;
		inputIsValid = isValid;
	}
	
	@Before
	public void initialize(){
		transformer = new TemperatureTransformer();
		fahreinheit = new FahrenheitTemperature();
	}
	
	@Test
	public void testCelsiusTemperatureConvertionValid() throws Exception {
		
		if(inputIsValid) {
			fahreinheit.setValue(inputFahreinheitValue);
			double expected = inputExpectedCelsius;
			double actual = transformer.convert(fahreinheit).getValue();
			assertEquals(expected, actual, 0.1);
		}else {
			if(inputFahreinheitValue < fahreinheit.getZERO()) {
				exception.expect(TemperatureException.class);
				fahreinheit.setValue(inputFahreinheitValue);
				transformer.convert(fahreinheit);
			}
			
			if(inputFahreinheitValue == 0.0) {
				exception.expect(NullPointerException.class);	
				transformer.convert(null);
			}
			
		}
	}
		

}
