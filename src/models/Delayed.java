package models;
public class Delayed extends Status{

    public Delayed(Flight flight) {
        super(flight);
    }

    @Override
    public Boolean subscribe(Subscriber subscriber) {
        System.out.println("Ação não permitida!");
        return false;
    }
    
    @Override
    public Boolean unsubscribe(Subscriber subscriber) {
        System.out.println("Ação não permitida!");
        return false;
    }

    @Override
    public void confirm() {
        System.out.println("Ação não permitida!");
    }

    @Override
    public void cancel() {
        System.out.println("Ação não permitida!");
    }

    @Override
    public void delay() {
        System.out.println("Ação não permitida!");
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
        return "Voo " + this.flight.getCode() + " atrasado.";
    }
    
}
