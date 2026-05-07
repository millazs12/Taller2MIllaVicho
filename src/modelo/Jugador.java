package modelo;

import java.util.ArrayList;

public class Jugador {
	
	private String nombre;
	private ArrayList<Pokemon> PC;
	private ArrayList<Pokemon> equipo;
	private int numeroEquipo;
	private int medallas;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.PC = new ArrayList<>();
		this.equipo = new ArrayList<>();
		this.numeroEquipo = 0;
		this.medallas = 0;
	}

	public int getNumeroEquipo() {
		return numeroEquipo;
	}

	public void setNumeroEquipo(int numeroEquipo) {
		this.numeroEquipo = numeroEquipo;
	}

	public int getMedallas() {
		return medallas;
	}

	public void setMedallas(int medallas) {
		this.medallas = medallas;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void AñadirPC(Pokemon pokemon) {
		PC.add(pokemon);
	}
	
	public void AñadirEquipo(Pokemon pokemon) {
		equipo.add(pokemon);
	}
	
	public void CurarEquipo() {
		System.out.println("placeholder");
	}
	
	public void CambiarEquipo(int team,int pc) {
		System.out.println("placeholder");
	}
	
	public void GanarMedalla() {
		medallas++;
	}
	
	public void RetarGym(int numero) {
		System.out.println("placeholder");
	}
	
	public void DesafiarAltoMando() {
		System.out.println("placeholder");
	}

}
