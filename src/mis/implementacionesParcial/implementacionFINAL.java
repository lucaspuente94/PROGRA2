//package mis.implementacionesParcial;
//
//import mis.implementacionesParcial.GrafoAristaDinamicaVerticeEstatico.NodoArista;
//import implementacion.estatica.Conjuntos;
//import apis.ConjuntoTDA;
//import apis.GrafoTDA;
//
///*
//* @tarea Agrega una arista al grafo entre los vertices dados y con el peso dado
//* @parametros Int, Int, Int
//* @devuelve Void
//* @precondicion El grafo debe estar inicializado, los nodos deben existir y no la arista entre ellos
//* @postcondicion No posee
//* @costoTemporal Lineal
//* @costoEspacial 0
//*/
//public class implementacionFINAL implements GrafoTDA {
//
//	
//	class	NodoVertice{
//		int valor;
//		NodoArista aristasEntrantes;
//		NodoVertice sig;
//	}
//
//	 class NodoArista {
//		int verticeOrigen;
//		int peso;
//		NodoArista sig;
//	}
//	 
//	 NodoVertice inicio;
//	 public void inicializarGrafo() {
//		 inicio = null;
//	 }
//	//INSERTAR
//	 public void agregarVertice(int v) {
//		 // TODO Auto-generated method stub
////		 NodoVertice nuevo = new NodoVertice();
////		 nuevo.valor = v;
////		 nuevo.AristaEntrantes = null;
////		 
////		 
////		 NodoVertice aux = inicio;
////		 for (aux != null && aux.valor>v) {
////			aux = aux.sig;
////		}
////		 nuevo.siguiente=aux.siguiente;
////		 aux = nuevo;
////		 
//	 }
//
//	 //sacar
//	 public void eliminarVertice(int v) {
////		 // TODO Auto-generated method stub
////		NodoV verticeOrigen = posVertice(v1);
////		if(veritceOrigen.sig == null){
////			verticeOrigen = null;
////		}else{
////			verticeOrigen = verticeOrigen.sig			
////		}
//		
//	 }
//	 //insertarArista
//	public void agregarArista(int v1, int v2, int peso) {
//		// TODO Auto-generated method stub
//		// LO QUE AHRIA
//		NodoV verticeOrigen = posVertice(v1);
//		NodoV verticeDestino = posVertice(v2);
//		//en el origen
//		nodoA aux = nodoA;
//		aux.peso = peso
//		aux.verticeOrigen = verticeDestino;
//		aux.sig = =verticeOrigen.aristaEntrante;
//		verticeOrigen.aristaEntrante=aux;
//		
//	}
//
//	//sacarArista
//	public void eliminarArista(int v1, int v2) {
//		// TODO Auto-generated method stub
//		NodoV verticeOrigen = posVertice(v1);
//		NodoV verticeDestino = posVertice(v2);
//		while(verticeOrigen.aritas != null && verticeOrigen.aristas.verticeOrigen != verticeDestino){
//			verticeOrigen.Arritas = verticeOrigen.Aristas.sig;
//		}
//		if(verticeOrigen.Arritas.sig == null){
//			verticeOrigen.Arritas = null;
//		}else{
//			verticeOrigen.Arritas = verticeOrigen.Arritas.sig			
//		}
//		
//	}
//
//
//	public boolean existeArista(int v1, int v2) {
//		// TODO Auto-generated method stub
//		NodoV verticeOrigen = posVertice(v1);
//		NodoV verticeDestino = posVertice(v2);
//		while(verticeOrigen.aritas != null){
//			if(verticeOrigen.aristas.verticeOrigen == verticeDestino){
//				return true;
//			}else{
//				verticeOrigen.aristas = verticeOrigen.aristas.sig;
//			}
//		}
//		return false;
//	}
//
//
//	public int pesoArista(int v1, int v2) {
//		// TODO Auto-generated method stub
//		NodoV verticeOrigen = posVertice(v1);
//		NodoV verticeDestino = posVertice(v2);
//		while(verticeOrigen.aritas != null && verticeOrigen.aristas.verticeOrigen != verticeDestino){
//			verticeOrigen.aristas= verticeOrigen.aristas.sig
//		}
//		return verticeOrigen.aristas.peso;	
//	}
//
//	public ConjuntoTDA vertices() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
