package util;

import apis.AbbTDA;
import apis.ColaPrioridadTDA;
import apis.ColaTDA;
import apis.ConjuntoTDA;
import apis.DiccionarioSimpleTDA;
import apis.GrafoTDA;
import implementacion.estatica.Cola;
import implementacion.estatica.ColaPrioridad;
import implementacion.estatica.Conjuntos;
import implementacion.estatica.DiccionarioMultiple;
import implementacion.estatica.DiccionarioSimple;

public class FinalUtil {

	public void ordenarCola(ColaTDA cola, ColaTDA cola2, ColaTDA aux) {
		int menor,valorCola;
		while(!cola.colaVacia()) {
			aux.acolar(cola.tope());
			cola2.acolar(cola.tope());
			cola.desacolar();
		}
		
		while(!cola2.colaVacia()) {
			menor = cola2.tope();
			while(!aux.colaVacia()) {
				if(menor > aux.tope()) {
					menor = aux.tope();
				}
				aux.desacolar();
			}
			copiarCola(cola2,aux,menor);
 			cola.acolar(menor);
		}
		while(!cola.colaVacia()) {
			System.out.println(cola.tope());
			cola.desacolar();
		}		
	}

	private static void copiarCola(ColaTDA cola2, ColaTDA aux, int menor) {
		ColaTDA aux2 = new Cola();
		aux2.incializarCola();
		while(!cola2.colaVacia()) {
			if(menor != cola2.tope()) {
				aux.acolar(cola2.tope());
				aux2.acolar(cola2.tope());
			}
			cola2.desacolar();
		}
		while(!aux2.colaVacia()) {
			cola2.acolar(aux2.tope());
			aux2.desacolar();
		}
		
	}

	public void quitarRepetidos(ColaTDA cola) {
		// TODO Auto-generated method stub
		ColaTDA aux = new Cola();
		aux.incializarCola();
		int valor=0;
		while(!cola.colaVacia()) {
			if(valor != cola.tope()) {
				valor = cola.tope();
				aux.acolar(cola.tope());
			}
			cola.desacolar();
			}
		while(!aux.colaVacia()) {
			System.out.println(aux.tope());
			aux.desacolar();
	}
	}

	public void juntarDiccionarios(DiccionarioSimpleTDA dicSimple, DiccionarioSimpleTDA dicSimple2) {
		// TODO Auto-generated method stub
		DiccionarioMultiple dicMultiple = new DiccionarioMultiple();
		DiccionarioSimpleTDA dicFinal = new DiccionarioSimple();
		dicFinal.inicializarDiccionarioMultiple();
		ConjuntoTDA conjunto = new Conjuntos();
		int valor,valorConjunto;
		conjunto = dicSimple.claves();
		//agrego el 1 dic
		while(!conjunto.conjuntoVacio()) {
			valorConjunto =conjunto.elegir();
			valor = dicSimple.recuperar(valorConjunto);
			conjunto.sacar(valorConjunto);
			dicMultiple.agregar(valorConjunto, valor);
		}
		//agrego el 2 dic
		conjunto = dicSimple2.claves();
		while(!conjunto.conjuntoVacio()) {
			valorConjunto =conjunto.elegir();
			valor = dicSimple.recuperar(valorConjunto);
			conjunto.sacar(valorConjunto);
			dicMultiple.agregar(valorConjunto, valor);
		}
		//meto el segundo diccionario valindado si existe
		conjunto = dicMultiple.claves();
		ConjuntoTDA conjuntoMultiple = new Conjuntos();
		while(!conjunto.conjuntoVacio()) {
			valorConjunto =conjunto.elegir();
			conjuntoMultiple = dicMultiple.recuperar(valorConjunto);
			conjunto.sacar(valorConjunto);
			dicFinal.agregar(valorConjunto, obtenerMenorConjunto(conjuntoMultiple));
		}
		
		
	}

	private int obtenerMenorConjunto(ConjuntoTDA conjuntoMultiple) {
		int valor = conjuntoMultiple.elegir();
		int valor2;
		conjuntoMultiple.sacar(valor);
		if(!conjuntoMultiple.conjuntoVacio()) {
			valor2=conjuntoMultiple.elegir();
			if(valor2 <valor) {
				return valor2;
			}else {
				return valor;
			}
		}else {
			return valor;
		}
	}

	public int obtenerAlturaArbol(AbbTDA arbol, int i) {
		// TODO Auto-generated method stub
		if(arbol.arbolVacio()) {
			if(arbol.raiz() == i) {
				return 0;
			}else if(arbol.raiz()>i) {
				return 1 + obtenerAlturaArbol(arbol.hijoizq(), i);
			}else {
				return 1 + obtenerAlturaArbol(arbol.hijoDer(), i);
			}
		}
		return 0;
	}

	public void ordenarGrafo(GrafoTDA grafo) {
		// TODO Auto-generated method stub
		ConjuntoTDA conjunto = new Conjuntos();
		ColaPrioridadTDA colaPri = new ColaPrioridad();
		int valor;
		conjunto = grafo.vertices();
		while(!conjunto.conjuntoVacio()) {
			valor = conjunto.elegir();
			colaPri.acolarPrioridad(valor,valor);
			conjunto.sacar(valor);
		}
	}
	///////////////////////////////////////////////////////////////////////////////
	//GODIO FINAL WEBCAMPUS
	//A
	/*
	 * ) Escribir un algoritmo que reciba un TDAGrafo y un ABBTDA y verifique que
para cada nodo del grafo que existe como valor en el árbol la diferencia entre el
peso de las aristas entrantes menos el peso las aristas salientes sea igual a la
sumatoria de los valores del hijo izquierdo menos la sumatoria de los valores
del hijo derecho del valor del nodo en el arbol.
	 */
	public int existeGrafoArbol(GrafoTDA grafo,AbbTDA arbol) {
		ConjuntoTDA conjunto = grafo.vertices();
		int valor,ref=0;
		while(!conjunto.conjuntoVacio()) {
			valor = conjunto.elegir();
			conjunto.sacar(valor);
			int difPesoGrafo = obtenerDiferenciaGrafo(grafo,valor);
			int difHijosArbol = obtenerDiferenciaHijosArbol(posicionarArbol(valor,arbol));
			if(difPesoGrafo == difHijosArbol) {
				ref = 1;
			}else {
				return 0;
			}
		}
		return ref;
	}
	private AbbTDA posicionarArbol(int valor, AbbTDA arbol) {
		if(!arbol.arbolVacio()) {
			if(arbol.raiz()==valor) {
				return arbol;
			}else if(arbol.raiz()<valor){
				posicionarArbol(valor, arbol.hijoDer());
			}else {
				posicionarArbol(valor, arbol.hijoizq());
			}
		}
		return null;
	}

	private int obtenerDiferenciaHijosArbol(AbbTDA arbol) {
		if(!arbol.arbolVacio()) {
			int valorIzq =  arbol.raiz()+ obtenerDiferenciaHijosArbol(arbol.hijoizq());
			int valorDer = arbol.raiz()+obtenerDiferenciaHijosArbol(arbol.hijoDer());
			return valorIzq - valorDer;
		}
		return 0;
	}

	private int obtenerDiferenciaGrafo(GrafoTDA grafo, int valor) {
		// TODO Auto-generated method stub
		ConjuntoTDA nodos = new Conjuntos();
		int valor2;
		int entrante=0,saliente=0;
		nodos = grafo.vertices();
		while(!nodos.conjuntoVacio()) {
			valor2 = nodos.elegir();
			nodos.sacar(valor);
			if(grafo.existeArista(valor, valor2)) {
				saliente = saliente +grafo.pesoArista(valor,valor2);
			}
			if(grafo.existeArista(valor2, valor)) {
				entrante = entrante +grafo.pesoArista(valor2,valor);
			}
		}
		return 0;
	}
	/////////////////////////////////////////////////////////////////////////////////77
	/*
	 * el B DEL PUNTO 3
	 * 
	 * Escribir un algoritmo que reciba un ABBTDA y un TDAColaPrioridad y que
		devuelva un TDAConjunto que contenga los valores del árbol que existen
		como valores de la cola con prioridad y donde la cantidad de descendientes
		menos la cantidad de sus ascendientes sea igual a la prioridad.
	 */
		//main
	private ConjuntoTDA puntoB(AbbTDA arbol, ColaPrioridadTDA cola) {
		ConjuntoTDA conjunto = new Conjuntos();
		AbbTDA arbolAux = arbol;
		while(cola.colaVacia()) {
			//valido en las 2 funciones las condiciones del ej
			if(existeValorArbol(arbolAux,cola.primero()) && prioridadEnArbol(arbolAux,cola.prioridad(),cola.primero())) {
				conjunto.agregar(cola.primero());
			}
			cola.desacolar();
		}
		return conjunto;
	}
	//me fijo si la prioridad de la cola es igual a los ascendientes y descendientes del arbol
	private boolean prioridadEnArbol(AbbTDA arbolAux, int prioridad,int valor) {
		// TODO Auto-generated method stub
		int ascendientes = obtenerAscendientes(arbolAux,valor);
		int descendientes = obtenerDescendientes(arbolAux,valor);
		if(descendientes - ascendientes == prioridad) {
			return true;
		}
		return false;
	}
	private int obtenerDescendientes(AbbTDA arbolAux, int valor) {
		if(!arbolAux.arbolVacio()) {
			if(arbolAux.raiz() == valor) {
				//busco posicionarme en el valor pasado por parametro, y despues cuento las posiciones para abajo
				return devolverValoresDescendientes(arbolAux);
			}else {
				if(arbolAux.raiz()>valor) {
					return obtenerAscendientes(arbolAux.hijoizq(), valor);
				}else {
					return obtenerAscendientes(arbolAux.hijoDer(), valor);
				}
			}
		}
		return 0;
	}
	//aca devuelvo todos los descendientes
	private int devolverValoresDescendientes(AbbTDA arbolAux) {
		if(!arbolAux.arbolVacio()) {
			return 1 + devolverValoresDescendientes(arbolAux.hijoDer()) + devolverValoresDescendientes(arbolAux.hijoizq());
		}
		return 0;
	}
	//obtengo los ascendientes de la raiz hasta el valor pasado por paraemtro
	private int obtenerAscendientes(AbbTDA arbolAux, int valor) {
		if(!arbolAux.arbolVacio()) {
			if(arbolAux.raiz() == valor) {
				return 0;
			}else {
				if(arbolAux.raiz()>valor) {
					return 1 + obtenerAscendientes(arbolAux.hijoizq(), valor);
				}else {
					return 1 + obtenerAscendientes(arbolAux.hijoDer(), valor);
				}
			}
		}
		return 0;
	}

	//me fijo si existe el arbol
	private boolean existeValorArbol(AbbTDA arbolAux, int primero) {
		if(!arbolAux.arbolVacio()) {
			if(arbolAux.raiz() == primero) {
				return true;
			}else if(primero >arbolAux.raiz()) {
				existeValorArbol(arbolAux.hijoDer(), primero);
			}else{
				existeValorArbol(arbolAux.hijoizq(), primero);
			}
		}
		return false;
	}
}

