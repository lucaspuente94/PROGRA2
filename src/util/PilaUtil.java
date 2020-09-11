package util;

import implementacion.estatica.Cola;
import implementacion.estatica.Conjuntos;
import implementacion.estatica.Pila;
import apis.ColaTDA;
import apis.ConjuntoTDA;
import apis.PilaTDA;

public class PilaUtil {

	public PilaTDA generarPilaNueva(PilaTDA p1) {
		System.out.println("pila original : ");
		for (int i = 0; i < 6; i++) {
			p1.apilar(i);
			System.out.println("Se apilo en p1 : "+i);
		}
		return p1;
	}

	public PilaTDA generarPilaNuevaB(PilaTDA p1) {
		System.out.println("pila original : ");
		for (int i = 0; i < 3; i++) {
			p1.apilar(i);
			System.out.println("Se apilo en p1 : "+i);
		}
		return p1;
	}
	
	public PilaTDA generarPilaNuevaC(PilaTDA p1) {
		System.out.println("pila original : ");
		int vec[]={1,4,2,3,5,6,7,19,1,4};
		for (int i = 0; i < vec.length; i++) {
			p1.apilar(vec[i]);
			System.out.println("Se apilo en p1 : "+i);
		}
		return p1;
	}
	
	public void pasarApila(PilaTDA p1, PilaTDA p2) {
		System.out.println(" Entro al metodo de pasar pila ");
		while (!p1.pilaVacia()) {
			p2.apilar(p1.tope());
			System.out.println("Se apilo en p2: "+p1.tope());
			p1.desapilar();
		}
	}

	public void vaciarPila(PilaTDA p2) {
		while (!p2.pilaVacia()) {
			p2.desapilar();
		}
	}

	public void copiarPila(PilaTDA p1, PilaTDA p2) {
	System.out.println(" Entro al metodo de copiar pila ");
	PilaTDA pilaAux =generarPilaAux();
		while(!p1.pilaVacia()){
			pilaAux.apilar(p1.tope());
			p1.desapilar();
		}
		while(!pilaAux.pilaVacia()){
			p2.apilar(pilaAux.tope());
			System.out.println("Se apilo en p2: "+pilaAux.tope());
			pilaAux.desapilar();
		}
	}

	private PilaTDA generarPilaAux() {
		PilaTDA pilaAux = new Pila();
		pilaAux.inicializarPila();
		return pilaAux;
	}

	public void invertirPila(PilaTDA p1) {
		System.out.println(" Entro al metodo de invetir pila ");
		ColaTDA cola = new Cola();
		cola.incializarCola();
		while(!p1.pilaVacia()){
			cola.acolar(p1.tope());
			p1.desapilar();
		}
		while(!cola.colaVacia()){
			p1.apilar(cola.tope());
			System.out.println(" Pila : "+cola.tope());
			cola.desacolar();
		}
	}

	public void desapilarPila(PilaTDA p1) {
		while(!p1.pilaVacia()){
			p1.desapilar();
		}		
	}

	public int cantidadPila(PilaTDA p1) {
		int cant= 0;
		while(!p1.pilaVacia()){
			cant++;
			p1.desapilar();
		}
		return cant;
	}

	public int sumarElementosPila(PilaTDA p1) {
		int suma= 0;
		while(!p1.pilaVacia()){
			suma = suma + p1.tope();
			p1.desapilar();
		}
		return suma;
	}

	public boolean contienePila(PilaTDA p1, PilaTDA p2) {
		int i =0;
			while(!p1.pilaVacia() && !p2.pilaVacia()){
				if(p1.tope() == p2.tope()){
					i ++;
					p2.desapilar();
				}else{
					p1.desapilar();
				}
			}
			if(i>0){
				return true;
			}else{
				return false;
			}
	}

	public void eliminarRepetidos(PilaTDA p) {
			PilaTDA aux = new Pila() ;
			aux.inicializarPila();
			ConjuntoTDA c = new Conjuntos();
			while(!p.pilaVacia()){
				int tope = p.tope();
				if(!c.pertenece(tope)){
						aux.apilar(tope);
						c.agregar(tope) ;
				}
				p.desapilar() ;
			}
			while(!aux.pilaVacia() ){
				p.apilar(aux.tope());
				aux.desapilar() ;
			}
	}
	
	
	
	
public void invertirColaSinPila(ColaTDA c) {
		
		//Cola que voy a utilizar para acolar y desacolar en cada iteracion
		ColaTDA aux = new Cola();
		aux.incializarCola();
		copiarColaCola(aux,c);
		
		//Cola que voy a utilizar para reiniciar la cola auxiliar
		ColaTDA resguardo = new Cola();
		resguardo.incializarCola();
		copiarColaCola(resguardo,c);
		
		//Obtengo la longitud o cantidad de elementos. La pila original queda sin valores
		int cant = 0;
		while(!c.colaVacia()) {
			cant++;
			c.desacolar();
		}

		
		int cantAux = cant;
		
		for(int i=1 ; i <= cant ; i++) {
			
			//Desacolo. 1er iteracion: queda 1. 2da iteracion: quedan 2...
			while(cantAux>1) {
				aux.desacolar();
				cantAux--;
			}
			c.acolar(aux.tope());
			while(!aux.colaVacia()) {
				aux.desacolar();
			}
			copiarColaCola(aux,resguardo);
			cantAux = cant-i;
		}
	}

public void copiarColaCola(ColaTDA origen, ColaTDA destino) {
	ColaTDA colaAuxiliar = new Cola();
	colaAuxiliar.incializarCola();
	while(!origen.colaVacia()) {
		colaAuxiliar.acolar(origen.tope());
		destino.acolar(origen.tope());
		origen.desacolar();
	}
	pasarColaCola(colaAuxiliar, origen);
}

public void pasarColaCola(ColaTDA origen, ColaTDA destino) {
	while (!origen.colaVacia()) {
		destino.acolar(origen.tope());
		origen.desacolar();
	}
}
	
}
