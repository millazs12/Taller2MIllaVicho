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
		//para equipo cura a todos
		for (Pokemon p : this.equipo) {
	        p.setEstado(true); 
	    }
	    //para pc cura a PC
	    for (Pokemon p : this.PC) {
	        p.setEstado(true);
	    }
	    System.out.println("Tu equipo y los Pokémon del PC se han recuperado!");
	}
	
	public void CambiarEquipo(int team,int pc) {
		if (team >= 0 && team < equipo.size() && pc >= 0 && pc < PC.size()) {
	        
	        Pokemon pokeEquipo = equipo.get(team);
	        Pokemon pokePC = PC.get(pc);

	        equipo.set(team, pokePC);
	        PC.set(pc, pokeEquipo);

	        // para confirmar
	        System.out.println("¡Cambio exitoso! " + pokePC.getNombre() + " ahora está en tu equipo.");
	    } else {
	        
	        System.out.println("Error: Índices inválidos. No se pudo realizar el cambio.");
	    }
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
