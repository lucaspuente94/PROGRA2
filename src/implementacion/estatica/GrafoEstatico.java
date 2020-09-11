package implementacion.estatica;

import apis.ConjuntoTDA;
import apis.GrafoTDA;

public class GrafoEstatico implements GrafoTDA {

	int [][]matriz;
	int []vertices; 
	int cant,cantVertices;
	
	public void inicializarGrafo() {
		// TODO Auto-generated method stub
		cant =100;
		vertices = new int[cant];
		cantVertices = 0;
		matriz = new int[cant][cant];
		for (int origen = 0; origen < cant; origen++) {
			for (int destino = 0; destino < cant; destino++) {
				matriz[origen][destino]=0;
			}
		}
	}
	//no tiene que exitir el vertice para agregarlo
	public void agregarVertice(int v) {
		// TODO Auto-generated method stub
		vertices[cantVertices]=v;
		cantVertices++;
	}
	
	public void agregarArista(int v1, int v2, int peso) {
		int fila;
		int columna;
		fila = posicionVertice(v1);
		columna=posicionVertice(v2);
		matriz[fila][columna]=peso;	
	}
	
	public void eliminarVertice(int v) {
		int posicion;
		posicion=posicionVertice(v);
		for (int i = 0; i < cant; i++) {
			matriz[posicion][i]=matriz[i][posicion]=0;
		}
		vertices[posicion]=vertices[cantVertices-1];
		cantVertices--;
	}
	
	
	private int posicionVertice(int v){
		int i;
		for (i=0; i < cantVertices && vertices[i]!=v; i++) {
		}
		return i;
	}
	public ConjuntoTDA vertices() {
		// TODO Auto-generated method stub
		ConjuntoTDA conjunto = new Conjuntos();
		conjunto.inicializarConjunto();
		for (int i = 0; i < cantVertices; i++) {
			conjunto.agregar(vertices[i]);

	}
	return conjunto;
	}
	
	public void eliminarArista(int v1, int v2) {
		// TODO Auto-generated method stub
		matriz[v1][v2]=0;
		int fila,columna;
		fila=posicionVertice(v1);
		columna=posicionVertice(v2);
		matriz[fila][columna]=0;
	}
	public boolean existeArista(int v1, int v2) {
		// TODO Auto-generated method stub
		int fila,columna;
		fila=posicionVertice(v1);
		columna=posicionVertice(v2);
		return matriz[fila][columna] !=0;
	}
	//costo que sale de ir a un nodo a otro, la distancia
	public int pesoArista(int v1, int v2) {
		// TODO Auto-generated method stub
		int fila,columna;
		fila=posicionVertice(v1);
		columna=posicionVertice(v2);
		return matriz[fila][columna];
	}
	
}
