package liskov_substitution_principle;

public class CreditCard extends Card {
    @Override
    public String cardName(String name) {
        return super.cardName(name);
    }
}
