package app;

import util.ArbolUtil;
import implementacion.dinamica.ABB;
import apis.AbbTDA;

public class ArbolApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AbbTDA arbol = new ABB();
		AbbTDA arbol2 = new ABB();
		arbol2.inicizalizarAbbd();
		arbol.inicizalizarAbbd();
		ArbolUtil util = new ArbolUtil();
		arbol.agregar(10);
		arbol.agregar(22);
		arbol.agregar(2);
		arbol.agregar(88);
		arbol.agregar(17);
		arbol.agregar(27);
		arbol.agregar(9);
		
		arbol2.agregar(10);
		arbol2.agregar(22);
		arbol2.agregar(2);
		arbol2.agregar(88);
		arbol2.agregar(17);
		arbol2.agregar(27);
		arbol.agregar(9);
		
		
	 int a = util.valorAnterior(arbol,27);
		System.out.println(a);
//		
//		arbol2.agregar(10);
//		arbol2.agregar(22);
//		arbol2.agregar(2);
//		arbol2.agregar(5);
//		arbol2.agregar(17);
//		arbol2.agregar(27);
//		arbol2.agregar(9);
		
//		System.out.println("ordenado : ");
//		util.mostrarOrdenado(arbol);
//		System.out.println("posrOrden : ");
//		//izq-der-raiz
//		util.mostrarPostOrden(arbol);
//		System.out.println("pre orden : ");
//		//raiz, izq,derecho
//		util.mostrarPreOrden(arbol);
//		
		//determinar si esta un elemento en el arbol
//		if(util.encontrarValorArbol(arbol, 10) == 1){
//			System.out.println("existe");
//		}else{
//			System.out.println("no existe");
//		}
		
		//determinar si esta un elemento en el arbol
//		if(util.encontrarValorArbol(arbol, 10) == 1){
//			System.out.println("existe");
//		}else{
//			System.out.println("no existe");
//		}
		
		//determinar si esta un elemento en el arbol
//		if(util.encontrarValorArbol(arbol, 10) == 1){
//			System.out.println("existe");
//		}else{
//			System.out.println("no existe");
//		}
		
		
		//determinar cant de elementos en mismi nivel
//		int nivel = 3;
//		System.out.println("Cant de arbol en el nivel "+nivel+" es : "+util.elementosMismoNivel(arbol,nivel));
//
		//determinar cant de hojass
//		System.out.println("Cant de hojas de un arbol es : "+util.cantHojas(arbol));
		
		//determinar si son iguales los arboles
//		if(util.arbolIgual(arbol,arbol2)){
//			System.out.println("los arboles son iguales");
//		}else{
//			System.out.println("los arboles NO son iguales");
//		}

		//System.out.println(util.buscarNivelArvol(arbol,5));
	}

}
