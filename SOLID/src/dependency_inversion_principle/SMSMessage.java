package dependency_inversion_principle;

public class SMSMessage implements MessageSender{
    @Override
    public void sendMessage(String message) {
        System.out.println("Email:: "+message);
    }
}
