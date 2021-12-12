package vendingmachine.model;

public class Asset {

    private final MoneyBill moneyBill;
    private final MoneyCoins moneyCoins;

    public Asset(int amount) {
        this.moneyBill = new MoneyBill(amount);
        this.moneyCoins = new MoneyCoins();
    }

    public void generateRandomCoins() {
        while (!moneyBill.isZero()) {
            moneyCoins.add(moneyBill.convertToRandomCoin());
        }
    }

    public String showCoins() {
        System.out.println(moneyCoins.toString());
        return moneyCoins.toString();
    }
}
