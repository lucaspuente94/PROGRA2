package app;

import util.ColaUtil;
import implementacion.estatica.Cola;
import apis.ColaTDA;

public class ColaApp {

	public static void main(String[] args) {
		ColaTDA c1 = new Cola();
		ColaTDA c2 = new Cola();
		ColaUtil colaUtil = new ColaUtil();

		c1.incializarCola();
		c2.incializarCola();
		
		//lleno la cola
		c1 = colaUtil.generarCola(c1,6);
//		
//		System.out.println("///////////////////////////////////////////");
//		//ejercicio a pasar cola a otra. 
//		colaUtil.pasarAcola(c1,c2);
//	
//		
//		System.out.println("///////////////////////////////////////////");
//		//ejercicio b y c pasar cola a otra. 
//		colaUtil.invertirCola(colaUtil.generarCola(c1,6));
		
		System.out.println("///////////////////////////////////////////");
		//ejercicio b y c pasar cola a otra. 
		colaUtil.invertirColaSinPila(colaUtil.generarCola(c1, 10));
		
//		
//		System.out.println("///////////////////////////////////////////");
//		//ejercicio d  
//		
//		if(colaUtil.compararFinalCola(colaUtil.generarCola(c1,6),colaUtil.generarCola(c2,6))){
//			System.out.println("el resultado de la ultima posicion de la cola son iguales ");
//		}else{
//			System.out.println("el resultado de la ultima posicion de la cola no son iguales ");
//		}

//		System.out.println("///////////////////////////////////////////");
//		//ejercicio de cola capicula  
//		if(colaUtil.colaCapicuca(colaUtil.generarCola(c1,6))){
//			System.out.println("son capiacua ");
//		}else{
//			System.out.println("no son capicua ");
//		}
		
		
//		System.out.println("////////////////////////////VEEER///////////////");
//		//ejercicio de f  
//		colaUtil.invertirCola(colaUtil.generarCola(c1,6));
//		//error cuando compara las colas, siempre da 5 cuando desacola
//		if(colaUtil.compararColasInversa(c1,colaUtil.generarCola(c2,6))){
//			System.out.println("son iguales");
//		}else{
//			System.out.println("no son iguales");
//		}
		
		
		colaUtil.partirCola(colaUtil.generarCola(c1,10));
	
		
	}

}
