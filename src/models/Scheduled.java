package models;
public class Scheduled extends Status {

    public Scheduled(Flight flight) {
        super(flight);
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        if (this.flight.isFull()) {
            System.out.println("Vôo lotado!");
        } else {
            this.flight.subscribe(subscriber);
        }
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        this.flight.unsubscribe(subscriber);
    }

    @Override
    public void confirm() {
        this.flight.setStatus(new Confirmed(this.flight));
    }

    @Override
    public void cancel() {
        this.flight.setStatus(new Canceled(this.flight));
    }

    @Override
    public void delay() {
        System.out.println("Ação não permitida!");
    }

    @Override
    public void changeGate(Number newGate) {
        System.out.println("Ação não permitida!");
    }

    @Override
    public String toString() {
        return "Programado";
    }

}