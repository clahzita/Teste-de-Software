package main.parametrizadoTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AposentadoriaValidTest {

	@Parameters(name = "{index}: fib[{0}]={1}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { 61, 24, "parcial" }, { 61, 35, "integral" }, { 40, 18, "nao aposenta" },
				{ 40, 35, "nao aposenta" }, { 60, 20, "parcial" }, { 60, 29, "parcial" }, { 55, 30, "nao aposenta" },
				{ 55, 0, "nao aposenta" }, { 55, 19, "nao aposenta" }, { 55, 32, "nao aposenta" },
				{ 65, 28, "parcial" }, { 65, 22, "parcial" }, { 59, -1, "invalido" } });
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
