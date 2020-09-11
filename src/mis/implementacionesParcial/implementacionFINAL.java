package mis.implementacionesParcial;

import mis.implementacionesParcial.GrafoAristaDinamicaVerticeEstatico.NodoArista;
import implementacion.estatica.Conjuntos;
import apis.ConjuntoTDA;
import apis.GrafoTDA;

/*
* @tarea Agrega una arista al grafo entre los vertices dados y con el peso dado
* @parametros Int, Int, Int
* @devuelve Void
* @precondicion El grafo debe estar inicializado, los nodos deben existir y no la arista entre ellos
* @postcondicion No posee
* @costoTemporal Lineal
* @costoEspacial 0
*/
public class implementacionFINAL implements GrafoTDA {
	class NodoVertice{
		String valor;
		NodoVertice sig;
		NodoArista arista;
	}
	class NodoArista{
		NodoArista sig;
		NodoVertice destino;
		int valor;
	}
	
	NodoVertice inicio;
	
	//inicializar
	@Override
	public void inicializarGrafo() {
		// TODO Auto-generated method stub
		inicio  = null;
	}
	//insertar
	@Override
	public void agregarVertice(String v) {
		// TODO Auto-generated method stub
			NodoVertice nuevo = new NodoVertice();
			nuevo.valor=v;
			nuevo.arista=null;
			//aca pregunta si v es mayor que lo que esta, si da positivo lo es
			if(inicio == null || v.compareTo(inicio.valor)>0) {
				nuevo.sig=inicio;
				inicio=nuevo;
			}else {
				NodoVertice aux = inicio;
				//lo busco me paro en el anterior
				while(aux.sig!= null && aux.sig.valor.compareTo(v)>0) {
					aux=aux.sig;
				}
				nuevo.sig=aux.sig;
				aux.sig=nuevo;
			}
	}
	//sacar
	@Override
	public void eliminarVertice(String v) {
		// TODO Auto-generated method stub
		NodoVertice aux = inicio;
		if(aux != null & v.compareTo(aux.valor) == 0) {
			aux = aux.sig;
		}else {
			//0 significa que son equivalentes
			while(aux != null) {
				if(aux.sig.valor.compareTo(v) == 0) {
					aux.sig = aux.sig.sig;
				}
				aux=aux.sig;
			}
		}
		
	}

	@Override
	public void agregarArista(String v1, int String v2, int peso) {
		// TODO Auto-generated method stub
		
		//primero me paso en el nodo inicio
		NodoVertice aux1 = inicio;
		while(inicio != null && v1.compareTo(aux.valor) != 0) {
			aux = aux.sig;
		}
		//me paro en el nodo inicio final
		NodoVertice aux2 = inicio;
		while(inicio != null && v1.compareTo(aux2.valor) != 0) {
			aux2 = aux2.sig;
		}
		//tomo el nodo ariasta del inicio
		NodoArista nuevo = aux.arista;
		while(nuevo != null && nuevo != aux2.arista) {
			nuevo = nuevo.sig;
		}
		NodoArista nuevoNodo = new NodoArista();
		nuevoNodo = peso;
		nuevoNodo.destino = aux2;
		nuevoNodo.sig= aux1.arista;
		aux1.arista = nuevoNodo;
		
		//agrego la arista
		
	}
	@Override
	public ConjuntoTDA vertices() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void eliminarArista(int v1, int v2) {
		// TODO Auto-generated method stub
		//primero me paso en el nodo inicio
		NodoVertice aux1 = inicio;
		while(inicio != null && v1.compareTo(aux.valor) != 0) {
			aux = aux.sig;
		}
		//me paro en el nodo inicio final
		NodoVertice aux2 = inicio;
		while(inicio != null && v1.compareTo(aux2.valor) != 0) {
			aux2 = aux2.sig;
		}
		NodoArista arista = aux1.arista;
		// es el primero y lo elimino
		if(arista.destino == aux2) {
			arista = arista.sig;
		}else {
			while(arista != null) {
				if(arista.sig != null && arista.sig.destino == aux2) {
					arista.sig = arista.sig.sig;
				}
				arista = arista.sig;
			}
			
		}
	}

	@Override
	public boolean existeArista(int v1, int v2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int pesoArista(int v1, int v2) {
		// TODO Auto-generated method stub
		NodoVertice aux1 = inicio;
		while(inicio != null && v1.compareTo(aux.valor) != 0) {
			aux = aux.sig;
		}
		//me paro en el nodo inicio final
		NodoVertice aux2 = inicio;
		while(inicio != null && v1.compareTo(aux2.valor) != 0) {
			aux2 = aux2.sig;
		}
		NodoArista nodoArista = aux1.arista;
		while(nodoArista.destino != aux2) {
			nodoArista = nodoArista.sig;
		}
		return nodoArista.valor;
	}

	
}
