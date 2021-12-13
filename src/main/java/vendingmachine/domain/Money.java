package vendingmachine.domain;

public class Money {
    private static final Money instance = new Money();
    private int money;

    private Money() {
    }

    public void storeMoney(int money) {
        this.money = money;
    }

    public static Money getInstance() {
        return instance;
    }

    public void minusMoney(String productName) {
        money -= ProductRepository.getInstance().useMoneyForProductPurchase(productName);
    }

    public int getMoney() {
        return money;
    }
}
