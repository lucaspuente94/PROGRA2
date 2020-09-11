package apis;
//A diferencia de cola, esta estructura nos permite almacenar, eliminar o recuperar datos segun la prioridad que nosotros le demos. Cada valor agregado en la cola, va a tenen asociado una prioridad.
public interface ColaPrioridadTDA {
	
	//No posee ninguna precondicion, ya que esta operación va a inicializar la cola.
	 void inicializarColaPrioridad();
	 
	 //La precondición de esta operación es que la cola tiene que estar inicializada. Ademas tener algun valor para poder enviarle como parametro(en este caso un entero), y tambien asignarle la prioridad.
	 //Agregar un elemento nuevo a la cola, con su prioridad.
	 void acolarPrioridad(int x,int p);
	 
	 //La precondición de esta operación es que la cola tiene que estar inicializada. Y no este vacia.
	 //Elimina el valor con maxima prioridad ingresado. En caso de que la prioridad este repetida, nos devuelve el primero ingresado.
	 void desacolar();
	 
		
	 //La precondición de esta operación es que la cola tiene que estar inicializada. Y no este vacia.
	 //Nos retorna el valor con maxima prioridad ingresado. En caso de que la prioridad este repetida, nos devuelve el primero ingresado.
	 int primero();
	 
	 //La precondición de esta operación es que la cola tiene que estar inicializada. Y no este vacia.
	 //Nos informa cual es el elemento con mayor prioridad de la cola.
	 int prioridad();
	 
	 //La precondición de esta operación es que la cola tiene que estar inicializada.
	 //Verifica si la cola esta vacia o no. Retorna un valor booleano
	 boolean colaVacia();
}
