package vendingmachine.model;

import vendingmachine.view.InputView;

public class VendingMachine {
    public static final String INFO_MESSAGE_FOR_CHANGE = "\n잔돈";
    private Coins coins;

    private VendingMachine(int initialMoney) {
        this.coins = Coins.setCoins(initialMoney);
    }

    public static VendingMachine initialize(Integer initialMoney) {
        VendingMachine vendingMachine = new VendingMachine(initialMoney);
        vendingMachine.printCoinStatus();
        return vendingMachine;
    }

    public void printCoinStatus() {
        System.out.println(InputView.INFO_MESSAGE_OF_MACHINE_COINS);
        this.coins.getCoins().forEach((coin, amount) -> System.out.print(coin.getCoinInfo(amount)));
    }

    public void returnChange(int money) {
        System.out.println(INFO_MESSAGE_FOR_CHANGE);
        System.out.println(coins.getChangeMessage(money));
    }
}
