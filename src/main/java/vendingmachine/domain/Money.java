package vendingmachine.domain;

public class Money {
    private int money;

    public Money(String insertMoney) {
        this.money = Integer.parseInt(insertMoney);
    }
}
