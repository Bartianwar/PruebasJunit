package main;
import java.util.*;

public class AlmacenVuelos {
    private List<Vuelos> flights = new ArrayList<>();

    public void addFlight(String id, String ciudadSalida, String ciudadDestino, int asientosDisponibles) {
    	String numeroVuelo;
    	if(id == "0") {
    		numeroVuelo = generateUniqueCode();
    	}else {
    		numeroVuelo = id;
    	}

        Vuelos flight = new Vuelos(numeroVuelo, ciudadSalida, ciudadDestino, asientosDisponibles);
        flights.add(flight);
        System.out.println("Vuelo con id " + numeroVuelo + " con origen " + ciudadSalida + " a " + ciudadDestino + " añadido con exito.");
    }

    private String generateUniqueCode() {
        String code;
        do {
            code = generateRandomCode();
        } while (codeAlreadyExists(code));

        return code;
    }

    private String generateRandomCode() {
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder codeBuilder = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(characters.length());
            codeBuilder.append(characters.charAt(index));
        }
        return codeBuilder.toString();
    }

    private boolean codeAlreadyExists(String code) {
        for (Vuelos flight : flights) {
            if (flight.getNumeroVuelo().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public List<Vuelos> getAllFlights() {
        return flights;
    }
    
    public Vuelos getFlight(String numVuelo) {
        for (Vuelos flight : flights) {
            if (flight.getNumeroVuelo().equals(numVuelo)) {
                return flight;
            }
        }
        return null;
    }
    
    public void removeFlight(String flightNumber) {
        flights.removeIf(flight -> flight.getNumeroVuelo().equals(flightNumber));
    }
    
    public void printFlights() {
    	if (flights.size() == 0) {
    		System.out.println("No hay vuelos registrados");
    		return;
    	}
        for (Vuelos flight : flights) {
            flight.printVuelo();
        }
    }
}