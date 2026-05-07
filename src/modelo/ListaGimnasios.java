package modelo;

import java.util.ArrayList;

public class ListaGimnasios {
	
	private ArrayList<LiderGimnasio> lista;
	
	public ListaGimnasios() {
		this.lista = new ArrayList<>();
	}
	
	public void AñadirLider(LiderGimnasio Lider) {
		lista.add(Lider);
	}

}
