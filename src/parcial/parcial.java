package parcial;

import implementacion.dinamica.ABB;
import implementacion.estatica.Cola;
import implementacion.estatica.ColaPrioridad;
import implementacion.estatica.DiccionarioMultiple;
import implementacion.estatica.DiccionarioSimple;
import implementacion.estatica.Pila;
import util.ArbolUtil;
import apis.AbbTDA;
import apis.ColaPrioridadTDA;
import apis.ColaTDA;
import apis.ConjuntoTDA;
import apis.DiccionarioMultipleTDA;
import apis.DiccionarioSimpleTDA;
import apis.PilaTDA;

public class parcial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int fibonacci[] = {0,1,2,3,5,8,13};
		
		ArbolUtil util = new ArbolUtil();
		
		ColaPrioridadTDA cola = new ColaPrioridad();

		PilaTDA pila = new Pila();
		
		ColaTDA colaComun = new Cola();
		ColaTDA colaComunDos = new Cola();
		ColaPrioridadTDA colaPri = new ColaPrioridad();
		colaPri.inicializarColaPrioridad();
		colaPri.acolarPrioridad(1,6);
		colaPri.acolarPrioridad(1,2);
		colaPri.acolarPrioridad(2,5);
		colaPri.acolarPrioridad(2,7);
		
		ColaPrioridadTDA nuevaCola = new ColaPrioridad();
		nuevaCola.inicializarColaPrioridad();
		
		sacarRepetidos(colaPri,nuevaCola);
		

		DiccionarioSimpleTDA diccionario = new DiccionarioSimple();
		
		AbbTDA arbol = new ABB();
		
		pila.inicializarPila();
		colaComun.incializarCola();
		diccionario.inicializarDiccionarioMultiple();
		cola.inicializarColaPrioridad();
		arbol.inicizalizarAbbd();
		colaComunDos.incializarCola();
		
		
		colaComun.acolar(1);
		colaComun.acolar(2);
		colaComun.acolar(0);
		colaComun.acolar(3);
		colaComun.acolar(4);
		colaComun.acolar(0);
		colaComun.acolar(5);
		colaComun.acolar(6);
		
		agregarSecuenciaCola(colaComun,colaComunDos);
		mostrarCola(colaComunDos);
		
		
		//System.out.println("altura arbol:"+util.altura(arbol));

	}
	//recuperatorio saca el porcentaje de los valors repetidos ena una cola con prioridad
	private static void sacarRepetidos(ColaPrioridadTDA colaPri,ColaPrioridadTDA nuevaCola) {
		DiccionarioMultipleTDA dic = new DiccionarioMultiple();
		ConjuntoTDA conjuntoClaves,conjuntoClavesValores;
		int valor,valores=0,i=0,acum=0;
		dic.inicializarDiccionarioMultiple();
		while(!colaPri.colaVacia()){
			dic.agregar(colaPri.primero(),colaPri.prioridad());
			colaPri.desacolar();
		}
		conjuntoClaves = dic.claves();
		while(!conjuntoClaves.conjuntoVacio()){
			valor = conjuntoClaves.elegir();
			conjuntoClaves.sacar(valor);
			conjuntoClavesValores = dic.recuperar(valor);
			acum=0;
			i=0;
			while(!conjuntoClavesValores.conjuntoVacio()){
				valores = conjuntoClavesValores.elegir();
				conjuntoClavesValores.sacar(valores);
				acum = acum + valores;
				i++;
			}
			nuevaCola.acolarPrioridad(valor, acum/i);
		}
		while(!nuevaCola.colaVacia()){
			System.out.println("V" + nuevaCola.primero() + " P : " + nuevaCola.prioridad() );
			nuevaCola.desacolar();
		}
	}

	private static void agregarSecuenciaCola(ColaTDA colaComun,ColaTDA colaComunDos) {
		ColaTDA colaAux = new Cola();
		colaAux.incializarCola();
		while(!colaComun.colaVacia()){
			if(colaAux.tope() !=0){
				colaAux.acolar(colaAux.tope());
				colaComun.desacolar();
			}
		}
	}

	private static void mostrarCola(ColaTDA cola) {
		while(!cola.colaVacia()){
			System.out.println("valor cola :"+cola.tope());
			cola.desacolar();
		}
	}
	
	private static void mostrarPila(PilaTDA pila) {
		while(!pila.pilaVacia()){
			System.out.println("valor pila :"+pila.tope());
			pila.desapilar();
		}
	}
	
	private static void mostrarDicSimple(DiccionarioSimpleTDA dic){
		while(!dic.claves().conjuntoVacio()){
			int clave = dic.claves().elegir();
			System.out.println("valor dic simple :"+clave);
			dic.eliminar(clave);
		}
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
