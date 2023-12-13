package models;
public class Delayed extends Status{

    public Delayed(Flight flight) {
        super(flight);
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        System.out.println("Ação não permitida!");
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        System.out.println("Ação não permitida!");
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
    public void changeGate(Number newGate) {
        this.flight.setStatus(new GateChanged(this.flight, newGate));
    }

    @Override
    public String toString() {
        return "Vôo " + this.flight.getCode() + " atrasado.";
    }
    
}
