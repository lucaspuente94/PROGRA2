package apis;

public interface AbbTDA {
	void inicizalizarAbbd();
	int raiz();
	AbbTDA hijoDer();
	AbbTDA hijoizq();
	void agregar(int x);
	void eliminar(int x);
	boolean arbolVacio();
}
