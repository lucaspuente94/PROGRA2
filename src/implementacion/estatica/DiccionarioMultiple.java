package implementacion.estatica;

import apis.ConjuntoTDA;
import apis.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {
	class Elemento {
		int clave;
		int cantValores;
		int[] valores;
	}
	Elemento[] elementos;
	int cantClaves;

	public void agregar(int clave, int valor) {
		//devuelve la posicion de la clave en el vector
		int posC = Clave2Indice(clave);
		//si es -1 quiere decir que es el 1 elemento
		if (posC == -1) {
			posC = cantClaves;
			elementos[posC] = new Elemento();
			elementos[posC].clave = clave;
			elementos[posC].cantValores = 0;
			elementos[posC].valores = new int[100];
			cantClaves++;
		}
		//busca el obj elementos en la posicion encontrada por la clave
		Elemento e = elementos[posC];
		//como no acepta repetidos, en la misma clave, verifica que no este repetido
		int posV = Valor2Indice(e, valor);
		if (posV == -1) {
			//guarda en el obj los valores por parametros y aumenta la cantidad
			e.valores[e.cantValores] = valor;
			e.cantValores++;
		}
	}

	private int Clave2Indice(int clave) {
		int i = cantClaves - 1;
		while (i >= 0 && elementos[i].clave != clave)
			i--;
		return i;
	}

	public ConjuntoTDA claves() {
		ConjuntoTDA c=new Conjuntos() ;
		c.inicializarConjunto () ;
		for ( int i =0; i < cantClaves; i ++) {
		c.agregar( elementos[i ]. clave);
		}
		return c;
	}

	public void eliminar(int clave) {
		int pos = Clave2Indice(clave);
		if (pos != -1) {
			elementos[pos] = elementos[cantClaves - 1];
			cantClaves--;
		}
	}

	public void eliminarValor(int clave, int valor) {
		int posC = Clave2Indice(clave);
		if (posC != -1) {
			Elemento e = elementos[posC];
			int posV = Valor2Indice(e, valor);
			if (posV != -1) {
				e.valores[posV] = e.valores[e.cantValores - 1];
				e.cantValores--;
				if (e.cantValores == 0) {
					eliminar(clave);
				}
			}
		}
	}

	private int Valor2Indice(Elemento e, int valor) {
		int i = e.cantValores - 1;
		while (i >= 0 && e.valores[i] != valor)
			i--;
		return i;
	}

	public void inicializarDiccionarioMultiple() {
		elementos = new Elemento[100];
		cantClaves = 0;
	}

	public ConjuntoTDA recuperar(int clave) {
		ConjuntoTDA c1 = new Conjuntos();
		c1.inicializarConjunto();
		int pos = Clave2Indice(clave);
		if (pos != -1) {
			Elemento e = elementos[pos];
			for (int i = 0; i < e.cantValores; i++) {
				c1.agregar(e.valores[i]);
			}
		}
		return c1;
	}

}
