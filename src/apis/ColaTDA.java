package apis;

//Nos permite agregar almacenar valores, eliminarlos y recuperarlos.
//Es muy similar a la pila, con la unica diferencia es como guardar o recuperan los datos. Simpre va a ser el primer valor ingresado.
public interface ColaTDA {
	
	 //No posee ninguna precondicion, ya que esta operaci�n va a inicializar la cola.
	 void incializarCola();
	 
	 //La precondici�n de esta operaci�n es que la cola tiene que estar inicializada. Ademas tener algun valor para poder enviarle como parametro(en este caso un entero).
	 //Permite agregar elemenos nuevos a la cola.
	 void acolar(int x);
	 
	 //La precondici�n de esta operaci�n es que la cola tiene que estar inicializada.
	 //Permite eliminar el primer registro ingresado en la cola.
	 void desacolar();
	 
	 //La precondicion de esta operaci�n es que la cola tiene que estar inicializada y que no este vacia.
	 //Muestra el primer elemento ingresado.
	 int tope();
	 
	 //La precondici�n de esta operaci�n es que la cola tiene que estar inicializada.
	 //Verifica si la cola esta vacia o no. Retorna un valor booleano
	 boolean colaVacia();
}
