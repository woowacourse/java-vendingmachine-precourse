package vendingmachine.domain;

public class InputAmount {

    private int amount;

    public InputAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < 10) {
            throw new IllegalArgumentException("[ERROR] 투입 금액은 10원 이상이어야 합니다.");
        }
        if (amount % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 투입 금액은 10원 단위만 가능합니다.");
        }
    }

    public void decrease(int amount) {
        this.amount -= amount;
    }

    public int getAmount() {
        return amount;
    }
}
