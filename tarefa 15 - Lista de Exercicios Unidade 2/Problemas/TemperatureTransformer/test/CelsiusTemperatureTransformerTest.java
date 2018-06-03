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
import main.Temperature;
import main.TemperatureTransformer;
import main.exception.TemperatureException;

@RunWith(Parameterized.class)
public class CelsiusTemperatureTransformerTest {
	
	@Parameters(name = "CT{index}: convert[{0}C]= {1}F")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { -0.1, 31.82, true}, { 0.0, 32.0, true },
											  { 0.1, 32.18, true }, { 100, 212, true },
											  { -273, -459.40000000000003, false }, { 99.9, 211.82, true },
											  { -272.9, -459.22, true }, { 100.1, 212.18, true },
											  { -273.1, -459.58, false }, { 0.0, 0.0, false }//usado para testar o null
										    });
	}
	
	/**
	 * Unit Rule for test exceptions
	 */
	@org.junit.Rule  
	public ExpectedException exception = ExpectedException.none();  
 
	
	private TemperatureTransformer transformer;
	private Temperature celsius;
	
	private double inputCelsiusValue;
	private double inputFahreinheitValue;
	private boolean inputIsValid;
	
	public CelsiusTemperatureTransformerTest(double celsiusValue, double expectedFahreinheit, boolean isValid) throws Exception {
		inputCelsiusValue = celsiusValue;
		inputFahreinheitValue = expectedFahreinheit;
		inputIsValid = isValid;
	}
	
	@Before
	public void initialize(){
		transformer = new TemperatureTransformer();
		celsius = new CelsiusTemperature();
	}
	
	@Test
	public void testCelsiusTemperatureConvertionValid() throws Exception {
		
		if(inputIsValid) {
			celsius.setValue(inputCelsiusValue);
			//fahreinheit.setValue(inputFahreinheitValue);	
			double expected = inputFahreinheitValue;
			double actual = transformer.convert(celsius).getValue();
			assertEquals(expected, actual,0.1);
		}else {
			if(inputCelsiusValue <= celsius.getZERO()) {
				exception.expect(TemperatureException.class);
				celsius.setValue(inputCelsiusValue);
				transformer.convert(celsius);
			}
			
			if(inputCelsiusValue == 0.0) {
				exception.expect(NullPointerException.class);	
				transformer.convert(null);
			}
			
		}
	}
		

}
