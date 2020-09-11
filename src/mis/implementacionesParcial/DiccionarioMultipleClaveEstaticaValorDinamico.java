package mis.implementacionesParcial;

import implementacion.estatica.Conjuntos;
import apis.ConjuntoTDA;
import apis.DiccionarioMultipleTDA;

public class DiccionarioMultipleClaveEstaticaValorDinamico implements
		DiccionarioMultipleTDA {
	
	class Elemento {
		int clave;
		int cantValores;
		NodoValor valoresDic;
	}
	
	class NodoValor {
		int valor;
		NodoValor sig;
	}
	
	Elemento[] elementos;
	int cantClaves;
	NodoValor origen;

	public void inicializarDiccionarioMultiple() {
		elementos = new Elemento[100];
		cantClaves = 0;
	}

	
	public void agregar(int clave, int valor) {
		//devuelve la posicion de la clave en el vector
				int posC = Clave2Indice(clave);
				
				//creo este nodo para depsues referenciarlo al siguiente nodo cuando se agrega el valor
				NodoValor aux = new NodoValor();
				
				//si es -1 quiere decir que es el 1 elemento
				if (posC == -1) {
					posC = cantClaves;
					elementos[posC] = new Elemento();
					elementos[posC].clave = clave;
					elementos[posC].cantValores = 0;
					cantClaves++;
				}
				//busca el obj elementos en la posicion encontrada por la clave
				Elemento e = elementos[posC];
				//como no acepta repetidos, en la misma clave, verifica que no este repetido
				int posV = Valor2Indice(e, valor);
				if (posV == -1) {
					NodoValor nodoNuevo = new NodoValor();
					nodoNuevo.valor=valor;
					//pongo el nuevo nodo que estoy ingresnado que aputnte al nodo actual que estoy llenando
					nodoNuevo.sig= aux;
					aux = nodoNuevo;
				}
	}

	private int Clave2Indice(int clave) {
		int i = cantClaves - 1;
		while (i >= 0 && elementos[i].clave != clave)
			i--;
		return i;
	}

	private int Valor2Indice(Elemento e, int valor) {
		int i = e.cantValores - 1;
		while (i >= 0 && e.valoresDic.valor != valor)
			i--;
		return i;
	}
	
	public void eliminar(int c) {
		int pos = Clave2Indice(c);
		if (pos != -1) {
			elementos[pos] = elementos[cantClaves - 1];
			cantClaves--;
		}
	}

	public ConjuntoTDA recuperar(int c) {
		ConjuntoTDA c1 = new Conjuntos();
		int i = 0;
		c1.inicializarConjunto();
		int pos = Clave2Indice(c);
		if (pos != -1) {
			Elemento e = elementos[pos];
			//recorro el elemento e mientras i menor al acant de elementos y valores dinamicos no sea null
			while(i<e.cantValores && e.valoresDic != null){
				c1.agregar(e.valoresDic.valor);
				e.valoresDic = e.valoresDic.sig;
				i++;
			}
		}
		return c1;
	}	
		

	public void eliminarValor(int c, int x) {
		int pos = Clave2Indice(c);
		NodoValor aux = elementos[pos].valoresDic;
		while(aux != null && aux.valor != x){
			aux = aux.sig; 
		}
		//aca piso el valor actual con el siguiente
		aux = aux.sig;
		
	}

	public ConjuntoTDA claves() {
		ConjuntoTDA c=new Conjuntos() ;
		c.inicializarConjunto () ;
		for ( int i =0; i < cantClaves; i ++) {
		c.agregar( elementos[i].clave);
		}
		return c;
	}

}
