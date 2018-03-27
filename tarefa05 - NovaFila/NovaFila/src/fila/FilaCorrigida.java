package fila;

public class FilaCorrigida implements IFila {
	
	private static final int capacidade = 5;
	private Object[] FilaCorrigida;  //Array que representa a fila
	private final int tam; // tamanho atual da fila
	private int fim = 0; //final da fila - modificada para 0
	
	public FilaCorrigida() {
		this(capacidade);
	}
	
	public FilaCorrigida(int capacidade) {
		this.tam = capacidade;
		FilaCorrigida = new Object[tam];
	}
	
	public int getFim() {
		return fim;
	}

	public void setFim(int fim) {
		this.fim = fim;
	}

	public int getTam() {
		return tam;
	}

	public void limpaFila(){
		for(int i=0; i < tam; i++)
			FilaCorrigida[i] = null;
		fim=0;
	}
	
	@Override
	public int tamanho() {
		return fim;
	}

	@Override
	public boolean estaVazia() {
		return (fim == 0) ? true : false;
	}

	@Override
	public boolean estaCheia() {
		return (fim == tam) ? true : false;
	}

	@Override
	public void insereNaFila(Object obj) throws FilaCheiaException {
		if(!this.estaCheia()) {
			FilaCorrigida[fim] = obj;
			fim++;
		}else {
			throw new FilaCheiaException();
		}
			
	}

	@Override
	public Object removeDaFila() throws FilaVaziaException {
		if(!this.estaVazia()) {
			Object item = FilaCorrigida[0];
			for(int k = 1; k < fim; k++)
				FilaCorrigida[k-1] = FilaCorrigida[k];
			fim--;
			return item;
		} else {
			throw new FilaVaziaException();
		}
		
		
	}
	
	

}
