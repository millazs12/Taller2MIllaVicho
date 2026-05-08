package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Pokemon;

public class SistemaPokemon {
	public void menuPrincipal() throws FileNotFoundException {

		// lectura de archivos base completa
		ArrayList<Pokemon> listaPokemones = LeerPokedex();
		

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
				int stats = Integer.parseInt(partes[3]) + Integer.parseInt(partes[4]) + Integer.parseInt(partes[5]) +Integer.parseInt(partes[6]) +Integer.parseInt(partes[7]) + Integer.parseInt(partes[8]);
				String tipo = partes[9];
				
				Pokemon poke = new Pokemon(nombre, habitat, porcentajeAparicion, stats, tipo);
				listaPokemones.add(poke);
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("aydua");
		}
		
		return listaPokemones;
	}
		
}
