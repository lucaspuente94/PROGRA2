package apis;

import implementacion.estatica.Cola;
import implementacion.estatica.Conjuntos;
import implementacion.estatica.DiccionarioSimple;

public interface GodioTDA {

	void inicializar();
	/*
	 * Tiene que estar iniizalizada
	 */
	void agregar(int libreta,int nota);
	/*
	 * tiene que exisistir la estructura
	 */
	void eliminar(int libreta);
	/*
	 * tiene que estar inicializada y tiene que tener datos
	 */
	DiccionarioSimple promedio();
	/*
	 * idem anterior
	 */
	Cola notas(int libreta);
	/*
	 * inicializada
	 */
	Boolean estaVacia();
	
	Conjuntos aprobado();
}
