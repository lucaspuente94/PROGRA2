package app;

import implementacion.dinamica.ColaPrioridadDinamica;
import implementacion.estatica.ColaPrioridad;
import util.ColaPrioridadUtil;
import apis.ColaPrioridadTDA;

public class ColaPrioridadApp {

	public static void main(String[] args) {
		ColaPrioridadTDA c1 = new ColaPrioridadDinamica();
		ColaPrioridadTDA c2 = new ColaPrioridad();
		ColaPrioridadUtil util = new ColaPrioridadUtil();
		c1.inicializarColaPrioridad();
		c2.inicializarColaPrioridad();
		//util.generarColaPrioridad(c1);
		c1.acolarPrioridad(1, 2);
		c1.acolarPrioridad(2, 3);
		c1.acolarPrioridad(1, 10);
		
		c2.acolarPrioridad(1, 2);
		c2.acolarPrioridad(2, 3);
		c2.acolarPrioridad(1, 10);
		
		
//		for (int i = 0; i < 6; i++) {
//			c2.acolarPrioridad(i, i+2);
//		}
		
		
		while(!c1.colaVacia()){
			System.out.println("v : "+c1.primero()+ "p :"+c1.prioridad());
			c1.desacolar();
		}
		
		//Primer ejercicio
		//util.unirColasPrioridad(c1,c2);
		
		//segunro ej
//		if(util.colasIdenticas(c1,c2)){
//			System.out.println("Las colas son iguales");
//		}else{
//			System.out.println("Las colas no son iguales");
//		}
//		
	
		
	}
	
	
}
