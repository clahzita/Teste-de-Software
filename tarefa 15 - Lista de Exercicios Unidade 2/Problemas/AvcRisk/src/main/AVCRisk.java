/**
 * 
 */
package main;

import main.exception.InvalidArgumentException;

/**
 * @author clah
 *
 */
public class AVCRisk {

	/*
	O método retorna o risco do usuário do relógio desenvolver um AVC:
	- Retorna FALSE se: temperatura <= 39 || card <=118
	- Retorna TRUE se: temperatura > 39 && card > 118
	Caso os sensores apresentam algum problema eles podem enviar um dado NEGATIVO este método
	lança a exceção checada chamada InvalidArgumentException.
	*/
	public boolean checkRisk (double temp, int card) throws InvalidArgumentException {
		
		if(temp < 0.0 || card < 0) {
			throw new InvalidArgumentException();
		}
		
		if(temp > 39.0 && card > 118) {
			return true;
		}
		return false;
	}
	
}
