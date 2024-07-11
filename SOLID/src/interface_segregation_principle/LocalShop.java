package interface_segregation_principle;

public class LocalShop implements Cart{
    @Override
    public void showCartItem() {
        System.out.println("You got a cart item");
    }
}
