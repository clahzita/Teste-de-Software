package fila;

public class FilaBug implements IFila {

	private static final int capacidade = 5;
	private Object[] FilaBug;  //Array que representa a fila
	private final int tam; // tamanho atual da fila
	private int fim = 0; //final da fila - modificada para 0
	
	public FilaBug() {
		this(capacidade);
	}
	
	public FilaBug(int capacidade) {
		this.tam = capacidade;
		FilaBug = new Object[tam];
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
			FilaBug[i] = null;
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
			FilaBug[fim] = obj;
			fim++;
		}else {
			throw new FilaCheiaException();
		}
			
	}

	@Override
	public Object removeDaFila() throws FilaVaziaException {
		if(!this.estaVazia()) {
			Object item = FilaBug[fim-1];
			fim--;
			return item;
		} else {
			throw new FilaVaziaException();
		}
	}

}
