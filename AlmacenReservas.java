package main;
import java.util.*;

public class AlmacenReservas {
    private List<Reservas> reservations = new ArrayList<>();

    public void addReservation(String id, Vuelos vuelo, int asientos, String nombrePasajero) {
    	String numeroReserva;
    	if(id == "0") {
    		numeroReserva = generateUniqueReservationCode();
    	} else {
    		numeroReserva = id;
    	}
    	
    	Reservas reserv = new Reservas(numeroReserva, vuelo, nombrePasajero, asientos);
        reservations.add(reserv);
        System.out.println("Reserva \"" + numeroReserva + "\" al vuelo \"" + vuelo.getNumeroVuelo() + "\" añadida con exito.");
    }
    
    private String generateUniqueReservationCode() {
        String code;
        do {
            code = generateRandomCode();
        } while (reservationCodeAlreadyExists(code));

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

    private boolean reservationCodeAlreadyExists(String code) {
        for (Reservas reservation : reservations) {
            if (reservation.getNumeroReserva().equals(code)) {
                return true;
            }
        }
        return false;
    }
    
    public Reservas getReservation(String numRes) {
    	
        for (Reservas reserva : reservations) {
            if (reserva.getNumeroReserva().equals(numRes)) {
                return reserva;
            }
        }
        return null;
    }
    
    
    
    public void removeReservation(String reservationCode) {
        reservations.removeIf(reservation -> reservation.getNumeroReserva().equals(reservationCode));
    }

    public List<Reservas> getAllReservations() {
        return reservations;
    }
}