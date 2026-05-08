package modelo;

import java.util.ArrayList;
import java.util.Random;

public class Habitat {

	private ArrayList<Pokemon> especies;
	private String nombre;

	public Habitat(String nombre) {
		this.nombre = nombre;
		this.especies = new ArrayList<>();

	}
	//codigo generico para añadir a lista
	public void AñadirHabitante(Pokemon p) {
		especies.add(new Pokemon(p.getNombre(), p.getHabitat(), p.getPorcentajeAparicion(), p.getStats(), p.getTipo()));
	}
	
	public String getNombreHabitat() {
		return nombre;
	}

	// este metodo busca un pokemon generando un numero random del 0.0 hasta el 1.0
	public Pokemon buscarSalvaje() {
		if (especies == null || especies.isEmpty())
			return null;

		Random rnd = new Random();
		double suerte = rnd.nextDouble(); // Número entre 0.0 y 1.0
		double acumulador = 0.0;

		for (Pokemon p : especies) {
			acumulador += p.getPorcentajeAparicion();
			if (suerte <= acumulador) {
				return new Pokemon(p.getNombre(), p.getHabitat(), p.getPorcentajeAparicion(), p.getStats(),
						p.getTipo());
			}
		}

		return especies.get(especies.size() - 1);
	}
	
	public ArrayList<Pokemon> GetPokemon() {
		return especies;
		
	}

}
