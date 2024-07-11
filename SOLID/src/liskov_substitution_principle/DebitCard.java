package liskov_substitution_principle;

public class DebitCard extends Card {
    @Override
    public String cardName(String name) {
        return super.cardName(name);
    }
}
