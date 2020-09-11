package app;

import util.ConjuntoUtil;
import implementacion.estatica.Conjuntos;
import apis.ConjuntoTDA;

public class ConjuntoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConjuntoTDA c1 = new Conjuntos();
		ConjuntoTDA c2 = new Conjuntos();
		
		ConjuntoUtil util = new ConjuntoUtil();
		
		c1.inicializarConjunto();
		c2.inicializarConjunto();
		util.cargarConjunto(c1);
		util.cargarConjuntoB(c2);
		
		//ej : L TP PARA ENTREGAR 
		//util.pasarAConjunto(c1,c2);
		
		//determinar si 2 conjuntos son iguales

//		if(util.compararConjuntos(c1,c2)){
//			System.out.println("Los conjuntos son iguales");
//		}else{
//			System.out.println("Los conjuntos no son iguales");
//		}
		
		/**
		 * CONJUNTO UNION
		 */
		//util.unirConjuntos(c1,c2);
		
		/**
		 * CONJUNTO interseccion e inclusion
		 */
		//util.interseccionConjuntos(c1,c2);
		
		/**
		 * diferencia de conjuntos
		 */
		util.diferenciaConjuntos(c1,c2);
		
		
	}

}
