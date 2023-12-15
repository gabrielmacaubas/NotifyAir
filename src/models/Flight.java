package models;
import java.util.ArrayList;

public class Flight {

    private ArrayList<Subscriber> subscribers = new ArrayList<>();
    private Status status;
    private Number code;
    public String spectedDeparture;
    public String spectedArrival;
    public Airport origin;
    public Airport destination;
    public Aircraft aircraft;
    public Number gate;

    public Flight(Number code, String spectedDeparture, String spectedArrival, 
                  Airport origin, Airport destination, Aircraft aircraft, 
                  Number gate) {
        this.code = code;
        this.spectedDeparture = spectedDeparture;
        this.spectedArrival = spectedArrival;
        this.origin = origin;
        this.destination = destination;
        this.aircraft = aircraft;
        this.gate = gate;
        this.status = new Scheduled(this);
    }

    public Status getState() {
        return this.status;
    }

    public Number getCode() {
        return this.code;
    }

    public Number getEmptySeats() {
        return this.aircraft.capacity.intValue() - this.subscribers.size();
    }

    public boolean isFull() {
        return this.aircraft.capacity.intValue() == this.subscribers.size();
    }

    public void notifySubscribers() {
        for (Subscriber subscriber : this.subscribers) {
            subscriber.notify(this.status.toString());
        }
    }

    public void setStatus(Status status) {
        this.status = status;
        this.notifySubscribers();
    }

    public void subscribe(Subscriber subscriber) {
        if (this.status.subscribe(subscriber)) {
            this.subscribers.add(subscriber);
        };
    }

    public void unsubscribe(Subscriber subscriber) {
        if (this.status.unsubscribe(subscriber)) {
            this.subscribers.remove(subscriber);
        };
    }
    
    public void confirm() {
        this.status.confirm();
    }

    public void cancel() {
        this.status.cancel();
    }

    public void delay() {
        this.status.delay();
    }

    public void takeOff() {
        this.status.takeOff();
    }

    public void changeGate(Number newGate) {
        this.status.changeGate(newGate);
    }

    public void showFlight() {
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("Voo " + this.code + " de " + this.origin.toString() + " para " + this.destination.toString() + ".");
        System.out.println("Partida prevista para " + this.spectedDeparture + " e chegada prevista para " + this.spectedArrival + ".");
        System.out.println("Aeronave: " + this.aircraft.model + ".");
        System.out.println("Portão: " + this.gate + ".");
        System.out.println("Status: " + this.status.toString() + ".");
        System.out.println("--------------------------------------------------------------------------------\n");
    }

}
