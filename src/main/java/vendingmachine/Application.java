package vendingmachine;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int machineMoney = new Input().requestMachineMoney();
        List<Coin> coins = Coin.generateCoinsBy(machineMoney);

        for (Coin coin : coins) {
            System.out.println(coin);
        }
    }
}
