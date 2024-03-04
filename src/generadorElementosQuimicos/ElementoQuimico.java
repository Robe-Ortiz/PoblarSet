package generadorElementosQuimicos;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ElementoQuimico {

	private String letra;
	private String nombre;
	private int numeroAtomico;
	private static Random random = new Random();
	private enum Orden{DIRECTO,INVERSO;};
	private enum PropiedadParaOrdenar{LETRA,NOMBRE,NUMERO};
	
	private static Set <ElementoQuimico> setDeElementosQuimicos = new LinkedHashSet<>(Set.of(new ElementoQuimico("H", "Hidrógeno",1), new ElementoQuimico("He","Helio",2),
			new ElementoQuimico("Li","Litio",3),new ElementoQuimico("Be","Berilio",4),new ElementoQuimico("B","Boro",5),new ElementoQuimico("C","Carbon",6),
			new	ElementoQuimico("N","Nitrógeno",7),new ElementoQuimico("O","Oxígeno",8),new ElementoQuimico("F","Flúor",9),new ElementoQuimico("Ne","Neón",10),
			new ElementoQuimico("Na","Sodio",11),new ElementoQuimico("Mg","Magnesio",12),new ElementoQuimico("Al","Aluminio",13),new ElementoQuimico("Si","Silicio",14),
			new ElementoQuimico("P","Fósforo",15),new ElementoQuimico("S","Azufre",16),new ElementoQuimico("Cl","Cloro",17),new ElementoQuimico("Ar","Argón",18),
			new ElementoQuimico("K","Potasio",19),new ElementoQuimico("Ca","Calcio",20)));	
	
	public ElementoQuimico(String letra, String nombre, int numeroAtomico) {
		this.letra = letra;
		this.nombre = nombre;
		this.numeroAtomico = numeroAtomico;
	}
			
	public String getLetra() {
		return letra;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumeroAtomico() {
		return numeroAtomico;
	}

	private static void ordenarLista(Orden orden, PropiedadParaOrdenar propiedad,List<ElementoQuimico> listaSeleccionados) {
		if(propiedad == PropiedadParaOrdenar.NUMERO) {
			if(orden == Orden.DIRECTO) {
				listaSeleccionados.sort((num1,num2) -> num1.getNumeroAtomico() - num2.getNumeroAtomico());
				return;
			}else if(orden == Orden.INVERSO) {
				listaSeleccionados.sort((num1,num2)-> num2.getNumeroAtomico() - num1.getNumeroAtomico());
				return;
			}	
		}
		
		if(propiedad == PropiedadParaOrdenar.NOMBRE) {
			if(orden == Orden.DIRECTO) {
				listaSeleccionados.sort((nom1,nom2) -> nom1.nombre.compareTo(nom2.nombre));
				return;
			}else if(orden == Orden.INVERSO) {
				listaSeleccionados.sort((nom1,nom2) -> nom2.nombre.compareTo(nom1.nombre));
				return;
			}
		}
		
		if(propiedad == PropiedadParaOrdenar.LETRA) {
			if(orden == Orden.DIRECTO) {
				listaSeleccionados.sort((nom1,nom2) -> nom1.letra.compareTo(nom2.letra));
				return;
			}else if(orden == Orden.INVERSO) {
				listaSeleccionados.sort((nom1,nom2) -> nom2.letra.compareTo(nom1.letra));
				return;
			}
		}
	}
	
	
	public static ElementoQuimico[] generarElementosAleatorios(Orden orden, PropiedadParaOrdenar propiedad) {
		int elementosASacar = random.nextInt(setDeElementosQuimicos.size());
		
		List<ElementoQuimico> listaElementosQuimicos = new ArrayList<>(setDeElementosQuimicos);
		List<ElementoQuimico> listaSeleccionados = new ArrayList<>();
		
		while(listaSeleccionados.size()<elementosASacar) {
			int indice = random.nextInt(listaElementosQuimicos.size());
			listaSeleccionados.add(listaElementosQuimicos.get(indice));
			listaElementosQuimicos.remove(indice);
		}		
		ordenarLista(orden, propiedad, listaSeleccionados);
		ElementoQuimico [] elementosQuimicosGenerados = listaSeleccionados.toArray(new ElementoQuimico[listaSeleccionados.size()]);
		return elementosQuimicosGenerados;
	}

	@Override	
	public String toString() {
			return String.format("%s - %s - Número atómico: %d",letra,nombre,numeroAtomico);
		}
	

	public static void main(String[] args) {
		
		ElementoQuimico[] elementos = generarElementosAleatorios(Orden.DIRECTO,PropiedadParaOrdenar.LETRA);	
		for(ElementoQuimico elemento : elementos) {
			System.out.println(elemento);
		}
		
		
		
	}
}
