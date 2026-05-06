package modelo;

public class MiembroAltoMando {
	private int numAltoMando;
	 private String Miembro;
	 private Pokemon[] pokemonesAltoMando;
	 
	 public MiembroAltoMando(int numAltoMando, String miembro, Pokemon[] pokemonesAltoMando) {
		this.numAltoMando = numAltoMando;
		Miembro = miembro;
		this.pokemonesAltoMando = pokemonesAltoMando;
	 }

	 public int getNumAltoMando() {
		 return numAltoMando;
	 }

	 public String getMiembro() {
		 return Miembro;
	 }

	 public Pokemon[] getPokemonesAltoMando() {
		 return pokemonesAltoMando;
	 }
	
}
