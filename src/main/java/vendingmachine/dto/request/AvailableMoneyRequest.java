package vendingmachine.dto.request;

import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_WRONG_MONEY_TO_INSERT_INPUT;

public class AvailableMoneyRequest {
    private final String input;

    public AvailableMoneyRequest(String input) {
        this.input = input;
    }

    public int toAvailableMoney() {
        try {
            int availableMoney = Integer.parseInt(input);
            validate(availableMoney);
            return availableMoney;
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_MONEY_TO_INSERT_INPUT);
        }
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }
    }
}
