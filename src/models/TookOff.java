package models;
public class TookOff extends Status {

    public TookOff(Flight flight) {
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
        System.out.println("Ação não permitida!");
    }

    @Override
    public void changeGate(Number newGate) {
        System.out.println("Ação não permitida!");
    }

    @Override
    public String toString() {
        return "Voo " + this.flight.getCode() + " decolou.";
    }
    
}
