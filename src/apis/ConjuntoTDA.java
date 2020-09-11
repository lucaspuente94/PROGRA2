package apis;

//Permite almacenar datos sin que los mismos se repitan, y no tienen un orden. Tambien te permite conocer si el elemento se encuentra o perteneces al conjunto.
//Para poder recuperar un dato, al no tener un orden nos devuelve uno cualquiera perteneciente al conjunto. Y para eliminar uno, tenemos que indicarle cual.
public interface ConjuntoTDA {
	
	//No posee ninguna precondicion, ya que esta operación va a inicializar el conjunto.
	void inicializarConjunto();
	
	//La precondición de esta operación es que el conjunto tiene que estar inicializado.
	//Nos permite agregar un nuevo elemento al conjunto.
	void agregar(int x);
	
	//La precondición de esta operación es que el conjunto tiene que estar inicializado.Y que no este vacio.
	//Nos permite eliminar un elemento indicado por el parametro.
	void sacar(int x);
	
	//La precondición de esta operación es que el conjunto tiene que estar inicializado.Y que no este vacio.
	//Nos retorna un elemento cualquiera perteneciente al conjunto.
	int elegir();
	
	//La precondición de esta operación es que el conjunto tiene que estar inicializado.
	//Verifica si el conjunto esta vacia o no. Retorna un valor booleano
	boolean conjuntoVacio();
	
	//La precondición de esta operación es que el conjunto tiene que estar inicializado.
	//Permite saber si el elemento existe en el conjunto.
	boolean pertenece(int x);	
}
