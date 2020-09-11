package mis.implementacionesParcial;

import implementacion.estatica.Conjuntos;
import apis.ConjuntoTDA;
import apis.GrafoTDA;

public class GrafoAristaDinamicaVerticeEstatico implements GrafoTDA{

class	NodoVertice{
	int valor;
	NodoArista aristasEntrantes;
}

 class NodoArista {
	int verticeOrigen;
	int peso;
	NodoArista sig;
}

NodoVertice[] origen;
int cantVertices;
	
	public void inicializarGrafo() {
		cantVertices=0;
		origen = new NodoVertice[100];

	}

	public void agregarVertice(int v) {
		origen[cantVertices].valor=v;
		cantVertices++;
	}
	
	public void agregarArista(int v1, int v2, int peso) {
		NodoArista verticeNuevo = new NodoArista();
		
		//obtengo la pos de los vertices en el vector
		int valorV1= posVertice(v1);
		
		//seteo los valores en el objetos
		verticeNuevo.peso=peso;
		verticeNuevo.verticeOrigen=v2;

		//busco el nodo en el array
		verticeNuevo.sig=origen[valorV1].aristasEntrantes;
		origen[valorV1].aristasEntrantes = verticeNuevo;
	}

	private int posVertice(int v){
		int i;
		for (i=0; i < cantVertices && origen[i].valor!=v; i++) {
		}
		return i;
	}

	public void eliminarVertice(int v) {
		int posicion,vertices=cantVertices-1;
		posicion=posVertice(v);
		//elimino el vertice dle array
		while(posicion<=cantVertices-1){
			origen[posicion]=origen[posicion+1];
			posicion++;
		}
		//elimino todas las aristas que tiene el v 
		while(vertices>=0){
			if(origen[posicion].aristasEntrantes.verticeOrigen==v){
				origen[posicion].aristasEntrantes = origen[posicion].aristasEntrantes.sig;
			}
			vertices--;
		}
		cantVertices--;
	}
	
	public void eliminarArista(int v1, int v2) {
		//busco la pos del vertice
		int posicion=posVertice(v1);
		//recorro el auxiliar hasta envontrar la referencia al nodo de la arista buscada
		NodoArista aux = origen[posicion].aristasEntrantes;
		while(aux != null && aux.sig.verticeOrigen!=v2){
			aux=aux.sig;
		}
		//elimino el nodo encontrado, pisnadolo con el proximo
		aux=aux.sig;
	}

	
	public ConjuntoTDA vertices() {
		ConjuntoTDA conjunto = new Conjuntos();
		conjunto.inicializarConjunto();
		for (int i = 0; i < cantVertices; i++) {
			conjunto.agregar(origen[i].valor);
		}
		return conjunto;
	}


	public boolean existeArista(int v1, int v2) {
		int ve1=posVertice(v1);
		//recorro el nodo hasta encontrar el valor del vertice, si el peso es distinto a 0 tiene una arista
		NodoArista auxUno = origen[ve1].aristasEntrantes;
		while(origen[ve1].aristasEntrantes != null && origen[ve1].aristasEntrantes.verticeOrigen != v2){
			auxUno = auxUno.sig;
		}
		return auxUno.peso != 0;
	}

	public int pesoArista(int v1, int v2) {
		int ve1;
		ve1=posVertice(v1);
		//recorro el nodo hasta encontrar el valor del vertice, si el peso es distinto a 0 tiene una arista
		NodoArista auxUno = origen[ve1].aristasEntrantes;
		while(origen[ve1].aristasEntrantes != null && origen[ve1].aristasEntrantes.verticeOrigen != v2){
			auxUno = auxUno.sig;
		}
		return auxUno.peso;
	}

}
