package vendingmachine.model;

public class Client {
    public static final String INFO_MESSAGE_OF_MONEY_LEFT = "\n투입 금액: %s원";
    private int money;

    public Client(int money) {
        this.money = money;
    }

    public void printMoneyLeft() {
        System.out.printf(INFO_MESSAGE_OF_MONEY_LEFT, money);
    }

    public void buy(int price) {
        money -= price;
    }

    public boolean hasNotEnoughMoney(int lowestPrice) {
        return money < lowestPrice;
    }

    public int getMoney() {
        return money;
    }
}
