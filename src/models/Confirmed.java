package models;
public class Confirmed extends Status {
    
    public Confirmed(Flight flight) {
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
        System.out.println("Ação não permitida!");
    }

    @Override
    public void cancel() {
        this.flight.setStatus(new Canceled(this.flight));
    }

    @Override
    public void delay() {
        this.flight.setStatus(new Delayed(this.flight));
    }

    @Override
    public void changeGate(Number newGate) {
        this.flight.setStatus(new GateChanged(this.flight, newGate));
    }

    @Override
    public String toString() {
        return "Vôo " + this.flight.getCode() + " confirmado.";
    }

}
