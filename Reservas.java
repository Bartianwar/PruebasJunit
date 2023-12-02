package main;

public class Reservas {
    private String numeroReserva;
    private Vuelos vuelo;
    private String nombrePasajero;
    private int asientos;
 
    public Reservas(String numeroReserva, Vuelos vuelo, String nombrePasajero, int asientos) {
    	this.numeroReserva = numeroReserva;
    	this.vuelo = vuelo;
    	this.nombrePasajero = nombrePasajero;
    	this.asientos = asientos;
    }
    
    public String getNumeroReserva() {
    	return this.numeroReserva;
    }
    
    public Vuelos getVuelo() {
    	return this.vuelo;
    }
    
    public String getNombrePasajero() {
    	return this.nombrePasajero;
    }
    
    public int getAsientos() {
    	return this.asientos;
    }
    
    public void printReserva() {
    	System.out.println("Numero Reserva: " + numeroReserva);
    	System.out.println("Numero Vuelo: " + vuelo.getNumeroVuelo());
    	System.out.println("Nombre Persona: " + nombrePasajero);
    	System.out.println("Asientos: " + asientos);
    }
}
