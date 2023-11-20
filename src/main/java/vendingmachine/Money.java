package vendingmachine;

public class Money {
    private int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    public boolean isMoreOrEqualThen(int amount) {
        return this.amount >= amount;
    }

    public boolean isLessThen(int amount) {
        return this.amount < amount;
    }

    public void minus(int amount) {
        if (this.amount - amount < 0) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        this.amount -= amount;
    }

    public int getAmount() {
        return amount;
    }
}
