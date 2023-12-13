package models;
import java.util.ArrayList;


public class Company {

    public String name;
    private ArrayList<Flight> flights = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void removeFlight(Flight flight) {
        if (flight.getState().toString() == "Programado") {
            flights.remove(flight);
        } else {
            System.out.println("Só é permitido remover vôos com o estado 'Programado'");
        }
    }

    public Flight findFlight(Number flightCode) {
        for (Flight flight : flights) {
            if (flight.getCode() == flightCode) {
                return flight;
            }
        }
        return null;
    }
    
}