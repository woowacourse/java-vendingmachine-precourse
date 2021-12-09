package vendingmachine.machine;

public class Machine {
    private static final String INPUT_AMOUNT_NOW_MESSAGE = "투입 금액: ";
    private static final String AMOUNT_UNIT_MESSAGE = "원";

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

    @Override
    public String toString() {
        return INPUT_AMOUNT_NOW_MESSAGE + amountByClient
                + AMOUNT_UNIT_MESSAGE;
    }
}
