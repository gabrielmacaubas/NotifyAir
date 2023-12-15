package models;
public class Scheduled extends Status {

    public Scheduled(Flight flight) {
        super(flight);
    }

    @Override
    public Boolean subscribe(Subscriber subscriber) {
        if (this.flight.isFull()) {
            System.out.println("Voo lotado!");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean unsubscribe(Subscriber subscriber) {
        return true;
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
    public void takeOff() {
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