package generadorNumerosAleatorios;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class GeneradorAleatorio {

	private static Random random = new Random();
	
	
	
	static public Integer[] generarNumerosUnicosOrdenados(int cantidad, int maximo) {
		Set<Integer> setNumeros = new TreeSet<>();
		while(setNumeros.size()<cantidad) {
			setNumeros.add(random.nextInt(maximo)+1);
		}
		
		Integer[] arrayNumeros = new Integer[cantidad];
		setNumeros.toArray(arrayNumeros);
		return arrayNumeros;	
	}
	
	
	public static void main(String[] args) {
		
		
		Integer[] arrayDeNumeros = generarNumerosUnicosOrdenados(10, 100);
	
		for(Integer numero : arrayDeNumeros) {
			System.out.print(numero + " ");
		}
	
		
	}
}
