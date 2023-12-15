package models;
public abstract class Status {
    protected Flight flight;

    public Status(Flight flight) {
        this.flight = flight;
    }

    public abstract Boolean subscribe(Subscriber subscriber);

    public abstract Boolean unsubscribe(Subscriber subscriber);

    public abstract void confirm();

    public abstract void cancel();

    public abstract void  delay();

    public abstract void takeOff();
    
    public abstract void changeGate(Number newGate);

    public abstract String toString();
}
