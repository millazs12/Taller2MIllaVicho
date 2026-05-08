package logica;

import modelo.Pokemon;

public class GestorBatalla {

	private TablaDeTipos tabla;

	public GestorBatalla() {
		this.tabla = new TablaDeTipos();
	}

	// Método para calcular el daño final
	public double aplicarEfectividad(String tipoAtacante, String tipoDefensor) {
		return tabla.obtenerEficacia(tipoAtacante, tipoDefensor);
	}

	public int simularCombate(Pokemon p1, Pokemon p2) {
		// Mostrar puntaje inicial (stats base)
		System.out.println(p1.getNombre() + " -> " + p1.getStats() + " puntos");
		System.out.println(p2.getNombre() + " -> " + p2.getStats() + " puntos");
		System.out.println();

		// Obtener los multiplicadores
		double multP1 = aplicarEfectividad(p1.getTipo(), p2.getTipo());
		double multP2 = aplicarEfectividad(p2.getTipo(), p1.getTipo());

		// Mostrar mensajes de efectividad solo si no es daño normal (1.0)
		imprimirEfecto(p1.getNombre(), p2.getNombre(), multP1);
		imprimirEfecto(p2.getNombre(), p1.getNombre(), multP2);

		// Calcular el poder final
		double poderP1 = p1.getStats() * multP1;
		double poderP2 = p2.getStats() * multP2;

		// Mostrar puntaje final
		System.out.println("Nuevo puntaje:");
		System.out.println(p1.getNombre() + " -> " + poderP1 + " puntos");
		System.out.println(p2.getNombre() + " -> " + poderP2 + " puntos");
		System.out.println();

		// Retornar ganador
		if (poderP1 >= poderP2) {
			return 1; // Gana el Jugador/P1
		} else {
			return 2; // Gana el Rival/P2
		}
	}

	private void imprimirEfecto(String atacante, String defensor, double mult) {
		if (mult > 1.0) {
			System.out.println("¡" + atacante + " es súper efectivo contra " + defensor + "!");
		} else if (mult < 1.0 && mult > 0) {
			System.out.println(atacante + " no es efectivo contra " + defensor + "!");
		} else if (mult == 0) {
			System.out.println("¡" + atacante + " no afecta a " + defensor + "!");
		}
	}
}