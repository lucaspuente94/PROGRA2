package implementacion.dinamica;

import apis.ConjuntoTDA;
import apis.GrafoTDA;
import implementacion.estatica.Conjuntos;

public class GrafoDinamico implements GrafoTDA {

	class NodoV{
		int et; // valor nombre etiqueta
		NodoV sigV;
		NodoA inicio;
	}
	class NodoA{
		int peso;
		NodoA sigA;
		NodoV dest;
		
	}
	NodoV inicio;
	
	public void inicializarGrafo() {
		// TODO Auto-generated method stub
		inicio = null;
	}
	//precondicion el vertice no existe
	public void agregarVertice(int v) {
		// TODO Auto-generated method stub
		//lo primero creas el nuevo noco del vertice
		NodoV nuevo= new NodoV();
		
		//asignas el valor de la etiqueta
		nuevo.et=v;
		nuevo.inicio = null;
		
		//vinculas ahora
		//aca insertas el vertice
		nuevo.sigV=inicio;
		inicio = nuevo;
	}
	
	
	//los dos vertices tienen que existir
		public void agregarArista(int v1, int v2, int peso) {
			// TODO Auto-generated method stub
			NodoV verticeOrigen = posVertice(v1);
			//tenes que buscar si existe alguna nodo tiene el vertice destino
			NodoV verticeDestino = posVertice(v2);
			//vomienzo lista
			NodoA actual=verticeOrigen.inicio;
			//recorro hasta encontrar el actual destino sea el v
			while(actual!= null && actual.dest != verticeDestino){
				actual = actual.sigA;
			}
			if(actual == null){
				//no existe arista
				NodoA nuevoNodo = new NodoA();
				nuevoNodo.peso=peso;
				nuevoNodo.dest=verticeDestino;
				//ahora agregas a la lista
				nuevoNodo.sigA=verticeOrigen.inicio;
				verticeOrigen.inicio=nuevoNodo;
			}
		}

	public void eliminarVertice(int v) {
		// TODO Auto-generated method stub
		ConjuntoTDA verticesOrigen = this.vertices();
		verticesOrigen.sacar(v);//elimino vertice destino
		int vo;//ver roigen
		while(!verticesOrigen.conjuntoVacio()){
			vo = verticesOrigen.elegir();
			verticesOrigen.sacar(vo);
			if(this.existeArista(vo, v)){
				this.eliminarArista(vo, v);
			}
		}
		//elimino vertice V
		NodoV ant = null, actual=inicio;
		while(actual.et != v){
			ant = actual;
			actual = actual.sigV;
		}
		if(ant == null){
			inicio = inicio.sigV;
		}else{
			ant.sigV = actual.sigV;
		}
	}


	private NodoV posVertice(int v){
		NodoV actual = inicio;
		while(actual.et !=v){
			actual = actual.sigV; // avanzas hasta encontrar
		}
		return actual;
	}
	//la precondicion existe arista
	public void eliminarArista(int v1, int v2) {
			NodoV verticeOrigen = posVertice(v1);
			NodoV verticeDestino = posVertice(v2);
			NodoA actual=verticeOrigen.inicio;
			NodoA ant=null;
			while(actual.dest != verticeDestino){
				ant = actual.sigA;
				actual = actual.sigA;
			}
			if(ant == null){ // si la arista es la primera de la lista
				verticeOrigen.inicio = verticeOrigen.inicio.sigA;
			}else{
				ant.sigA = actual.sigA;
			}
	}

	public boolean existeArista(int v1, int v2) {
		// TODO Auto-generated method stub
		NodoV verticeOrigen = posVertice(v1);
		NodoV verticeDestino = posVertice(v2);
		NodoA actual=verticeOrigen.inicio;
		while(actual!= null && actual.dest != verticeDestino){
			actual = actual.sigA;
		}	
		return actual !=null;	
	}

	public int pesoArista(int v1, int v2) {
		NodoV verticeOrigen = posVertice(v1);
		//tenes que buscar si existe alguna arista/nodo tiene el vertice destino
		NodoV verticeDestino = posVertice(v2);
		//vomienzo lista
		NodoA actual=verticeOrigen.inicio;
		while(actual.dest != verticeDestino){
			actual = actual.sigA;
		}
		return actual.peso;
	}
	
	public ConjuntoTDA vertices(){
		ConjuntoTDA resultado = new Conjuntos();
		resultado.inicializarConjunto();
		NodoV actual = inicio;
		while(actual != null){
			resultado.agregar(actual.et);
			actual = actual.sigV;
		}
		//VER ESTO
		return resultado;
	}

}
