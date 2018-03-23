package fila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FilaTest {
	private Fila fila1;
	private Fila fila2;
	
	@Before
	public void setUp() throws Exception {
		fila1 = new Fila();
		fila2 = new Fila(1);
		
	}
	
	//atributo fim está informando o ultimo indice 
	@Test
	public void testTamanho() {
		
		int a = 1;
		fila1.insereNaFila(a);
		//devereria ser tamanho 1, mas retorna sucesso com 0
		assertEquals(1,fila1.tamanho());
	}
	/**
	 * Testa se uma classe que foi instanciada está vazia.
	 */
	@Test
	public void testEstaVaziaSucesso1() {
		//passou
		assertTrue(fila1.estaVazia());
	}
	
	/**
	 * Testa se uma fila que foi inserido um elemento e logo em seguida removido está vazia.
	 */
	@Test
	public void testEstaVaziaSucesso2() {
		fila1.insereNaFila("elemento");
		fila1.removeDaFila();
		//passou
		assertTrue(fila1.estaVazia());
	}
	
	/**
	 * Testa se uma fila que foi inserido um elemento e logo em seguida removido está vazia.
	 */
	@Test
	public void testEstaVaziaSucesso3() {
		fila1.insereNaFila("elemento");
		fila1.limpaFila();
		//passou
		assertTrue(fila1.estaVazia());
	}
	
	/**
	 * Testa se uma fila com um elemento retorna falso.
	 */
	@Test
	public void testEstaVaziaFalha() {
		//passou
		fila1.insereNaFila("elemento");
		assertFalse(fila1.estaVazia());
	}
	
	/**
	 * Testa se a fila está cheia.
	 */
	@Test
	public void testEstaCheiaSucesso() {
		fila2.insereNaFila("elemento 1");
		
		//teste falhou, deveria retornar verdadeiro
		assertTrue(fila2.estaCheia());
	}
	/**
	 * Insere um elemento na fila e verifica se ele está na fila
	 */
	@Test
	public void testInsereNaFilaSucesso() {
		fila1.insereNaFila("oi");
		
		
		

	}
	

}
