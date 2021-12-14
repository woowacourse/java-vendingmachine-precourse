package vendingmachine.domain.consumer;

import vendingmachine.domain.product.Product;

import static vendingmachine.util.validator.error.Error.CONSUMER_NOT_ENOUGH_BALANCE;

public class Consumer {
    private int balance;

    private Consumer(int balance) {
        this.balance = balance;
    }

    public static Consumer from(int balance) {
        return new Consumer(balance);
    }

    public void reduceBalance(int price) {
        balance -= price;
    }

    public boolean possibleToBuy(Product product) {
        return product.verifyEnough(balance);
    }

    public int getHowMuchBalance(int machineBalance) {
        if (isLessThanConsumerBalance(machineBalance)) {
            return machineBalance;
        }
        return balance;
    }

    private boolean isLessThanConsumerBalance(int machineBalance) {
        return machineBalance < balance;
    }

    public void buy(Product product) {
        if (!possibleToBuy(product)) {
            throw new IllegalArgumentException(CONSUMER_NOT_ENOUGH_BALANCE.getMessage());
        }
        product.isPurchasedBy(this);
    }

    @Override
    public String toString() {
        return "투입 금액: " + balance + "원";
    }

    // for test
    public boolean hasBalance(int targetBalance) {
        return this.balance == targetBalance;
    }

}
