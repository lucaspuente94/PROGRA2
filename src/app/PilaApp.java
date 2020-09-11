package app;

import util.PilaUtil;
import implementacion.estatica.Pila;
import apis.PilaTDA;

public class PilaApp {

	public static void main(String[] args) {
		PilaTDA p1 = new Pila();
		p1.inicializarPila();
		PilaUtil utilPila = new PilaUtil();
		p1 = utilPila.generarPilaNueva(p1);
		PilaTDA p2 = new Pila();
		p2.inicializarPila();
		
//		int cantPila = 0;
//		int sumarPila = 0;
//		
//		System.out.println("///////////////////////////////////////////");
//		//ejercicio A pasar pila de una a otra, en orden inverso. 
//		utilPila.pasarApila(p1,p2);
//		utilPila.vaciarPila(p2);
//		
//		System.out.println("///////////////////////////////////////////");
//		//ejercicio B copiar pila, dejandola en el mismo orden. 
//		p1 = utilPila.generarPilaNueva(p1);
//		utilPila.copiarPila(p1,p2);
//		
//		System.out.println("///////////////////////////////////////////");
//		//ejercicio C invertir pila
//		p1 = utilPila.generarPilaNueva(p1);
//		utilPila.invertirPila(p1);
//		utilPila.desapilarPila(p1); // desapilo la pila, para que llegue limpia al proximo metodo
//		
//		System.out.println("///////////////////////////////////////////");
//		//ejercicio D contar elementos pila
//		p1 = utilPila.generarPilaNueva(p1);
//		 cantPila = utilPila.cantidadPila(p1);
//		System.out.println("cantidad de elementos pila : " + cantPila);
//		
//		
//		System.out.println("///////////////////////////////////////////");
//		//ejercicio E sumar elementos pila
//		p1 = utilPila.generarPilaNueva(p1);
//		sumarPila = utilPila.sumarElementosPila(p1);
//		System.out.println("suma de la pila : " + sumarPila);
//		
//		System.out.println("///////////////////////////////////////////");
//		//ejercicio F promedio
//		float  promedio = (float)sumarPila / (float)cantPila;
//		System.out.println("promedio de la pila : " + promedio);
		
		
		
		//determinar si una pila pertenece a otra
	utilPila.generarPilaNuevaB(p2);
	if(utilPila.contienePila(p1,p2)){
		System.out.println("La Pila P1 contiene a P2");
	}else{
		System.out.println("La Pila P1 no contiene a P2");
	}
	
	//Determinar si una pila tiene elementos repetidos, en ese caso eliminar y dejar uno 
	utilPila.eliminarRepetidos(utilPila.generarPilaNuevaC(p1));
	}
}
