package implementacion.dinamica;

import implementacion.estatica.Conjuntos;
import apis.ConjuntoTDA;
import apis.DiccionarioMultipleTDA;

public class DiccionarioMultipleDinamico implements DiccionarioMultipleTDA {

	class NodoClave {
		int clave;
		NodoValor valores;
		NodoClave sigClave;
	}

	class NodoValor {
		int valor;
		NodoValor sigValor;
	}

	NodoClave origen;

	public void agregar(int clave, int valor) {
		NodoClave nc = Clave2NodoClave(clave);
		if (nc == null) {
			nc = new NodoClave();
			nc.clave = clave;
			nc.sigClave = origen;
			origen = nc;
		}
		NodoValor aux = nc.valores;
		while (aux != null && aux.valor != valor) {
			aux = aux.sigValor;
		}
		if (aux == null) {
			NodoValor nv = new NodoValor();
			nv.valor = valor;
			nv.sigValor = nc.valores;
			nc.valores = nv;
		}
	}

	private NodoClave Clave2NodoClave(int clave) {
		NodoClave aux = origen;
		while (aux != null && aux.clave != clave) {
			aux = aux.sigClave;
		}
		return aux;
	}

	public ConjuntoTDA claves() {
		// TODO Auto-generated method stub
		return null;
	}

	public void eliminar(int clave) {
		if (origen != null) {
			if (origen.clave == clave) {
				origen = origen.sigClave;
			} else {
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave != clave) {
					aux = aux.sigClave;
				}
				if (aux.sigClave != null) {
					aux.sigClave = aux.sigClave.sigClave;
				}
			}
		}
	}

	public void eliminarValor(int clave, int valor) {
		if (origen != null) {
			if (origen.clave == clave) {
				EliminarValorEnNodo(origen, valor);
				if (origen.valores == null) {
					origen = origen.sigClave;
				}
			} else {
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave != clave) {
					aux = aux.sigClave;
				}
				if (aux.sigClave != null) {
					EliminarValorEnNodo(aux.sigClave, valor);
					if (aux.sigClave.valores == null) {
						aux.sigClave = aux.sigClave.sigClave;
					}
				}
			}
		}
	}

	private void EliminarValorEnNodo(NodoClave nodo, int valor) {
		if (nodo.valores != null) {
			if (nodo.valores.valor == valor) {
				nodo.valores = nodo.valores.sigValor;
			} else {
				NodoValor aux = nodo.valores;
				while (aux.sigValor != null && aux.sigValor.valor != valor) {
					aux = aux.sigValor;
				}
				if (aux.sigValor != null) {
					aux.sigValor = aux.sigValor.sigValor;
				}
			}
		}
	}

	public void inicializarDiccionarioMultiple() {
		origen = null;

	}

	public ConjuntoTDA recuperar(int clave) {
		NodoClave n = Clave2NodoClave(clave);
		ConjuntoTDA c = new Conjuntos();
		c.inicializarConjunto();
		if (n != null) {
			NodoValor aux = n.valores;
			while (aux != null) {
				c.agregar(aux.valor);
				aux = aux.sigValor;
			}
		}
		return c;
	}

}
