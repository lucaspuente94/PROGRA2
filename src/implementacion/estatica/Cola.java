package implementacion.estatica;

import apis.ColaTDA;


public class Cola implements ColaTDA {
	
	
	//declaro un arreglo para poder implementar mi cola
	int []a;
	//declaro la variable indice para la posición de la cola.
	int indice;
	
	
	public void acolar(int x) {
		//la posicion 0 se almacena el primer valor, pero despues cuando agregar otro, ese valor inicial pasa a la derecha y en el 0 queda el nuevo
		for(int i=indice-1;i>=0;i--) {
			a[i+1]=a[i];
		}
		a[0]=x;
		indice++;
	}

	public boolean colaVacia() {
		return (indice==0);

	}
	
	public void desacolar() {
		indice--;
	}

	public void incializarCola() {
		a=new int[100];
		indice=0;
	}

	public int tope() {
		return a[indice-1];
	}

}
