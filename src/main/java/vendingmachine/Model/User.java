package vendingmachine.Model;

public class User {
    private int inputMoney;

    public User(int inputMoney) {
        this.inputMoney = inputMoney;
    }

    public boolean isPurchasable(int price) {
        if (inputMoney >= price) {
            return true;
        }
        return false;
    }

    public void pay(Drink drink) {
        inputMoney -= drink.getPrice();
    }

    public int getRemainMoney() {
        return inputMoney;
    }
}
