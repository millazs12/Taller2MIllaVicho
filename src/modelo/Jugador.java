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
		numeroEquipo++;
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
	    System.out.println("Tu equipo se ha recuperado!");
	}
	
	public void CambiarEquipo(int team,int pc) {
		if (team >= 0 && team < equipo.size() && pc >= 0 && pc < PC.size()) {
	        
	        Pokemon pokeEquipo = equipo.get(team);
	        Pokemon pokePC = PC.get(pc);

	        equipo.set(team, pokePC);
	        PC.set(pc, pokeEquipo);

	        // para confirmar
	        System.out.println(pokePC.getNombre() + " ha sido agregado a tu equipo!");
	    } else {
	    	System.out.println("Opcion invalida.");
	    }
	}
	
	public void GanarMedalla() {
		medallas++;
	}
	
	public void RetarGym(int numero,ArrayList<LiderGimnasio> listaGimnasios) {
		
	    if (numero != (this.medallas + 1)) {
	        System.out.println("No puedes desafiar a este lider todavia. Debes derrotar a los anteriores.");
	        return;
	    }
	    LiderGimnasio lider = listaGimnasios.get(numero - 1);

	    System.out.println("Desafiando a " + lider.getNombre());
	    
	    //logica aca
	}
	
	public void DesafiarAltoMando() {
		if (this.medallas < 8) {
	        System.out.println("Aun no tienes las 8 medallas para entrar a la Liga.");
	        return;
	    }
		System.out.println("Entrando a la Liga Pokemon...");
		//logica aca
	}
	
	public ArrayList<Pokemon> GetEquipo() {
		return equipo;
	}
	
	public boolean yaTieneAlPokemon(String nombreBuscado) {
	    // Revisar en el equipo
	    for (Pokemon p : this.equipo) {
	        if (p.getNombre().equalsIgnoreCase(nombreBuscado)) {
	            return true;
	        }
	    }
	    // Revisar en el PC
	    for (Pokemon p : this.PC) { // Suponiendo que tu PC se llama listaPC
	        if (p.getNombre().equalsIgnoreCase(nombreBuscado)) {
	            return true;
	        }
	    }
	    return false; // Si recorrió todo y no lo halló
	}
	
	public ArrayList<Pokemon> GetPC() {
		return PC;
	}

	public void SetNombre(String nuevoNombre) {
		this.nombre = nuevoNombre;
		
	}
}