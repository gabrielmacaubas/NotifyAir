package models;
public class GateChanged extends Status {

    public GateChanged(Flight flight, Number newGate) {
        super(flight);
        this.flight.gate = newGate;
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
        this.flight.setStatus(new Delayed(this.flight));
    }

    @Override
    public void changeGate(Number newGate) {
        this.flight.setStatus(new GateChanged(this.flight, newGate));
    }

    @Override
    public String toString() {
        return "Vôo " + this.flight.getCode() + " com portão alterado para " + this.flight.gate + ".";
    }

}
