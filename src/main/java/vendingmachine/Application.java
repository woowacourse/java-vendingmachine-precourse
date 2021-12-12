package vendingmachine;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachine vendingMachine = new VendingMachine();
        ValidatedInput input = new ValidatedInput();

        int machineMoney = input.requestMachineMoney();
        List<Coin> coins = Coin.generateCoinsBy(machineMoney);

        vendingMachine.insertCoins(coins);
        vendingMachine.registerProducts(input.requestMachineProduct());
        vendingMachine.insertMoney(input.requestUserMoney());
    }
}
