package implementacion.dinamica;

import apis.ColaTDA;

public class ColaDinamica implements ColaTDA {
	private class Nodo {
		int valor;
		Nodo siguiente;
	}

	Nodo primer;
	Nodo ultimo;
	public void incializarCola() {
		this.primer = this.ultimo = null;
	}

	public void acolar(int valor) {
		Nodo nuevo = new Nodo();
		nuevo.valor = valor;
		nuevo.siguiente = null;
		if (this.ultimo == null)
			this.ultimo = this.primer = nuevo;
		else {
			this.ultimo.siguiente = nuevo;
			this.ultimo = nuevo;
		}
	}

	public void desacolar() {
		this.primer = this.primer.siguiente;
		if (this.primer == null)
			this.ultimo = null;
	}

	public int tope() {
		return this.primer.valor;
	}

	public boolean colaVacia() {
		return this.ultimo == null;
	}

}
