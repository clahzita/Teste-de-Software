package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.AVCRisk;
import main.exception.InvalidArgumentException;

@RunWith(Parameterized.class)
public class AVCRiskValidTest {
	
	@Parameters(name = "CT{index}: checkRisk[{0},{1}]")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { 0.0, 0, false }, { 0.1, 1, false },
											  { 39.1, 119, true }, { 39.0, 119, false },
											  { 39.1, 118, false }, { 38.9, 117, false }
										    });
	}
	
	private double inputTemp;
	private int inputCard;
	private boolean resultRiscoAvc;
	
	private AVCRisk avcRisk;
		
	public AVCRiskValidTest(double temp, int card, boolean riscoAvc) {
		this.inputTemp = temp;
		this.inputCard = card;
		this.resultRiscoAvc = riscoAvc;
		
	}
	
	@Before
	public void start() {
		avcRisk = new AVCRisk();
	}
	
	
	@Test
	public void test() throws InvalidArgumentException {
		if(resultRiscoAvc) {
			assertTrue(avcRisk.checkRisk(inputTemp, inputCard));
		}else {
			assertFalse(avcRisk.checkRisk(inputTemp, inputCard));
		}
	
	}

}
