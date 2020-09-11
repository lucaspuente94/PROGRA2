package implementacion.estatica;

import apis.ConjuntoTDA;
import apis.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {
	class Elem{
		int clave,valor;
	}
	Elem[] elementos;
	int cant;
	
	public void agregar(int clave, int valor) {
		int pos = clave2indice(clave);
		if(pos == -1){
			pos = cant;
			elementos[ pos ]= new Elem ();
			elementos[ pos ]. clave = clave;
			cant ++;
		}
		elementos[ pos ]. valor = valor;
	}
	

	public ConjuntoTDA claves() {
		ConjuntoTDA c= new Conjuntos();
		c. inicializarConjunto() ;
		for( int i =0; i < cant ; i ++) {
			c.agregar( elementos[i ]. clave);
		}
		return c;
	}

	public void eliminar(int clave) {
		int pos = clave2indice(clave);
		if ( pos != -1) {
			elementos[pos]=elementos[cant-1];
			cant--;
		}
	}

	public void inicializarDiccionarioMultiple() {
		cant = 0;
		elementos = new Elem[100];
	}

	public int recuperar(int clave) {
		int pos = clave2indice(clave);
		return elementos[ pos ]. valor;
	}

	
	private int clave2indice(int clave){
		int i = cant-1;
		while(i>=0 && elementos[i].clave!=clave){
			i--;
		}
		return i;
	}
	
}
