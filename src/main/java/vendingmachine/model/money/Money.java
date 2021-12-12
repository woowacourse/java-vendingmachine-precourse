package vendingmachine.model.money;

import vendingmachine.model.Item.Item;
import vendingmachine.model.Item.Name;

public class Money {

    public static final String DENOMINATION = "원";
    private final MoneyBill moneyBill;
    private final MoneyCoins moneyCoins;

    public Money(int amount) {
        this.moneyBill = new MoneyBill(amount);
        this.moneyCoins = new MoneyCoins();
    }

    public void generateRandomCoins() {
        while (!moneyBill.isZero()) {
            moneyCoins.add(moneyBill.convertToRandomCoin());
        }
    }

    public String showCoins() {
        return moneyCoins.toString();
    }

    public void addMoneyBill(MoneyBill inputMoney) {
        moneyBill.add(inputMoney);
    }

    public String showMoneyBill() {
        return moneyBill.toString() + DENOMINATION;
    }

    public String showChange() {
        return moneyCoins.showChange();
    }

    public boolean isAffordable(Item item) {
        return moneyBill.isSameOrBigger(item);
    }
}
