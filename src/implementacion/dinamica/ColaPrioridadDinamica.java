package implementacion.dinamica;

import apis.ColaPrioridadTDA;

public class ColaPrioridadDinamica implements ColaPrioridadTDA {
	class NodoPrioridad{
		int info ;
		int prioridad;
		NodoPrioridad sig ;
		}
	NodoPrioridad mayorPrioridad ;

	public void acolarPrioridad(int x, int prioridad) {
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo. info = x;
		nuevo. prioridad = prioridad;

		if ( mayorPrioridad == null ||	prioridad > mayorPrioridad.prioridad) {
		nuevo. sig = mayorPrioridad ;
		mayorPrioridad = nuevo;
		}
		else {
			NodoPrioridad aux = mayorPrioridad;
			while( aux.sig !=null && aux.sig.prioridad >= prioridad) {
				aux = aux.sig ;
			}
			nuevo.sig = aux.sig ;
			aux.sig = nuevo;
		}

	}

	public boolean colaVacia() {
		return ( mayorPrioridad == null ) ;
	}

	public void desacolar() {
		mayorPrioridad = mayorPrioridad. sig ;

	}

	public void inicializarColaPrioridad() {
		mayorPrioridad = null ;

	}

	public int primero() {
		return mayorPrioridad. info ;
	}

	public int prioridad() {
		return mayorPrioridad. prioridad;
	}

}
