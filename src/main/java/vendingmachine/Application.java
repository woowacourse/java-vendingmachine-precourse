package vendingmachine;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        int machineMoney = input.requestMachineMoney();
        List<Coin> coins = Coin.generateCoinsBy(machineMoney);
        System.out.println(new CoinCollection(coins));
        input.requestMachineProduct();
    }
}
