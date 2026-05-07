package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.LiderGimnasio;
import modelo.MiembroAltoMando;
import modelo.Pokemon;

public class SistemaPokemon {
	public void menuPrincipal() throws FileNotFoundException{
		Scanner scanner = new Scanner(System.in);
		ArrayList<Pokemon> pokemons = new ArrayList<>();
		ArrayList<LiderGimnasio> gimnasio = new ArrayList<>();
		ArrayList<MiembroAltoMando> altoMando = new ArrayList<>();

		lectorArchivoPokemon(pokemons);
		lectorArchivoGimnasio(gimnasio, pokemons);
		lectorArchAltomando(altoMando, pokemons);

		boolean entrar = true;

		while (entrar) {
			System.out.println("1) Continuar.");
			System.out.println("2) Nueva Partida.");
			System.out.println("3) Salir.");
			int opcion = leectorOpcion(scanner);
			System.out.println();

			switch(opcion) {
			case 1:
				System.out.println("continua");
				break;
			case 2:
				menuNuevaPartida(scanner);
				break;
			case 3: 
				entrar = false;
				break;
			}
		}
	}

	
	private void lectorArchAltomando(ArrayList<MiembroAltoMando> altoMando, ArrayList<Pokemon> pokemons) throws FileNotFoundException {
		Scanner archAltoMando = new Scanner(new File("Alto Mando.txt"));

		while(archAltoMando.hasNextLine()) {
			String lineaAltoMando = archAltoMando.nextLine();
			String[] partesAM = lineaAltoMando.split(";");

			int numAltoMando = Integer.parseInt(partesAM[0]);
			String miembro = partesAM[1];

			Pokemon[] pokemonesAltoMando = new Pokemon[6];

			for (int b = 0; b < pokemonesAltoMando.length; b++) {
				String nombreAM = partesAM[2 + b];

				for (Pokemon pokemon : pokemons) {
					if (pokemon.getPokemon().equals(nombreAM)) { 
						pokemonesAltoMando[b] = pokemon;
						break;
					}
				}
			}

			MiembroAltoMando miembroObj = new MiembroAltoMando(numAltoMando, miembro, pokemonesAltoMando);
			altoMando.add(miembroObj);
		}

		archAltoMando.close(); 
	}

	private static void menuNuevaPartida(Scanner scanner) {
		boolean menuJ = true;

		while (menuJ) {
			System.out.println("nombre usuario,que deseas hacer?");
			System.out.println("1) Revisar equipo.");
			System.out.println("2) Salir a capturar.");
			System.out.println("3) Acceso al PC (cambiar Pokémon del equipo).");
			System.out.println("4) Retar un gimnasio.");
			System.out.println("5) Desafío al Alto Mando.");
			System.out.println("6) Curar Pokémon.");
			System.out.println("7) Guardar.");
			System.out.println("8) Guardar y Salir.");
			int opcion = leectorOpcion(scanner);
			System.out.println();

			switch (opcion) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				menuJ = false;
				break;
			}
		}
	}

	private static int leectorOpcion(Scanner scanner) {
		System.out.print("Ingrese opcion: ");
		return scanner.nextInt();
	}

	private static void lectorArchivoPokemon(ArrayList<Pokemon> pokemons) throws FileNotFoundException {
		Scanner lineaPokemon = new Scanner(new File("Pokedex.txt"));

		while (lineaPokemon.hasNextLine()) {
			String lineaP = lineaPokemon.nextLine();
			String[] partes = lineaP.split(";");

			String pokemon = partes[0];
			String habitat = partes[1];
			double porcentajeAparicion = Double.parseDouble(partes[2]);
			int vida = Integer.parseInt(partes[3]);
			int ataque = Integer.parseInt(partes[4]);

			Pokemon po = new Pokemon(pokemon, habitat, porcentajeAparicion, vida, ataque);
			pokemons.add(po);
		}

		lineaPokemon.close();
	}

	
	private void lectorArchivoGimnasio(ArrayList<LiderGimnasio> gimnasio, ArrayList<Pokemon> pokemons) throws FileNotFoundException {
		Scanner archgym = new Scanner(new File("Gimnasios.txt"));

		while(archgym.hasNextLine()) {
			String lineagym = archgym.nextLine();
			String[] partesgym = lineagym.split(";");

			int numeroGym = Integer.parseInt(partesgym[0]);
			String liderGym = partesgym[1];
			String estadoGym = partesgym[2];
			int cantPokeGym = Integer.parseInt(partesgym[3]);

			Pokemon[] pokemonesGYM = new Pokemon[cantPokeGym];

			for(int i = 0; i < cantPokeGym; i++) {
				String nombre = partesgym[4 + i];

				for (Pokemon pokemon : pokemons) {
					if (pokemon.getPokemon().equals(nombre)) {
						pokemonesGYM[i] = pokemon;
						break;
					}
				}
			}

			LiderGimnasio gym = new LiderGimnasio(numeroGym, liderGym, estadoGym, pokemonesGYM);
			gimnasio.add(gym); 
		}

		archgym.close();
	}
}
