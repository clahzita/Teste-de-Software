package main.parametrizadoTest;

public class Aposentadoria implements AposentadoriaInterface {
	
	final String TRABALHO_INFANTIL = "TRABALHO INFANTIL NÃO CONTABILIZA TEMPO DE CONTRIBUIÇÃO.";
	final String MATOSALEM = "IDADE SUPERIOR AO MÁXIMO DA HUMANIDADE.";
	final String NEGATIVO = "VALORES NEGATIVOS NÃO SÃO ACEITOS.";
	
	
	/* (non-Javadoc)
	 * @see main.parametrizadoTest.AposentadoriaInterface#deveSeAposentar(int, int)
	 */
	@Override
	public String deveSeAposentar (int idade, int tempoContribuicao) throws BusinessException {
		
		
		if(idade<0 || tempoContribuicao <0) {
			throw new BusinessException(this.NEGATIVO);
		}
		
		if(idade >=130) {
			throw new BusinessException(this.MATOSALEM);
		}
		
		if(tempoContribuicao > idade-16) {
			throw new BusinessException(this.TRABALHO_INFANTIL);
		}
		
		
		if(idade < 60 || tempoContribuicao <20) {
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
