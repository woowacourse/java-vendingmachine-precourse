package vendingmachine.Domain;

public class InputAmount {
    private static InputAmount instance = new InputAmount();
    private static int inputAmount;

    private InputAmount() {
    }

    public static void setInputAmount(int amount) {
        inputAmount = amount;
    }
}
