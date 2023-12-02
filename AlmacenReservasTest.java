package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlmacenReservasTest {

	@Test
	void testCheckAddAndRemoveReservation() {
		AlmacenReservas reservasAlmacen = new AlmacenReservas();
		
        Vuelos vuelo = new Vuelos("SN123", "Santiago", "NuevaYork", 100);
        reservasAlmacen.addReservation("RSN123", vuelo, 2, "Tomas Rebolledo");
        assertEquals(1, reservasAlmacen.getAllReservations().size());

        reservasAlmacen.removeReservation("RSN123");
        assertEquals(0, reservasAlmacen.getAllReservations().size());	
	}
	@Test 
	void testAddAndFindReservation(){
		AlmacenReservas reservasAlmacen = new AlmacenReservas();
		
        Vuelos vuelo = new Vuelos("SN123", "Santiago", "NuevaYork", 100);
        reservasAlmacen.addReservation("RSN123", vuelo, 2, "Tomas Rebolledo");
        
        assertNotNull(reservasAlmacen.getReservation("RSN123"));
	}
	
	@Test 
	void testAddReservationButNotEnoughAsientos() {
		AlmacenReservas reservasAlmacen = new AlmacenReservas();
		
        Vuelos vuelo = new Vuelos("SN123", "Santiago", "NuevaYork", 1);
		int asientos = 4;
		if(asientos <= vuelo.getAsientosDisponibles()) {
	    	reservasAlmacen.addReservation("RSN123", vuelo, asientos, "Tomas Rebolledo");
		}
		else
			System.out.println("No hay suficientes asientos");
		
        
        assertNull(reservasAlmacen.getReservation("RSN123"));
	}
	
}
