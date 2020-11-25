package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Autopista {
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telepase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	private PorPatente ordenador = new PorPatente();
	private TreeSet<Vehiculo> vehiculosPorPatente;
	
	private String nombre;
	
	
	public Autopista(String nombre) {
		super();
		this.nombre = nombre;
		this.vehiculosEnCirculacion = new HashSet <Vehiculo>();
		this.vehiculosPorPatente = new TreeSet<Vehiculo>(ordenador);
		this.telepase = new HashMap <Integer,Vehiculo>();
	}
	public Boolean registrarTelepase (Integer numeroTelepase, Vehiculo vehiculo) {
		if(!telepase.containsKey(numeroTelepase) || !telepase.containsValue(vehiculo)) {
		telepase.put(numeroTelepase, vehiculo);
		return true;
		}
		return false;
	}
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFounException {
		//si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFounException
	   // y no permite ingresar al autopista	
		if(telepase.containsKey(numeroTelepase))
			return vehiculosEnCirculacion.add(telepase.get(numeroTelepase));
		
		throw new VehiculoNotFounException();
	}
	
	public Boolean salirAutpista (Vehiculo vehiculo) throws VehiculoNotFounException {
		//lanza Una exception VehiculoNotFounException si no esta en circulacion
		if(telepase.containsValue(vehiculo)) {
			 telepase.remove(vehiculo);
			 return true;
		}
		
		throw new VehiculoNotFounException();
		
	}
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
		
		return vehiculosPorPatente;
    }

	public Integer cantidadDeVehiculosENCirculacion() {
	
		return vehiculosEnCirculacion.size();
	}
	
	public void vehiculosMultados() {
		for (Vehiculo vehiculo : vehiculosEnCirculacion) {
			if (vehiculo.enInfraccion())
				vehiculosPorPatente.add(vehiculo);
		}
		
	}
	
	
}
