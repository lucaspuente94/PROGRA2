package apis;

//Permite almacenar datos con una clave asociada, que es única. Cada clave permite tener un conjunto valores asignados. A diferencia del simple, que permite un único valor.
public interface DiccionarioMultipleTDA {
	//Inicializa la esturctura del diccionario.
	void inicializarDiccionarioMultiple();
	
	//La precondicion que tiene este metodo, es que el diccionario este inicializado.
	//Agrega un nuevo elementos con su clave asociada. Si la clave ya existe, el elemento se pisa y queda el ultimo ingresado.
	void agregar(int c, int x);
	
	//La precondicion que tiene este metodo, es que el diccionario este inicializado.
	//Elimina todos los valores, determinados por su clave. Si la clave no existe, no hace nada.
	void eliminar(int c);
	
	//La precondicion que tiene este metodo, es que el diccionario este inicializado.
	//Dada una clave, devuelve el conjunto de valores asociados a esa clave.
	ConjuntoTDA recuperar(int c);
	
	//La precondicion que tiene este metodo, es que el diccionario este inicializado.
	//Dado una clave y un valor, se elimina el valor asociado. Pero si no existe ni la clave, ni le valor no hace nada.
	void eliminarValor(int c, int x);
	
	//La precondicion que tiene este metodo, es que el diccionario este inicializado.
	//devuelve todas la claves definidas dentro del conjunto.
	ConjuntoTDA claves();
}
