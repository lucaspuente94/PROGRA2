package util;

import java.util.concurrent.ThreadLocalRandom;

import implementacion.estatica.ColaPrioridad;
import implementacion.estatica.Conjuntos;
import implementacion.estatica.DiccionarioMultiple;
import apis.ColaPrioridadTDA;
import apis.ConjuntoTDA;
import apis.DiccionarioMultipleTDA;

public class ColaPrioridadUtil {

	public void generarColaPrioridad(ColaPrioridadTDA cola) {
		int prioridad = 0;
		for (int i = 0; i < 6; i++) {
			//le agrego una propiedad aleatorea para uqe no sean iguales
			prioridad = ThreadLocalRandom.current().nextInt(1, 20);
			cola.acolarPrioridad(i, prioridad);
			System.out.println("Cola Original : ");
			System.out.println("prioridad : "+prioridad+"__Valor : "+i);
			
		}
	}

	public void unirColasPrioridad(ColaPrioridadTDA c1, ColaPrioridadTDA c2) {
		ColaPrioridadTDA aux = new ColaPrioridad();
		aux.inicializarColaPrioridad();
		while (!c1.colaVacia() && !c2.colaVacia()) {
			if(c1.prioridad()>= c2.prioridad()){
				aux.acolarPrioridad(c1.primero(), c1.prioridad());
				aux.acolarPrioridad(c2.primero(), c2.prioridad());
			}else{
				aux.acolarPrioridad(c2.primero(), c2.prioridad());
				aux.acolarPrioridad(c1.primero(), c1.prioridad());
			}
			c1.desacolar();
			c2.desacolar();
		}
		if(!c1.colaVacia()){
			while(!c1.colaVacia()){
				aux.acolarPrioridad(c1.primero(), c1.prioridad());
				c1.desacolar();
			}
		}
		if(!c2.colaVacia()){
			while(!c2.colaVacia()){
				aux.acolarPrioridad(c2.primero(), c2.prioridad());
				c2.desacolar();
			}
		}
		
		while(!aux.colaVacia()){
			System.out.println("Cola generada , valor: "+aux.primero() +", prioridad : "+aux.prioridad());
			aux.desacolar();
		}
	}

	public boolean colasIdenticas(ColaPrioridadTDA c1, ColaPrioridadTDA c2) {
		while (!c1.colaVacia() && !c2.colaVacia()) {
			if(c1.primero() != c2.primero()){
				return false;
			}
			c1.desacolar();
			c2.desacolar();
		}
		return true;		
	}
	
	public void colasIdenticasPromedio(ColaPrioridadTDA c1){
		DiccionarioMultipleTDA d = new DiccionarioMultiple();
		int claveConjunto;
		ConjuntoTDA c=new Conjuntos() ;
		c.inicializarConjunto () ;
		ColaPrioridadTDA aux = new ColaPrioridad();
		while(!c1.colaVacia()){
			d.agregar(c1.primero(),c1.prioridad());
		}
		c = d.claves();
		while(!c.conjuntoVacio()){
			claveConjunto = c.elegir();
			c.sacar(claveConjunto);
			aux.acolarPrioridad(claveConjunto,obtenerPromedioValorDicccionario(claveConjunto,d));
		}
	}

	private int obtenerPromedioValorDicccionario(int claveConjunto, DiccionarioMultipleTDA d) {
		ConjuntoTDA c=new Conjuntos() ;
		c.inicializarConjunto () ;
		int valor = 0,cantidad  = 0;
		c = d.recuperar(claveConjunto);
		while(!c.conjuntoVacio()){
			valor = valor + c.elegir();
			c.sacar(valor);
			cantidad++;
		}
		return valor/cantidad;
	}
}
