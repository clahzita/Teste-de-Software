import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {
	private int saldoInicial = 0;
	private int saldoAtualizado = 0;
	private String correntista;
	private List<Deposito> depositos = new ArrayList<Deposito>();

	public ContaCorrente() {
	}

	public ContaCorrente(int saldoInicial) {
		this.saldoInicial = saldoInicial;
		this.saldoAtualizado = saldoInicial;

	}

	public ContaCorrente(String correntista) {
		this.correntista = correntista;
	}

	public ContaCorrente(String nome, int saldoInicial) {
		this.correntista = nome;
		this.saldoInicial = saldoInicial;
		this.saldoAtualizado = saldoInicial;
	}

	public int saldo() {
		return saldoAtualizado;
	}

	public void creditar(Deposito deposito) {
		depositos.add(deposito);
		this.saldoAtualizado += deposito.valor();
		
	}

	public String extrato() {
		if(this.correntista == null){
			this.correntista = "James Grenning";
		}
		
		String extrato ="Conta de "+ this.correntista + "\n" +
						"Saldo Inicial $" + this.saldoInicial + "\n" +
						"Saldo Final $" + this.saldoAtualizado + "\n";
		
		if(depositos.size()==0){
			extrato+= "Nenhuma trasacao realizada\n";
		}else{
			for (Deposito deposito : depositos) {
				extrato+= deposito.data()+"\tDeposito\t$"+deposito.valor()+"\n";
			}
			
		}
						
		return extrato;
	}


}
