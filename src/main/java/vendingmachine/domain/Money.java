package vendingmachine.domain;

public class Money {
    private int money;

    public Money(String insertMoney) {
        this.money = Integer.parseInt(insertMoney);
    }

    public int getRemainMoney() {
        return money;
    }

    public void use(int price) {
        money -= price;
    }
}
