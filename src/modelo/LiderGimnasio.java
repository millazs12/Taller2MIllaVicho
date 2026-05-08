package modelo;

import java.util.ArrayList;

public class LiderGimnasio {
	private int numero;
	private String nombre;
	private boolean estadoGym;
	private ArrayList<Pokemon> equipoGym;

	public LiderGimnasio(int numero, String nombre) {
		this.numero = numero;
		this.nombre = nombre;
		this.estadoGym = true;
		this.equipoGym = new ArrayList<>();
	}

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean getEstadoGym() {
		return estadoGym;
	}

	public void liderDerrotado() {
		estadoGym = false;
	}

	public void añadirEquipo(Pokemon p) {
		equipoGym.add(new Pokemon(p.getNombre(), p.getHabitat(), p.getPorcentajeAparicion(), p.getStats(), p.getTipo()));

	}

}
