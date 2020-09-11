package mis.implementacionesParcial;

import implementacion.estatica.Conjuntos;
import apis.ConjuntoTDA;
import apis.GrafoTDA;

public class GrafoAristaEstaticaVerticeDinamico implements GrafoTDA {
	class NodoVertice {
		int valor;
		NodoVertice sig;
		NodoArista[] arista;
		int cantArista;
	}

	class NodoArista {
		int peso;
		NodoVertice destino;
		int cantAristas;
	}

	NodoVertice origen;

	public void inicializarGrafo() {
		origen = new NodoVertice();
		origen.arista = new NodoArista[100];
	}

	public void agregarVertice(int v) {
		NodoVertice nuevo = new NodoVertice();
		nuevo.valor = v;
		nuevo.sig = origen;
		origen = nuevo;
	}

	public void agregarArista(int v1, int v2, int peso) {
		NodoVertice origenV = buscarNodoVertice(v1);
		NodoVertice destino = buscarNodoVertice(v2);
		origenV.arista[origenV.cantArista].peso = peso;
		origenV.arista[origenV.cantArista].destino = destino;
		origenV.cantArista++;
	}

	public NodoVertice buscarNodoVertice(int v) {
		NodoVertice aux = origen;
		while (aux != null && aux.valor != v) {
			aux = aux.sig;
		}
		return aux;
	}

	public void eliminarVertice(int v) {
		// busco el nodo
		NodoVertice origenV = buscarNodoVertice(v);
		// como estoy posicionado sobre el elemento me referencio al otro para
		// eliminarlo
		origenV = origenV.sig;
		while (origenV != null) {
			// elimino todas las aristas que tienen el vertice enviado por
			// parametro como destino
			eliminarAristasVertice(origenV, v);
			origen = origenV.sig;
		}
	}

	private void eliminarAristasVertice(NodoVertice origenV, int v) {
		//elimino todas las aristas que tiene el v 
//				while(vertices>=0){
//					if(origen[posicion].aristasEntrantes.verticeOrigen==v){
//						origen[posicion].aristasEntrantes = origen[posicion].aristasEntrantes.sig;
//					}
//					vertices--;
//				}
//				cantVertices--;
	}

	public void eliminarArista(int v1, int v2) {
		NodoVertice origenV = buscarNodoVertice(v1);
		int i;
		for (i = 0; i <= origenV.cantArista	&& origen.arista[i].destino.valor != v2; i++) {
			origenV = origenV.sig;
		}
		origenV.arista[i] = origenV.arista[i - 1];
		origenV.cantArista--;
	}

	public ConjuntoTDA vertices() {
		ConjuntoTDA conjunto = new Conjuntos();
		conjunto.inicializarConjunto();
		NodoVertice nodoAux = origen;
		while (nodoAux != null) {
			conjunto.agregar(nodoAux.valor);
			nodoAux= nodoAux.sig;
		}
		return conjunto;
	}

	public boolean existeArista(int v1, int v2) {
		NodoVertice origenV = buscarNodoVertice(v1);
		int i = origenV.cantArista;
		while (i >= 0 && origenV.arista[i].destino.valor != v2) {
			i--;
		}
		return origenV.arista[i].peso != 0;
	}

	public int pesoArista(int v1, int v2) {
		NodoVertice origenV = buscarNodoVertice(v1);
		int i;
		for (i = 0; i <= origenV.cantArista
				&& origen.arista[i].destino.valor != v2; i++) {
			origenV = origenV.sig;
		}
		return origenV.arista[i].peso;
	}

}
