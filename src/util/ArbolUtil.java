package util;

import implementacion.dinamica.ABB;
import apis.AbbTDA;
import apis.ColaPrioridadTDA;
import apis.ColaTDA;
import apis.DiccionarioSimpleTDA;

public class ArbolUtil {
	
	/****************************************************/

	public void mostrarOrdenado (AbbTDA arbol){
		if(!arbol.arbolVacio()){
			mostrarOrdenado(arbol.hijoizq());
			System.out.println(arbol.raiz());
			mostrarOrdenado(arbol.hijoDer());
		}
	}
	/****************************************************/

	public void mostrarPreOrden(AbbTDA arbol){
		if(!arbol.arbolVacio()){
			System.out.println(arbol.raiz());
			mostrarPreOrden(arbol.hijoizq());
			mostrarPreOrden(arbol.hijoDer());
		}

	}
	
	/****************************************************/

	public void mostrarPostOrden(AbbTDA arbol){
		if(!arbol.arbolVacio()){
			mostrarPostOrden(arbol.hijoizq());
			mostrarPostOrden(arbol.hijoDer());
			System.out.println(arbol.raiz());
		}
	}
	
	/****************************************************/

	
	public int elementosMismoNivel(AbbTDA arbol, int nivel){
		if(arbol.arbolVacio()){
			return 0;
		}else{
			if(nivel == 0){
				return 1;
			}else
				return elementosMismoNivel(arbol.hijoizq(),nivel-1) + elementosMismoNivel(arbol.hijoDer(),nivel-1);
		}
	}
	
	/****************************************************/

public int encontrarValorArbol(AbbTDA arbol,int valor){
	if(!arbol.arbolVacio()){
		if(arbol.raiz()>valor){
			return encontrarValorArbol(arbol.hijoizq(),valor);
		}else{
			if(arbol.raiz()<valor)
				return encontrarValorArbol(arbol.hijoDer(),valor);
			else
				return 1;
		}
	}
	return 0;
}
	

/****************************************************/
	public int cantidadElementos(AbbTDA arbol){
		AbbTDA a = new ABB();
		if(!a.arbolVacio()){
			return 1 + cantElem(a.hijoizq()) +cantElem(a.hijoDer());
		}
		return 0;
	}
	
	private int cantElem(AbbTDA a) {
		if(a.arbolVacio()){
			return 0;
		}else{
			if(a.hijoizq().arbolVacio() && a.hijoDer().arbolVacio()){
				// si es hojas, o sea esta solo
				return 1;
			} else {
				return cantElem(a.hijoizq()) + cantElem(a.hijoDer());
			}
		}
	}
	/****************************************************/

	private int AcumImparesElem(AbbTDA a) {
		if(a.arbolVacio()){
			return 0;
		}else{
			if(a.raiz()%2 == 1){
				return a.raiz() + AcumImparesElem(a.hijoizq()) + AcumImparesElem(a.hijoDer());
			}else{
				return AcumImparesElem(a.hijoizq()) + AcumImparesElem(a.hijoDer());
			}
		}
	}
	/****************************************************/

	private int cantElemTotal(AbbTDA a) {
		if(a.arbolVacio()){
			return 0;
		}
		return 1 + cantElemTotal(a.hijoizq()) + cantElemTotal(a.hijoDer());
	}


	/****************************************************/

	public int minimo(AbbTDA a) {
		if (a.hijoizq().arbolVacio()) {
			return a.raiz();
		} else if (a.hijoizq().arbolVacio() && a.hijoDer().arbolVacio()) {
			return a.raiz();
		} else {
			return minimo(a.hijoizq());
		}
	}
	/****************************************************/

	public int profundidad(AbbTDA a, int dato) {
		if (a.raiz() == dato) {
			return 0;
			// si el dato es mayot va a estar en el lado derecho del arbol
		} else if (a.raiz() < dato) {
			return 1 + profundidad(a.hijoDer(), dato);
		} else {
			// si es menor va a estar a la izq
			return 1 + profundidad(a.hijoizq(), dato);
		}
	}
	
	/****************************************************/

	public int altura(AbbTDA a){
		if(a.arbolVacio()){
			return 0;
		}else{
			int alturaDer = altura(a.hijoDer());
			int alturaIzq = altura(a.hijoizq());
			if(alturaDer> alturaIzq){
				return alturaDer +1;
			}else{
				return alturaIzq +1;
			}
		}
	}
	
	
	public int altura2(AbbTDA arbol){
        if(arbol.arbolVacio()){
            return 0;
        }else if(!arbol.hijoDer().arbolVacio() || !arbol.hijoizq().arbolVacio()){
            int alturaDer = altura(arbol.hijoDer());
            int alturaIzq = altura(arbol.hijoizq());
            if(alturaDer > alturaIzq){
                return alturaDer +1;
            }else{
                return alturaIzq +1;
            }
        } else {
        	return 0;
        }
    }
	

	/****************************************************/

	public int cantHojas(AbbTDA arbol) {
		if(arbol.arbolVacio()){
			return 0;
		}else{
			if(arbol.hijoDer().arbolVacio() && arbol.hijoDer().arbolVacio()){
				return 1;
			}else{
				return cantHojas(arbol.hijoDer()) + cantHojas(arbol.hijoizq());
			}
		}
	}
	public boolean arbolIgual(AbbTDA arbol, AbbTDA arbol2) {
		if(arbol.arbolVacio() && arbol2.arbolVacio()){
			return true;
		}else{
			if(arbol.raiz() == arbol2.raiz()){
				if(arbolIgual(arbol.hijoDer(),arbol2.hijoDer())){
					return  arbolIgual(arbol.hijoizq(),arbol2.hijoizq());
				}else
					return false;
			}else{
				return false;
			}
		}
	}
/*******************************************************
 * 
 */
	//cuando queres el arbol igual
	public   void agregarpreorden(AbbTDA B, AbbTDA A) {
        if (!A.arbolVacio()) {
            B.agregar(A.raiz());
            agregarpreorden(B, A.hijoizq());            
            agregarpreorden(B, A.hijoDer());
        }
    }

	/*******************************************************
	 * 
	 */
	public void agregarPostOrden(AbbTDA arbolB,AbbTDA arbolA){
		if(!arbolA.arbolVacio()){
			agregarPostOrden(arbolB,arbolA.hijoizq());
			agregarPostOrden(arbolB,arbolA.hijoDer());
			arbolB.agregar(arbolA.raiz());
		}
	}

    ////////////////////////////////////////////
    public void rotar(AbbTDA B, AbbTDA A) {
        if (!A.hijoDer().arbolVacio()) {
            B.agregar(A.hijoDer().raiz());
            B.agregar(A.raiz());
            agregarpreorden(B, A.hijoizq());
            agregarpreorden(B, A.hijoDer().hijoizq());
            agregarpreorden(B, A.hijoDer().hijoDer());
            
        }
    }

    
    /**
     * 
     * Preorden: (raíz, izquierdo, derecho). Para recorrer un árbol binario no vacío en preorden, hay que realizar las siguientes operaciones recursivamente en cada nodo, comenzando con el nodo de raíz:
Visite la raíz
Atraviese el sub-árbol izquierdo
Atraviese el sub-árbol derecho



	Inorden: (izquierdo, raíz, derecho). Para recorrer un árbol binario no vacío en inorden (simétrico), hay que realizar las siguientes operaciones recursivamente en cada nodo:
Atraviese el sub-árbol izquierdo
Visite la raíz
Atraviese el sub-árbol derecho


	
	Postorden: (izquierdo, derecho, raíz). Para recorrer un árbol binario no vacío en postorden, hay que realizar las siguientes operaciones recursivamente en cada nodo:
Atraviese el sub-árbol izquierdo
Atraviese el sub-árbol derecho
Visite la raíz
     * @param arbol
     * @return
     */
    
    public int cantPares(AbbTDA arbol){
    	if(!arbol.arbolVacio()){
    		if(arbol.raiz()%2==0){
    			return 1 + cantPares(arbol.hijoizq()) + cantPares(arbol.hijoDer());
    		}else{
    			return 0 + cantPares(arbol.hijoizq()) + cantPares(arbol.hijoDer());
    		}
    	}
    	return 0;
    }
    
    public int cantInPares(AbbTDA arbol){
    	if(!arbol.arbolVacio()){
    		if(arbol.raiz()%2==1){
    			return 1 + cantInPares(arbol.hijoizq()) + cantInPares(arbol.hijoDer());
    		}else{
    			return 0 + cantInPares(arbol.hijoizq()) + cantInPares(arbol.hijoDer());
    		}
    	}
    	return 0;
    }

	///****************************************************
    public int valorMinimo(AbbTDA arbol){
    	int valor = 0;
    	
    	if(!arbol.arbolVacio()){
    		valor = arbol.raiz();
    		valor = obtenerMinimo(arbol.hijoizq(),valor);
    		valor = obtenerMinimo(arbol.hijoDer(), valor);
    	}
    	return valor;
    }
	private int obtenerMinimo(AbbTDA arbol, int valor) {
		if(!arbol.arbolVacio()){
			if(valor>arbol.raiz()){
				valor = arbol.raiz();
				return obtenerMinimo(arbol.hijoizq(),valor);
			}else{
				return obtenerMinimo(arbol.hijoDer(),valor);
			}
		}
		return valor;
	}
	
	///****************************************************
	public int valorMax(AbbTDA arbol){
    	int valor = 0;
    	if(!arbol.arbolVacio()){
    		valor = arbol.raiz();
    		valor = obtenerMax(arbol.hijoizq(),valor);
    		valor = obtenerMax(arbol.hijoDer(), valor);
    	}
    	return valor;
    }
	private int obtenerMax(AbbTDA arbol, int valor) {
		if(!arbol.arbolVacio()){
			if(valor<arbol.raiz()){
				valor = arbol.raiz();
				return obtenerMax(arbol.hijoDer(),valor);
			}else{
				return obtenerMax(arbol.hijoizq(),valor);
			}
		}
		return valor;
	}
	
	
	///**************************************************** VALORES POR NIVEL
	private static void agregarValoresAcolaComun(AbbTDA arbol,ColaTDA cola, int nivel) {
		if(!arbol.arbolVacio()){
			if(nivel != 0){
				elementosMismoNivel(arbol.hijoizq(),cola,nivel-1);
				elementosMismoNivel(arbol.hijoDer(),cola,nivel-1);
			}else{
				cola.acolar(arbol.raiz());
			}
		}
	}

	public static void elementosMismoNivel(AbbTDA arbol,ColaTDA cola,int nivel){
		if(!arbol.arbolVacio()){
			if(nivel == 0){
				cola.acolar(arbol.raiz());
			}else
			 elementosMismoNivel(arbol.hijoizq(),cola,nivel-1);
			 elementosMismoNivel(arbol.hijoDer(),cola,nivel-1);
		}
	}
	
	///****************************************************
	
	private static void esfibonacci(AbbTDA arbol, int[] fibonacci) {
		if(!arbol.arbolVacio()){
			perteneceAFibonacci(arbol, fibonacci);
			esfibonacci(arbol.hijoizq(), fibonacci);
			esfibonacci(arbol.hijoDer(), fibonacci);
		}
	}


	private static void perteneceAFibonacci(AbbTDA arbol, int[] fibonacci) {
		for (int i = 0; i < fibonacci.length; i++) {
			if(arbol.raiz() == fibonacci[i]){
				System.out.println(arbol.raiz() +" es finobacci");
			}
		}
	}

	///****************************************************

//del parcial de prueba
	private void cargarDiccionarioSimple(DiccionarioSimpleTDA diccionario, AbbTDA arbol) {
		if(!arbol.arbolVacio()){
			diccionario.agregar(arbol.raiz(), obtenerDiferencia(arbol));
			cargarDiccionarioSimple(diccionario,arbol.hijoizq());
			cargarDiccionarioSimple(diccionario,arbol.hijoDer());
		}
	}
	
	///****************************************************

	private  ColaPrioridadTDA agregarVaolresCola(AbbTDA arbol, ColaPrioridadTDA cola) {
		if(!arbol.arbolVacio()){
			cola.acolarPrioridad(obtenerDiferencia(arbol),arbol.raiz());
			agregarVaolresCola(arbol.hijoizq(), cola);
			agregarVaolresCola(arbol.hijoDer(), cola);
		}
		return cola;
	}
	///****************************************************

	private int obtenerDiferencia(AbbTDA arbol) {
		return altura(arbol.hijoizq()) - altura(arbol.hijoDer());
	}
	///****************************************************


	public int diferenciaAltura(AbbTDA a) {
		if(a.hijoizq().arbolVacio()&&a.hijoDer().arbolVacio())
			return 0;
		if(!a.hijoizq().arbolVacio()&&a.hijoDer().arbolVacio())
			return 1+(this.altura(a.hijoizq()));
		if(!a.hijoDer().arbolVacio()&&a.hijoizq().arbolVacio())
			return 1+(this.altura(a.hijoDer()));
		int alturaI=this.altura(a.hijoizq());
		int alturaD=this.altura(a.hijoDer());
		if(alturaI>alturaD) {
			return (alturaI-alturaD);
		}else
			return(alturaD-alturaI);
	}
	
	
	
	///***************************************************
	
	public void ancestros(AbbTDA arbol, ColaTDA colaComun, int valor) {
		if(!arbol.arbolVacio()){
			if(arbol.raiz()<valor){
				colaComun.acolar(arbol.raiz());
				ancestros(arbol.hijoDer(), colaComun,valor);
			}else if(arbol.raiz()>valor){
				colaComun.acolar(arbol.raiz());
				ancestros(arbol.hijoDer(),colaComun,valor);
			}
		}
	}
	

	/**
	 * 
	 * 
	 * 
	 */
	public int buscarNivelArvol(AbbTDA arbol, int valor) {
		if(!arbol.arbolVacio()){
			if(valor == arbol.raiz()){
				return 0;
			}else if(valor<arbol.hijoDer().raiz()){
				return 1 + buscarNivelArvol(arbol.hijoizq(), valor);
			}else{
			return 1+ buscarNivelArvol(arbol.hijoDer(), valor);
			}
		}
		return 0;
}
	

	/**
	 * 
	 * 
	 * 
	 */
	public void generarNuevoArbol(AbbTDA arbol) {
		AbbTDA arbolNuevo = new ABB();
		arbolNuevo.inicizalizarAbbd();
		if(!arbol.arbolVacio()){
			arbolNuevo.agregar(arbol.raiz());
			arbolNuevo.hijoizq().agregar(arbol.hijoizq().hijoDer().raiz());
			agregarpreorden(arbolNuevo, arbol);
			agregarpreorden(arbolNuevo.hijoizq(), arbol);
			agregarpreorden(arbolNuevo.hijoDer(), arbol);
			
		}
	}
	
	/**
	 * 
	 * obtener el valor anterior del arbol
	 * 
	 */
	
	
	public int valorAnterior(AbbTDA a , int v){
		if(a.raiz()<v){
			if(a.hijoDer().raiz() == v){
				return a.raiz();
			}else{
				return valorAnterior(a.hijoDer(), v);
			}
		}else{
			if(a.hijoizq().raiz() == v){
				return a.raiz();
			}else{
				return valorAnterior(a.hijoizq(), v);
			}
		}
	}
	
	
	
	public int buscarDiferenciaHijoDerIz(AbbTDA arbol, int verticeIn) {
		if(!arbol.arbolVacio()){
			if(arbol.raiz()==verticeIn){
				return diferenciaAlturaValor(arbol);	
			}else if(arbol.raiz()<verticeIn){
				buscarDiferenciaHijoDerIz(arbol.hijoDer(), verticeIn);
			}else{
				buscarDiferenciaHijoDerIz(arbol.hijoizq(), verticeIn);
			}
		}
		return 0;
	}
	
	/*
	 * 
	 */
	
	public int diferenciaAlturaValor(AbbTDA a) {
		int alturaI=this.sumatoriaNodosHijos(a.hijoizq());
		int alturaD=this.sumatoriaNodosHijos(a.hijoDer());
		return alturaD-alturaI;
	}
	
	public int sumatoriaNodosHijos(AbbTDA a){
		if(a.arbolVacio()){
			return 0;
		}else{
			return a.raiz() + sumatoriaNodosHijos(a.hijoDer()) + sumatoriaNodosHijos(a.hijoizq());
		}
	}
	

}
	
	
	
