package models;

import models.notifier.Notifier;

public class Passenger implements Subscriber{

    private Notifier notifier;
    public String name;
    public String email;

    public Passenger(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void notify(String content) {
        content = "Notificação Para: " + this.name + "\n" + content;
        this.notifier.execute(content);
    }
    
}
