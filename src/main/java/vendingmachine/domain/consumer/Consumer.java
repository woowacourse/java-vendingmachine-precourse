package vendingmachine.domain.consumer;

public class Consumer {
    private int balance;

    private Consumer(int balance) {
        this.balance = balance;
    }

    public static Consumer from(int balance) {
        return new Consumer(balance);
    }
    // for test
    public boolean hasBalance(int targetBalance) {
        return this.balance == targetBalance;
    }
}
