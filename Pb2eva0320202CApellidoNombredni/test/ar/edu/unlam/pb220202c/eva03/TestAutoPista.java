package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista autoSol = new Autopista("Del Sol");
		Vehiculo autoRuben = new Automovil("AA470FO");
		
		assertTrue(autoSol.registrarTelepase(103, autoRuben));
		
	}
	@Test(expected = VehiculoNotFounException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException{
		Autopista autoSol = new Autopista("Del Sol");
		Vehiculo autoRuben = new Automovil("AA470FO");
		
		
		assertFalse(autoSol.salirAutpista(autoRuben));
		
		
	}
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente() throws VehiculoNotFounException{
		Autopista autoSol = new Autopista("Del Sol");
		Vehiculo autoUltimo = new Automovil("ZZ470FO");
		Vehiculo autoRuben = new Camion("BB470FO", 16);
		Vehiculo autoPrimero = new Camion("AA470FO", 16);
		Vehiculo autoRn = new Automovil("JJ470FO");
		Vehiculo autoR = new Automovil("FF470FO");
		
		autoSol.registrarTelepase(103, autoRuben);
		autoSol.registrarTelepase(102, autoUltimo);
		autoSol.registrarTelepase(104, autoR);
		autoSol.registrarTelepase(107, autoRn);
		autoSol.registrarTelepase(105, autoPrimero);
		autoSol.ingresarAutopista(103);
		autoSol.ingresarAutopista(102);
		autoSol.ingresarAutopista(104);
		autoSol.ingresarAutopista(107);
		autoSol.ingresarAutopista(105);
		
		autoUltimo.incrmentarVelocidad(150);
		autoRuben.incrmentarVelocidad(150);
		autoR.incrmentarVelocidad(150);
		autoPrimero.incrmentarVelocidad(150);
		autoRn.incrmentarVelocidad(150);
		
		
		
		autoSol.vehiculosMultados();
		
//		assertEquals(5, autoSol.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().size());
		assertEquals(autoUltimo, autoSol.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente().last());
	}
	@Test
	public void queLaCantidadDeAutosEnCirculacionSeaLaEsperada() throws VehiculoNotFounException {
		Autopista autoSol = new Autopista("Del Sol");
		Vehiculo autoUltimo = new Automovil("ZZ470FO");
		Vehiculo autoRuben = new Camion("BB470FO", 16);
		Vehiculo autoPrimero = new Camion("AA470FO", 16);
		Vehiculo autoRn = new Automovil("JJ470FO");
		Vehiculo autoR = new Automovil("FF470FO");
		
		autoSol.registrarTelepase(103, autoRuben);
		autoSol.registrarTelepase(102, autoUltimo);
		autoSol.registrarTelepase(104, autoR);
		autoSol.registrarTelepase(107, autoRn);
		autoSol.registrarTelepase(105, autoPrimero);
		
		autoSol.ingresarAutopista(103);
		autoSol.ingresarAutopista(102);
		
		
		
		assertEquals(2,autoSol.cantidadDeVehiculosENCirculacion(),0.1);
		
	}
	@Test
	public void queSeExedalaVelocidadDeUnAuto() {
		
		Vehiculo autoUltimo = new Automovil("ZZ470FO");
		autoUltimo.incrmentarVelocidad(150);
		
		assertTrue(autoUltimo.enInfraccion());
		
	}
	
}
