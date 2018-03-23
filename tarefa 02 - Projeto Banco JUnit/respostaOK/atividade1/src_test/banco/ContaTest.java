package banco;

//s�� para os testes com @Test
import static org.junit.Assert.*;


import junit.framework.TestCase;

public class ContaTest extends TestCase {

	public void testDebitarSucesso() throws OperacaoIlegalException{
		Conta c = new Conta("123", 20);
		c.debitar(10);
		assertEquals(10,c.getSaldo(),0.0);
	} 
}
