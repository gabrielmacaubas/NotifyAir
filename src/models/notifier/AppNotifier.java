package models.notifier;
public class AppNotifier implements Notifier {

    @Override
    public void execute(String data) {
        System.out.println("-Notificação via APP- " + data);
    }
    
}
