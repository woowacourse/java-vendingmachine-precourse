package vendingmachine.Domain;

public class InputAmount {
    private static int inputAmount;

    private InputAmount() {
        inputAmount = 0;
    }

    public static void inputMoney(int amount) {
        inputAmount += amount;
    }

}
