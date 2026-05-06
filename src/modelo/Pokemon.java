package modelo;

public class Pokemon {
	String pokemon ;
	String habitat;
	double porcentajeAparicion;
	int vida;
	int ataque ;
	
	
	public Pokemon(String pokemon, String habitat, double porcentajeAparicion, int vida, int ataque) {
		this.pokemon = pokemon;
		this.habitat = habitat;
		this.porcentajeAparicion = porcentajeAparicion;
		this.vida = vida;
		this.ataque = ataque;
	}


	public String getPokemon() {
		return pokemon;
	}


	public String getHabitat() {
		return habitat;
	}


	public double getPorcentajeAparicion() {
		return porcentajeAparicion;
	}


	public int getVida() {
		return vida;
	}


	public int getAtaque() {
		return ataque;
	}
		

}
