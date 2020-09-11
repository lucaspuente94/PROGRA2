package apis;
//Permite almacenar datos con una clave asociada, que es única. Cada clave permite tener un único valor asignado.
public interface DiccionarioSimpleTDA {
	
	//Inicializa la esturctura del diccionario.
	void inicializarDiccionarioMultiple();
	
	//La precondicion que tiene este metodo, es que el diccionario este inicializado.
	//Agrega un nuevo elementos con su clave asociada. Si la clave ya existe, el elemento se pisa y queda el ultimo ingresado.
	void agregar(int c, int x);
	
	//La precondicion que tiene este metodo, es que el diccionario este inicializado y la clave exista.
	//Elimina un valor, determinado por su clave. Si la clave no existe, no hace nada.
	void eliminar(int c);
	
	//La precondicion que tiene este metodo, es que el diccionario este inicializado.
	//Dada una clave, devuelve el valor asociado a esa clave.
	int recuperar(int c);
	
	//La precondicion que tiene este metodo, es que el diccionario este inicializado.
	//devuelve todas la claves definidas dentro del conjunto.
	ConjuntoTDA claves();
}
