import Single_Reponsible_Principle.EmailSent;
import Single_Reponsible_Principle.OrderCalculator;
import dependency_inversion_principle.SMSMessage;
import interface_segregation_principle.LocalShop;
import interface_segregation_principle.OnlineShop;
import liskov_substitution_principle.Card;
import liskov_substitution_principle.CreditCard;
import liskov_substitution_principle.DebitCard;
import open_closed_principle.Pay;

public class Main {
    public static void main(String[] args) {
        Pay pay = new Pay();
        int total = pay.calculateOrder(
                10,
                12,
                5,
                40
        );
       
        int balance = pay.remainingBalance - total;
        EmailSent emailSent = new EmailSent();
        Card creditCard = new CreditCard();
        Card debitCard = new DebitCard();
        LocalShop localShop = new LocalShop();
        OnlineShop onlineShop = new OnlineShop();
        SMSMessage smsMessage = new SMSMessage();
        if(total != 0){
            emailSent.sendMail("Raj", String.valueOf(balance));
            smsMessage.sendMessage(creditCard.cardName("CREDIT CARD"));
            localShop.showCartItem();
        }else{
            System.out.println("No Order Found");
            smsMessage.sendMessage(debitCard.cardName("DEBIT CARD"));
            onlineShop.showCartItem();
            onlineShop.sendNotification();
        }
    }
}
