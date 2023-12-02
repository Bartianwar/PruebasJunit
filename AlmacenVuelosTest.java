package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlmacenVuelosTest {

	@Test
	void testAddFlight() {
		AlmacenVuelos almacenVuelos = new AlmacenVuelos();
		almacenVuelos.addFlight("SN123", "Santiago", "NuevaYork", 100);
		
		assertEquals(1, almacenVuelos.getAllFlights().size());
	}

	@Test
	void testAddAndRemoveFlight() {
		AlmacenVuelos almacenVuelos = new AlmacenVuelos();
		almacenVuelos.addFlight("SN123", "Santiago", "NuevaYork", 100);
		
		assertEquals(1, almacenVuelos.getAllFlights().size());
		almacenVuelos.removeFlight("SN123");
		assertEquals(0, almacenVuelos.getAllFlights().size());
	}	
	
	@Test
	void testAddAndFindFlight() {
		AlmacenVuelos almacenVuelos = new AlmacenVuelos();
		almacenVuelos.addFlight("SN123", "Santiago", "NuevaYork", 100);
		
		assertEquals(1, almacenVuelos.getFlight("SN123"));
	}
}
