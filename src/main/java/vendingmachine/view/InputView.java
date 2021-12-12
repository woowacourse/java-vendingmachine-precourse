package vendingmachine.view;

public class InputView {
    private static void isValidPrice(int price){
        if (price%10!=0){
            throw new IllegalArgumentException();
        }
    }
    public static int parseInt(String input) {
        isInteger(input);
        int result = Integer.parseInt(input);
        isPositive(result);
        isValidPrice(result);
        return result;
    }

    private static void isPositive(int input) {
        if (input < 1) {
            throw new IllegalArgumentException();
        }
    }

    private static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
