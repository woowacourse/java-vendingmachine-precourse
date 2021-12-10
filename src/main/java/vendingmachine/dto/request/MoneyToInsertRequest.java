package vendingmachine.dto.request;

public class MoneyToInsertRequest {
    private final String input;

    public MoneyToInsertRequest(String input) {
        this.input = input;
    }

    public int toMoneyToInsert() {
        return Integer.parseInt(input);
    }
}
