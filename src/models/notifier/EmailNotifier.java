package models.notifier;
public class EmailNotifier implements Notifier {

    @Override
    public void execute(String data) {
        System.out.println("-Notificação via EMAIL- " + data);
    }
    
}
