package mis.implementacionesParcial;

import apis.ConjuntoTDA;
import apis.GodioTDA;
import implementacion.estatica.Cola;
import implementacion.estatica.Conjuntos;
import implementacion.estatica.DiccionarioSimple;

public class GodioFINAL implements GodioTDA {

	class NodoAlumno{
		int libreta;
		NodoNota notas;
		NodoAlumno sigA;
	}
	class NodoNota{
		int nota;
		NodoNota sigN;
	}
	
	NodoAlumno alumno;
	
	@Override
	public void inicializar() {
		alumno = null;
	}

	@Override
	public void agregar(int libreta, int nota) {
		// TODO Auto-generated method stub
		NodoAlumno aux = alumno;
		obtenerPosicion(libreta,aux);
		//si es igual a null quiere decir que no existe la libreta
		if(aux == null) {
			NodoAlumno aux2 = new NodoAlumno();
			aux.notas.nota=nota;
			aux.libreta=libreta;
			aux.sigA=alumno;
			alumno=aux;
		}else {
			//en este caso la libreta existe y tengo que agregar el valor de la nota
			NodoNota nodoAux = new NodoNota();
			nodoAux.nota=nota;
			nodoAux.sigN=alumno.notas;
			alumno.notas = nodoAux;
		}
		
	}

	private void obtenerPosicion(int libreta, NodoAlumno aux) {
		while(aux != null && aux.libreta != libreta) {
			aux = aux.sigA;
		}
	}

	@Override
	public void eliminar(int libreta) {
		// TODO Auto-generated method stub
		NodoAlumno aux = alumno;
		if(aux.libreta==libreta) {
			aux = aux.sigA;
		}else{
			while(aux != null) {
				if(aux.sigA.libreta == libreta) {
					aux.sigA = aux.sigA.sigA;
				}
				aux = aux.sigA;
			}
		}
		
	}

	@Override
	public DiccionarioSimple promedio() {
		// TODO Auto-generated method stub
		ConjuntoTDA conjunto = recuperarClaves();
		DiccionarioSimple dicSimple = new DiccionarioSimple();
		dicSimple.inicializarDiccionarioMultiple();
		int valorClave;
		while(!conjunto.conjuntoVacio()) {
			valorClave = conjunto.elegir();
			conjunto.sacar(valorClave);
			//este diccionario tendria que aceptar float por eso lo dejo entero
			dicSimple.agregar(valorClave, obtenerPromedioAlumno(valorClave));
		}
		
		return dicSimple;
	}
	
	private int obtenerPromedioAlumno(int valorClave) {
		NodoAlumno aux = alumno;
		int nota=0,cant=0;
		while(aux != null && aux.libreta != valorClave) {
			aux = aux.sigA;
		}
		while(aux.notas != null) {
			nota = nota + aux.notas.nota;
			cant++;
		}
		return nota/cant;
	}

	//me trae las claves del diccionario multiple
	private ConjuntoTDA recuperarClaves() {
		// TODO Auto-generated method stub
		NodoAlumno aux = alumno;
		ConjuntoTDA conjunto = new Conjuntos();
		while(aux != null) {
			conjunto.agregar(aux.libreta);
			aux = aux.sigA;
		}
		return conjunto;
	}

	@Override
	public Cola notas(int libreta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean estaVacia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conjuntos aprobado() {
		ConjuntoTDA alumno = recuperarClaves();
		ConjuntoTDA aprobados = new Conjuntos();
		int persona;
		aprobados.inicializarConjunto();
		while(!alumno.conjuntoVacio()) {
			persona = alumno.elegir();
			alumno.sacar(persona);
			if(obtenerPromedioAlumno(persona)>=4) {
				aprobados.agregar(persona);
			}
		}
		return (Conjuntos) aprobados;
	}

}
