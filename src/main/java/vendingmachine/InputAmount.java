package vendingmachine;

public class InputAmount {
    private int amount;

    public InputAmount(String amount) {
        this.amount = Integer.parseInt(amount);
    }

    public void reduce(int price) {
        this.amount -= price;
    }
}
