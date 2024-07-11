package interface_segregation_principle;

public class OnlineShop implements Notification, Cart{
    @Override
    public void sendNotification() {
        System.out.println("You bought someItem");
    }

    @Override
    public void showCartItem() {
        System.out.println("You got a cart item");
    }
}
