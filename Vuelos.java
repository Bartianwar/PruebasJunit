package main;

public class Vuelos {
    private String numeroVuelo;
    private String ciudadSalida;
    private String ciudadDestino;
    private int asientosDisponibles;
   
    public Vuelos(String numeroVuelo, String ciudadSalida, String ciudadDestino, int asientosDisponibles) {
    	this.numeroVuelo = numeroVuelo;
    	this.ciudadSalida = ciudadSalida;
    	this.ciudadDestino = ciudadDestino;
    	this.asientosDisponibles = asientosDisponibles;
    }
    
    public String getNumeroVuelo() {
    	return this.numeroVuelo;
    }
    
    public String getCiudadSalida() {
    	return this.ciudadSalida;
    }
    
    public String getCiudadDestino() {
    	return this.ciudadDestino;
    }
    
    public int getAsientosDisponibles() {
    	return this.asientosDisponibles;
    }
    
    public void printVuelo() {
    	System.out.println("Numero Vuelo: " + this.numeroVuelo);
    	System.out.println("Ciudad Origen: " + this.ciudadSalida);
    	System.out.println("Ciudad Destino: " + this.ciudadDestino);
    	System.out.println("Asientos Disponibles: " + this.asientosDisponibles);
    }
}
