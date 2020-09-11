package util;

public class Recursividad {
	public class PracticaRecursividad {

		void mostrar(int inicio, int fin) {

			if (inicio <= fin)
			{
				System.out.println(inicio);
				mostrar(inicio + 1, fin);
			}

		}

		void inversa(int inicio, int fin) {

			if (inicio <= fin)

			{
				System.out.println(fin);

				mostrar(inicio, fin - 1);

			}

		}

		void mostrarVector(int[] vector, int inicio, int fin) {

			if (inicio <= fin)

			{

				System.out.println(vector[inicio]);

				mostrarVector(vector, inicio + 1, fin);

			}

		}

		int sumar(int[] vector, int inicio, int fin) {

			if (inicio <= fin) {

				return vector[inicio] + sumar(vector, inicio + 1, fin);

			} else {

				return 0;

			}

		}

		int minimo(int[] vector, int inicio, int fin) {

			if (inicio == fin) {

				return vector[inicio];

			} else {

				int minRestante = minimo(vector, inicio + 1, fin);

				if (vector[inicio] < minRestante) {

					return vector[inicio];

				} else {

					return minRestante;

				}

			}

		}

	}
}
