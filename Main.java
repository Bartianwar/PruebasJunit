package main;
import java.util.Scanner;

public class Main {
		public static void main(String[] args) {
		AlmacenVuelos almacenVuelos = new AlmacenVuelos();
		AlmacenReservas almacenReservas = new AlmacenReservas();
		boolean flag = true;
		System.out.println("Bienvenido, que desea hacer");
		Scanner scanner = new Scanner(System.in);  
		while(flag) {
			System.out.println("1.- Gestionar Vuelos");
			System.out.println("2.- Gestionar Reservas");
			System.out.println("3.- Salir");
			String opt = scanner.nextLine();
			
			switch (opt) {
			case "1":
				System.out.println("Opcion 1");
				boolean flagVuelos = true;
				while (flagVuelos) {
					System.out.println("1.- Ver Vuelos");
					System.out.println("2.- Añadir Vuelos");
					System.out.println("3.- Quitar Vuelos");
					System.out.println("4.- Encontrar vuelo");
					System.out.println("5.- Volver");
					String opt2 = scanner.nextLine();
					switch(opt2) {
					case "1":
						almacenVuelos.printFlights();
						break;
					case "2":
						System.out.print("Añada Ciudad de Origen: ");
				        String ciudadSalida = scanner.nextLine();

				        System.out.print("Añada Ciudad de Llegada: ");
				        String ciudadDestino = scanner.nextLine();

				        System.out.print("Añada asientos disponibles: ");
				        int asientosDisponibles = scanner.nextInt();
				        scanner.nextLine();
				        
						almacenVuelos.addFlight("0", ciudadSalida, ciudadDestino, asientosDisponibles);
						break;
					case "3":
						System.out.println("Añada vuelo a Quitar");
						String numVuelo = scanner.nextLine();
						Vuelos vuelo = almacenVuelos.getFlight(numVuelo);
						if(vuelo != null)
							almacenVuelos.removeFlight(vuelo.getNumeroVuelo());
						else
							System.out.println("No existe un vuelo con esa ID");
						break;
					case "4":
						System.out.println("Añada Vuelo a Encontrar");
						String numVuelo1 = scanner.nextLine();
						Vuelos vuelo1 = almacenVuelos.getFlight(numVuelo1);
						if(vuelo1 != null)
							vuelo1.printVuelo();
						else
							System.out.println("No existe un vuelo con esa ID");
						break;
					case "5":
						System.out.println("Opcion 5");
						flagVuelos = false;
						break;
					default:
						System.out.println("Opcion Invalida");
					}
				}
				break;
			case "2":
				System.out.println("Opcion 2");
				boolean flagReserv = true;
				while (flagReserv) {
					System.out.println("1.- Añadir Reserva");
					System.out.println("2.- Encontrar Reserva");
					System.out.println("3.- Quitar Reserva");
					System.out.println("4.- Volver");
					String opt2 = scanner.nextLine();
					switch(opt2) {
					case "1":
						System.out.println("Introduzca vuelo a reservar");
						String numVuelo1 = scanner.nextLine();
						Vuelos vuelo = almacenVuelos.getFlight(numVuelo1);
						if(vuelo != null) {
							System.out.println("Introduzca asientos a reservar: ");
							int asientos = scanner.nextInt();
							if(asientos <= vuelo.getAsientosDisponibles()) {
						    	System.out.println("Introduzca nombre pasajero");
					    		String nombrePasajero = scanner.nextLine();
								almacenReservas.addReservation("0",vuelo, asientos, nombrePasajero);
							}
							else
								System.out.println("No hay suficientes asientos");
						}
						else
							System.out.println("No existe un vuelo con esa ID");
						break;
					case "2":
						System.out.print("Introduzca la reserva a encontrar");
						String numRes = scanner.nextLine();
						Reservas res = almacenReservas.getReservation(numRes);
						if(res != null)
							res.printReserva();
						else
							System.out.println("No existe una reserva con esta ID");
						break;
					case "3":
						System.out.print("Introduzca la reserva a quitar");
						String numRes1 = scanner.nextLine();
						Reservas res1 = almacenReservas.getReservation(numRes1);
						if(res1 != null)
							almacenReservas.removeReservation(res1.getNumeroReserva());
						else
							System.out.println("No existe una reserva con esta ID");
						break;
					case "4":
						flagReserv = false;
						break;
					default:
						System.out.println("Opcion Invalida");
					}
				}
				break;
			case "3":
				flag = false;
				scanner.close();
				break;
			default:
				System.out.println("Opcion Invalida");
				
			}
		}
		
		
	}

}
