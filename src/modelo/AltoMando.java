package modelo;

import java.util.ArrayList;

public class AltoMando {
	
private ArrayList<MiembroAltoMando> miembros;
	
	public AltoMando() {
		this.miembros = new ArrayList<>();
	}
	
	public void AñadirAltoMando(MiembroAltoMando miembro) {
		miembros.add(miembro);
	}

	public ArrayList<MiembroAltoMando> getMiembros() {
		return miembros;
	}

}
