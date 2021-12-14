package vendingmachine.model.user;

public class ChoiceDrink {
    private final String choiceDrinkName;

    public ChoiceDrink(String drink) {
        this.choiceDrinkName = drink.trim();
    }

    public String getName() {
        return choiceDrinkName;
    }
}
