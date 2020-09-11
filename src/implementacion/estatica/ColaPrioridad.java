package implementacion.estatica;

import apis.ColaPrioridadTDA;



public class ColaPrioridad implements ColaPrioridadTDA {

	//Creo una nueva clase, con 2 elementos enteros. Los mismos son la prioridad y el valor.
	class Elem{
		int v,p;
	}
	//declaro el arreglo
	Elem[]vector;
	
	//declaro la variable cantidad
	int cant;
	
	//en la posicon 0 va el elemento con menor prioridad.
	public void acolarPrioridad(int x, int p) {
		int i=cant-1;
		//pregunta si el anterior(mayor prioridad)es > a la nueva prioridad ingreasa
		while (i>=0 && vector[i].p>=p){
			//al ser mayor en una posicion corrida a la derecha pone el valor con mayor prioridad
			vector[i+1] = vector[i];
			//resta para poder seguir recorriendo y preguntar si el anterior es mayor a la nueva prioridad ingresada
			i -= 1;
		}
		//si no paso por el while quiere decir que es el valor con mayor prioridad y se agrega al final.
		//si pasa por el while quiere decir que es menor a la prioridad mas grande y va recorriendo hasta encontrar su posicion(que este entre una prioridad menor y la mayor) y devuleve la posicion I 
		vector[i+1]= new Elem();
		vector[i+1].v = x;
		vector[i+1].p = p;
		cant++;
	}
	
	
	
////SI ES IGUAL PASA A MAYOR PRIORIDAD
//	public void acolarPrioridad(int x, int p) {
//		boolean esta=false;
//		int i;
//		for (i=cant-1; i > 0 && vector[i].p>p; i--) {
//			vector[i+1]=vector[i];
//			if(vector[i].v==x){
//				esta=true;
//			}
//		}
//		if(esta){
//			int pri = prioridad();
//			vector[i].p= pri+1;
//			vector[cant+1] = vector[i];
//			while(i<cant){
//				vector[i]=vector[i+1];
//				i++;
//			}
//			
//		}else{
//			vector[i+1]= new Elem();
//			vector[i+1].v = x;
//			vector[i+1].p = p;
//			cant++;
//		}
//	}
	
	public boolean colaVacia() {
		return cant == 0;
	}
	
	
	public void desacolar() {
		cant -=1;
	}
	
	public void inicializarColaPrioridad() {
		vector = new Elem[100];
		cant = 0;
	}

	public int primero() {
		return vector[cant-1].v;

	}	
	
	
	public int prioridad() {
		return vector[cant-1].p;

	}

}
