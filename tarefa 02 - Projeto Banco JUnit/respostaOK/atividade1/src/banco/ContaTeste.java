package banco;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContaTeste {
	private Conta c1;
	private Conta c2;


	@Before
	public void setUp() throws Exception {
		c1 = new Conta("123", 500.00);
		c2 = new Conta("321", 100.00);
		
	}
	
	@Test
	public void saqueDeveSerRealizadoComSucesso() throws OperacaoIlegalException {
		c1.debitar(150.0);
		
		assertEquals(c1.getSaldo(), 350.0, 0.0);
		
	}

	@Test
	public void saqueNaoDeveSerRealizado() {
		try {
			c1.debitar(600.00);
			fail("Não há saldo suficiente!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test
	public void depositoDeveSerRealizadoComSucesso() throws OperacaoIlegalException {
		c1.creditar(150.0);
		
		assertEquals(c1.getSaldo(), 650.0, 0.0);
		
	}
	
	@Test
	public void depositoNaoDeveSerRealizado() {
		try {
			c1.creditar(-100.00);
			fail("Não é possível creditar valor negativo!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test
	public void tranferenciaDeveSerRealizadaComSucesso() throws OperacaoIlegalException {
		c1.transferir(c2, 200.00);
		assertEquals(c1.getSaldo(), 300.00, 0.0);
		assertEquals(c2.getSaldo(), 300.00, 0.0);		
		
	}
	
	@Test
	public void tranferenciaNaoDeveSerRealizada() {
		try {
			c1.transferir(c2,600.00);
			fail("Não há saldo suficiente!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

}
