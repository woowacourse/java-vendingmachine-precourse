package vendingmachine;

public class Validators {
    public static int validateAmount(String inputData) {
        try {
            int amount = Integer.parseInt(inputData);
            if (amount <= 0) {
                throw new IllegalArgumentException();
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
