package implementacion.estatica;

import apis.PilaTDA;


public class Pila implements PilaTDA {
	
	//declaro un arreglo para poder implementar mi pila
	 int []a;
	 //declaro la variable indice para la posicion de la pila.
	 int indice;
	 
	//Para que todas las operaciones funcionen correctamente, tienen que estar declaradas las variables anteriores.

	 
	public void apilar(int x) {
		a[indice]=x;
		indice++;
	}
	
	public void desapilar() {
		indice--;
	}

	
	public void inicializarPila() {
		a=new int[100];
		indice=0;
	}
	
	public boolean pilaVacia() {
		return(indice==0);

	}
	public int tope() {
		return a[indice-1];
	}

}
