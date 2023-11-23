package vendingmachine.domain;

public class Purchaser {

    private final int money;

    private Purchaser(int money){
        this.money = money;
    }

    // Static Factory Method
    public static Purchaser from(int money) {
        return new Purchaser(money);
    }

    public int getMoney() {
        return money;
    }
}
