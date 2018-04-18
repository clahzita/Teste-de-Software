import exception.NumeroFilhosInvalidoException;
import exception.ValorInvalidoException;

public class Pagamento {
	
	public double calculaMensalidade (int num_filhos, double valor_mensalidade_individual) throws NumeroFilhosInvalidoException, ValorInvalidoException {
		if(num_filhos >= 0) {
			throw new NumeroFilhosInvalidoException();
		}
		if(valor_mensalidade_individual < 0.0) {
			throw new ValorInvalidoException();
		}
		double total = num_filhos * valor_mensalidade_individual;
		
		return (num_filhos >=3) ? (total/2) : total;
		
	}
}
