package modelo;


public class Gimnasio {
	private int numeroGym;
	 private String liderGym;
	 private String estadoGym;
	 private Pokemon[] pokemonesGym;
	 
	 public Gimnasio(int numeroGym, String liderGym, String estadoGym, Pokemon[] pokemonesGym) {
		this.numeroGym = numeroGym;
		this.liderGym = liderGym;
		this.estadoGym = estadoGym;
		this.pokemonesGym = pokemonesGym;
	 }
	 public int getNumeroGym() {
		 return numeroGym;
	 }
	 public String getLiderGym() {
		 return liderGym;
	 }
	 public String getEstadoGym() {
		 return estadoGym;
	 }
	 public Pokemon[] getPokemones() {
		 return pokemonesGym;
	 }

}
