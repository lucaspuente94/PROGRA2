package app;

import apis.AbbTDA;
import apis.ColaTDA;
import apis.ConjuntoTDA;
import apis.DiccionarioSimpleTDA;
import apis.GrafoTDA;
import implementacion.dinamica.ABB;
import implementacion.dinamica.GrafoDinamico;
import implementacion.estatica.Cola;
import implementacion.estatica.Conjuntos;
import implementacion.estatica.DiccionarioSimple;
import util.ColaUtil;
import util.FinalUtil;

public class Final {

	public static void main(String[] args) {
		ColaTDA cola = new Cola();
		ColaTDA cola2 = new Cola();
		ConjuntoTDA conjunto = new Conjuntos();
		ColaTDA aux = new Cola();
		ColaUtil utilCola = new ColaUtil();
		cola2.incializarCola();
		aux.incializarCola();
		cola.incializarCola();
		cola.acolar(1);
		cola.acolar(5);
		cola.acolar(3);
		cola.acolar(3);
		cola.acolar(3);
		cola.acolar(3);
		cola.acolar(4);
		cola.acolar(20);
		cola.acolar(20);
		cola.acolar(10);
		FinalUtil utilF = new FinalUtil();
		//ordenar la cola usando cola,pila,conjunsto, o diccionaroi
		//utilF.ordenarCola(cola,cola2,aux);
		//utilF.quitarRepetidos(cola);
		
		DiccionarioSimpleTDA dicSimple = new DiccionarioSimple();
		dicSimple.inicializarDiccionarioMultiple();
		DiccionarioSimpleTDA dicSimple2 = new DiccionarioSimple();
		dicSimple2.inicializarDiccionarioMultiple();
		dicSimple.agregar(1, 2);
		dicSimple.agregar(2, 8);
		dicSimple2.agregar(1, 1);
		dicSimple2.agregar(2, 9);
		
		//utilF.juntarDiccionarios(dicSimple,dicSimple2);
		
		
		AbbTDA arbol = new ABB();
		arbol.agregar(10);
		arbol.agregar(22);
		arbol.agregar(2);
		arbol.agregar(88);
		arbol.agregar(17);
		arbol.agregar(27);
		arbol.agregar(9);	
		
		utilF.obtenerAlturaArbol(arbol,2);
		
		
		GrafoTDA grafo = new GrafoDinamico();
		grafo.inicializarGrafo();
		grafo.agregarArista(2, 2, 5);
		grafo.agregarArista(1, 2, 5);
		utilF.ordenarGrafo(grafo);
	}


}
