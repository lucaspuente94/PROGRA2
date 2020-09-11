package util;

import implementacion.estatica.Cola;
import implementacion.estatica.Conjuntos;
import implementacion.estatica.Pila;
import apis.ColaTDA;
import apis.ConjuntoTDA;
import apis.PilaTDA;

public class ColaUtil {

	public ColaTDA generarCola(ColaTDA cola, int cantidad) {
		System.out.println("Cola Original");
		for (int i = 0; i < cantidad; i++) {
			cola.acolar(i);
			System.out.println("Se acolo : "+i);
		}
		return cola;
	}

	public void pasarAcola(ColaTDA c1, ColaTDA c2) {
		//utilizo una pila para no invertir el valor al copiar la cola
		PilaTDA pilaAux = new Pila();
		pilaAux.inicializarPila();
		System.out.println("entro al metodo pasar a cola :");
		
		while(!c1.colaVacia()){
			pilaAux.apilar(c1.tope());
			c1.desacolar();
		}
		while(!pilaAux.pilaVacia()){
			c2.acolar(pilaAux.tope());
			System.out.println("cola nueva : "+pilaAux.tope());
			pilaAux.desapilar();
		}
	}

	public void invertirCola(ColaTDA c1) {
		System.out.println("entro al metodo invertir cola :");
		ColaTDA colaAux = new Cola();
		colaAux.incializarCola();
		
		while(!c1.colaVacia()){
			colaAux.acolar(c1.tope());
			c1.desacolar();
		}
		
		while(!colaAux.colaVacia()){
			c1.acolar(colaAux.tope());
			System.out.println("cola invertida : "+colaAux.tope());
			colaAux.desacolar();
		}
	}

	public boolean compararFinalCola(ColaTDA c1, ColaTDA c2) {
		System.out.println("entro al metodo de comparar resultado cola :");
		int resultadoC1 = 0;
		int resultadoC2 = 0;
		
		while(!c1.colaVacia()){
			//le sumo el 2 al valor de la cola para corroborar que la ultima posicion no son iguales
			resultadoC1 = c1.tope()+2;
			System.out.println(resultadoC1);
			c1.desacolar();
		}
		while(!c2.colaVacia()){
			resultadoC2 = c2.tope();
			System.out.println(resultadoC2);
			c2.desacolar();
		}

		if(resultadoC1 == resultadoC2){
			return true;
		}else{
			return false;
		}
	}

	public boolean colaCapicuca(ColaTDA c1) {
		System.out.println("entro al metodo capicua :");
		ColaTDA colaAux = new Cola();
		colaAux.incializarCola();
		//guardo la cola c1 en la aux para poder compararla despues
		colaAux=c1;
		//invierto la cola aux1 para ver si es capicua
		invertirCola(c1);
		
		//se asume que la cantidad de elementos de la cola es par
		while(!c1.colaVacia() && !colaAux.colaVacia()){
			if(c1.tope() != colaAux.tope()){
				return false;
			}
			c1.desacolar();
			colaAux.desacolar();
		}
		return true;
	}

	public boolean compararColasInversa(ColaTDA c1, ColaTDA c2) {
		while(!c1.colaVacia() && !c2.colaVacia()){
			if(c1.tope() != c2.tope()){
				return false;
			}
			c1.desacolar();
			c2.desacolar();
		}
		return true;
	}

	public void invertirColaSinPila(ColaTDA c1) {
		int []vec =new int[100];
		int i=0;
		while(!c1.colaVacia()){
			vec[i]=c1.tope();
			c1.desacolar();
			i++;
		}
		for (int j=i-1; j >=0; j--) {
			System.out.println("cola invertida");
			c1.acolar(vec[j]);
			System.out.println(vec[j]);
		}
	}

	public void partirCola(ColaTDA c) {
		ConjuntoTDA conjunto = new Conjuntos();
		conjunto.inicializarConjunto();
		ColaTDA c2 = new Cola();
		c2.incializarCola();
		ColaTDA c3 = new Cola();
		c3.incializarCola();
		int i = 0;
		while(!c.colaVacia()){
			int tope = c.tope();
			if(!conjunto.pertenece(tope)){
				c2.acolar(tope);
				conjunto.agregar(tope);
				i++;
			}
			c.desacolar();
		}
		int j = 0;
		int resultado = i/2;
		while(c2.colaVacia()){
			if(j<resultado){
				c.acolar(c2.tope());
			}else{
				c3.acolar(c2.tope());
			}
			c2.desacolar();
		}
	}
}
