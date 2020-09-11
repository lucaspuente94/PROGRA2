package app;

import implementacion.estatica.DiccionarioMultiple;
import mis.implementacionesParcial.DiccionarioMultipleValorEstaticoClaveDinamica;
import apis.DiccionarioMultipleTDA;

public class DisccionarioMultipleApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DiccionarioMultipleTDA d = new DiccionarioMultiple();
		d.inicializarDiccionarioMultiple();
		d.agregar(1, 10);
		d.agregar(1, 11);
		d.agregar(1, 11);
		d.agregar(1, 12);
		
		d.agregar(2, 10);
		d.agregar(2, 11);
		d.agregar(2, 9);
		d.agregar(2, 12);
		
		DiccionarioMultipleTDA de = new DiccionarioMultipleValorEstaticoClaveDinamica();
		de.inicializarDiccionarioMultiple();
		de.agregar(1, 10);
		de.agregar(1, 11);
		de.agregar(1, 11);
		de.agregar(1, 12);
		
		de.agregar(2, 10);
		de.agregar(2, 11);
		de.agregar(2, 9);
		de.agregar(2, 12);
	}

}
