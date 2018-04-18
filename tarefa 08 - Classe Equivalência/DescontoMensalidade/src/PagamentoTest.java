import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.NumeroFilhosInvalidoException;
import exception.ValorInvalidoException;

public class PagamentoTest {
	
	private Pagamento pag1;


	@Before
	private void setup() {
		pag1 = new Pagamento();

	}
	
	/**
	 * Testa o caso válido: num_filhos < 3 filhos e pagamento sem desconto
	 * @throws NumeroFilhosInvalidoException 
	 * @throws ValorInvalidoException 
	 */
	@Test
	public void testNumeroFilhosMenorQueTresSemDesconto() throws NumeroFilhosInvalidoException, ValorInvalidoException {
		double actual = pag1.calculaMensalidade(2, 100.00);
		double expected = 200.00;
		assertEquals(expected, actual,0.0);
	}
	
	/**
	 * Testa o caso válido: num_filhos = 3 filhos e pagamento com desconto
	 * @throws NumeroFilhosInvalidoException 
	 * @throws ValorInvalidoException 
	 */
	@Test
	public void testNumerFilhosIgualTresComDesconto() throws NumeroFilhosInvalidoException, ValorInvalidoException {
		double actual = pag1.calculaMensalidade(3, 100.00);
		double expected = 100.00;
		assertEquals(expected, actual,0.0);
	}
	
	/**
	 * Testa o caso inválido: num_filhos >= 0 , lança exceção
	 * @throws NumeroFilhosInvalidoException 
	 * @throws ValorInvalidoException 
	 */
	@Test (expected= NumeroFilhosInvalidoException.class)
	public void testNumeroFilhosInvalido() throws NumeroFilhosInvalidoException, ValorInvalidoException {
		pag1.calculaMensalidade(0, 100.00);
		
	}
	
	
	/**
	 * Testa o caso inválido: valor_mensalidade_individual < 0 , lança exceção
	 * @throws NumeroFilhosInvalidoException 
	 * @throws ValorInvalidoException 
	 */
	@Test (expected= NumeroFilhosInvalidoException.class)
	public void test() throws NumeroFilhosInvalidoException, ValorInvalidoException {
		pag1.calculaMensalidade(4, -100.00);
		
	}

}
