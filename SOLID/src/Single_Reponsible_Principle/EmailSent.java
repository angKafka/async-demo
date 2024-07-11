package Single_Reponsible_Principle;

public class EmailSent {
    String recipient;
    String subject;

    public void sendMail(String recipient, String subject) {
        System.out.println(recipient+" your remaining card balance : "+subject);
    }
}
