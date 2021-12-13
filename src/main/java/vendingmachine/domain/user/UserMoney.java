package vendingmachine.domain.user;

public class UserMoney {
    private int money;

    public UserMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void reduce(int price) {
        money -= price;
    }
}
