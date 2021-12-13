package vendingmachine.model.coin;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.util.Constant;

public class MachineMoney {
    private final int money;

    public MachineMoney(String inputMoney) {
        new MachineMoneyValidator(inputMoney);
        this.money = Integer.parseInt(inputMoney);
    }

    private static Map<Integer, Integer> toMap() {
        Map<Integer, Integer> coins = new LinkedHashMap<>();
        for (int type : Coin.toList()) {
            coins.put(type, Constant.STACK_COINS_BEGIN_VALUE);
        }
        return coins;
    }

    public Map<Integer, Integer> toRandomCoins() {
        Map<Integer, Integer> coins = toMap();
        int money = this.money;

        while (money != 0) {
            int pickedCoin = Coin.createRandomCoin();
            if (money - pickedCoin < 0)
                continue;
            money -= pickedCoin;
            coins.put(pickedCoin, coins.get(pickedCoin) + Constant.COIN_STACK_UP_VOLUME);
        }
        return coins;
    }

    public List<CoinType> createCoins() {
        List<CoinType> coins = new ArrayList<>();

        for (Map.Entry<Integer, Integer> coin : toRandomCoins().entrySet()) {
            coins.add(new CoinType(Coin.of(coin.getKey()), coin.getValue()));
        }
        return coins;
    }
}
