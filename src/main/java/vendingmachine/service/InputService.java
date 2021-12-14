package vendingmachine.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    private final InputValidationService inputValidationService = new InputValidationService();
    private final ProductValidationService productValidationService = new ProductValidationService();

    public int inputCorrectHolding() {
        while (true) {
            String input = Console.readLine();
            if (inputValidationService.isValidateNumber(input)) {
                return Integer.parseInt(input);
            }
        }
    }

    public String[] inputCorrectProducts() {
        while (true) {
            String input = Console.readLine();
            String[] parsedInput = input.split(";");
            if (inputValidationService.isValidateProduct(parsedInput)) {
                return parsedInput;
            }
        }
    }

    public int inputCorrectAmount() {
        while (true) {
            String input = Console.readLine();
            if (inputValidationService.isValidateAmount(input)) {
                return Integer.parseInt(input);
            }
        }
    }

    public String inputProductName() {
        while (true) {
            String input = Console.readLine();
            if (productValidationService.isValidateProductName(input)) {
                return input;
            }
        }
    }
}
