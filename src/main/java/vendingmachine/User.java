package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private Validation validation = new Validation();
    private Parser parser = new Parser();
    private Products products = new Products();

    public int inputHolding() throws IllegalArgumentException {
        while (true) {
            String input = Console.readLine();
            if (validation.isValidateNumber(input)) {
                return Integer.parseInt(input);
            }
        }
    }

    public String[] inputProducts() {
        while (true) {
            String input = Console.readLine();
            String[] parsedInput = parser.parseProduct(input);
            if (validation.isValidateProduct(parsedInput)) {
                return parsedInput;
            }
        }
    }

    public int inputAmount() {
        while (true) {
            String input = Console.readLine();
            if (validation.isValidateAmount(input)) {
                return Integer.parseInt(input);
            }
        }
    }

    public String inputProductName() {
        while (true) {
            String input = Console.readLine();
            if (validation.isValidateProductName(input)) {
                return input;
            }
        }
    }
}
