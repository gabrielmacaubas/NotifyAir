import models.*;
import models.notifier.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Criando aeroportos
        Airport originAirport = new Airport("GRU", "Aeroporto de Guarulhos");
        Airport destinationAirport = new Airport("JPA", "Aeroporto de João Pessoa");

        // Criando uma aeronave
        Aircraft aircraft = new Aircraft("Boeing 747", 300);

        // Criando um voo
        Flight flight = new Flight(101, "01/01/2024 10:00", "01/01/2024 14:00", originAirport, destinationAirport, aircraft, 25);
        Company latam = new Company("LATAM");
        latam.addFlight(flight);

        // Criando passageiros
        Passenger passenger1 = new Passenger("Rogério", "rogerio@example.com");
        Passenger passenger2 = new Passenger("Lucas", "lucas@example.com");
        Passenger passenger3 = new Passenger("Eduarda", "eduarda@example.com");

        // Criando notificadores
        EmailNotifier emailNotifier = new EmailNotifier();
        AppNotifier appNotifier = new AppNotifier();
        SmsNotifier smsNotifier = new SmsNotifier();

        // Associando notificadores aos passageiros
        passenger1.setNotifier(emailNotifier);
        passenger2.setNotifier(appNotifier);
        passenger3.setNotifier(smsNotifier);

        System.out.println("\n--------------------------------------------------------------------------------PRIMEIRO VOO--------------------------------------------------------------------------------");
        // Adicionando passageiros ao voo
        flight.subscribe(passenger1);
        flight.subscribe(passenger2);
        flight.subscribe(passenger3);

        // Visualizando informações do voo
        Thread.sleep(3000);
        flight.showFlight();

        // Cancelar o voo
        Thread.sleep(3000);
        flight.cancel();
        Thread.sleep(1000);
        flight.showFlight();


        Flight flight2 = new Flight(102, "02/01/2024 11:00", "02/01/2024 14:00", originAirport, destinationAirport, aircraft, 25);
        latam.addFlight(flight);
        
        System.out.println("\n--------------------------------------------------------------------------------SEGUNDO VOO--------------------------------------------------------------------------------");
        // Adicionando passageiros ao voo
        flight2.subscribe(passenger1);
        flight2.subscribe(passenger2);
        flight2.subscribe(passenger3);

        // Visualizando informações do voo
        Thread.sleep(3000);
        flight2.showFlight();

        // Confirmar o voo
        Thread.sleep(3000);
        flight2.confirm();
        Thread.sleep(1000);
        flight2.showFlight();

        // Cancelar o voo
        Thread.sleep(3000);
        flight2.cancel();
        Thread.sleep(1000);
        flight2.showFlight();


        Flight flight3 = new Flight(102, "03/01/2024 11:00", "03/01/2024 14:00", originAirport, destinationAirport, aircraft, 25);
        latam.addFlight(flight);

        System.out.println("\n--------------------------------------------------------------------------------TERCEIRO VOO--------------------------------------------------------------------------------");
        // Adicionando passageiros ao voo
        flight3.subscribe(passenger1);
        flight3.subscribe(passenger2);
        flight3.subscribe(passenger3);

        // Visualizando informações do voo
        Thread.sleep(3000);
        flight3.showFlight();

        // Confirmar o voo
        Thread.sleep(3000);
        flight3.confirm();
        Thread.sleep(1000);
        flight3.showFlight();

        // Mudar portão do voo
        Thread.sleep(3000);
        flight3.changeGate(15);
        Thread.sleep(1000);
        flight3.showFlight();

        // Atrasar o voo
        Thread.sleep(3000);
        flight3.delay();
        Thread.sleep(1000);
        flight3.showFlight();
        
        // Decolar o voo
        Thread.sleep(3000);
        flight3.takeOff();
        Thread.sleep(1000);
        flight3.showFlight();
    }
}
