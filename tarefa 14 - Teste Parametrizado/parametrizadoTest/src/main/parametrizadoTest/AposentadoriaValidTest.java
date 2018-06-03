package main.parametrizadoTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AposentadoriaValidTest {

	@Parameters(name = "{index}: deveSeAposentar[{0},{1}]")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { 60, 20, "parcial" }, { 30, 10, "nao aposenta" },
											  { 61, 21, "parcial" }, { 59, 19, "nao aposenta" },
											  { 125, 30, "integral" },{ 65, 25, "parcial" }, 
											  { 58, 18, "nao aposenta" }, { 124, 32, "integral" },
											  { 65, 28, "parcial" }, { 40, 24, "nao aposenta" }, 
											  { 40, 23, "nao aposenta" } });
	}

	private int fInputIdade;
	
	private int fInputTempoAposentadoria;

	private String fExpected;

	AposentadoriaInterface consultaAposentadoria;

	public AposentadoriaValidTest(int inputIdade, int inputTempoContribuicao, String expected) {
		fInputIdade = inputIdade;
		fInputTempoAposentadoria = inputTempoContribuicao;
		fExpected = expected;
		consultaAposentadoria = new Aposentadoria();

	}

	@Test
	public void DeveSeAposentarTest() throws BusinessException {
		assertEquals(fExpected, consultaAposentadoria.deveSeAposentar(fInputIdade, fInputTempoAposentadoria));
	}

}
