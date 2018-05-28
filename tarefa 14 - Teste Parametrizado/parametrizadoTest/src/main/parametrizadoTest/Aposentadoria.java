package main.parametrizadoTest;

public class Aposentadoria {
	
	
	public String deveSeAposentar (int idade, int tempoContribuicao){
		
		
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
