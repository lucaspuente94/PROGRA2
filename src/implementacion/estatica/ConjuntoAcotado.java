package implementacion.estatica;

import apis.ConjuntoTDA;

public class ConjuntoAcotado implements ConjuntoTDA {
	int[] vector;

	public void inicializarConjunto() {
		vector = new int[100];
		for(int i = 0 ; i < 100 ; i++) {
			vector[i] = 0;
		}
	}

	public void agregar(int x) {
		vector[x] = 1;

	}

	public void sacar(int x) {
		vector[x] = 0;
	}

	public int elegir() {
	int i = 0;
		while(vector[i] != 1) {
			i++;
		}
		return vector[i];
	}

	public boolean conjuntoVacio() {
		// TODO Auto-generated method stub
		
		int i = 0;
		
		while(vector[i] != 1) {
			i++;
		}
		
		return vector[i] == 1;	}

	public boolean pertenece(int x) {
		// TODO Auto-generated method stub
		return vector[x] == 1;

	}

}
