package vendingmachine.model.coin;

import java.util.Map;

public class MachineMoney {
    private final int amount;

    public MachineMoney(String inputMoney) {
        new MachineMoneyValidator(inputMoney);
        this.amount = Integer.parseInt(inputMoney);
    }

    public Map<Integer, Integer> toCoins() {
        return Coin.moneyToRandomCoins(amount);
    }
}
