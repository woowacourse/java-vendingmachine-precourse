package vendingmachine.domain.consumer;

import vendingmachine.domain.product.Product;

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
            throw new IllegalArgumentException("[ERROR] 구매자의 잔액이 부족하여 해당 제품을 구매하지 못합니다.");
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
