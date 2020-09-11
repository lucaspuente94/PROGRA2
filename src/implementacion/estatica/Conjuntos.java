package implementacion.estatica;

import apis.ConjuntoTDA;

public class Conjuntos implements ConjuntoTDA {

	int [] a;
	int cant;
	
	final int cotaInf=1;
	final int cotaSup = 100;
	
	public void agregar(int x) {
		 if(!this.pertenece(x)) {
		    	a[cant]=x;
		    	cant++;
		    }
	}
	public boolean conjuntoVacio() {
		return(cant==0);
	}

	public int elegir() {
		return a[cant-1];

	}

	public void inicializarConjunto() {
		a=new int[100];
		cant=0;
	}

	public boolean pertenece(int x) {
		int i = 0;
		while(i<cant && a[i] != x){
			i++;
		}
		return i<cant;
	}

	public void sacar(int x) {
		int i=0;
		while(i<cant&&a[i]!=x) {
			i++;
			
		}
		if(i<cant) {
			a[i]=a[cant-1];
			cant--;
		}
	}

}
