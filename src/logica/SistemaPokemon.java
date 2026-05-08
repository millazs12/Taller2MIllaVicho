package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.AltoMando;
import modelo.Habitat;
import modelo.LiderGimnasio;
import modelo.ListaGimnasios;
import modelo.MiembroAltoMando;
import modelo.Pokemon;

public class SistemaPokemon {
	public void menuPrincipal() throws FileNotFoundException {

		// lectura de archivos base completa
		ArrayList<Pokemon> listaPokemones = LeerPokedex();
		ListaGimnasios Gimnasios = LeerGimnasios(listaPokemones);
		AltoMando maestros = LeerAltoMando(listaPokemones);
		ArrayList<Habitat> ListaHabitats = LeerHabitats();
		asignarHabitat(ListaHabitats, listaPokemones);
		

		Scanner scanner = new Scanner(System.in);
		boolean validar = true;

		while (validar == true) {
			System.out.println("1) Continuar.");
			System.out.println("2) Nueva Partida.");
			System.out.println("3) Salir.");
			int opcion = 0;

			try {
				opcion = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Ingrese un valor valido.");
				System.out.println("");
				scanner.nextLine();
				continue;
			}

			switch (opcion) {
			case 1: {
				System.out.println("continuar");
				break;
			}
			case 2: {
				System.out.println("nueva partida");
				break;
			}
			case 3: {
				System.out.println("saliendo....");
				validar = false;
				scanner.close();
				break;
			}
			default:
				System.out.println("Ingrese un valor valido.");
				System.out.println();
				break;
			}

		}

	}

	// ===============================================================================================================

	//Lectura de archivos
	
	public ArrayList<Pokemon> LeerPokedex() {

		ArrayList<Pokemon> listaPokemones = new ArrayList<>();

		try {
			Scanner lector = new Scanner(new File("Pokedex.txt"));
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] partes = linea.split(";");

				String nombre = partes[0];
				String habitat = partes[1];
				double porcentajeAparicion = Double.parseDouble(partes[2]);
				int stats = Integer.parseInt(partes[3]) + Integer.parseInt(partes[4]) + Integer.parseInt(partes[5])
						+ Integer.parseInt(partes[6]) + Integer.parseInt(partes[7]) + Integer.parseInt(partes[8]);
				String tipo = partes[9];

				Pokemon poke = new Pokemon(nombre, habitat, porcentajeAparicion, stats, tipo);
				listaPokemones.add(poke);
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("no se encontro archivo de Pokedex");
		}

		return listaPokemones;
	}

	public ListaGimnasios LeerGimnasios(ArrayList<Pokemon> Pokemones) {

		ListaGimnasios Gimnasio = new ListaGimnasios();

		try {
			Scanner lector = new Scanner(new File("Gimnasios.txt"));
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] partes = linea.split(";");

				int numero = Integer.parseInt(partes[0]);
				String nombre = partes[1];

				LiderGimnasio lider = new LiderGimnasio(numero, nombre);

				for (int i = 4; i < partes.length; i++) {
					String nombrePokeBuscado = partes[i];

					// Buscamos el objeto Pokémon de la lista
					for (Pokemon p : Pokemones) {
						if (p.getNombre().equalsIgnoreCase(nombrePokeBuscado)) {
							lider.añadirEquipo(p);
							break; // encontrado
						}
					}
				}
				Gimnasio.AñadirLider(lider);

			}
			lector.close();
		} catch (Exception e) {
			System.out.println("no se encontro archivo de Gimnasios Correcto");
		}

		return Gimnasio;

	}
	
	public AltoMando LeerAltoMando(ArrayList<Pokemon> Pokemones) {

		AltoMando Maestros = new AltoMando();

		try {
			Scanner lector = new Scanner(new File("Alto Mando.txt"));
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] partes = linea.split(";");

				String nombre = partes[1];

				MiembroAltoMando Miembro = new MiembroAltoMando(nombre);

				for (int i = 2; i < partes.length; i++) {
					String nombrePokeBuscado = partes[i];

					// Buscamos el objeto Pokémon de la lista
					for (Pokemon p : Pokemones) {
						if (p.getNombre().equalsIgnoreCase(nombrePokeBuscado)) {
							Miembro.añadirEquipo(p);
							break; // encontrado
						}
					}
				}
				Maestros.AñadirAltoMando(Miembro);

			}
			lector.close();
		} catch (Exception e) {
			System.out.println("no se encontro archivo de Altos Mandos Correcto");
		}

		return Maestros;
		
	}
	
	public ArrayList<Habitat> LeerHabitats() {

		ArrayList<Habitat> ListaHabitats = new ArrayList<>();

		try {
			Scanner lector = new Scanner(new File("Habitats.txt"));
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				

				String nombre = linea;

				Habitat Habitat = new Habitat(nombre);
				ListaHabitats.add(Habitat);
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("no se encontro archivo de habitats Correcto");
		}

		return ListaHabitats;
	}
	
	public void asignarHabitat(ArrayList<Habitat> Lista, ArrayList<Pokemon> Pokemones) {
		for (Habitat h : Lista) {
			for (Pokemon p : Pokemones) {
				if (p.getHabitat().equalsIgnoreCase(h.getNombreHabitat())) {
					h.AñadirHabitante(p);
				}
			}
		}
	}


}
