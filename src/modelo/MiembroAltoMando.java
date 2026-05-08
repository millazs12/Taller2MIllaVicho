package modelo;

import java.util.ArrayList;

public class MiembroAltoMando {

	private String nombre;
	private ArrayList<Pokemon> equipo;

	public MiembroAltoMando(String nombre) {
		this.nombre = nombre;
		this.equipo = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Pokemon> getEquipo() {
		return equipo;
	}
	
	public void añadirEquipo(Pokemon p) {
		equipo.add(new Pokemon(p.getNombre(), p.getHabitat(), p.getPorcentajeAparicion(), p.getStats(), p.getTipo()));
	}

}
