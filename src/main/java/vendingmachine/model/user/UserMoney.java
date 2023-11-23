package vendingmachine.model.user;

public class UserMoney {
    int money = 0;

    public UserMoney(int money) {
        this.money = money;
    }

    public int getBalance() {
        return money;
    }

    public void purchaseDrink(int price) {
        money -= price;
    }
}
