package app;

import apis.GrafoTDA;
import implementacion.dinamica.GrafoDinamico;
import util.GrafoUtil;

public class GrafoApp {
	public static void main(String[] args) {
		GrafoUtil util = new GrafoUtil();
		GrafoTDA grafo = new GrafoDinamico();
		//GrafoTDA grafo = new GrafoEstatico();

		grafo.inicializarGrafo();
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(7);
		
		grafo.agregarArista(1, 3, 5);
		grafo.agregarArista(2, 4, 8);
		grafo.agregarArista(3, 7, 5);
		grafo.agregarArista(3, 2, 15);
		grafo.agregarArista(3, 4, 25);
		grafo.agregarArista(4, 2, 8);
		grafo.agregarArista(7, 4, 8);
		/*
		 * 
		 * Dado un Grafo G y un vértice v, calcular el conjunto de vértices AdyacentesDobles de v.
			Se define que un vértice w es adyacente doble de un vértice v, si existe otro vértice x y hay
			una arista que comienza en v y termina en x y otra que comienza en x y termina en w.	
		 * 
		 */
		//util.doblementeAdyacente(grafo,3);
		
		
		/**
		 * Dado un vértice v de un grafo, calcular el mayor de los costos de las aristas salientes.
		 */
		
//		int valor = util.mayorCostoAristaSaliente(grafo,3);
//		System.out.println(valor);
//	
		
		//mostrar nodos ordenados del grafo
		//util.listarNodosOrdenados(grafo);
		
		util.mostrarMateriasGrafo(grafo);
	}
	
	
	//mostrarGrafo
	
}
