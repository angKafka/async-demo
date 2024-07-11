package Single_Reponsible_Principle;

public class OrderCalculator {
    int totalAmount;
    int taxPercentage;
    int tip;
    int shippingCost;

    public int calculateOrder(int totalAmount, int taxPercentage, int tip, int shippingCost) {
        return totalAmount + taxPercentage + tip + shippingCost;
    }

    /*The class should have only one method which we tell here as responsibility.*/
}
