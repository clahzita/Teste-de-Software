import junit.framework.TestCase;

/*
 * Adaptado de:  James W. Grenning
 * For use by attendees of James training or conference sessions
 * 
 */

/*
 * ATIVIDADE TDD
 *
 * O proposito desta segunda atividade eh simular a experiencia 
 * de vc estar desenvolvendo em TDD junto com um programador experiente.
 
 *
 * Antes de iniciar nos pensamos em uma lista inicial de testes.
 * Segue a lista que nos pensamos (lembrando que esta lista nao estah completa):
 * - Estah vazia apos criacao
 * - Nao esta cheia apos criacao
 * - Nao esta vazia apos a inclusao de um elemento
 * - Esta vazia apos remocao do ultimo elemento
 * - Colocar e remover um elemento
 * - Definir a capacidade
 * - Checar se esta totamente cheia (sem ter dado o 'giro' na fila circular) 
 * - Checar se esta totamente cheia (sem ter dado o 'giro' na fila circular) 
 * - Tentar remover de uma lista vazia
 * - Tentar incluir em uma lista cheia
 *
 * O perocesso eh:
 * - escrever um teste de unidade que falha
 * - fazer o codigo compilar (deixe o Eclipse lhe ajudar)
 * - rodar o teste e ver ele falhar
 * - adicionar a quantidade minima de codigo para o teste passar
 *
 * Ter o feeeling de que em TDD vc desenvolve um teste de cada vez
 * desta forma:
 *
 *   Descomente um teste por vez usando press CTRL-/
 *   
 *   Estude o teste, tenha certeza que vc entendeu o que o teste
 *   procura avaliar.  Leia o nome do teste.  Voc6e está fazendo pair programming comigo
 *   Eu apenas escrevi o teste, você precisa fazer o teste passar.
 * 
 *   A cada vez que você descomenta o teste, siga CUIDADOSAMENTE este processo:
 *   1) Faça o teste compilar. O Eclipse lhe ajuda muito neste passo
 *   	CTRL-1 lhe mostra algumas sugestoes.
 *   2) Escreva uma implementacao triviar e veja o codigo falhar.
 *   3) Finalmente adicione a quantidade minima de codigo necessaria para o teste passar.
 *   Algumas vezes isto significa HARD CODING (retornar um valar na marra :-))
 *   Nao permita que o seu código esteja mais avancado que os testes.
 *   4) Agora va para o proximo teste.
 *
 * Por favor leia as instrucoes na medida em que vc implementa.
 * Entre em contato comigo (roberta@dimap.ufrn.br) caso vc nao tenha entendido algum passo.
 * Lembre: estamos fazendo pair programming.
 */


public class CircularBufferTest extends TestCase {

	CircularBuffer buffer;
	
	/*
	 * Roda antes de cada teste
	 */

	protected void setUp() throws Exception {
		buffer = new CircularBuffer();
	}
	
	/*
	 * Os metodos de testes devem ser: 
	 * 1) public 
	 * 2) void 
	 * 3) Ter um nome significativo
	 */
	

//	public void testShouldBeEmptyAfterCreate() {
//		assertTrue(buffer.isEmpty());
//	}

//	public void testNotFullAfterCreation()
//	{
//		assertTrue(!buffer.isFull());
//	}

//	public void testNotEmptyAfterput()
//	{
//		buffer.put(10046);
//		assertTrue(!buffer.isEmpty());
//	}

//	public void testNotEmptyThenEmpty()
//	{
//		buffer.put(4567);
//		assertTrue(!buffer.isEmpty());
//		buffer.get();
//		assertTrue(buffer.isEmpty());
//	}

//	public void testGetPutOneValue()
//	{
//		buffer.put(4567);
//		assertEquals(4567, buffer.get());
//	}

	/*
	 * Para fazer os testes anteiores passarem voce nao precisaria de um array de inteiros.
	 * Os seus testes nao precisavam dele. Voce so precisaria de um contator que guardasse 
	 * quantos inteirios tinham sido inseridos do BUFFER, e um retorno HARD CODED para o get().
	 * 
	 * Se voce implementou mais que isso DELETE AGORA! Pois este codigo A MAIS nao eh CODIGO TESTADO.
	 * LEMBRE-SE em TDD toda linha implementada deve ser testada!
	 * 
	 * Para os proximos testes voce precisara de um ARRAY.
	 * 
	 */
	
//	public void testGetPutAFew()
//	{
//		buffer.put(1);
//		buffer.put(2);
//		buffer.put(3);
//		assertEquals(1, buffer.get());
//		assertEquals(2, buffer.get());
//		assertEquals(3, buffer.get());
//	}

	/*
	 * O teste anterior lhe levou a incluir um array de tamanho fixo.
	 * com um indice e um out_indice. Voce ainda nao precisou
	 *  implementar a logica de um buffer circular ate aqui.
	 * Por que? Simplemente porque os testes nao lhe exigiram isso.
	 */

//	public void testCapacity()
//	{
//		CircularBuffer buffer = new CircularBuffer(2);
//		assertEquals(2, buffer.capacity());
//	}

	/*
	 * Voce criou um buffer interno com new. Essa eh uma boa oportunidade de fazer isso
	 * 
	 * Voce adicionou um segundo construtor? Ou voce mudou o construtor default para um 
	 * parametrizado? Ou recomendo a segunda opcao. Pois no momento da criacao devemos 
	 * saber o tamanho do buffer.
	 * 
	 */

//	public void testIsFull()
//	{
//		for (int i = 0; i < buffer.capacity(); i++)
//			buffer.put(i + 100);
//
//		assertTrue(buffer.isFull());
//	}
	
	/*
	 * Voce incluiu um ARRAY de interios HARD CODED no seu codigo,
	 * e os testes anteriores passaram. Voce ainda nao implementou a logica 'que da a volta' na fila circular
	 * Se voce ja implementou essa logica ela nao foi testada por nenhum teste,
	 * entao voce deve DELETA-LA.
	 */

//	public void testEmptyToFullToEmpty()
//	{
//		for (int i = 0; i < buffer.capacity(); i++)
//		buffer.put(i + 100);
//
//		for (int j = 0; j < buffer.capacity(); j++)
//		{
//			assertEquals(j + 100, buffer.get());
//			assertTrue(!buffer.isFull());
//		}
//
//		assertTrue(buffer.isEmpty());
//	}

	/*
	 * O TESTE ANTERIOR PASSOU SEM VOCE ALTERAR O CODIGO?
	 * Isto pode acontecer para algumas implementacoes.
	 *
	 * Finalmente o teste que exercita o 'dar a volta' na fila circular.
	 */

//	public void testWrapAround()
//	{
//		int capacity = buffer.capacity();
//		int seed = 100;
//		
//		for (int i = 0; i < capacity; i++)
//			buffer.put(i + seed);
//
//		assertEquals(seed, buffer.get());
//		buffer.put(1000);
//		assertTrue(buffer.isFull());
//
//		for (int i = 1; i < capacity; i++)
//			assertEquals(i + seed, buffer.get());
//
//		assertEquals(1000, buffer.get());
//		assertTrue(buffer.isEmpty());
//	}

	/*
	 *  Ao chegar aqui voce ja deve estar chamar o metodo fill em loops (for)
	 *  para preencher o buffer. Que tal refatorar?
	 *  Pegue o contendo o loop para preencher o buffer e crie o metodo fillTheBuffer()
	 *  este metodo deve ser privado a classe CurcularBufferTest.
	 * Se livre da duplicacao de código na classe de testes.
	 * Lembre-se: o seu codigo de testes deve tambem adotar boas praticas,
	 * pois voce precisara dar manutencao neste codigo.
	 *
	 *  Este exemplo do fillTheBuffer coloca 5 values no buffer
	 *  usando 900 como valo:
	 *  	fillTheBuffer(900, 5);
	 *
	 *  Você pode usar esta mesma logica de refatoramento para criar outros metodos auxiliares
	 *  e evitar duplicacao no codigo.
	 *
	 *  Neste ponto voce ainda nao tem nenhum codigo que se preocupe com checar que
	 *  nao eh permitido remover elemento da fila vazia ou incluir na fila cheia. 
	 *  Pois ainda nao temos testes para isto. Estamos usando TDD lembra?
	 *
	 */
	
//	public void testPutToFullThrows()
//	{
//		fillTheBuffer(900, buffer.capacity());
//
//		try
//		{
//			buffer.put(9999);
//			fail("Put to full circularBuffer should throw");
//		}
//		catch (CircularBufferException e)
//		{
//			String expected = "Put to full circular buffer";
//			assertEquals(expected, e.getMessage());
//		}
//	}

//	public void testPutToFullDoesNotDamageContents()
//	{
//		fillTheBuffer(900, buffer.capacity());
//
//		try
//		{
//			buffer.put(9999);
//		}
//		catch (CircularBufferException e)
//		{
//		}
//
//		drainAndCheck(900, buffer.capacity());
//
//		assertTrue(buffer.isEmpty());
//	}

	/*
	 * Veja se mais algum retatoramento eh necessario
	 *
	 */

//	public void testGetFromEmptyThrows()
//	{
//		try
//		{
//			buffer.get();
//			fail("Get from empty should throw");
//		}
//		catch (CircularBufferException e)
//		{
//			String expected = "Get from empty circular buffer";
//			assertEquals(expected, e.getMessage());
//			assertTrue(buffer.isEmpty());
//		}
//	}

	/*
	 * Voce acha que esta lista de testes é suficiente para implementarmos uma fila circular?
	 * Implemente  um teste que avalia uma caracteristica que a fila circular deve ter que os testes
	 * acima não exercitam.
	 * 
	 */

}
