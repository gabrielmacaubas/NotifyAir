package models;
public class GateChanged extends Status {

    public GateChanged(Flight flight, Number newGate) {
        super(flight);
        this.flight.gate = newGate;
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
        return "Voo " + this.flight.getCode() + " com portão alterado para " + this.flight.gate + ".";
    }

}
