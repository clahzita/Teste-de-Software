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
	O m�todo retorna o risco do usu�rio do rel�gio desenvolver um AVC:
	- Retorna FALSE se: temperatura <= 39 || card <=118
	- Retorna TRUE se: temperatura > 39 && card > 118
	Caso os sensores apresentam algum problema eles podem enviar um dado NEGATIVO este m�todo
	lan�a a exce��o checada chamada InvalidArgumentException.
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
