package logica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.AltoMando;
import modelo.Habitat;
import modelo.Jugador;
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
				Jugador player = Cargarpartida(listaPokemones);
				boolean juegoActual = true;
				while (juegoActual == true) {
					System.out.println(player.getNombre() + ", que deseas hacer?");
					System.out.println();
					menuPartida();
					int opcion2 = 0;
					try {
						opcion2 = scanner.nextInt();
						scanner.nextLine();
					} catch (Exception e) {
						System.out.println("Ingrese un valor valido.");
						System.out.println("");
						scanner.nextLine();
						continue;
					}
					// =========================
					switch (opcion2) {
					case 1: {
						if (player.getNumeroEquipo() == 0) {
							System.out.println("No tienes Pokemones en tu equipo, sal a capturar");
						} else {
							int contador = 0;
							for (Pokemon p : player.GetEquipo()) {
								contador++;
								System.out.println(contador + ") " + p.getNombre() + "|" + p.getTipo()
										+ "|Stats totales: " + p.getStats());
							}
						}
						break;
					}
					case 2: {
						int opcionCapturar = 0;
						// _________________________________________________________________
						while (opcionCapturar != 7) {
							System.out.println("Donde deseas ir a explorar?");
							System.out.println();
							System.out.println("Zonas disponibles:");
							System.out.println();

							int contador = 0;

							for (Habitat h : ListaHabitats) {
								contador++;
								System.out.println(contador + ") " + h.getNombreHabitat());
							}
							System.out.println("7) Volver al menu.");
							System.out.print("Ingrese Zona: ");
							try {
								opcionCapturar = scanner.nextInt();
								scanner.nextLine();

							} catch (Exception e) {
								System.out.println("Ingrese un valor valido.");
								System.out.println("");
								scanner.nextLine();
								continue;
							}
							switch (opcionCapturar) {

							case 1: {
								visitarHabitat(0, ListaHabitats, player, scanner);
								break;

							}
							case 2: {
								visitarHabitat(1, ListaHabitats, player, scanner);
								break;
							}
							case 3: {
								visitarHabitat(2, ListaHabitats, player, scanner);
								break;
							}
							case 4: {
								visitarHabitat(3, ListaHabitats, player, scanner);
								break;
							}
							case 5: {
								visitarHabitat(4, ListaHabitats, player, scanner);
								break;
							}
							case 6: {
								visitarHabitat(5, ListaHabitats, player, scanner);
								break;
							}
							case 7: {
								System.out.println("Operacion Cancelada");
								break;
							}
							default:
								System.out.println("Ingrese un valor valido.");
								System.out.println();
							}

						}
						// __________________________________________________________________
						break;
					}
					case 3: {
					    
					    if (player.GetEquipo().size() == 0) {
					        System.out.println("No tienes Pokemon en tu equipo.");
					    } else if (player.GetPC().size() == 0) {
					        System.out.println("Tu PC esta vacio. Captura mas Pokemon para realizar cambios.");
					    } else {
					       
					        player.mostrarEquipo();
					        player.mostrarPC();

					        int indiceEquipo = -1;
					        int indicePC = -1;

					        
					        while (true) {
					            System.out.print("Elige el numero del Pokemon en tu EQUIPO para sacar: ");
					            try {
					                indiceEquipo = scanner.nextInt();
					                scanner.nextLine(); 

					                
					                if (indiceEquipo >= 1 && indiceEquipo <= player.GetEquipo().size()) {
					                    break; 
					                } else {
					                    System.out.println("Valor invalido. Debe ser entre 1 y " + player.GetEquipo().size());
					                }
					            } catch (Exception e) {
					                System.out.println("Error: Ingrese un numero valido.");
					                scanner.nextLine(); 
					            }
					        }

					     
					        while (true) {
					            System.out.print("Elige el numero del Pokemon en tu PC para meter al equipo: ");
					            try {
					                indicePC = scanner.nextInt();
					                scanner.nextLine(); 

					                if (indicePC >= 1 && indicePC <= player.GetPC().size()) {
					                    break; 
					                } else {
					                    System.out.println("Valor invalido. Debe ser entre 1 y " + player.GetPC().size());
					                }
					            } catch (Exception e) {
					                System.out.println("Error: Ingrese un numero valido.");
					                scanner.nextLine();
					            }
					        }

					      
					        player.CambiarEquipo(indiceEquipo - 1, indicePC - 1);
					    }
					    break;
					}
						
					
					case 4: {
						System.out.println("A cual Lider deseas retar??\n");
					    int contador = 1;
					    for (LiderGimnasio lider : Gimnasios.GetLista()) {
					        String estadoStr = lider.getEstadoGym() ? "Sin derrotar" : "Derrotado";
					        System.out.println(contador + ") " + lider.getNombre() + " - Estado: " + estadoStr);
					        contador++;
					    }
					    System.out.println("9) Volver al menu.");
					    
					    System.out.print("Ingrese Opcion: ");
					    int liderElegido = scanner.nextInt();
					    scanner.nextLine();

					    if (liderElegido == 9) {
					        break;
					    }

					    LiderGimnasio seleccionado = Gimnasios.GetLista().get(liderElegido - 1);

					    if (liderElegido != (player.getMedallas() + 1)) {
					        System.out.println("Calmado Entrenador!!! No puedes retar a " + seleccionado.getNombre() + " sin haber derrotado a los lideres anteriores!!");
					        System.out.println();
					        break;
					    }

					    GestorBatalla gestor = new GestorBatalla();
					    iniciarBatallaGym(player, seleccionado, gestor, scanner);
					    break;
					}
					case 5: {
						if (player.getMedallas() < 8) {
					        System.out.println("¡Aun no estas listo! Necesitas las 8 medallas de gimnasio para este desafio.");
					        System.out.println("");
					        break;
					    }

					    System.out.println("¡ESTAS ENTRANDO A LA ARENA DE LA LIGA PKMN!");
					    System.out.println("Debes derrotar a los 7 miembros seguidos. Si caes, vuelves al inicio.");
					    
					    // Llamamos al método que controla la maratón
					    iniciarDesafioAltoMando(player, maestros, scanner);
					}
					case 6: {
						if (player.getNumeroEquipo() == 0) {
							System.out.println("No tienes pokemon");
						} else {
							player.CurarEquipo();
						}
						break;
					}
					case 7: {
						System.out.println("Guardando partida.....");
						guardarPartida(player, player.getMedallas());
						System.out.println("Partida guardada!");
						System.out.println();
						break;
					}
					case 8: {
						System.out.println("Guardando partida.....");
						guardarPartida(player, player.getMedallas());
						System.out.println("Partida guardada!");
						System.out.println("Nos vemos pronto... entrenador");
						System.out.println();
						juegoActual = false;
						break;
					}
					default:
						System.out.println("eleccion no valida");
					}

				}

				break;
			}
			case 2: {
				System.out.print("Ingrese su apodo de jugador: ");
				String nombre = scanner.nextLine();
				System.out.println();
				Jugador player = new Jugador(nombre);
				boolean juegoActual = true;
				while (juegoActual == true) {
					System.out.println(player.getNombre() + ", que deseas hacer?");
					System.out.println();
					menuPartida();
					int opcion2 = 0;
					try {
						opcion2 = scanner.nextInt();
						scanner.nextLine();
					} catch (Exception e) {
						System.out.println("Ingrese un valor valido.");
						System.out.println("");
						scanner.nextLine();
						continue;
					}
					// =========================
					switch (opcion2) {
					case 1: {
						if (player.getNumeroEquipo() == 0) {
							System.out.println("No tienes Pokemones en tu equipo, sal a capturar");
						} else {
							int contador = 0;
							for (Pokemon p : player.GetEquipo()) {
								contador++;
								System.out.println(contador + ") " + p.getNombre() + "|" + p.getTipo()
										+ "|Stats totales: " + p.getStats());
							}
						}
						break;
					}
					case 2: {
						int opcionCapturar = 0;
						// _________________________________________________________________
						while (opcionCapturar != 7) {
							System.out.println("Donde deseas ir a explorar?");
							System.out.println();
							System.out.println("Zonas disponibles:");
							System.out.println();

							int contador = 0;

							for (Habitat h : ListaHabitats) {
								contador++;
								System.out.println(contador + ") " + h.getNombreHabitat());
							}
							System.out.println("7) Volver al menu.");
							System.out.print("Ingrese Zona: ");
							try {
								opcionCapturar = scanner.nextInt();
								scanner.nextLine();

							} catch (Exception e) {
								System.out.println("Ingrese un valor valido.");
								System.out.println("");
								scanner.nextLine();
								continue;
							}
							switch (opcionCapturar) {

							case 1: {
								visitarHabitat(0, ListaHabitats, player, scanner);
								break;

							}
							case 2: {
								visitarHabitat(1, ListaHabitats, player, scanner);
								break;
							}
							case 3: {
								visitarHabitat(2, ListaHabitats, player, scanner);
								break;
							}
							case 4: {
								visitarHabitat(3, ListaHabitats, player, scanner);
								break;
							}
							case 5: {
								visitarHabitat(4, ListaHabitats, player, scanner);
								break;
							}
							case 6: {
								visitarHabitat(5, ListaHabitats, player, scanner);
								break;
							}
							case 7: {
								System.out.println("Operacion Cancelada");
								break;
							}
							default:
								System.out.println("Ingrese un valor valido.");
								System.out.println();
							}

						}
						// __________________________________________________________________
						break;
					}
					case 3: {
					  
					    if (player.GetEquipo().size() == 0) {
					        System.out.println("No tienes Pokemon en tu equipo.");
					    } else if (player.GetPC().size() == 0) {
					        System.out.println("Tu PC esta vacio. Captura mas Pokemon para realizar cambios.");
					    } else {
					      
					        player.mostrarEquipo();
					        player.mostrarPC();

					        int indiceEquipo = -1;
					        int indicePC = -1;

					     
					        while (true) {
					            System.out.print("Elige el numero del Pokemon en tu EQUIPO para sacar: ");
					            try {
					                indiceEquipo = scanner.nextInt();
					                scanner.nextLine(); 

					               
					                if (indiceEquipo >= 1 && indiceEquipo <= player.GetEquipo().size()) {
					                    break; 
					                } else {
					                    System.out.println("Valor invalido. Debe ser entre 1 y " + player.GetEquipo().size());
					                }
					            } catch (Exception e) {
					                System.out.println("Error: Ingrese un numero valido.");
					                scanner.nextLine();
					            }
					        }

					     
					        while (true) {
					            System.out.print("Elige el numero del Pokemon en tu PC para meter al equipo: ");
					            try {
					                indicePC = scanner.nextInt();
					                scanner.nextLine(); 

					                if (indicePC >= 1 && indicePC <= player.GetPC().size()) {
					                    break; 
					                } else {
					                    System.out.println("Valor invalido. Debe ser entre 1 y " + player.GetPC().size());
					                }
					            } catch (Exception e) {
					                System.out.println("Error: Ingrese un numero valido.");
					                scanner.nextLine(); 
					            }
					        }

					      
					        player.CambiarEquipo(indiceEquipo - 1, indicePC - 1);
					    }
					    break;
					}
					case 4: {
						System.out.println("A cual Lider deseas retar??\n");
					    int contador = 1;
					    for (LiderGimnasio lider : Gimnasios.GetLista()) {
					        String estadoStr = lider.getEstadoGym() ? "Sin derrotar" : "Derrotado";
					        System.out.println(contador + ") " + lider.getNombre() + " - Estado: " + estadoStr);
					        contador++;
					    }
					    System.out.println("9) Volver al menu.");
					    
					    System.out.print("Ingrese Opcion: ");
					    int liderElegido = scanner.nextInt();
					    scanner.nextLine();

					    if (liderElegido == 9) {
					        break;
					    }

					    LiderGimnasio seleccionado = Gimnasios.GetLista().get(liderElegido - 1);

					    if (liderElegido != (player.getMedallas() + 1)) {
					        System.out.println("Calmado Entrenador!!! No puedes retar a " + seleccionado.getNombre() + " sin haber derrotado a los lideres anteriores!!");
					        System.out.println();
					        break;
					    }

					    GestorBatalla gestor = new GestorBatalla();
					    iniciarBatallaGym(player, seleccionado, gestor, scanner);
					    break;
					}
					case 5: {
						if (player.getMedallas() < 8) {
					        System.out.println("¡Aun no estas listo! Necesitas las 8 medallas de gimnasio para este desafio.");
					        System.out.println("");
					        break;
					    }

					    System.out.println("¡ESTAS ENTRANDO A LA ARENA DE LA LIGA PKMN!");
					    System.out.println("Debes derrotar a los 7 miembros seguidos. Si caes, vuelves al inicio.");
					    
					    // Llamamos al método que controla la maratón
					    iniciarDesafioAltoMando(player, maestros, scanner);
					    break;
					}
					case 6: {
						if (player.getNumeroEquipo() == 0) {
							System.out.println("No tienes pokemon");
						} else {
							player.CurarEquipo();
						}
						break;
					}
					case 7: {
						System.out.println("Guardando partida.....");
						guardarPartida(player, player.getMedallas());
						System.out.println("Partida guardada!");
						System.out.println();
						break;
					}
					case 8: {
						System.out.println("Guardando partida.....");
						guardarPartida(player, player.getMedallas());
						System.out.println("Partida guardada!");
						System.out.println("Nos vemos pronto... entrenador");
						System.out.println();
						juegoActual = false;
						break;
					}
					default:
						System.out.println("eleccion no valida");
					}

				}

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

	// Lectura de archivos

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
	
	public Jugador Cargarpartida(ArrayList<Pokemon> listaPokemones) {
		
		Jugador player = new Jugador(null);
		
		try {
			Scanner lector = new Scanner(new File("Registros.txt"));
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			int medallas = Integer.parseInt(partes[1]);
			player.SetNombre(partes[0]);
			player.setMedallas(medallas);

			while (lector.hasNextLine()) {
				linea = lector.nextLine();
				partes = linea.split(";");
				

				String pokemonLeido = partes[0];
				boolean estadoCargado = Boolean.parseBoolean(partes[1]);
				
				for (Pokemon p: listaPokemones) {
					if (p.getNombre().equalsIgnoreCase(pokemonLeido)) {
						if (player.yaTieneAlPokemon(p.getNombre())) {
							System.out.print("");
						} else {
							// Lógica normal de captura
							if (player.getNumeroEquipo() < 6) {
								player.AñadirEquipo(p);
								p.setEstado(estadoCargado);
							} else {
								player.AñadirPC(p);
								p.setEstado(estadoCargado);
							}
							break;
						}
						
					}
				}
				
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("no se encontraron datos de guardado");
		}

		return player;
		
	}

	// ===============================================================================================================

	// Menu

	public void menuPartida() {
		System.out.println("1) Revisar equipo.");
		System.out.println("2) Salir a capturar.");
		System.out.println("3) Acceso al PC (cambiar Pokémon del equipo).");
		System.out.println("4) Retar un gimnasio.");
		System.out.println("5) Desafío al Alto Mando.");
		System.out.println("6) Curar Pokémon.");
		System.out.println("7) Guardar.");
		System.out.println("8) Guardar y Salir.");
	}

	public void visitarHabitat(int indiceHabitat, ArrayList<Habitat> listaHabitats, Jugador player, Scanner scanner) {
		Pokemon salvaje = listaHabitats.get(indiceHabitat).buscarSalvaje();
		System.out.println("Oh!! Ha aparecido un " + salvaje.getNombre() + " salvaje!!");
		System.out.println();
		System.out.println("Que deseas hacer?");
		System.out.println();
		System.out.println("1) Capturar");
		System.out.println("2) Huir");
		System.out.println();

		int seCaptura = 0;
		do {
			try {
				System.out.print("Ingrese Opcion: ");
				seCaptura = scanner.nextInt();
				scanner.nextLine();

				if (seCaptura != 1 && seCaptura != 2) {
					System.out.println("Opción inválida. Intente de nuevo.");
				}

			} catch (Exception e) {
				System.out.println("Error: Ingrese un número.");
				scanner.nextLine();
			}
		} while (seCaptura != 1 && seCaptura != 2);
		if (seCaptura == 1) {
			// Verificamos si ya existe
			if (player.yaTieneAlPokemon(salvaje.getNombre())) {
				System.out.println("¡Ya tienes a este Pokemon! No puedes capturarlo de nuevo.");
			} else {
				// Lógica normal de captura
				if (player.getNumeroEquipo() < 6) {
					player.AñadirEquipo(salvaje);
					System.out.println("¡" + salvaje.getNombre() + " se ha unido a tu equipo!");
				} else {
					player.AñadirPC(salvaje);
					System.out.println("Equipo lleno. " + salvaje.getNombre() + " enviado al PC.");
				}
			}
		} else {
			System.out.println("has huido");
		}

	}

	public void guardarPartida(Jugador player, int medallas) {
		try {
			// El constructor de FileWriter crea el archivo si no existe
			BufferedWriter escritor = new BufferedWriter(new FileWriter("registros.txt"));

			// 1. Primera línea: nombre y medallas
			escritor.write(player.getNombre() + ";" + medallas);
			escritor.newLine();


			// 2. Guardar el equipo
			for (Pokemon p : player.GetEquipo()) {
				if (p.getEstado() == true) {
					escritor.write(p.getNombre() + ";Vivo");
					escritor.newLine();
				} else {
					escritor.write(p.getNombre() + ";Debilitado");
					escritor.newLine();
				}
				
			}


			// 3. Guardar el PC
			for (Pokemon p : player.GetPC()) {
				if (p.getEstado() == true) {
					escritor.write(p.getNombre() + ";Vivo");
					escritor.newLine();
				} else {
					escritor.write(p.getNombre() + ";Debilitado");
					escritor.newLine();
				}
			}


			escritor.close();

		} catch (IOException e) {
			System.out.println("No se pudo guardar la partida: " + e.getMessage());
		}
	}
	
	public void iniciarBatallaGym(Jugador player, LiderGimnasio lider, GestorBatalla gestor, Scanner scanner) {
	    System.out.println("Desafiando a " + lider.getNombre() + "!!");

	    // Usamos los métodos que ya tienes para sacar al primer Pokémon vivo
	    Pokemon miPoke = player.getPokemonActivo();
	    Pokemon pokeRival = lider.getPokemonActivo();

	    if (miPoke == null) {
	        System.out.println("Te has quedado sin pokemons en tu equipo!");
	        System.out.println("Volviendo al menu...");
	        return;
	    }

	    // Textos iniciales
	    String nombreJugador = player.getNombre();
	    if(nombreJugador == null) nombreJugador = "Clapt"; // Por si es nulo
	    
	    System.out.println(lider.getNombre() + " saca a " + pokeRival.getNombre() + "!");
	    System.out.println(nombreJugador + " saca a " + miPoke.getNombre() + "!");

	    // El bucle sigue mientras ambos tengan al menos un Pokémon vivo
	    while (miPoke != null && pokeRival != null) {
	        System.out.println("Que deseas hacer?");
	        System.out.println("1) Atacar\n2) Cambiar de pokemon\n3) Rendirse");
	        System.out.print("Ingrese Opcion: ");
	        int accion = scanner.nextInt();
	        scanner.nextLine();

	        if (accion == 1) { // ATACAR
	            int resultado = gestor.simularCombate(miPoke, pokeRival); // Tu gestor hace la magia aquí
	            
	            if (resultado == 1) { // Gana jugador
	                System.out.println("Ha ganado " + miPoke.getNombre() + "!");
	                System.out.println(pokeRival.getNombre() + " ha sido derrotado...");
	                pokeRival.setEstado(false); // Debilitamos al rival
	                pokeRival = lider.getPokemonActivo(); // El líder saca al siguiente
	                if (pokeRival != null) {
	                     System.out.println(lider.getNombre() + " saca a " + pokeRival.getNombre() + "!");
	                }
	            } else { // Gana rival
	                System.out.println("Ha ganado " + pokeRival.getNombre() + "!");
	                System.out.println(miPoke.getNombre() + " ha sido derrotado...");
	                miPoke.setEstado(false); // Te debilitan a ti
	                miPoke = player.getPokemonActivo(); // Sacas al siguiente automáticamente
	                if (miPoke != null) {
	                    System.out.println(nombreJugador + " saca a " + miPoke.getNombre() + "!");
	                }
	            }
	        } else if (accion == 2) { // CAMBIAR
	            player.mostrarEquipo();
	            System.out.print("Elige un nuevo Pokémon (numero): ");
	            int indice = scanner.nextInt();
	            scanner.nextLine();
	            Pokemon elegido = player.GetEquipo().get(indice - 1);
	            if (elegido.getEstado()) {
	                miPoke = elegido;
	                System.out.println(nombreJugador + " saca a " + miPoke.getNombre() + "!");
	            } else {
	                System.out.println("¡Ese Pokémon está debilitado!");
	            }
	        } else if (accion == 3) { // RENDIRSE
	            System.out.println("Te has rendido...");
	            System.out.println("Volviendo al menu...");
	            return;
	        }
	    }

	    // Revisamos quién ganó la guerra final
	    if (pokeRival == null) {
	        System.out.println("¡Has derrotado al Líder " + lider.getNombre() + "!");
	        lider.liderDerrotado(); // Marcamos el gym como derrotado
	        player.GanarMedalla(); // Te sumas una medalla
	    } else if (miPoke == null) {
	        System.out.println("Te has quedado sin pokemons en tu equipo!");
	        System.out.println("Volviendo al menu...");
	    }
	}
	
	public void iniciarDesafioAltoMando(Jugador player, AltoMando maestros, Scanner scanner) {
	    GestorBatalla gestor = new GestorBatalla();
	    boolean desafioFallido = false;

	    // Recorremos a cada miembro del Alto Mando uno por uno
	    for (MiembroAltoMando miembro : maestros.getMiembros()) {
	        System.out.println("\n--- SIGUIENTE OPONENTE: " + miembro.getNombre() + " ---");
	        
	        // Ejecutamos la batalla (reutilizando la lógica de turnos)
	        boolean victoria = ejecutarPeleaContinua(player, miembro, gestor, scanner);

	        if (!victoria) {
	            System.out.println("Has sido derrotado por el Alto Mando...");
	            desafioFallido = true;
	            break; // Sale del bucle for, no pelea contra el siguiente
	        }
	        
	        System.out.println("¡Increible! Has derrotado a " + miembro.getNombre());
	        System.out.println("Preparate para el siguiente combate...");
	    }

	    if (desafioFallido) {
	        System.out.println("Debes retirarte y entrenar mas. El Alto Mando ha recuperado sus fuerzas.");
	        // Reseteamos la salud de todos los miembros para el proximo intento
	        for (MiembroAltoMando m : maestros.getMiembros()) {
	            m.revivirEquipo();
	        }
	    } else {
	        System.out.println("¡FELICIDADES! ERES EL NUEVO CAMPEON DE LA REGION.");
	    }
	}
	
	private boolean ejecutarPeleaContinua(Jugador player, MiembroAltoMando oponente, GestorBatalla gestor, Scanner scanner) {
	    Pokemon miPoke = player.getPokemonActivo();
	    Pokemon pokeRival = oponente.getPokemonActivo();
	    String nombreJ = player.getNombre() != null ? player.getNombre() : "Entrenador";

	    System.out.println(oponente.getNombre() + " saca a " + pokeRival.getNombre() + "!");

	    while (miPoke != null && pokeRival != null) {
	        System.out.println("\n" + miPoke.getNombre() + " vs " + pokeRival.getNombre());
	        System.out.println("1) Atacar  2) Cambiar  3) Rendirse");
	        int accion = scanner.nextInt();
	        
	        if (accion == 1) {
	            int resultado = gestor.simularCombate(miPoke, pokeRival);
	            if (resultado == 1) { // Gana jugador
	                pokeRival.setEstado(false);
	                pokeRival = oponente.getPokemonActivo();
	                if (pokeRival != null) System.out.println(oponente.getNombre() + " saca a " + pokeRival.getNombre());
	            } else { // Gana rival
	                miPoke.setEstado(false);
	                miPoke = player.getPokemonActivo();
	                if (miPoke != null) System.out.println(nombreJ + " saca a " + miPoke.getNombre());
	            }
	        } else if (accion == 2) {
	            player.mostrarEquipo();
	            int idx = scanner.nextInt();
	            Pokemon elegido = player.GetEquipo().get(idx - 1);
	            if (elegido.getEstado()) miPoke = elegido;
	        } else {
	            return false; // Rendición cuenta como derrota
	        }
	    }
	    return (pokeRival == null); // True si el rival se quedó sin pokes
	}

}