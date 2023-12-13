package models.notifier;
public class SmsNotifier implements Notifier {
    
    @Override
    public void execute(String data) {
        System.out.println("-Notificação via SMS- " + data);
    }
    
}
