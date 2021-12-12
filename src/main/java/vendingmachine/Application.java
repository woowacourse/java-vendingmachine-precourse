package vendingmachine;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ValidatedInput input = new ValidatedInput();
        int machineMoney = input.requestMachineMoney();
        List<Coin> coins = Coin.generateCoinsBy(machineMoney);
        System.out.println(new CoinCollection(coins));
        input.requestMachineProduct();
    }
}
