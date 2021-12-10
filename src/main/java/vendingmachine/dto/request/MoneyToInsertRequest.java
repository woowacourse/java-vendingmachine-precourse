package vendingmachine.dto.request;

import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_WRONG_MONEY_TO_INSERT_INPUT;

public class MoneyToInsertRequest {
    private final String input;

    public MoneyToInsertRequest(String input) {
        this.input = input;
    }

    public int toMoneyToInsert() {
        try {
            int moneyToInsert = Integer.parseInt(input);
            validate(moneyToInsert);
            return moneyToInsert;
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_MONEY_TO_INSERT_INPUT);
        }

    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_MONEY_TO_INSERT_INPUT);
        }
    }
}
