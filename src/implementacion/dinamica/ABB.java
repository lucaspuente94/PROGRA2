package implementacion.dinamica;

import apis.AbbTDA;

public class ABB implements AbbTDA {

	class Nodo {
		int valor;
		AbbTDA der, izq;
	}

	Nodo r;

	public void agregar(int x) {
		// TODO Auto-generated method stub
		if(arbolVacio()){
			r = new Nodo(); // si esta vacio lo creas
			r.valor = x; // le agrego el valor
			r.der = new ABB();
			r.der.inicizalizarAbbd();
			r.izq = new ABB();
			r.izq.inicizalizarAbbd();
		}else if(x <raiz()){
			r.izq.agregar(x); // si es menor va al arbol izq y se agrega
		}else{
			r.der.agregar(x); // sin olo contrario se agrega a der
		}
	}

	public void eliminar(int x) {
		if (!this.arbolVacio()) {
			if (r.valor == x) {// encontro valor
				if (r.der == null && r.izq == null) {// es hoja
					r = null;// elimina valor
				} else {// no es hoja
					if (!r.der.arbolVacio()) {
						int a = minimo(r.der);
						r.valor = a;
						r.der.eliminar(a);
					} else {
						int a = maximo(r.izq);
						r.valor = a;
						r.izq.eliminar(a);
					}

				}
			} else {
				if (r.valor > x) {
					r.der.eliminar(x);
				} else {
					r.izq.eliminar(x);

				}
			}

		}

	}

	public void inicizalizarAbbd() {
		r = null;
	}

	public int raiz() {
		return r.valor;
	}

	public AbbTDA hijoDer() {
		return r.der;
	}

	public AbbTDA hijoizq() {
		return r.izq;
	}

	public boolean arbolVacio() {
		return r == null;
	}

	
	private int minimo(AbbTDA a) {
		if (a.hijoizq().arbolVacio())
			return a.raiz();
		else
			return minimo(a.hijoizq());
	}

	private int maximo(AbbTDA a) {
		if (a.hijoDer().arbolVacio())
			return a.raiz();
		else
			return maximo(a.hijoDer());
	}
}
