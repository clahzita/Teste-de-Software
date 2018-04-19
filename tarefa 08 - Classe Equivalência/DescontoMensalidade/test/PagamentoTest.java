import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.NumeroFilhosInvalidoException;
import exception.ValorInvalidoException;


public class PagamentoTest{
	
	private Pagamento pag1;


	@Before
	public void setup() {
		pag1 = new Pagamento();

	}
	
	/**
	 * CT1.
	 * Testa o caso válido: 0 < num_filhos < 3 filhos e pagamento sem desconto
	 * @throws NumeroFilhosInvalidoException 
	 * @throws ValorInvalidoException 
	 */
	@Test
	public void testNumeroFilhosMenorQueTresSemDesconto() throws NumeroFilhosInvalidoException, ValorInvalidoException {
		double actual = pag1.calculaMensalidade(2, 100.00);
		double expected = 200.00;
		assertEquals(expected, actual, 0);
		
	}
	
	/**
	 * CT2.
	 * Testa o caso válido: num_filhos >= 3 e pagamento com desconto
	 * @throws NumeroFilhosInvalidoException 
	 * @throws ValorInvalidoException 
	 */
	@Test
	public void testNumerFilhosIgualTresComDesconto() throws NumeroFilhosInvalidoException, ValorInvalidoException {
		double actual = pag1.calculaMensalidade(3, 100.00);
		double expected = 150.00;
		assertEquals(expected, actual,0.0);
	}
	
	/**
	 * CT3.
	 * Testa o caso válido: valor_mensalidade_individual >= 0.00
	 * @throws NumeroFilhosInvalidoException 
	 * @throws ValorInvalidoException 
	 */
	@Test
	public void testValorMensalidadeValido() throws NumeroFilhosInvalidoException, ValorInvalidoException {
		double actual = pag1.calculaMensalidade(3, 0.00);
		double expected = 0.00;
		assertEquals(expected, actual,0.0);
	}
	
	/**
	 * CT4. Testa o caso inválido: num_filhos <= 0 , lança exceção NumeroFilhosInvalidoException
	 * @throws NumeroFilhosInvalidoException 
	 * @throws ValorInvalidoException 
	 */
	@Test (expected= NumeroFilhosInvalidoException.class)
	public void testNumeroFilhosInvalido() throws NumeroFilhosInvalidoException, ValorInvalidoException {
		pag1.calculaMensalidade(0, 100.00);
		
	}
	
	
	/**
	 * CT5.
	 * Testa o caso inválido: valor_mensalidade_individual < 0.0 , lança exceção ValorInvalidoException
	 * @throws NumeroFilhosInvalidoException 
	 * @throws ValorInvalidoException 
	 */
	@Test (expected= ValorInvalidoException.class)
	public void testValorMensalidadeNegativo() throws NumeroFilhosInvalidoException, ValorInvalidoException {
		pag1.calculaMensalidade(2, -1.00);
		
	}

}
