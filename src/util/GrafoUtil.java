package util;

import implementacion.estatica.Cola;
import implementacion.estatica.ColaPrioridad;
import implementacion.estatica.Conjuntos;
import implementacion.estatica.DiccionarioSimple;
import implementacion.estatica.Pila;
import apis.ColaPrioridadTDA;
import apis.ConjuntoTDA;
import apis.DiccionarioSimpleTDA;
import apis.GrafoTDA;
import apis.PilaTDA;

public class GrafoUtil {

	public DiccionarioSimpleTDA aristasSalientesPorNodo(GrafoTDA grafo) {
		DiccionarioSimpleTDA resultado = new DiccionarioSimple();
		ConjuntoTDA vertices = grafo.vertices();
		ConjuntoTDA bkpVertices;
		int unVertice, otroVertice;
		while (!vertices.conjuntoVacio()) {
			bkpVertices = grafo.vertices();
			unVertice = vertices.elegir();
			resultado.agregar(unVertice, 0);
			while (!bkpVertices.conjuntoVacio()) {
				otroVertice = bkpVertices.elegir();
				if (grafo.existeArista(unVertice, otroVertice))
					resultado.agregar(unVertice,
							resultado.recuperar(unVertice) + 1);
				bkpVertices.sacar(otroVertice);
			}
			vertices.sacar(unVertice);
		}
		return resultado;
	}

	public DiccionarioSimpleTDA aristasEntrantesPorNodo(GrafoTDA grafo) {
		DiccionarioSimpleTDA resultado = new DiccionarioSimple();
		ConjuntoTDA vertices = grafo.vertices();
		ConjuntoTDA bkpVertices;
		int unVertice, otroVertice;
		while (!vertices.conjuntoVacio()) {
			bkpVertices = grafo.vertices();
			unVertice = vertices.elegir();
			resultado.agregar(unVertice, 0);
			while (!bkpVertices.conjuntoVacio()) {
				otroVertice = bkpVertices.elegir();
				if (grafo.existeArista(otroVertice, unVertice))
					resultado.agregar(unVertice,
							resultado.recuperar(unVertice) + 1);
				bkpVertices.sacar(otroVertice);
			}
			vertices.sacar(unVertice);
		}
		return resultado;
	}

	public ConjuntoTDA verticesAdyacentes(GrafoTDA grafo, int unVertice) {
		ConjuntoTDA vertices = grafo.vertices();
		ConjuntoTDA resultado = new Conjuntos();
		resultado.inicializarConjunto();
		int otroVertice;
		if (vertices.pertenece(unVertice)) {
			while (!vertices.conjuntoVacio()) {
				otroVertice = vertices.elegir();
				if (grafo.existeArista(unVertice, otroVertice)
						|| grafo.existeArista(otroVertice, unVertice))
					resultado.agregar(otroVertice);
				vertices.sacar(otroVertice);
			}
		}
		return resultado;
	}

	public int porcentajeNodosAislados(GrafoTDA grafo) {
		int cantidadTotal = 0, cantidadAislados = 0;
		int unVertice, otroVertice;
		ConjuntoTDA vertices = grafo.vertices();
		ConjuntoTDA bkpVertices;
		while (!vertices.conjuntoVacio()) {
			unVertice = vertices.elegir();
			bkpVertices = grafo.vertices();
			while (!bkpVertices.conjuntoVacio()) {
				otroVertice = bkpVertices.elegir();
				if (!grafo.existeArista(unVertice, otroVertice)
						&& !grafo.existeArista(otroVertice, unVertice))
					cantidadAislados += 1;
				bkpVertices.sacar(otroVertice);
			}
			cantidadTotal += 1;
			vertices.sacar(unVertice);
		}
		return (cantidadAislados / cantidadTotal) * 100;
	}

	public int aristasSalientesPorVertice(GrafoTDA grafo, int vertice) {
		int resultado = 0;
		ConjuntoTDA vertices = grafo.vertices();
		int otroVertice;
		if (vertices.pertenece(vertice)) {
			while (!vertices.conjuntoVacio()) {
				otroVertice = vertices.elegir();
				if (grafo.existeArista(vertice, otroVertice))
					resultado++;
				vertices.sacar(otroVertice);
			}
		}
		return resultado;
	}

	public void mostrarMateriasGrafo(GrafoTDA grafo) {
		int verticeOrigen, verticeDestino;
		ConjuntoTDA vert = grafo.vertices();
		ConjuntoTDA dest;
		while (!vert.conjuntoVacio()) {
			verticeOrigen = vert.elegir();
			vert.sacar(verticeOrigen);

			System.out.println("Vertice : " + verticeOrigen);
			dest = grafo.vertices();
			while (!dest.conjuntoVacio()) {
				verticeDestino = dest.elegir();
				dest.sacar(verticeDestino);
				if (grafo.existeArista(verticeOrigen, verticeDestino))
					System.out.println(" Vert dest " + verticeDestino
							+ ". Peso: "
							+ grafo.pesoArista(verticeOrigen, verticeDestino));
			}
		}
	}

	public int aristasEntrantesPorVertice(GrafoTDA grafo, int vertice) {
		int resultado = 0;
		ConjuntoTDA vertices = grafo.vertices();
		int otroVertice;
		if (vertices.pertenece(vertice)) {
			while (!vertices.conjuntoVacio()) {
				otroVertice = vertices.elegir();
				if (grafo.existeArista(otroVertice, vertice))
					resultado++;
				vertices.sacar(otroVertice);
			}
		}
		System.out.println(resultado);
		return resultado;
	}
	
	
	/**
	 * 
	 * @param grafo 
	 * @param v
	 * @return
	 */
	public int aristasEntrantesPorVerticeValor(GrafoTDA grafo, int vertice) {
		int resultado = 0;
		ConjuntoTDA vertices = grafo.vertices();
		int otroVertice;
		if (vertices.pertenece(vertice)) {
			while (!vertices.conjuntoVacio()) {
				otroVertice = vertices.elegir();
				if (grafo.existeArista(otroVertice, vertice))
					return grafo.pesoArista(otroVertice,vertice);
				vertices.sacar(otroVertice);
			}
		}
		return resultado;
	}
	/**
	 * 
	 * @param grafo
	 * @param vertice
	 * @return
	 */
	public int aristasSalientesPorVerticeValor(GrafoTDA grafo, int vertice) {
		int resultado = 0;
		ConjuntoTDA vertices = grafo.vertices();
		int otroVertice;
		if (vertices.pertenece(vertice)) {
			while (!vertices.conjuntoVacio()) {
				otroVertice = vertices.elegir();
				if (grafo.existeArista(vertice,otroVertice))
					return grafo.pesoArista(vertice,otroVertice);
				vertices.sacar(otroVertice);
			}
		}
		return resultado;
	}
	
	

	public ConjuntoTDA doblementeAdyacente(GrafoTDA grafo, int v) {
		ConjuntoTDA conjunto = new Conjuntos(), conjuntoGrafo,conjuntoGrafoDos;
		conjunto.inicializarConjunto();
		int valorGrafo,valorGrafoDos;
		conjuntoGrafo = grafo.vertices();
		conjuntoGrafoDos = grafo.vertices();
		while (!conjuntoGrafo.conjuntoVacio()) {
			valorGrafo = conjuntoGrafo.elegir();
			//ojo ava la segunda validacion puede ser existe ariasta al reves
			if (grafo.existeArista(v, valorGrafo) && aristasSalientesPorVertice(grafo, valorGrafo) == 1) {
				while(!conjuntoGrafoDos.conjuntoVacio()){
					valorGrafoDos=conjuntoGrafoDos.elegir();
					if(grafo.existeArista(valorGrafo, valorGrafoDos)){
						conjunto.agregar(v);
						conjunto.agregar(valorGrafoDos);
					}
					conjuntoGrafoDos.sacar(valorGrafoDos);
				}
			}
			conjuntoGrafo.sacar(valorGrafo);
		}
		while(!conjunto.conjuntoVacio()){
			valorGrafo=conjunto.elegir();
			System.out.print(valorGrafo+" ");
			conjunto.sacar(valorGrafo);
		}
		System.out.println("son doblemente adyacentes");

		return null;
	}

	public int mayorCostoAristaSaliente(GrafoTDA grafo, int v) {
		ConjuntoTDA conjuntoGrafo;
		conjuntoGrafo = grafo.vertices();
		int valor=0,valorGrafo,valorPeso;
		while(!conjuntoGrafo.conjuntoVacio()){
			valorGrafo = conjuntoGrafo.elegir();
			if(grafo.existeArista(v, valorGrafo)){
				valorPeso = grafo.pesoArista(v, valorGrafo);
				if(valor<valorPeso){
					valor=valorPeso;
				}
			}
			conjuntoGrafo.sacar(valorGrafo);
		}
		return valor;
	}

	public void listarNodosOrdenados(GrafoTDA grafo) {
		ConjuntoTDA datoConjunto = grafo.vertices();
		ColaPrioridadTDA cola = new ColaPrioridad();
		int valor;
		PilaTDA pila = new Pila();
		pila.inicializarPila();
		cola.inicializarColaPrioridad();
		while(!datoConjunto.conjuntoVacio()){
			valor = datoConjunto.elegir();
			datoConjunto.sacar(valor);
			cola.acolarPrioridad(valor, valor);
		}
		while(!cola.colaVacia()){
			//System.out.println(cola.primero());
			pila.apilar(cola.primero());
			cola.desacolar();
		}
		//lo pongo en la pila para poder invertirlo y que quede de mayor a menor
		while(!pila.pilaVacia()){
			System.out.println(pila.tope());
			pila.desapilar();
		}
	}

}
