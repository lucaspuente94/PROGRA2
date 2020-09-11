//package parcial;
//
//import implementacion.dinamica.ABB;
//import implementacion.dinamica.GrafoDinamico;
//import implementacion.estatica.ColaPrioridad;
//import implementacion.estatica.Pila;
//import util.ArbolUtil;
//import util.GrafoUtil;
//import apis.AbbTDA;
//import apis.ColaPrioridadTDA;
//import apis.ColaTDA;
//import apis.ConjuntoTDA;
//import apis.GrafoTDA;
//import apis.PilaTDA;
//
//public class parcialArbolgrafo {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//
//		AbbTDA arbol = new ABB();
//		arbol.inicizalizarAbbd();
//
//		arbol.agregar(2);
//		arbol.agregar(7);
//		arbol.agregar(1);
//		
//		GrafoTDA grafo = new GrafoDinamico();
//
//		grafo.inicializarGrafo();
//		grafo.agregarVertice(1);
//		grafo.agregarVertice(7);
//		grafo.agregarVertice(2);
//		
//		grafo.agregarArista(1, 7, 1);
//		grafo.agregarArista(7, 2, 2);
//		grafo.agregarArista(2, 1, 3);
//		
//		/**
//		 * ) Escribir un algoritmo que reciba un TDAGrafo y un ABBTDA y verifique que
//			para cada nodo del grafo que existe como valor en el árbol la diferencia entre el
//			peso de las aristas entrantes menos el peso las aristas salientes sea igual a la
//			sumatoria de los valores del hijo izquierdo menos la sumatoria de los valores
//			del hijo derecho del valor del nodo en el arbol.
//		 */
//		obtenerDiferenciaArbolNodo(grafo,arbol);
//		
//		
//	}
//	//precondicion el arbol y el grafo tienen los mismso valores
//	private static void obtenerDiferenciaArbolNodo(GrafoTDA grafo, AbbTDA arbol) {
//		ArbolUtil util = new ArbolUtil();
//		GrafoUtil utilGrafo = new GrafoUtil();
//		ConjuntoTDA vertices = grafo.vertices();
//		int aristaEntrante,aristaSaliente,verticeIn,salidaArbol;
//		while(!vertices.conjuntoVacio()){
//			verticeIn = vertices.elegir();
//			vertices.sacar(verticeIn);
//			aristaEntrante = utilGrafo.aristasEntrantesPorVerticeValor(grafo, verticeIn);
//			aristaSaliente = utilGrafo.aristasSalientesPorVerticeValor(grafo, verticeIn);
//			salidaArbol = util.buscarDiferenciaHijoDerIz(arbol,verticeIn);
//			if(salidaArbol == aristaEntrante-aristaSaliente){
//				System.out.println("el V "+verticeIn + " cumple con lo solicitado");
//			}else{
//				System.out.println("el V "+verticeIn + " no cumple con lo solicitado");
//			}
//		}
//		
//		
//	}
//	
//
//	
//
//
//
//
//
//
//
////B
//
//
//public void ordenarPila(PilaTDA a ){
//	ColaPrioridadTDA colaPri = new ColaPrioridad();
//	while(!a.pilaVacia()){
//		colaPri.acolarPrioridad(a.tope(), a.tope());
//		a.desapilar();
//	}
//	while(!colaPri.colaVacia()){
//		a.apilar(colaPri.primero());
//		colaPri.desacolar();
//	}
//}
//
//
//
//
//
//
//
////A
//public void puntoA(ABB a){
//	PilaTDA pila = new Pila();
//	ColaPrioridadTDA colaPri = new ColaPrioridad();
//	colaPri.inicializarColaPrioridad();
//	pila.inicializarPila();
//	int menor = 0;
//	int minimo  = obtenerMenorminimo(a,menor);
//	colaPri = agregarValoresMinmosArbol(a,minimo,colaPri);
//	while(!colaPri.colaVacia()){
//		pila.apilar(colaPri.primero());
//		colaPri.desacolar();
//	}
//}
//private ColaPrioridadTDA agregarValoresMinmosArbol(ABB a,int minimo,ColaPrioridadTDA colaPri) {
//	
//	if(a.arbolVacio()){
//		return colaPri;
//	}
//	if(altura(a.raiz()) == minimo){
//		colaPri.acolarPrioridad(a.raiz(), a.raiz());
//	}
//	agregarValoresMinmosArbol(a.hijoDer(),minimo,colaPri);
//	agregarValoresMinmosArbol(a.hijoizq(),minimo,colaPri);
//}
//
//private int obtenerMenorminimo(ABB a,int menor) {
//	if(a.arbolVacio()){
//		return 0;
//	}
//	if(minimoAltura(a)<menor){
//		menor = minimoAltura(a.raiz());
//		menor = obtenerMenorminimo(a.hijoDer(),menor);
//		menor = obtenerMenorminimo(a.hijoizq(),menor);
//	}
//		return menor;		
//}
// private int minimoAltura(AbbTDA a ){
//	return altura(a.hijoDer()()) - altura(a.hijoizq());
// }
//
//public int altura(AbbTDA a){
//	if(a.arbolVacio()){
//		return 0;
//	}else{
//		int alturaDer = altura(a.hijoDer());
//		int alturaIzq = altura(a.hijoizq());
//		if(alturaDer> alturaIzq){
//			return alturaDer +1;
//		}else{
//			return alturaIzq +1;
//		}
//	}
//}
//
//
//
//}
