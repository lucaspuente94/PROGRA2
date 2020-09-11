package mis.implementacionesParcial;

import apis.ConjuntoTDA;
import implementacion.estatica.Conjuntos;

public class recuperatorio {
	//diccionario multiple
	//Agregar
	//recuperar
	//claves estatico
	//valores dinamicos
	
	
	class Elemento {
		int clave;
		int cantValores;
		NodoValor valores;
	}
	class NodoValor {
		int valor;
		NodoValor sigValor;
	}
	int cantClaves;
	Elemento[] elementos;

	public void agregar(int clave,int valor){
		//me paro en la clave enviada
		int posC = Clave2Indice(clave);
		//se valida que la clave exista
		if (posC != -1) {
			Elemento e = elementos[posC];
			//aca pregunto si nodovalor no tiene nigun dato
			if(e.valores == null){
				e.valores.valor = valor;
			}else{
				NodoValor aux = new NodoValor();
				aux.valor=valor;
				aux.sigValor=e.valores;
				e.valores=aux;
			}
		}
	}
	
	public ConjuntoTDA recuperar(int clave){
		ConjuntoTDA c1 = new Conjuntos();
		c1.inicializarConjunto();
		int pos = Clave2Indice(clave);
		if (pos != -1) {
			Elemento e = elementos[pos];
			NodoValor aux=elementos[pos].valores;
			while(aux != null){
				c1.agregar(aux.valor);
				aux = aux.sigValor;
			}
		}
		return c1;
	}
	
	private int Clave2Indice(int clave) {
		int i = cantClaves - 1;
		while (i >= 0 && elementos[i].clave != clave)
			i--;
		return i;
	}
}
