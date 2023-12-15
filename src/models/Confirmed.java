package models;
public class Confirmed extends Status {
    
    public Confirmed(Flight flight) {
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
    public void takeOff() {
        this.flight.setStatus(new TookOff(this.flight));
    }

    @Override
    public void changeGate(Number newGate) {
        this.flight.setStatus(new GateChanged(this.flight, newGate));
    }

    @Override
    public String toString() {
        return "Voo " + this.flight.getCode() + " confirmado.";
    }

}
