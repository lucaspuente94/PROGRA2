package apis;
//Apila conjuntos de valores, elimina y recupera.
//La condición que posee es que para recuperarlo o eliminarlo, va a ser el último que se ingreso.
public interface PilaTDA {
	//No posee ninguna precondicion, ya que esta operación va a inicializar la pila.
	void inicializarPila();
	
	//La precondicion de esta operación es que la pila tiene que estar inicializada. Ademas tener algun valor para poder enviarle como parametro(en este caso un entero).
	//Permite agregar elemenos nuevos a la una pila.
	void apilar(int x);
	
	//La precondicion de esta operación es que la pila tiene que estar inicializada.
	//Elimina el ultimo elemento ingresado en la pila.
	void desapilar();
	
	
	//La precondicion de esta operación es que la pila tiene que estar inicializada y que no este vacia.
	//Muestra el ultimo elemento ingresado.
	int tope();
	
	//La precondicion de esta operación es que la pila tiene que estar inicializada.
	//Verifica si la pila esta vacia o no. Retorna un valor booleano
	boolean pilaVacia();
}
