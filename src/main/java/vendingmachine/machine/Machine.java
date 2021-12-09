package vendingmachine.machine;

public class Machine {
    private int amountByClient;

    public Machine(int amountByClient) {
        this.amountByClient = amountByClient;
    }

    public int getAmountByClient() {
        return amountByClient;
    }

    public void buyProduct(int price) {
        amountByClient -= price;
    }
}
