package main.parametrizadoTest;

public class Aposentadoria implements AposentadoriaInterface {
	
	protected static final String TRABALHO_INFANTIL = "Trabalho infantil n�o contabiliza para tempo de contribui��o.";
	protected static final String MATOSALEM = "Idade superior ao m�ximo da humanidade.";
	protected static final String NEGATIVO = "Valores de idade/tempo de contribui��o negativos, como assim?";
	protected static final String VIDAS_PASSADAS = "Tempo de Contibui��o n�o considera vidas passadas.";
	
	
	/* (non-Javadoc)
	 * @see main.parametrizadoTest.AposentadoriaInterface#deveSeAposentar(int, int)
	 */
	@Override
	public String deveSeAposentar (int idade, int tempoContribuicao) throws BusinessException {
		
		
		if(idade<0 || tempoContribuicao <0) {
			throw new BusinessException(Aposentadoria.NEGATIVO);
		}
		
		if(idade > 125) {
			throw new BusinessException(Aposentadoria.MATOSALEM);
		}
		
		if(tempoContribuicao > idade) {
			throw new BusinessException(Aposentadoria.VIDAS_PASSADAS);
		}
		
		if(tempoContribuicao > idade-16) {
			throw new BusinessException(Aposentadoria.TRABALHO_INFANTIL);
		}
		
	
		
		if(idade < 60 || tempoContribuicao < 20) {
			return "nao aposenta";
		}
		
		
		if (tempoContribuicao >=30 ) {
			return "integral";
		}
		else {
			return "parcial";
		}
	}

}
