package implementacion.dinamica;

import apis.PilaTDA;

public class PilaDinamica implements PilaTDA {
	class Nodo {
		int info ;
		Nodo sig ;
		}
	Nodo primero;

	public void apilar(int x) {
		Nodo aux = new Nodo ();
		aux.info = x;
		aux.sig = primero;
		primero = aux ;
	}

	public void desapilar() {
		primero = primero.sig ;
	}

	public void inicializarPila() {
		primero = null ;
		// TODO Auto-generated method stub

	}

	public boolean pilaVacia() {
		return ( primero == null ) ;
	}

	public int tope() {
		return primero.info ;
	}

}
