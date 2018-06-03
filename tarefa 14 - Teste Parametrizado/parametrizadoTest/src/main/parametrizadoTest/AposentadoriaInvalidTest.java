package main.parametrizadoTest;

import java.util.Arrays;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AposentadoriaInvalidTest {
	
	AposentadoriaInterface consultaAposentadoria;
	
	
	private String fTypeException;
	
	private int fInputIdade;
	
	private int fInputTempoAposentadoria;

	/**
	 * Unit Rule for test exceptions
	 */
	@org.junit.Rule  
	public ExpectedException exception = ExpectedException.none();  

	

	public AposentadoriaInvalidTest(int inputIdade, int inputTempoContribuicao, String typeExcecao) {
		fInputIdade = inputIdade;
		fInputTempoAposentadoria = inputTempoContribuicao;
		fTypeException = typeExcecao;
		consultaAposentadoria = new Aposentadoria();

	}

	@Test 
	public void DeveSeAposentarTest() throws BusinessException {
		
		exception.expect(BusinessException.class);
		exception.expectMessage(fTypeException);
		
		consultaAposentadoria.deveSeAposentar(fInputIdade, fInputTempoAposentadoria);
		
	}
	
	@Parameters(name = "{index}: deveSeAposentar[{0},{1}] -> exceção {2}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { 0, 0, Aposentadoria.TRABALHO_INFANTIL }, 
			                                  {-2,-2, Aposentadoria.NEGATIVO },
											  { 1, 1, Aposentadoria.TRABALHO_INFANTIL },
											  { -1, -1, Aposentadoria.NEGATIVO}, 
											  { 126, 29, Aposentadoria.MATOSALEM},
											  { 127, 45, Aposentadoria.MATOSALEM},
											  { 40, 40, Aposentadoria.TRABALHO_INFANTIL},
											  { 40, 41, Aposentadoria.VIDAS_PASSADAS},
											  { 40, 39, Aposentadoria.TRABALHO_INFANTIL},
											  { 40, 25, Aposentadoria.TRABALHO_INFANTIL}});
	}

}
