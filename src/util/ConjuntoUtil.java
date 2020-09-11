package util;

import implementacion.estatica.Conjuntos;
import apis.ConjuntoTDA;

public class ConjuntoUtil {

	public void cargarConjunto(ConjuntoTDA c1) {
		System.out.println("Se genero el conjunto con : ");
		int vec[]={1,59,29,10,4,5,9,188,29};
		for (int i = 0; i < vec.length; i++) {
			c1.agregar(vec[i]);
			System.out.println(vec[i]);
		}
	}

	public void cargarConjuntoB(ConjuntoTDA c1) {
		System.out.println("Se genero el conjunto con : ");
		int vec[]={1,59,29,100,4,5};
		for (int i = 0; i < vec.length; i++) {
			c1.agregar(vec[i]);
			System.out.println(vec[i]);
		}
	}
	public void pasarAConjunto(ConjuntoTDA c1, ConjuntoTDA c2) {
		System.out.println("Datos del segundo conjunto : ");
		int a;
		while(!c1.conjuntoVacio()){
			a = c1.elegir();
			c2.agregar(a);
			System.out.println(c1.elegir());
			c1.sacar(a);
		}
	}

	public boolean compararConjuntos(ConjuntoTDA c1, ConjuntoTDA c2) {
		int i ;
		while(!c1.conjuntoVacio() && !c2.conjuntoVacio()){
			i = c2.elegir();
			if(!c1.pertenece(i)){
				return false;
			}
			c2.sacar(i);
		}
		return true;
	}

	public void unirConjuntos(ConjuntoTDA c1, ConjuntoTDA c2) {
		while(!c1.conjuntoVacio() && !c2.conjuntoVacio()){
			int tope = c2.elegir();
			if(!c1.pertenece(tope)){
				c1.agregar(tope);
			}
			c2.sacar(tope);
		}
		
		
	}

	public void interseccionConjuntos(ConjuntoTDA c1, ConjuntoTDA c2) {
		ConjuntoTDA caux = new Conjuntos();
		caux.inicializarConjunto();
		while(!c1.conjuntoVacio() && !c2.conjuntoVacio()){
			int tope = c2.elegir();
			if(c1.pertenece(tope)){
				caux.agregar(tope);
			}
			c2.sacar(tope);
		}
	}

	public void diferenciaConjuntos(ConjuntoTDA c1, ConjuntoTDA c2) {
		ConjuntoTDA caux = new Conjuntos();
		caux.inicializarConjunto();
		while(!c1.conjuntoVacio()){
				int tope = c1.elegir();
				caux.agregar(tope);
				c1.sacar(tope);
			}
		while(!c2.conjuntoVacio()){
			int tope = c2.elegir();
			if(caux.pertenece(tope)){
				caux.sacar(tope);
			}
			c2.sacar(tope);
		}		
	}
}
