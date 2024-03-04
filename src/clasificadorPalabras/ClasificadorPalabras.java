package clasificadorPalabras;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ClasificadorPalabras {	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Introducir texto: ");
		System.out.print("-> ");
		String texto = input.nextLine();
		// ¡Hola Pepe!, ¿Cómo estás?. Espero que estes bien y que estes feliz.
		
		Set<String> listaDePalabrasUnicas = new HashSet<>();
		texto = texto.replaceAll("\\p{Punct}","");
		texto = texto.replaceAll("[¡¿]", "");
		texto = texto.toLowerCase();
		String[] palabras = texto.split(" ");
		
		for(String palabra : palabras) {
			listaDePalabrasUnicas.add(palabra);
		}
		
		listaDePalabrasUnicas.forEach(s->System.out.println(s));	
		
		input.close();
	}
}
