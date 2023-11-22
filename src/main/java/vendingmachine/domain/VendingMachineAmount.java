package vendingmachine.domain;

public class VendingMachineAmount {

    private int amount;

    public VendingMachineAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < 10) {
            throw new IllegalArgumentException("[ERROR] 자판기가 보유 금액은 10원 이상이어야 합니다.");
        }
        if (amount % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 자판기 보유 금액은 10원 단위만 가능합니다.");
        }
    }

    public boolean isGreaterThanZero() {
        return amount > 0;
    }

    public boolean isLessThan(int amount) {
        return this.amount < amount;
    }

    public void decrease(int amount) {
        this.amount -= amount;
    }

    public int getAmount() {
        return amount;
    }
}
