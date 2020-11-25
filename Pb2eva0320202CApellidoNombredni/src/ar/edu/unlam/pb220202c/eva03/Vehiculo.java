package ar.edu.unlam.pb220202c.eva03;

public class Vehiculo implements Imultable{

	//Se debe crear contructeres getters y Setters y loos que crean convenientes
	private String patente;
	private Integer velocidadActual;
	private Integer limiteVelocidad;
	

	
	

	public Vehiculo(String patente, Integer limiteVelocidad) {
		super();
		this.patente = patente;
		this.limiteVelocidad = limiteVelocidad;
		this.velocidadActual = 0;
	}

	public void incrmentarVelocidad(Integer velocidad) {
		this.velocidadActual+=velocidad;
		
	}

	public String getPatente() {
		return this.patente;
	}

	public Integer getVelocidadActual() {
		return this.velocidadActual;
	}

	public Integer getLimiteVelocidad() {
		return this.limiteVelocidad;
	}

	@Override
	public Boolean enInfraccion() {
		if(this.velocidadActual> this.limiteVelocidad)
			return true;
		
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((limiteVelocidad == null) ? 0 : limiteVelocidad.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vehiculo))
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (limiteVelocidad == null) {
			if (other.limiteVelocidad != null)
				return false;
		} else if (!limiteVelocidad.equals(other.limiteVelocidad))
			return false;
		return true;
	}
	
	
}
