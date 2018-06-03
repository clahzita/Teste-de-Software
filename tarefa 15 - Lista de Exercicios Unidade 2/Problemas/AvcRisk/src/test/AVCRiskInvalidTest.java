package test;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.AVCRisk;
import main.exception.InvalidArgumentException;

@RunWith(Parameterized.class)
public class AVCRiskInvalidTest {
	@Parameters(name = "CT{index}: checkRisk[{0},{1}]")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { -0.1, 0 }, { 0.0, -1 }, {-0.1,-1}

										    });
	}
	
	private double inputTemp;
	private int inputCard;
	
	private AVCRisk avcRisk;
		
	public AVCRiskInvalidTest(double temp, int card) {
		this.inputTemp = temp;
		this.inputCard = card;
		
	}
	
	@Before
	public void start() {
		avcRisk = new AVCRisk();
	}
	
	
	@Test (expected=InvalidArgumentException.class)
	public void test() throws InvalidArgumentException {
		
		avcRisk.checkRisk(inputTemp, inputCard);
	
	}
}
