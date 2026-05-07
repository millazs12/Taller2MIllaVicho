package modelo;

public class Pokemon {
	private String nombre;
	private String habitat;
	private double porcentajeAparicion;
	private int stats;
	private boolean estado;
	private String tipo;
	
	
	public Pokemon(String nombre, String habitat, double porcentajeAparicion, int stats, String tipo) {
		this.nombre = nombre;
		this.habitat = habitat;
		this.porcentajeAparicion = porcentajeAparicion;
		this.stats = stats;
		this.estado = true;
		this.tipo = tipo;
	}


	public String getNombre() {
		return nombre;
	}


	public String getHabitat() {
		return habitat;
	}


	public double getPorcentajeAparicion() {
		return porcentajeAparicion;
	}


	public int getStats() {
		return stats;
	}


	public boolean getEstado() {
		return estado;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setEstado(boolean nuevoEstado) {
		estado = nuevoEstado;
		
	}
		

}
