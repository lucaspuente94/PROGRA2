package mis.implementacionesParcial;

import implementacion.estatica.Conjuntos;
import apis.ConjuntoTDA;
import apis.DiccionarioMultipleTDA;

public class DiccionarioMultipleValorEstaticoClaveDinamica implements
		DiccionarioMultipleTDA {

	class NodoClave {
		int clave;
		int pos;
		int[] valores;
		NodoClave sigClave;
		
	}

	NodoClave origen;

	public void inicializarDiccionarioMultiple() {
		origen = null;
		origen.pos=0;
		origen.valores= new int[100];
	}

	public void agregar(int clave, int valor) {
		int[] elementos;
		boolean existe=false;
		NodoClave nc = Clave2NodoClave(clave);
		if (nc == null) {
			nc = new NodoClave();
			nc.clave = clave;
			nc.valores[nc.pos]=valor;
			nc.sigClave = origen;
			nc.pos++;
			
			origen = nc;
		}
		// obtengo los valores
		elementos = nc.valores;
		for (int i = 0; i < elementos.length && elementos[i] == valor; i++) {
			existe = true;
		}
		if (!existe) {
			nc.valores[nc.pos]=valor;
			nc.pos++;
		}
	}

	private NodoClave Clave2NodoClave(int clave) {
		NodoClave aux = origen;
		while (aux != null && aux.clave != clave) {
			aux = aux.sigClave;
		}
		return aux;
	}

	public void eliminar(int c) {
		if (origen != null) {
			if (origen.clave == c) {
				origen = origen.sigClave;
			} else {
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave != c) {
					aux = aux.sigClave;
				}
				if (aux.sigClave != null) {
					aux.sigClave = aux.sigClave.sigClave;
				}
			}
		}
	}

	public ConjuntoTDA recuperar(int clave) {
		NodoClave n = Clave2NodoClave(clave);
		ConjuntoTDA c = new Conjuntos();
		c.inicializarConjunto();
		for (int i = 0; i < n.pos; i++) {
			c.agregar(n.valores[i]);
		}
		return c;
	}

	public void eliminarValor(int c, int x) {
		NodoClave nc = origen;
		int valor=0;
		while(nc != null && nc.clave != c){
			nc = nc.sigClave;
		}
		for (int i = 0; i < nc.pos; i++) {
			if(nc.valores[i] == x){
				valor = i;
			}
		}
		if (valor != -1) {
			nc.valores[valor] = nc.valores[nc.pos - 1];
			nc.pos--;
			if (nc.pos == 0) {
				eliminar(c);
			}
		}
		nc.pos--;
	}

	public ConjuntoTDA claves() {
		ConjuntoTDA conjunto = new Conjuntos();
		conjunto.inicializarConjunto();
		NodoClave aux = origen;
		while(aux!= null){
			conjunto.agregar(aux.clave);
			aux = aux.sigClave;
		}
		return conjunto;
	}

}
