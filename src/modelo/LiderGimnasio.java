package modelo;

<<<<<<< HEAD
import java.util.ArrayList;

public class LiderGimnasio {
	private int numero;
	 private String nombre;
	 private boolean estadoGym;
	 private ArrayList<Pokemon> equipoGym;
	 
	 public LiderGimnasio(int numero, String nombre) {
		this.numero = numero;
		this.nombre = nombre;
		this.estadoGym = true;
		this.equipoGym = new ArrayList<>();
	 }
	 public int getNumero() {
		 return numero;
	 }
	 public String getNombre() {
		 return nombre;
	 }
	 public boolean getEstadoGym() {
		 return estadoGym;
	 }
	 
	 public void liderDerrotado() {
		 estadoGym = false;
	 }
	 public void añadirEquipo(Pokemon p) {
		 equipoGym.add(new Pokemon(p.getNombre(), p.getHabitat(), p.getPorcentajeAparicion(), p.getStats(), p.getTipo()));
=======

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
>>>>>>> c923e69df08a176a3e2e72e7364ece35f97a4003
	 }

}
