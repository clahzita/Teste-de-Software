package main.parametrizadoTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AposentadoriaInvalidTest {
	
	AposentadoriaInterface consultaAposentadoria;
	
	
	private int fTypeException;
	
	private int fInputIdade;
	
	private int fInputTempoAposentadoria;

	/**
	 * Unit Rule for test exceptions
	 */
	@org.junit.Rule  
	public ExpectedException exception = ExpectedException.none();  

	

	public AposentadoriaInvalidTest(int inputIdade, int inputTempoContribuicao) {
		fInputIdade = inputIdade;
		fInputTempoAposentadoria = inputTempoContribuicao;
		consultaAposentadoria = new Aposentadoria();

	}

	@Test (expected=BusinessException.class)
	public void DeveSeAposentarTest() throws BusinessException {
		
		consultaAposentadoria.deveSeAposentar(fInputIdade, fInputTempoAposentadoria);
		
	}
	
	@Parameters(name = "{index}: fib[{0}]={1}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { 200, 200}, { 1, 200, 200}, });
	}

}
