package vendingmachine.model.money;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import vendingmachine.model.enums.Coin;

public class MoneyCoins {
    public static final String COUNT_UNIT = "개\n";
    public static final String HYPHEN = " - ";
    Map<MoneyCoin, Integer> coins;

    public MoneyCoins() {
        this.coins = new LinkedHashMap<>();
        initCoins();
    }

    private void initCoins() {
        List<Integer> valuesList = Coin.getValuesList();
        for (Integer value : valuesList) {
            coins.put(new MoneyCoin(value), 0);
        }
    }

    public void add(MoneyCoin coin) {
        if (coins.containsKey(coin)) {
            coins.put(coin, coins.get(coin) + 1);
            return;
        }
        coins.put(coin, 1);
    }

    public int get(MoneyCoin coin) {
        if (coins.containsKey(coin)) {
            return coins.get(coin);
        }
        return 0;
    }

    public String showChange() {
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<MoneyCoin> moneyCoins = (ArrayList<MoneyCoin>)coins.keySet()
            .stream()
            .filter(coin -> coins.get(coin) != 0)
            .collect(Collectors.toList());

        for (MoneyCoin moneyCoin : moneyCoins) {
            stringBuilder.append(moneyCoin.toString() + HYPHEN + coins.get(moneyCoin) + COUNT_UNIT);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<MoneyCoin> moneyCoins = new ArrayList<>(coins.keySet());
        for (MoneyCoin moneyCoin : moneyCoins) {
            stringBuilder.append(moneyCoin.toString() + HYPHEN + coins.get(moneyCoin) + COUNT_UNIT);
        }
        return stringBuilder.toString();
    }
}
