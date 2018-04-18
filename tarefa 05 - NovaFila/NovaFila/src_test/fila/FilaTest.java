package fila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FilaTest {
	private FilaBug fila1;
	private FilaBug fila2;
	
	@Before
	public void setUp() throws Exception {
		fila1 = new FilaBug();
		fila2 = new FilaBug(1);
		
	}
	
	//atributo fim está informando o ultimo indice 
	@Test
	public void testTamanho() {
		
		int a = 1;
		fila1.insereNaFila(a);
		//deveria ser tamanho 1, mas retorna sucesso com 0
		assertEquals(1,fila1.tamanho());
	}
	/**
	 * Testa se uma classe que foi instanciada está vazia.
	 */
	@Test
	public void testEstaVaziaSucesso1() {
		assertTrue(fila1.estaVazia()); //Sucesso
	}
	
	/**
	 * Testa se uma fila que foi inserido um elemento e logo em seguida removido está vazia.
	 */
	@Test
	public void testEstaVaziaSucesso2() {
		fila1.insereNaFila("elemento");
		fila1.removeDaFila();
		assertTrue(fila1.estaVazia()); //Sucesso
	}
	
	/**
	 * Testa se uma fila que foi inserido um elemento e logo em seguida removido está vazia.
	 */
	@Test
	public void testEstaVaziaSucesso3() {
		fila1.insereNaFila("elemento");
		fila1.limpaFila();
		
		assertTrue(fila1.estaVazia()); //Sucesso
	}
	
	/**
	 * Testa se uma fila com um elemento retorna falso.
	 */
	@Test
	public void testEstaVaziaFalha() {
		fila1.insereNaFila("elemento");
		assertFalse(fila1.estaVazia()); //Sucesso
	}
	
	/**
	 * Testa se a fila está cheia.
	 */
	@Test
	public void testEstaCheiaSucesso() {
		fila2.insereNaFila("elemento 1");
		assertTrue(fila2.estaCheia()); //falha,deveria retornar verdadeiro 
	}
	
	/**
	 * Insere um elemento na fila e verifica se ele está na fila, removendo-o
	 * e verificando se é o objeto inserido
	 */
	@Test
	public void testInsereERemoveNaFilaSucesso() {
		fila1.insereNaFila("oi");
		fila1.insereNaFila("ola");
		Object elemento1 = fila1.removeDaFila();
		assertTrue(elemento1.toString().equals("oi"));	//sucesso
	}
	
	/**
	 * Verifica se estoura a capacidade da fila
	 */
	@Test (expected=FilaCheiaException.class)
	public void testInserenaFilaCheia() {
		fila2.insereNaFila(1);
		fila2.insereNaFila(2);
		
		//Falha, não lançou exceção esperada, lançou ArrayIndexOutOfBoundException
		
	}
	
	/**
	 * Remove de uma fila vazia
	 */
	@Test (expected=FilaVaziaException.class)
	public void testRemoveDaFilaVazia() {
		Object elemento = fila1.removeDaFila(); 
		assertNull(elemento); //sucesso
	}
	
	/**
	 * Verifica se o item removido é realmente o ultimo inserido
	 */
	@Test
	public void testRemovePrimeiroElementoDaFila() {
		fila1.insereNaFila(1);
		fila1.insereNaFila(2);
		Object primeiro = fila1.removeDaFila();
		Object esperado = 1;
		//Esperado 1, mas retornou 2
		assertEquals(esperado, primeiro);
	}
	

}
